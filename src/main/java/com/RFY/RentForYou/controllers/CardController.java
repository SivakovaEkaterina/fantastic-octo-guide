package com.RFY.RentForYou.controllers;

import jakarta.validation.Valid;
import com.RFY.RentForYou.models.CardModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.RFY.RentForYou.service.CardServerImpl;

@Controller
@RequestMapping("/card")
public class CardController {
    private final CardServerImpl cardServer;

    public CardController(CardServerImpl cardServer) {
        this.cardServer = cardServer;
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("entities", cardServer.findAllCard());
        model.addAttribute("newEntity", new CardModel());
        return "adminPg0";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("newEntity") CardModel card, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("entities", cardServer.findAllCard());
            return "adminPg0";
        }
        cardServer.addCard(card);
        return "redirect:/card";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("existingEntity") CardModel card, BindingResult result) {
        cardServer.updateCard(card);
        return "redirect:/card";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        cardServer.deleteCard(id);
        return "redirect:/card";
    }

    @PostMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("existingEntity", cardServer.findCard(id));
        model.addAttribute("newEntity", new CardModel());
        return "adminPg0";
    }
}
