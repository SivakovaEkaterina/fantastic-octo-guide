package com.RFY.RentForYou.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "user_in")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUser;
    @Column(name = "nickname", nullable = false)
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String NickNameUser;
    @Column(name = "first_name", nullable = false)
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String FirstNameUser;
    @Column(name = "second_name", nullable = false)
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String SecondNameUser;
    @Nullable
    @Column(name = "third_name", nullable = false)
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String ThirdNameUser;
    @Nullable
    @OneToOne
    @JoinColumn(name = "id_picture", referencedColumnName = "IdPicture")
    private PictureModel IdPicture;
    @Nullable
    @OneToOne
    @JoinColumn(name = "passport_id", referencedColumnName = "IdPassport")
    private PassportModel IdPassport;
    /*@Nullable
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "IdRole")
    private RoleModel IdRole;*/
    @Nullable
    @Pattern(regexp = "\\d+", message = "Поле должно содержать только цифры")
    private String PhoneNumberUser;
    @Nullable
    @Email(message = "Некорректный email")
    private String EmailUser;
    @Size(min = 3, message = "Логин не менее 3 символов")
    private String LoginUser;
    @Size(min = 6, message = "Пароль не менее 6 символов")
    private String PasswordUser;
    private boolean active;
    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEnum> roles;



    public UserModel(){}

    public UserModel(Long idUser, String nickNameUser, String firstNameUser, String secondNameUser, @Nullable String thirdNameUser, @Nullable PictureModel idPicture, @Nullable PassportModel idPassport, @Nullable String phoneNumberUser,@Nullable String emailUser, String loginUser, String passwordUser, boolean active, Set<RoleEnum> roles) {
        IdUser = idUser;
        NickNameUser = nickNameUser;
        FirstNameUser = firstNameUser;
        SecondNameUser = secondNameUser;
        ThirdNameUser = thirdNameUser;
        IdPicture = idPicture;
        IdPassport = idPassport;
        PhoneNumberUser = phoneNumberUser;
        EmailUser = emailUser;
        LoginUser = loginUser;
        PasswordUser = passwordUser;
        this.active = active;
        this.roles = roles;
    }

    public Long getIdUser() {
        return IdUser;
    }

    public void setIdUser(Long idUser) {
        IdUser = idUser;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getNickNameUser() {
        return NickNameUser;
    }

    public void setNickNameUser(@Size(min = 3, message = "Имя не менее 3 символов") String nickNameUser) {
        NickNameUser = nickNameUser;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getFirstNameUser() {
        return FirstNameUser;
    }

    public void setFirstNameUser(@Size(min = 3, message = "Имя не менее 3 символов") String firstNameUser) {
        FirstNameUser = firstNameUser;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getSecondNameUser() {
        return SecondNameUser;
    }

    public void setSecondNameUser(@Size(min = 3, message = "Имя не менее 3 символов") String secondNameUser) {
        SecondNameUser = secondNameUser;
    }

    @Nullable
    public @Size(min = 3, message = "Имя не менее 3 символов") String getThirdNameUser() {
        return ThirdNameUser;
    }

    public void setThirdNameUser(@Nullable @Size(min = 3, message = "Имя не менее 3 символов") String thirdNameUser) {
        ThirdNameUser = thirdNameUser;
    }

    @Nullable
    public PictureModel getIdPicture() {
        return IdPicture;
    }

    public void setIdPicture(@Nullable PictureModel idPicture) {
        IdPicture = idPicture;
    }

    @Nullable
    public PassportModel getIdPassport() {
        return IdPassport;
    }

    public void setIdPassport(@Nullable PassportModel idPassport) {
        IdPassport = idPassport;
    }

    @Nullable
    public @Pattern(regexp = "\\d+", message = "Поле должно содержать только цифры") String getPhoneNumberUser() {
        return PhoneNumberUser;
    }

    public void setPhoneNumberUser(@Nullable @Pattern(regexp = "\\d+", message = "Поле должно содержать только цифры") String phoneNumberUser) {
        PhoneNumberUser = phoneNumberUser;
    }

    public @Email(message = "Некорректный email") String getEmailUser() {
        return EmailUser;
    }

    public void setEmailUser(@Email(message = "Некорректный email") String emailUser) {
        EmailUser = emailUser;
    }

    public @Size(min = 3, message = "Логин не менее 3 символов") String getLoginUser() {
        return LoginUser;
    }

    public void setLoginUser(@Size(min = 3, message = "Логин не менее 3 символов") String loginUser) {
        LoginUser = loginUser;
    }

    public @Size(min = 6, message = "Пароль не менее 6 символов") String getPasswordUser() {
        return PasswordUser;
    }

    public void setPasswordUser(@Size(min = 6, message = "Пароль не менее 6 символов") String passwordUser) {
        PasswordUser = passwordUser;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEnum> roles) {
        this.roles = roles;
    }
}
