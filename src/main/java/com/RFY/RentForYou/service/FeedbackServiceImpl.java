package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.FeedbackModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.FeedbackRepository;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackServer{
    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<FeedbackModel> findAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public FeedbackModel findFeedback(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public FeedbackModel addFeedback(FeedbackModel feedbackModel) {
        return feedbackRepository.save(feedbackModel);
    }

    @Override
    public FeedbackModel updateFeedback(FeedbackModel feedbackModel) {
        if (feedbackRepository.existsById(feedbackModel.getId())) {
            return feedbackRepository.save(feedbackModel);
        }
        return null;
    }

    @Override
    public void deleteFeedback(Long id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
        }
    }
}
