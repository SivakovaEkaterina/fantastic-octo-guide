package com.RFY.RentForYou.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "city")
public class CityModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCity;
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String NameCity;

    public CityModel(){}

    public CityModel(Long idCity, String nameCity) {
        IdCity = idCity;
        NameCity = nameCity;
    }

    public Long getId() {
        return IdCity;
    }

    public void setId(Long idCity) {
        IdCity = idCity;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getNameCity() {
        return NameCity;
    }

    public void setNameCity(@Size(min = 3, message = "Имя не менее 3 символов") String nameCity) {
        NameCity = nameCity;
    }
}
