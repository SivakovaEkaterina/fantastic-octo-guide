package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.CityModel;

import java.util.List;

public interface CityServer {
    public List<CityModel> findAllCity();
    public CityModel findCity(Long id);
    public CityModel addCity(CityModel cardModel);
    public CityModel updateCity(CityModel cardModel);
    public void deleteCity(Long id);
}
