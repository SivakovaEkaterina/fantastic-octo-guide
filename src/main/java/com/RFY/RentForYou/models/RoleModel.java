package com.RFY.RentForYou.models;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdRole;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String NameRole;

    public RoleModel(){}

    public RoleModel(Long idRole, String nameRole) {
        IdRole = idRole;
        NameRole = nameRole;
    }

    public Long getId() {
        return IdRole;
    }

    public void setId(Long idRole) {
        IdRole = idRole;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getNameRole() {
        return NameRole;
    }

    public void setNameRole(@Size(min = 3, message = "Имя не менее 3 символов") String nameRole) {
        NameRole = nameRole;
    }
}
