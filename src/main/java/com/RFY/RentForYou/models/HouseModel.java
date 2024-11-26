package com.RFY.RentForYou.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

@Entity
@Table(name = "house")
public class HouseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdHouse;

    @Column(name = "name", nullable = false)
    private String NameHouse;

    @Column(name = "city_id", nullable = false)
    private Long CityIdHouse;

    @Column(name = "street", nullable = false)
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
    @Min(value = 0, message = "этаж не может быть отрицательным")
    private Integer FloorsCountHouse;

    @Column(name = "apartments_count", nullable = true)
    @Min(value = 0, message = "колличество комнат не может быть отрицательным")
    private Integer ApartmentsCountHouse;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "IdUser")
    private UserModel OwnerIdHouse;

    public HouseModel(){}
    public HouseModel(Long idHouse, String nameHouse, Long cityIdHouse, String streetHouse, String houseNumberHouse, BigDecimal areaHouse, Integer constructionYearHouse, Integer floorsCountHouse, Integer apartmentsCountHouse, UserModel ownerIdHouse) {
        IdHouse = idHouse;
        NameHouse = nameHouse;
        CityIdHouse = cityIdHouse;
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

    public String getNameHouse() {
        return NameHouse;
    }

    public void setNameHouse(String nameHouse) {
        NameHouse = nameHouse;
    }

    public Long getCityIdHouse() {
        return CityIdHouse;
    }

    public void setCityIdHouse(Long cityIdHouse) {
        CityIdHouse = cityIdHouse;
    }

    public String getStreetHouse() {
        return StreetHouse;
    }

    public void setStreetHouse(String streetHouse) {
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

    public @Min(value = 0, message = "этаж не может быть отрицательным") Integer getFloorsCountHouse() {
        return FloorsCountHouse;
    }

    public void setFloorsCountHouse(@Min(value = 0, message = "этаж не может быть отрицательным") Integer floorsCountHouse) {
        FloorsCountHouse = floorsCountHouse;
    }

    public @Min(value = 0, message = "колличество комнат не может быть отрицательным") Integer getApartmentsCountHouse() {
        return ApartmentsCountHouse;
    }

    public void setApartmentsCountHouse(@Min(value = 0, message = "колличество комнат не может быть отрицательным") Integer apartmentsCountHouse) {
        ApartmentsCountHouse = apartmentsCountHouse;
    }

    public UserModel getOwnerIdHouse() {
        return OwnerIdHouse;
    }

    public void setOwnerIdHouse(UserModel ownerIdHouse) {
        OwnerIdHouse = ownerIdHouse;
    }
}
