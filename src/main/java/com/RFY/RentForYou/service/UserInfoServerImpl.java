package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.UserInfoModel;
import com.RFY.RentForYou.models.UserModel;
import com.RFY.RentForYou.repository.UserInfoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.RFY.RentForYou.repository.UserRepository;

import java.util.List;

@Service
public class UserInfoServerImpl implements UserInfoServer {
    private final UserInfoRepository userInfoRepository;

    public UserInfoServerImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public List<UserInfoModel> findAllUsers() {
        return userInfoRepository.findAll(Sort.by("id"));
    }

    @Override
    public UserInfoModel findUser(Long id) {
        return userInfoRepository.findById(id).orElse(null);
    }

    @Override
    public UserInfoModel addUser(UserInfoModel userInfoModel) {
        return userInfoRepository.save(userInfoModel);
    }

    @Override
    public UserInfoModel updateUser(UserInfoModel userInfoModel) {
        if (userInfoRepository.existsById(userInfoModel.getId())) {
            return userInfoRepository.save(userInfoModel);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        if (userInfoRepository.existsById(id)) {
            userInfoRepository.deleteById(id);
        }
    }
}
