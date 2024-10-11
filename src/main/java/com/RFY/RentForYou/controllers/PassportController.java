package com.RFY.RentForYou.controllers;

import jakarta.validation.Valid;
import com.RFY.RentForYou.models.PassportModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.RFY.RentForYou.service.PassportServerImpl;

@Controller
@RequestMapping("/passport")
public class PassportController {
    private final PassportServerImpl passportServer;

    public PassportController(PassportServerImpl passportServer) {
        this.passportServer = passportServer;
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("models", passportServer.findAllPassport());
        model.addAttribute("passport", new PassportModel());
        return "passportForm";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("passport") PassportModel passport, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("models", passportServer.findAllPassport());
            return "passportForm";
        }
        passportServer.addPassport(passport);
        return "redirect:/passport";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("passport") PassportModel passport, BindingResult result) {
        passportServer.updatePassport(passport);
        return "redirect:/passport";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        passportServer.deletePassport(id);
        return "redirect:/passport";
    }

    @PostMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("models", passportServer.findPassport(id));
        model.addAttribute("passport", new PassportModel());
        return "passportForm";
    }

}
