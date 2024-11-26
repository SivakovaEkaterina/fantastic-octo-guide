package com.RFY.RentForYou.service;


import com.RFY.RentForYou.models.HouseModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.HouseRepository;

import java.util.List;

@Service
public class HouseServerImpl implements HouseServer {
    private final HouseRepository houseRepository;

    public HouseServerImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public List<HouseModel> findAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public HouseModel findHouse(Long id) {
        return houseRepository.findById(id).orElse(null);
    }

    @Override
    public HouseModel addHouse(HouseModel houseModel) {
        return houseRepository.save(houseModel);
    }

    @Override
    public HouseModel updateHouse(HouseModel houseModel) {
        if (houseRepository.existsById(houseModel.getId())) {
            return houseRepository.save(houseModel);
        }
        return null;
    }

    @Override
    public void deleteHouse(Long id) {
        if (houseRepository.existsById(id)) {
            houseRepository.deleteById(id);
        }
    }
}
