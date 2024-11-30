package com.RFY.RentForYou.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Table(name = "user_in")
@Entity
public class UserModel {
    @Id
    @GeneratedValue
    private Long idUser;

    @Size(min = 3, message = "Логин должен быть длиной не менее 3 символов")
    private String username;
    @Size(min = 3, message = "Пароль должен быть длиной не менее 3 символов")
    @Pattern(regexp = "^.*[*\\/|$&-+].*$", message = "Пароль должен содержать хотя бы один специальный символ")
    private String password;
    private boolean active;

    @ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEnum> roles;

    public UserModel() {

    }

    public UserModel(String username, String password, boolean active, Set<RoleEnum> roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public @Size(min = 3, message = "Логин должен быть длиной не менее 3 символов") String getUsername() {
        return username;
    }

    public void setUsername(@Size(min = 3, message = "Логин должен быть длиной не менее 3 символов") String username) {
        this.username = username;
    }

    public @Size(min = 3, message = "Пароль должен быть длиной не менее 3 символов") @Pattern(regexp = "^.*[*\\/|$&-+].*$", message = "Пароль должен содержать хотя бы один специальный символ") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 3, message = "Пароль должен быть длиной не менее 3 символов") @Pattern(regexp = "^.*[*\\/|$&-+].*$", message = "Пароль должен содержать хотя бы один специальный символ") String password) {
        this.password = password;
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



