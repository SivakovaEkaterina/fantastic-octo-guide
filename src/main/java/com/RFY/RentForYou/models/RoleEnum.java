package com.RFY.RentForYou.models;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    User, Admin, Manager;

    @Override
    public String getAuthority() {
        return name();
    }
}
