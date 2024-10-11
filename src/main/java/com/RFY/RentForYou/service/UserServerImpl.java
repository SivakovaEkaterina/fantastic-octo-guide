package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.UserModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.UserRepository;

@Service
public class UserServerImpl extends CommonServerImpl<UserModel, Long, UserRepository> {
    public UserServerImpl(UserRepository repository) {
        super(repository);
    }
}
