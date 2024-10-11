package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.CityModel;
import com.RFY.RentForYou.repository.CityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServerImpl implements CityServer{
    private final CityRepository cityRepository;

    public CityServerImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityModel> findAllCity(){
        return cityRepository.findAll(Sort.by("id"));
    }

    @Override
    public CityModel findCity(Long id){
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public CityModel addCity(CityModel cityModel){
        return cityRepository.save(cityModel);
    }

    @Override
    public CityModel updateCity(CityModel cityModel){
        if (cityRepository.existsById(cityModel.getId())) {
            return cityRepository.save(cityModel);
        }
        return null;
    }

    @Override
    public void deleteCity(Long id){
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
        }

    }
}
