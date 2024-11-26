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
        model.addAttribute("cards", cardServer.findAllCard());
        model.addAttribute("card", new CardModel());
        return "cardPg"; // Название вашей HTML страницы
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("card") CardModel card,
                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cards", cardServer.findAllCard());
            return "cardPg"; // Название вашей HTML страницы
        }
        cardServer.addCard(card);
        return "redirect:/card";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("card") CardModel card, BindingResult result) {
        if (result.hasErrors()) {
            return "cardPg"; // Название вашей HTML страницы
        }
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
        model.addAttribute("card", cardServer.findCard(id));
        return "cardPg"; // Название вашей HTML страницы
    }
}
