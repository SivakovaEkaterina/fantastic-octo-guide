package com.RFY.RentForYou.repository;

import com.RFY.RentForYou.models.UserModel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.ui.Model;


public interface UserRepository extends CrudRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    boolean existsByUsername(String username);
}
