package com.RFY.RentForYou.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name", nullable = false)
    private String nickNameUser;

    @Column(name = "first_name", nullable = false)
    private String firstNameUser;

    @Column(name = "second_name", nullable = false)
    private String secondNameUser;

    @Column(name = "third_name", nullable = false)
    private String thirdNameUser;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumberUser;

    @Column(name = "email", nullable = false)
    private String emailUser;

    @Column(name = "login", nullable = false)
    private String loginUser;

    @Column(name = "password", nullable = false)
    private String passwordUser;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    public UserInfoModel(){};

    public UserInfoModel(Long id, String nickNameUser, String firstNameUser, String secondNameUser, String thirdNameUser, String phoneNumberUser, String emailUser, String loginUser, String passwordUser, UserModel user) {
        this.id = id;
        this.nickNameUser = nickNameUser;
        this.firstNameUser = firstNameUser;
        this.secondNameUser = secondNameUser;
        this.thirdNameUser = thirdNameUser;
        this.phoneNumberUser = phoneNumberUser;
        this.emailUser = emailUser;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickNameUser() {
        return nickNameUser;
    }

    public void setNickNameUser(String nickNameUser) {
        this.nickNameUser = nickNameUser;
    }

    public String getFirstNameUser() {
        return firstNameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        this.firstNameUser = firstNameUser;
    }

    public String getSecondNameUser() {
        return secondNameUser;
    }

    public void setSecondNameUser(String secondNameUser) {
        this.secondNameUser = secondNameUser;
    }

    public String getThirdNameUser() {
        return thirdNameUser;
    }

    public void setThirdNameUser(String thirdNameUser) {
        this.thirdNameUser = thirdNameUser;
    }

    public String getPhoneNumberUser() {
        return phoneNumberUser;
    }

    public void setPhoneNumberUser(String phoneNumberUser) {
        this.phoneNumberUser = phoneNumberUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
