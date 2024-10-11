package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.CardModel;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.CardRepository;

import java.util.List;

@Service
public class CardServerImpl implements CardServer{
    private final CardRepository cardRepository;

    public CardServerImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<CardModel> findAllCard(){
        return cardRepository.findAll(Sort.by("id"));
    }

    @Override
    public CardModel findCard(Long id){
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public CardModel addCard(CardModel cardModel){
        return cardRepository.save(cardModel);
    }

    @Override
    public CardModel updateCard(CardModel cardModel){
        if (cardRepository.existsById(cardModel.getId())) {
            return cardRepository.save(cardModel);
        }
        return null;
    }

    @Override
    public void deleteCard(Long id){
        if (cardRepository.existsById(id)) {
            cardRepository.deleteById(id);
        }

    }
}
