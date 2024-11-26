package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.ConditionModel;

import java.util.List;

public interface ConditionServer {
    List<ConditionModel> findAllConditions();
    ConditionModel findCondition(Long id);
    ConditionModel addCondition(ConditionModel conditionModel);
    ConditionModel updateCondition(ConditionModel conditionModel);
    void deleteCondition(Long id);
}
