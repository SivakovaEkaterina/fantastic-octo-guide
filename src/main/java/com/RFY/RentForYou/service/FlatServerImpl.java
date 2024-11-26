package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.FlatModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.FlatRepository;

import java.util.List;

@Service
public class FlatServerImpl implements FlatServer {
    private final FlatRepository flatRepository;

    public FlatServerImpl(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    @Override
    public List<FlatModel> findAllFlats() {
        return flatRepository.findAll();
    }

    @Override
    public FlatModel findFlat(Long id) {
        return flatRepository.findById(id).orElse(null);
    }

    @Override
    public FlatModel addFlat(FlatModel flatModel) {
        return flatRepository.save(flatModel);
    }

    @Override
    public FlatModel updateFlat(FlatModel flatModel) {
        if (flatRepository.existsById(flatModel.getId())) {
            return flatRepository.save(flatModel);
        }
        return null;
    }

    @Override
    public void deleteFlat(Long id) {
        if (flatRepository.existsById(id)) {
            flatRepository.deleteById(id);
        }
    }
}
