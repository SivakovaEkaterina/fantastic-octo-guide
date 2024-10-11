package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.CityModel;
import com.RFY.RentForYou.service.CityServerImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/city")
public class CityController {
    private final CityServerImpl cityServer;

    public CityController(CityServerImpl cityServer) {
        this.cityServer = cityServer;
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("entities", cityServer.findAll());
        model.addAttribute("newEntity", new CityModel()); // renamed to "newEntity"
        return "adminPg0";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("newEntity") CityModel card,
                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("entities", cityServer.findAll());
            return "adminPg0";
        }
        cityServer.add(card);
        return "redirect:/city";
    }


    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("existingEntity") CityModel card, BindingResult result) {
        cityServer.update(card);
        return "redirect:/city";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        cityServer.delete(id);
        return "redirect:/city";
    }

    @PostMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("existingEntity", cityServer.find(id));
        model.addAttribute("newEntity", new CityModel());
        return "adminPg0";
    }
}
