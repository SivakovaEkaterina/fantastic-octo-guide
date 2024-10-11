package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.RoleModel;

import java.util.List;

public interface RoleServer {
    public List<RoleModel> findAllRole();
    public RoleModel findRole(Long id);
    public RoleModel addRole(RoleModel roleModel);
    public RoleModel updateRole(RoleModel roleModel);
    public void deleteRole(Long id);
}
