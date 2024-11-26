package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.FlatModel;
import com.RFY.RentForYou.service.FlatServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flat")
public class FlatController {
    private final FlatServer flatService;

    public FlatController(FlatServer flatService) {
        this.flatService = flatService;
    }

    @GetMapping("")
    public String getAllFlats(Model model) {
        model.addAttribute("flats", flatService.findAllFlats());
        model.addAttribute("flat", new FlatModel());
        return "flatPg"; // имя вашего HTML-шаблона
    }

    @PostMapping("/add")
    public String addFlat(@ModelAttribute FlatModel flatModel) {
        flatService.addFlat(flatModel);
        return "redirect:/flat";
    }

    @PostMapping("/update")
    public String updateFlat(@ModelAttribute FlatModel flatModel) {
        flatService.updateFlat(flatModel);
        return "redirect:/flat";
    }

    @PostMapping("/delete")
    public String deleteFlat(@RequestParam Long id) {
        flatService.deleteFlat(id);
        return "redirect:/flat";
    }
}
