package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.CardModel;

import java.util.List;
import java.util.UUID;

public interface CardServer {
    public List<CardModel> findAllCard();
    public CardModel findCard(UUID id);
    public CardModel addCard(CardModel cardModel);
    public CardModel updateCard(CardModel cardModel);
    public void deleteCard(UUID id);
}
