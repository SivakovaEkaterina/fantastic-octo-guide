package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.CardModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.CardRepository;

@Service
public class CardServerImpl extends CommonServerImpl<CardModel, Long, CardRepository> {
    public CardServerImpl(CardRepository repository) {
        super(repository);
    }
}
