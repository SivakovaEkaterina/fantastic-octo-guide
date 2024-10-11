package com.RFY.RentForYou.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "cards")
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCard;

    @Size(min = 3, message = "Имя не менее 3 символов")
    private String NameCard;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "flat_id", referencedColumnName = "IdFlat")
    private FlatModel FlatCard;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "house_id", referencedColumnName = "IdHouse")
    private HouseModel HouseCard;

    @Column(name = "description", nullable = true)
    private String DescriptionCard;

    @Column(name = "price", nullable = false)
    @Digits(integer = 10, fraction = 2, message = "Неправильный формат цены")
    private BigDecimal PriceCard;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "IdUser")
    private UserModel OwnerIdCard;


    public CardModel(){}

    public CardModel(Long idCard, String nameCard, @Nullable FlatModel flatCard, @Nullable HouseModel houseCard, String descriptionCard, BigDecimal priceCard, UserModel ownerIdCard) {
        IdCard = idCard;
        NameCard = nameCard;
        FlatCard = flatCard;
        HouseCard = houseCard;
        DescriptionCard = descriptionCard;
        PriceCard = priceCard;
        OwnerIdCard = ownerIdCard;
    }

    public Long getId() {
        return IdCard;
    }

    public void setId(Long idCard) {
        IdCard = idCard;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getNameCard() {
        return NameCard;
    }

    public void setNameCard(@Size(min = 3, message = "Имя не менее 3 символов") String nameCard) {
        NameCard = nameCard;
    }

    @Nullable
    public FlatModel getFlatCard() {
        return FlatCard;
    }

    public void setFlatCard(@Nullable FlatModel flatCard) {
        FlatCard = flatCard;
    }

    @Nullable
    public HouseModel getHouseCard() {
        return HouseCard;
    }

    public void setHouseCard(@Nullable HouseModel houseCard) {
        HouseCard = houseCard;
    }

    public String getDescriptionCard() {
        return DescriptionCard;
    }

    public void setDescriptionCard(String descriptionCard) {
        DescriptionCard = descriptionCard;
    }

    public @Digits(integer = 10, fraction = 2, message = "Неправильный формат цены") BigDecimal getPriceCard() {
        return PriceCard;
    }

    public void setPriceCard(@Digits(integer = 10, fraction = 2, message = "Неправильный формат цены") BigDecimal priceCard) {
        PriceCard = priceCard;
    }

    public UserModel getOwnerIdCard() {
        return OwnerIdCard;
    }

    public void setOwnerIdCard(UserModel ownerIdCard) {
        OwnerIdCard = ownerIdCard;
    }
}
