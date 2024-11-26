package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.HouseModel;

import java.util.List;

public interface HouseServer {
    List<HouseModel> findAllHouses();
    HouseModel findHouse(Long id);
    HouseModel addHouse(HouseModel houseModel);
    HouseModel updateHouse(HouseModel houseModel);
    void deleteHouse(Long id);
}
