package com.RFY.RentForYou.repository;

import com.RFY.RentForYou.models.UserModel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long> {
}
