package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.service.*;
import jakarta.validation.Valid;
import com.RFY.RentForYou.models.CardModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@Controller
@RequestMapping("/card")
public class CardController {
    private final CardServerImpl cardServer;
    private final FlatServerImpl flatService;
    private final HouseServerImpl houseService;
    private final ConditionServerImpl conditionServer;

    public CardController(CardServerImpl cardServer, FlatServerImpl flatService, HouseServerImpl houseService, ConditionServerImpl conditionServer) {
        this.cardServer = cardServer;
        this.flatService = flatService;
        this.houseService = houseService;
        this.conditionServer = conditionServer;
    }

    @GetMapping("")
    public String getAll(Model model) {
        String currentUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        model.addAttribute("currentUrl", currentUrl);
        model.addAttribute("cards", cardServer.findAllCard());
        model.addAttribute("card", new CardModel());
        model.addAttribute("flats", flatService.findAllFlats());
        model.addAttribute("houses", houseService.findAllHouses());
        model.addAttribute("conditions", conditionServer.findAllConditions());

        return "cardPg"; // Название вашей HTML страницы
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("card") CardModel card,
                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cards", cardServer.findAllCard());
            model.addAttribute("flats", flatService.findAllFlats());
            model.addAttribute("houses", houseService.findAllHouses());
            model.addAttribute("conditions", conditionServer.findAllConditions());
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
    public String delete(@RequestParam UUID id) {
        cardServer.deleteCard(id);
        return "redirect:/card";
    }

    @PostMapping("/{id}")
    public String getId(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("card", cardServer.findCard(id));
        model.addAttribute("flats", flatService.findAllFlats());
        model.addAttribute("houses", houseService.findAllHouses());
        return "cardPg";
    }
}
