package com.RFY.RentForYou.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "passport")
public class PassportModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPassport;

    @Column(name = "series", nullable = false)
    @Size(min = 4, max = 4, message = "Серия паспорта должна содержать 4 цифры")
    @Pattern(regexp = "\\d{4}", message = "Серия паспорта должна содержать только цифры")
    private String SeriesPassport;

    @Column(name = "number", nullable = false)
    @Size(min = 6, max = 6, message = "Номер паспорта должен содержать 6 цифр")
    @Pattern(regexp = "\\d{4}", message = "Серия паспорта должна содержать только цифры")
    private String NumberPassport;

    @Column(name = "issue_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date IssueDatePassport;

    @Column(name = "issued_by", nullable = false)
    @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Выдано должно содержать только буквы")
    private String IssuedByPassport;

    @Column(name = "code_division", nullable = false)
    @Pattern(regexp = "\\d{3}-\\d{3}", message = "Код подразделения должен быть в формате 111-111")
    private String CodeDivisionPassport;

    @Column(name = "first_name", nullable = false)
    @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Имя должно содержать только буквы")
    private String FirstNamePassport;

    @Column(name = "second_name", nullable = false)
    @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Фамилия должна содержать только буквы")
    private String SecondNamePassport;

    @Column(name = "third_name", nullable = false)
    @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Отчество должно содержать только буквы")
    private String ThirdNamePassport;

    public PassportModel() {
    }

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

    public @Size(min = 4, max = 4, message = "Серия паспорта должна содержать 4 цифры") @Pattern(regexp = "\\d{4}", message = "Серия паспорта должна содержать только цифры") String getSeriesPassport() {
        return SeriesPassport;
    }

    public void setSeriesPassport(@Size(min = 4, max = 4, message = "Серия паспорта должна содержать 4 цифры") @Pattern(regexp = "\\d{4}", message = "Серия паспорта должна содержать только цифры") String seriesPassport) {
        SeriesPassport = seriesPassport;
    }

    public @Size(min = 6, max = 6, message = "Номер паспорта должен содержать 6 цифр") @Pattern(regexp = "\\d{4}", message = "Серия паспорта должна содержать только цифры") String getNumberPassport() {
        return NumberPassport;
    }

    public void setNumberPassport(@Size(min = 6, max = 6, message = "Номер паспорта должен содержать 6 цифр") @Pattern(regexp = "\\d{4}", message = "Серия паспорта должна содержать только цифры") String numberPassport) {
        NumberPassport = numberPassport;
    }

    public Date getIssueDatePassport() {
        return IssueDatePassport;
    }

    public void setIssueDatePassport(Date issueDatePassport) {
        IssueDatePassport = issueDatePassport;
    }

    public @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Выдано должно содержать только буквы") String getIssuedByPassport() {
        return IssuedByPassport;
    }

    public void setIssuedByPassport(@Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Выдано должно содержать только буквы") String issuedByPassport) {
        IssuedByPassport = issuedByPassport;
    }

    public @Pattern(regexp = "\\d{3}-\\d{3}", message = "Код подразделения должен быть в формате 111-111") String getCodeDivisionPassport() {
        return CodeDivisionPassport;
    }

    public void setCodeDivisionPassport(@Pattern(regexp = "\\d{3}-\\d{3}", message = "Код подразделения должен быть в формате 111-111") String codeDivisionPassport) {
        CodeDivisionPassport = codeDivisionPassport;
    }

    public @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Имя должно содержать только буквы") String getFirstNamePassport() {
        return FirstNamePassport;
    }

    public void setFirstNamePassport(@Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Имя должно содержать только буквы") String firstNamePassport) {
        FirstNamePassport = firstNamePassport;
    }

    public @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Фамилия должна содержать только буквы") String getSecondNamePassport() {
        return SecondNamePassport;
    }

    public void setSecondNamePassport(@Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Фамилия должна содержать только буквы") String secondNamePassport) {
        SecondNamePassport = secondNamePassport;
    }

    public @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Отчество должно содержать только буквы") String getThirdNamePassport() {
        return ThirdNamePassport;
    }

    public void setThirdNamePassport(@Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ\\s]+", message = "Отчество должно содержать только буквы") String thirdNamePassport) {
        ThirdNamePassport = thirdNamePassport;
    }
}