package com.RFY.RentForYou.service;


import com.RFY.RentForYou.models.HouseModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.HouseRepository;

@Service
public class HouseServerImpl  extends CommonServerImpl<HouseModel, Long, HouseRepository> {
    public HouseServerImpl(HouseRepository repository) {
        super(repository);
    }
}
