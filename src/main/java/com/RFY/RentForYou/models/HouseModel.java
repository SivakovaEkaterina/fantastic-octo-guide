package com.RFY.RentForYou.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "house")
public class HouseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdHouse;

    @Column(name = "name", nullable = false)
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String NameHouse;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "IdCity")
    private CityModel CityModel;

    @Column(name = "street", nullable = false)
    @Size(min = 3, message = "Имя не менее 3 символов")
    private String StreetHouse;

    @Column(name = "house_number", nullable = false)
    private String HouseNumberHouse;

    @Column(name = "area", nullable = false)
    @Digits(integer = 10, fraction = 2, message = "Неправильный формат площади")
    private BigDecimal AreaHouse;

    @Column(name = "construction_year", nullable = true)
    @Min(value = 1900, message = "год не может быть ранее 1900")
    private Integer ConstructionYearHouse;

    @Column(name = "floors_count", nullable = true)
    @Min(value = 1, message = "этажей не может быть меньше 1")
    private Integer FloorsCountHouse;

    @Column(name = "apartments_count", nullable = true)
    @Min(value = 1, message = "колличество комнат не может быть меньше 1")
    private Integer ApartmentsCountHouse;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "IdUser")
    private UserModel OwnerIdHouse;

    public HouseModel(){}
    public HouseModel(Long idHouse, String nameHouse, CityModel cityIdHouse, String streetHouse, String houseNumberHouse, BigDecimal areaHouse, Integer constructionYearHouse, Integer floorsCountHouse, Integer apartmentsCountHouse, UserModel ownerIdHouse) {
        IdHouse = idHouse;
        NameHouse = nameHouse;
        CityModel = cityIdHouse;
        StreetHouse = streetHouse;
        HouseNumberHouse = houseNumberHouse;
        AreaHouse = areaHouse;
        ConstructionYearHouse = constructionYearHouse;
        FloorsCountHouse = floorsCountHouse;
        ApartmentsCountHouse = apartmentsCountHouse;
        OwnerIdHouse = ownerIdHouse;
    }

    public Long getId() {
        return IdHouse;
    }

    public void setId(Long idHouse) {
        IdHouse = idHouse;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getNameHouse() {
        return NameHouse;
    }

    public void setNameHouse(@Size(min = 3, message = "Имя не менее 3 символов") String nameHouse) {
        NameHouse = nameHouse;
    }

    public com.RFY.RentForYou.models.CityModel getCityModel() {
        return CityModel;
    }

    public void setCityModel(com.RFY.RentForYou.models.CityModel cityModel) {
        CityModel = cityModel;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getStreetHouse() {
        return StreetHouse;
    }

    public void setStreetHouse(@Size(min = 3, message = "Имя не менее 3 символов") String streetHouse) {
        StreetHouse = streetHouse;
    }

    public String getHouseNumberHouse() {
        return HouseNumberHouse;
    }

    public void setHouseNumberHouse(String houseNumberHouse) {
        HouseNumberHouse = houseNumberHouse;
    }

    public @Digits(integer = 10, fraction = 2, message = "Неправильный формат площади") BigDecimal getAreaHouse() {
        return AreaHouse;
    }

    public void setAreaHouse(@Digits(integer = 10, fraction = 2, message = "Неправильный формат площади") BigDecimal areaHouse) {
        AreaHouse = areaHouse;
    }

    public @Min(value = 1900, message = "год не может быть ранее 1900") Integer getConstructionYearHouse() {
        return ConstructionYearHouse;
    }

    public void setConstructionYearHouse(@Min(value = 1900, message = "год не может быть ранее 1900") Integer constructionYearHouse) {
        ConstructionYearHouse = constructionYearHouse;
    }

    public @Min(value = 1, message = "этажей не может быть меньше 1") Integer getFloorsCountHouse() {
        return FloorsCountHouse;
    }

    public void setFloorsCountHouse(@Min(value = 0, message = "этажей не может быть меньше 1") Integer floorsCountHouse) {
        FloorsCountHouse = floorsCountHouse;
    }

    public @Min(value = 0, message = "колличество комнат не может быть меньше 1") Integer getApartmentsCountHouse() {
        return ApartmentsCountHouse;
    }

    public void setApartmentsCountHouse(@Min(value = 0, message = "колличество комнат не может быть меньше 1") Integer apartmentsCountHouse) {
        ApartmentsCountHouse = apartmentsCountHouse;
    }

    public UserModel getOwnerIdHouse() {
        return OwnerIdHouse;
    }

    public void setOwnerIdHouse(UserModel ownerIdHouse) {
        OwnerIdHouse = ownerIdHouse;
    }
}
