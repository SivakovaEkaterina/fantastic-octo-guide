package com.RFY.RentForYou.models;

import jakarta.persistence.*;

@Entity
@Table(name = "picture")
public class PictureModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPicture;
    @Column(name = "picture", nullable = false)
    @Lob
    private byte[] ImgPicture;

    public PictureModel(){}
    public PictureModel(Long idPicture, byte[] imgPicture) {
        IdPicture = idPicture;
        ImgPicture = imgPicture;
    }

    public Long getId() {
        return IdPicture;
    }

    public void setId(Long idPicture) {
        IdPicture = idPicture;
    }

    public byte[] getImgPicture() {
        return ImgPicture;
    }

    public void setImgPicture(byte[] imgPicture) {
        ImgPicture = imgPicture;
    }
}
