package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.HousePictureModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.HousePictureRepository;

@Service
public class HousePictureServerImpl extends CommonServerImpl<HousePictureModel, Long, HousePictureRepository> {
    public HousePictureServerImpl(HousePictureRepository repository) {
        super(repository);
    }
}
