package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.ConditionModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.ConditionRepository;

@Service
public class ConditionServerImpl extends CommonServerImpl<ConditionModel, Long, ConditionRepository> {
    public ConditionServerImpl(ConditionRepository repository) {
        super(repository);
    }
}
