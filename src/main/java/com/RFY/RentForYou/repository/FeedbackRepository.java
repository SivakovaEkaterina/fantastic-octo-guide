package com.RFY.RentForYou.repository;

import com.RFY.RentForYou.models.FeedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<FeedbackModel, Long> {
}
