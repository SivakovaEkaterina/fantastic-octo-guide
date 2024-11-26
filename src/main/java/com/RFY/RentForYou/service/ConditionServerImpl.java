package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.ConditionModel;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.ConditionRepository;

import java.util.List;

@Service
public class ConditionServerImpl implements ConditionServer {
    private final ConditionRepository conditionRepository;

    public ConditionServerImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public List<ConditionModel> findAllConditions() {
        return conditionRepository.findAll(Sort.by("id"));
    }

    @Override
    public ConditionModel findCondition(Long id) {
        return conditionRepository.findById(id).orElse(null);
    }

    @Override
    public ConditionModel addCondition(ConditionModel conditionModel) {
        return conditionRepository.save(conditionModel);
    }

    @Override
    public ConditionModel updateCondition(ConditionModel conditionModel) {
        if (conditionRepository.existsById(conditionModel.getId())) {
            return conditionRepository.save(conditionModel);
        }
        return null;
    }

    @Override
    public void deleteCondition(Long id) {
        if (conditionRepository.existsById(id)) {
            conditionRepository.deleteById(id);
        }
    }
}