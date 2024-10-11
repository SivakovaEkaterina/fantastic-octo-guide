package com.RFY.RentForYou.repository;

import com.RFY.RentForYou.models.CityModel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface CityRepository extends JpaRepository<CityModel, Long> {
}
