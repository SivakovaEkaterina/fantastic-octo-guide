package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.PictureModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.PictureRepository;

@Service
public class PictureServerImpl extends CommonServerImpl<PictureModel, Long, PictureRepository> {
    public PictureServerImpl(PictureRepository repository) {
        super(repository);
    }
}
