package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.PassportModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.PassportRepository;

@Service
public class PassrortServerImpl extends CommonServerImpl<PassportModel, Long, PassportRepository> {
    public PassrortServerImpl(PassportRepository repository) {
        super(repository);
    }
}
