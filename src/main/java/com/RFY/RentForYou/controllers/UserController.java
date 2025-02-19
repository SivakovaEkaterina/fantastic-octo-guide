package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.RoleEnum;
import com.RFY.RentForYou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.RFY.RentForYou.models.UserModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('Admin')")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public String userView(Model model) {
        String currentUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        model.addAttribute("currentUrl", currentUrl);
        model.addAttribute("user_list", userRepository.findAll());
        return "indexUser";
    }

    @GetMapping("/users/{id}")
    public String detailView(@PathVariable Long id, Model model) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Пользователя не существует:" + id));
        model.addAttribute("user_object", user);
        return "info";
    }

    @GetMapping("/users/{id}/update")
    public String updateView(@PathVariable Long id, Model model) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Пользователя не существует:" + id));
        model.addAttribute("user_object", user);
        model.addAttribute("roles", RoleEnum.values());
        return "update";
    }

    @PostMapping("/users/{id}/update")
    public String updateUser(@PathVariable Long id,
                             @RequestParam String username,
                             @RequestParam(name = "roles[]", required = false) String[] roles) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Пользователя не существует:" + id));
        user.setUsername(username);
        user.getRoles().clear();
        if (roles != null) {
            for (String role : roles) {
                user.getRoles().add(RoleEnum.valueOf(role));
            }
        }
        userRepository.save(user);
        return "redirect:/admin/users/" + id;
    }
}
