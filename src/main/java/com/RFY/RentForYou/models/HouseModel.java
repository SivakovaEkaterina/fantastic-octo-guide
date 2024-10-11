package com.RFY.RentForYou.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
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
    @Pattern(regexp = "[0-9]{4}", message = "Неправильный формат года постройки")
    private Integer ConstructionYearHouse;

    @Column(name = "floors_count", nullable = true)
    @Pattern(regexp = "[0-9]+", message = "Неправильный формат количества этажей")
    private Integer FloorsCountHouse;

    @Column(name = "apartments_count", nullable = true)
    @Pattern(regexp = "[0-9]+", message = "Неправильный формат количества квартир")
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

    public @Pattern(regexp = "[0-9]{4}", message = "Неправильный формат года постройки") Integer getConstructionYearHouse() {
        return ConstructionYearHouse;
    }

    public void setConstructionYearHouse(@Pattern(regexp = "[0-9]{4}", message = "Неправильный формат года постройки") Integer constructionYearHouse) {
        ConstructionYearHouse = constructionYearHouse;
    }

    public @Pattern(regexp = "[0-9]+", message = "Неправильный формат количества этажей") Integer getFloorsCountHouse() {
        return FloorsCountHouse;
    }

    public void setFloorsCountHouse(@Pattern(regexp = "[0-9]+", message = "Неправильный формат количества этажей") Integer floorsCountHouse) {
        FloorsCountHouse = floorsCountHouse;
    }

    public @Pattern(regexp = "[0-9]+", message = "Неправильный формат количества квартир") Integer getApartmentsCountHouse() {
        return ApartmentsCountHouse;
    }

    public void setApartmentsCountHouse(@Pattern(regexp = "[0-9]+", message = "Неправильный формат количества квартир") Integer apartmentsCountHouse) {
        ApartmentsCountHouse = apartmentsCountHouse;
    }

    public UserModel getOwnerIdHouse() {
        return OwnerIdHouse;
    }

    public void setOwnerIdHouse(UserModel ownerIdHouse) {
        OwnerIdHouse = ownerIdHouse;
    }
}
