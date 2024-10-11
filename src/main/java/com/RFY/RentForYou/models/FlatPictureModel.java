package com.RFY.RentForYou.models;

import jakarta.persistence.*;

@Entity
@Table(name = "flatpicture")
public class FlatPictureModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdFlatPicture;

    @ManyToOne
    @JoinColumn(name = "picture_id", referencedColumnName = "IdPicture")
    private PictureModel Picture;

    @ManyToOne
    @JoinColumn(name = "flat_id", referencedColumnName = "IdFlat")
    private FlatModel Flat;


    public FlatPictureModel(){}
    public FlatPictureModel(Long idFlatPicture, PictureModel picture, FlatModel flat) {
        IdFlatPicture = idFlatPicture;
        Picture = picture;
        Flat = flat;
    }

    public Long getId() {
        return IdFlatPicture;
    }

    public void setId(Long idFlatPicture) {
        IdFlatPicture = idFlatPicture;
    }

    public PictureModel getPicture() {
        return Picture;
    }

    public void setPicture(PictureModel picture) {
        Picture = picture;
    }

    public FlatModel getFlat() {
        return Flat;
    }

    public void setFlat(FlatModel flat) {
        Flat = flat;
    }
}
