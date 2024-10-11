package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.CityModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.CityRepository;

@Service
public class CityServerImpl extends CommonServerImpl<CityModel, Long, CityRepository> {
    public CityServerImpl(CityRepository repository) {
        super(repository);
    }
}
