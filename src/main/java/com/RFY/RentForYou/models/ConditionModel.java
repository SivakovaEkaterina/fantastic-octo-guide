package com.RFY.RentForYou.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "condition")
public class ConditionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCondition;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String NameCondition;

    public ConditionModel(){}

    public ConditionModel(Long idCondition, String nameCondition) {
        IdCondition = idCondition;
        NameCondition = nameCondition;
    }

    public Long getId() {
        return IdCondition;
    }

    public void setId(Long idCondition) {
        IdCondition = idCondition;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getNameCondition() {
        return NameCondition;
    }

    public void setNameCondition(@Size(min = 3, message = "Имя не менее 3 символов") String nameCondition) {
        NameCondition = nameCondition;
    }
}
