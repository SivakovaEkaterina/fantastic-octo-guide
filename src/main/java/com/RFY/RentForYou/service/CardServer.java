package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.CardModel;

import java.util.List;

public interface CardServer {
    public List<CardModel> findAllCard();
    public CardModel findCard(Long id);
    public CardModel addCard(CardModel cardModel);
    public CardModel updateCard(CardModel cardModel);
    public void deleteCard(Long id);
}
