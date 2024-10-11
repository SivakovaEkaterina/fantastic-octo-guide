package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.FeedbackModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.FeedbackRepository;

@Service
public class FeedbackServerImpl extends CommonServerImpl<FeedbackModel, Long, FeedbackRepository> {
    public FeedbackServerImpl(FeedbackRepository repository) {
        super(repository);
    }
}
