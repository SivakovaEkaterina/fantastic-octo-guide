package com.RFY.RentForYou.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "flat")
public class FlatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdFlat;

    @Size(min = 3, message = "Имя не менее 3 символов")
    private String NameFlat;

    @Column(name = "flat_number", nullable = false)
    private String FlatNumberFlat;

    @Column(name = "house_number", nullable = false)
    private String HouseNumberFlat;

    @Column(name = "floor_number", nullable = false)
    @Pattern(regexp = "[0-9]+", message = "Неправильный формат этажа")
    private Integer FloorNumberFlat;

    @Column(name = "apartment_number", nullable = false)
    private String ApartmentNumberFlat;

    @Column(name = "area", nullable = false)
    @Digits(integer = 10, fraction = 2, message = "Неправильный формат площади")
    private BigDecimal AreaFlat;

    @Column(name = "rooms_count", nullable = true)
    @Pattern(regexp = "[0-9]+", message = "Неправильный формат количества комнат")
    private Integer RoomsCountFlat;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "IdUser")
    private UserModel OwnerIdFlat;

    public FlatModel(){}
    public FlatModel(Long idFlat, String nameFlat, String flatNumberFlat, String houseNumberFlat, Integer floorNumberFlat, String apartmentNumberFlat, BigDecimal areaFlat, Integer roomsCountFlat, UserModel ownerIdFlat) {
        IdFlat = idFlat;
        NameFlat = nameFlat;
        FlatNumberFlat = flatNumberFlat;
        HouseNumberFlat = houseNumberFlat;
        FloorNumberFlat = floorNumberFlat;
        ApartmentNumberFlat = apartmentNumberFlat;
        AreaFlat = areaFlat;
        RoomsCountFlat = roomsCountFlat;
        OwnerIdFlat = ownerIdFlat;
    }

    public Long getId() {
        return IdFlat;
    }

    public void setId(Long idFlat) {
        IdFlat = idFlat;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getNameFlat() {
        return NameFlat;
    }

    public void setNameFlat(@Size(min = 3, message = "Имя не менее 3 символов") String nameFlat) {
        NameFlat = nameFlat;
    }

    public String getFlatNumberFlat() {
        return FlatNumberFlat;
    }

    public void setFlatNumberFlat(String flatNumberFlat) {
        FlatNumberFlat = flatNumberFlat;
    }

    public String getHouseNumberFlat() {
        return HouseNumberFlat;
    }

    public void setHouseNumberFlat(String houseNumberFlat) {
        HouseNumberFlat = houseNumberFlat;
    }

    public @Pattern(regexp = "[0-9]+", message = "Неправильный формат этажа") Integer getFloorNumberFlat() {
        return FloorNumberFlat;
    }

    public void setFloorNumberFlat(@Pattern(regexp = "[0-9]+", message = "Неправильный формат этажа") Integer floorNumberFlat) {
        FloorNumberFlat = floorNumberFlat;
    }

    public String getApartmentNumberFlat() {
        return ApartmentNumberFlat;
    }

    public void setApartmentNumberFlat(String apartmentNumberFlat) {
        ApartmentNumberFlat = apartmentNumberFlat;
    }

    public @Digits(integer = 10, fraction = 2, message = "Неправильный формат площади") BigDecimal getAreaFlat() {
        return AreaFlat;
    }

    public void setAreaFlat(@Digits(integer = 10, fraction = 2, message = "Неправильный формат площади") BigDecimal areaFlat) {
        AreaFlat = areaFlat;
    }

    public @Pattern(regexp = "[0-9]+", message = "Неправильный формат количества комнат") Integer getRoomsCountFlat() {
        return RoomsCountFlat;
    }

    public void setRoomsCountFlat(@Pattern(regexp = "[0-9]+", message = "Неправильный формат количества комнат") Integer roomsCountFlat) {
        RoomsCountFlat = roomsCountFlat;
    }

    public UserModel getOwnerIdFlat() {
        return OwnerIdFlat;
    }

    public void setOwnerIdFlat(UserModel ownerIdFlat) {
        OwnerIdFlat = ownerIdFlat;
    }
}
