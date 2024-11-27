package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.FeedbackModel;
import com.RFY.RentForYou.service.FeedbackServer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedback")
@PreAuthorize("hasAnyAuthority('Manager')")
public class FeedbackController {
    private final FeedbackServer feedbackService;

    public FeedbackController(FeedbackServer feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("")
    public String getAllFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAllFeedbacks());
        model.addAttribute("feedback", new FeedbackModel());
        return "feedbackPg"; // имя вашего HTML-шаблона
    }

    @PostMapping("/add")
    public String addFeedback(@ModelAttribute FeedbackModel feedbackModel) {
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