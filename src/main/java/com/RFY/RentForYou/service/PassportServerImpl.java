package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.PassportModel;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.PassportRepository;

import java.util.List;

@Service
public class PassportServerImpl implements PassportServer {
    private final PassportRepository passportRepository;

    public PassportServerImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public List<PassportModel> findAllPassport(){
        return passportRepository.findAll(Sort.by("id"));
    }

    @Override
    public PassportModel findPassport(Long id){
        return passportRepository.findById(id).orElse(null);
    }

    @Override
    public PassportModel addPassport(PassportModel passportModel){
        return passportRepository.save(passportModel);
    }

    @Override
    public PassportModel updatePassport(PassportModel passportModel){
        if (passportRepository.existsById(passportModel.getId())) {
            return passportRepository.save(passportModel);
        }
        return null;
    }

    @Override
    public void deletePassport(Long id){
        if (passportRepository.existsById(id)) {
            passportRepository.deleteById(id);
        }
    }
}
