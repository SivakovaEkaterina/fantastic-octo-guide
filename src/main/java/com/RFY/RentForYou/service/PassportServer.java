package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.PassportModel;

import java.util.List;

public interface PassportServer {
    public List<PassportModel> findAllPassport();
    public PassportModel findPassport(Long id);
    public PassportModel addPassport(PassportModel passportModel);
    public PassportModel updatePassport(PassportModel passportModel);
    public void deletePassport(Long id);
}
