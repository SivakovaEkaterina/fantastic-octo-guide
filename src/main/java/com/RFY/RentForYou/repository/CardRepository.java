package com.RFY.RentForYou.repository;

import com.RFY.RentForYou.models.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardModel, Long> {
}
