package com.RFY.RentForYou.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "passport")
public class PassportModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPassport;

    @Column(name = "series", nullable = false)
    private String SeriesPassport;

    @Column(name = "number", nullable = false)
    private String NumberPassport;

    @Column(name = "issue_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date IssueDatePassport;

    @Column(name = "issued_by", nullable = false)
    private String IssuedByPassport;

    @Column(name = "code_division", nullable = false)
    private String CodeDivisionPassport;

    @Column(name = "first_name", nullable = false)
    private String FirstNamePassport;

    @Column(name = "second_name", nullable = false)
    private String SecondNamePassport;

    @Column(name = "third_name", nullable = false)
    private String ThirdNamePassport;

    public PassportModel(){}
    public PassportModel(Long idPassport, String seriesPassport, String numberPassport, Date issueDatePassport, String issuedByPassport, String codeDivisionPassport, String firstNamePassport, String secondNamePassport, String thirdNamePassport) {
        IdPassport = idPassport;
        SeriesPassport = seriesPassport;
        NumberPassport = numberPassport;
        IssueDatePassport = issueDatePassport;
        IssuedByPassport = issuedByPassport;
        CodeDivisionPassport = codeDivisionPassport;
        FirstNamePassport = firstNamePassport;
        SecondNamePassport = secondNamePassport;
        ThirdNamePassport = thirdNamePassport;
    }

    public Long getId() {
        return IdPassport;
    }

    public void setId(Long idPassport) {
        IdPassport = idPassport;
    }

    public String getSeriesPassport() {
        return SeriesPassport;
    }

    public void setSeriesPassport(String seriesPassport) {
        SeriesPassport = seriesPassport;
    }

    public String getNumberPassport() {
        return NumberPassport;
    }

    public void setNumberPassport(String numberPassport) {
        NumberPassport = numberPassport;
    }

    public Date getIssueDatePassport() {
        return IssueDatePassport;
    }

    public void setIssueDatePassport(Date issueDatePassport) {
        IssueDatePassport = issueDatePassport;
    }

    public String getIssuedByPassport() {
        return IssuedByPassport;
    }

    public void setIssuedByPassport(String issuedByPassport) {
        IssuedByPassport = issuedByPassport;
    }

    public String getCodeDivisionPassport() {
        return CodeDivisionPassport;
    }

    public void setCodeDivisionPassport(String codeDivisionPassport) {
        CodeDivisionPassport = codeDivisionPassport;
    }

    public String getFirstNamePassport() {
        return FirstNamePassport;
    }

    public void setFirstNamePassport(String firstNamePassport) {
        FirstNamePassport = firstNamePassport;
    }

    public String getSecondNamePassport() {
        return SecondNamePassport;
    }

    public void setSecondNamePassport(String secondNamePassport) {
        SecondNamePassport = secondNamePassport;
    }

    public String getThirdNamePassport() {
        return ThirdNamePassport;
    }

    public void setThirdNamePassport(String thirdNamePassport) {
        ThirdNamePassport = thirdNamePassport;
    }
}
