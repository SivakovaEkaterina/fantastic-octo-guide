package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.RoleModel;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.RoleRepository;

@Service
public class RoleServerImpl extends CommonServerImpl<RoleModel, Long, RoleRepository> {
    public RoleServerImpl(RoleRepository repository) {
        super(repository);
    }
}
