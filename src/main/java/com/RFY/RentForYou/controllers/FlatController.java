package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.FlatModel;
import com.RFY.RentForYou.service.FlatServer;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/flat")
@PreAuthorize("hasAnyAuthority('User')")
public class FlatController {
    private final FlatServer flatService;

    public FlatController(FlatServer flatService) {
        this.flatService = flatService;
    }

    @GetMapping("")
    public String getAllFlats(Model model) {
        String currentUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        model.addAttribute("currentUrl", currentUrl);
        model.addAttribute("flats", flatService.findAllFlats());
        model.addAttribute("flat", new FlatModel());
        return "flatPg";
    }

    @PostMapping("/add")
    public String addFlat(@Valid  @ModelAttribute("flat") FlatModel flatModel, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("flats", flatService.findAllFlats());
            return "flatPg";
        }
        flatService.addFlat(flatModel);
        return "redirect:/flat";
    }

    @PostMapping("/update")
    public String updateFlat(@Valid  @ModelAttribute("flat") FlatModel flatModel, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("flats", flatService.findAllFlats());
            return "flatPg";
        }
        flatService.updateFlat(flatModel);
        return "redirect:/flat";
    }

    @PostMapping("/delete")
    public String deleteFlat(@RequestParam Long id) {
        flatService.deleteFlat(id);
        return "redirect:/flat";
    }
}
