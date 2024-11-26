package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.FeedbackModel;

import java.util.List;

public interface FeedbackServer {
    List<FeedbackModel> findAllFeedbacks();
    FeedbackModel findFeedback(Long id);
    FeedbackModel addFeedback(FeedbackModel feedbackModel);
    FeedbackModel updateFeedback(FeedbackModel feedbackModel);
    void deleteFeedback(Long id);
}
