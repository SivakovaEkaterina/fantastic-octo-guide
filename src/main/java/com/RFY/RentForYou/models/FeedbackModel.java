package com.RFY.RentForYou.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "feedback")
public class FeedbackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdFeedback;
    @Column(name = "feedback", nullable = true)
    @Size(min = 3, message = "Комментарий не менее 3-х символов")
    private String NameFeedback;
    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "IdCard")
    private CardModel Card;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "IdUser")
    private UserModel IdUser;

    public FeedbackModel(){}
    public FeedbackModel(Long idFeedback, String nameFeedback, UserModel idUser) {
        IdFeedback = idFeedback;
        NameFeedback = nameFeedback;
        IdUser = idUser;
    }

    public Long getId() {
        return IdFeedback;
    }

    public void setId(Long idFeedback) {
        IdFeedback = idFeedback;
    }

    public @Size(min = 3, message = "Имя не менее 3 символов") String getNameFeedback() {
        return NameFeedback;
    }

    public void setNameFeedback(@Size(min = 3, message = "Имя не менее 3 символов") String nameFeedback) {
        NameFeedback = nameFeedback;
    }

    public UserModel getIdUser() {
        return IdUser;
    }

    public void setIdUser(UserModel idUser) {
        IdUser = idUser;
    }
}
