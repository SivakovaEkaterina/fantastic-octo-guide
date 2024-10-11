package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.RoleModel;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServerImpl implements RoleServer {
    private final RoleRepository roleRepository;

    public RoleServerImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleModel> findAllRole(){
        return roleRepository.findAll(Sort.by("id"));
    }

    @Override
    public RoleModel findRole(Long id){
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public RoleModel addRole(RoleModel roleModel){
        return roleRepository.save(roleModel);
    }

    @Override
    public RoleModel updateRole(RoleModel roleModel){
        if (roleRepository.existsById(roleModel.getId())) {
            return roleRepository.save(roleModel);
        }
        return null;
    }

    @Override
    public void deleteRole(Long id){
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        }
    }
}
