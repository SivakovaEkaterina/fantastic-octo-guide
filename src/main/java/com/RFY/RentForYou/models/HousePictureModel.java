package com.RFY.RentForYou.models;

import jakarta.persistence.*;

@Entity
@Table(name = "housepicture")
public class HousePictureModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdHousePicture;

    @ManyToOne
    @JoinColumn(name = "picture_id", referencedColumnName = "IdPicture")
    private PictureModel Picture;

    @ManyToOne
    @JoinColumn(name = "house_id", referencedColumnName = "IdHouse")
    private HouseModel House;

    public HousePictureModel(){}
    public HousePictureModel(Long idHousePicture, PictureModel picture, HouseModel house) {
        IdHousePicture = idHousePicture;
        Picture = picture;
        House = house;
    }

    public Long getId() {
        return IdHousePicture;
    }

    public void setId(Long idHousePicture) {
        IdHousePicture = idHousePicture;
    }

    public PictureModel getPicture() {
        return Picture;
    }

    public void setPicture(PictureModel picture) {
        Picture = picture;
    }

    public HouseModel getHouse() {
        return House;
    }

    public void setHouse(HouseModel house) {
        House = house;
    }
}
