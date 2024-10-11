/*
package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.UserModel;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.UserRepository;

import java.util.List;

@Service
public class UserServerImpl implements UserServer {
    private final UserRepository userRepository;

    public UserServerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAllUser (){
        return userRepository.findAll(Sort.by("id"));
    }

    @Override
    public UserModel findUser (Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel addUser(UserModel userModel){
        return userRepository.save(userModel);
    }

    @Override
    public UserModel updateUser(UserModel userModel){
        if (userRepository.existsById(userModel.getId())) {
            return userRepository.save(userModel);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
*/
