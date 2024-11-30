package com.RFY.RentForYou.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.RFY.RentForYou.models.RoleModel;
import com.RFY.RentForYou.service.RoleServerImpl;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/role")
@PreAuthorize("hasAnyAuthority('Admin')")
public class RoleController {
    private final RoleServerImpl roleServer;

    public RoleController(RoleServerImpl roleServer) {
        this.roleServer = roleServer;
    }

    @GetMapping("")
    public String getAll(Model model) {
        String currentUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        model.addAttribute("currentUrl", currentUrl);
        model.addAttribute("models", roleServer.findAllRole());
        model.addAttribute("role", new RoleModel());
        return "adminPg0";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("role") RoleModel role, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("models", roleServer.findAllRole());
            return "adminPg0";
        }
        roleServer.addRole(role);
        return "redirect:/role";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("role") RoleModel role, BindingResult result) {
        roleServer.updateRole(role);
        return "redirect:/role";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        roleServer.deleteRole(id);
        return "redirect:/role";
    }

    @PostMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("models", roleServer.findRole(id));
        model.addAttribute("role", new RoleModel());
        return "adminPg0";
    }
}
