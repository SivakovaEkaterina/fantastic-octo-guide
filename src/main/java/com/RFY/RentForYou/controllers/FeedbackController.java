package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.CardModel;
import com.RFY.RentForYou.models.CityModel;
import com.RFY.RentForYou.models.ConditionModel;
import com.RFY.RentForYou.models.FeedbackModel;
import com.RFY.RentForYou.service.CardServer;
import com.RFY.RentForYou.service.CardServerImpl;
import com.RFY.RentForYou.service.CityServer;
import com.RFY.RentForYou.service.FeedbackServer;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/feedback")
@PreAuthorize("hasAnyAuthority('Manager')")
public class FeedbackController {
    private final FeedbackServer feedbackService;
    private final CardServer cardService;

    public FeedbackController(FeedbackServer feedbackService, CardServer cardService) {
        this.feedbackService = feedbackService;
        this.cardService = cardService;
    }

    @GetMapping("")
    public String getAllFeedbacks(Model model) {
        String currentUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        model.addAttribute("currentUrl", currentUrl);
        model.addAttribute("feedbacks", feedbackService.findAllFeedbacks());
        model.addAttribute("feedback", new FeedbackModel());

        List<CardModel> cards = cardService.findAllCard();
        model.addAttribute("cards", cards);

        return "feedbackPg"; // имя вашего HTML-шаблона
    }

    @PostMapping("/add")
    public String addFeedback(@Valid @ModelAttribute("feedback") FeedbackModel feedbackModel,
                              BindingResult result, Model model ) {
        if (result.hasErrors()) {
            String currentUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
            model.addAttribute("currentUrl", currentUrl);
            model.addAttribute("feedbacks", feedbackService.findAllFeedbacks());
            return "feedbackPg"; // Название вашей HTML страницы
        }
        feedbackService.addFeedback(feedbackModel);
        return "redirect:/feedback";
    }

    @PostMapping("/update")
    public String updateFeedback(@ModelAttribute FeedbackModel feedbackModel) {
        feedbackService.updateFeedback(feedbackModel);
        return "redirect:/feedback";
    }

    @PostMapping("/delete")
    public String deleteFeedback(@RequestParam Long id) {
        feedbackService.deleteFeedback(id);
        return "redirect:/feedback";
    }
}