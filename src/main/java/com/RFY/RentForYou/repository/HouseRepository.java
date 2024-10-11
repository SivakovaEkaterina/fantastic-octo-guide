package com.RFY.RentForYou.repository;

import com.RFY.RentForYou.models.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<HouseModel, Long> {
}
