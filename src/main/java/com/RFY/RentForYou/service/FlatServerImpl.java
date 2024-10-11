package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.FlatModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.FlatRepository;

@Service
public class FlatServerImpl extends CommonServerImpl<FlatModel, Long, FlatRepository> {
    public FlatServerImpl(FlatRepository repository) {
        super(repository);
    }
}
