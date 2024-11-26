package com.RFY.RentForYou.service;

import com.RFY.RentForYou.models.UserInfoModel;
import com.RFY.RentForYou.models.UserModel;

import java.util.List;

public interface UserInfoServer {
    List<UserInfoModel> findAllUsers();
    UserInfoModel findUser(Long id);
    UserInfoModel addUser(UserInfoModel userInfoModel);
    UserInfoModel updateUser(UserInfoModel userInfoModel);
    void deleteUser(Long id);
}
