package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.ConditionModel;
import com.RFY.RentForYou.service.ConditionServerImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/condition")
public class ConditionController {
    private final ConditionServerImpl conditionServer;

    public ConditionController(ConditionServerImpl conditionServer) {
        this.conditionServer = conditionServer;
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("conditions", conditionServer.findAllConditions());
        model.addAttribute("condition", new ConditionModel());
        return "conditionPg"; // Название вашей HTML страницы
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("condition") ConditionModel condition,
                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("conditions", conditionServer.findAllConditions());
            return "adminConditions"; // Название вашей HTML страницы
        }
        conditionServer.addCondition(condition);
        return "redirect:/condition";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("condition") ConditionModel condition, BindingResult result) {
        if (result.hasErrors()) {
            return "adminConditions"; // Название вашей HTML страницы
        }
        conditionServer.updateCondition(condition);
        return "redirect:/condition";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        conditionServer.deleteCondition(id);
        return "redirect:/condition";
    }

    @PostMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("condition", conditionServer.findCondition(id));
        return "adminConditions"; // Название вашей HTML страницы
    }
}
