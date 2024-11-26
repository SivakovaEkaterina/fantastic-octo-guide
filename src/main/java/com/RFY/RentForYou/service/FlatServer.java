package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.FlatModel;

import java.util.List;

public interface FlatServer {
    List<FlatModel> findAllFlats();
    FlatModel findFlat(Long id);
    FlatModel addFlat(FlatModel flatModel);
    FlatModel updateFlat(FlatModel flatModel);
    void deleteFlat(Long id);
}
