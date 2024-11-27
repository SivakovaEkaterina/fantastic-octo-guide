package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.service.FlatServerImpl;
import com.RFY.RentForYou.service.HouseServerImpl;
import jakarta.validation.Valid;
import com.RFY.RentForYou.models.CardModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.RFY.RentForYou.service.CardServerImpl;

@Controller
@RequestMapping("/card")
public class CardController {
    private final CardServerImpl cardServer;
    private final FlatServerImpl flatService;
    private final HouseServerImpl houseService;

    public CardController(CardServerImpl cardServer, FlatServerImpl flatService, HouseServerImpl houseService) {
        this.cardServer = cardServer;
        this.flatService = flatService;
        this.houseService = houseService;
    }

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("cards", cardServer.findAllCard());
        model.addAttribute("card", new CardModel());
        model.addAttribute("flats", flatService.findAllFlats());
        model.addAttribute("houses", houseService.findAllHouses());
        return "cardPg"; // Название вашей HTML страницы
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("card") CardModel card,
                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cards", cardServer.findAllCard());
            model.addAttribute("flats", flatService.findAllFlats());
            model.addAttribute("houses", houseService.findAllHouses());
            return "cardPg";
        }
        cardServer.addCard(card);
        return "redirect:/card";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("card") CardModel card, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("flats", flatService.findAllFlats());
            model.addAttribute("houses", houseService.findAllHouses());
            return "cardPg";
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
        model.addAttribute("flats", flatService.findAllFlats());
        model.addAttribute("houses", houseService.findAllHouses());
        return "cardPg";
    }
}
