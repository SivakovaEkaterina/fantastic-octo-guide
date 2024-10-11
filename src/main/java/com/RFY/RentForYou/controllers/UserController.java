/*
package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.service.PassportServerImpl;
import com.RFY.RentForYou.service.PictureServerImpl;
import com.RFY.RentForYou.service.RoleServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.RFY.RentForYou.models.UserModel;
import com.RFY.RentForYou.service.UserServerImpl;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServerImpl userServer;
    @Autowired
    private RoleServerImpl roleService;

    @Autowired
    private PictureServerImpl pictureService;

    @Autowired
    private PassportServerImpl passportService;

    public UserController(UserServerImpl userServer) {
        this.userServer = userServer;
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("models", userServer.findAllUser ());
        model.addAttribute("user", new UserModel());
        return "userForm";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("user") UserModel card,
                      BindingResult result, Model model) {
        model.addAttribute("roles", roleService.findAllRole());
        model.addAttribute("pictures", pictureService.findAllPicture());
        model.addAttribute("passports", passportService.findAllPassport());
        if (result.hasErrors()) {
            model.addAttribute("models", userServer.findAllUser ());
            return "userForm";
        }
        userServer.addUser (card);
        return "redirect:/user";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("user") UserModel card, BindingResult result) {
        userServer.updateUser (card);
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        userServer.deleteUser (id);
        return "redirect:/user";
    }

    @PostMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("models", userServer.findUser (id));
        model.addAttribute("user", new UserModel());
        return "userForm";
    }
}
*/
