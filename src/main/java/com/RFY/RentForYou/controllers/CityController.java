package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.CityModel;
import com.RFY.RentForYou.service.CityServerImpl;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/city")
@PreAuthorize("hasAnyAuthority('Admin')")
public class CityController {
    private final CityServerImpl cityServer;

    public CityController(CityServerImpl cityServer) {
        this.cityServer = cityServer;
    }

    @GetMapping("")
    public String getAll(Model model) {
        String currentUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        model.addAttribute("currentUrl", currentUrl);
        model.addAttribute("models", cityServer.findAllCity());
        model.addAttribute("city", new CityModel());
        return "adminPg0";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("city") CityModel card,
                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("models", cityServer.findAllCity());
            return "adminPg0";
        }
        cityServer.addCity(card);
        return "redirect:/city";
    }


    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("city") CityModel card, BindingResult result) {
        cityServer.updateCity(card);
        return "redirect:/city";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        cityServer.deleteCity(id);
        return "redirect:/city";
    }

    @PostMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("models", cityServer.findCity(id));
        model.addAttribute("city", new CityModel());
        return "adminPg0";
    }
}
