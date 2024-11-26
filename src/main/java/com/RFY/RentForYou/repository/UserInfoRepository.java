package com.RFY.RentForYou.repository;

import com.RFY.RentForYou.models.UserInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfoModel, Long> {
}
