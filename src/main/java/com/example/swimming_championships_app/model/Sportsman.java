package com.example.swimming_championships_app.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Sportsman implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthDate;
    private String grade;
    @ManyToOne
    @JoinColumn(name = "id_trainer")
    private Trainer trainer;

    public Sportsman() {
    }

    public Sportsman(Integer id, String surname, String name, String patronymic, LocalDate birthDate, String grade, Trainer trainer) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.grade = grade;
        this.trainer = trainer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "Sportsman{" +
                "\n\tid=" + id +
                "\n\tsurname='" + surname + '\'' +
                "\n\tname='" + name + '\'' +
                "\n\tpatronymic='" + patronymic + '\'' +
                "\n\tbirthDate=" + birthDate +
                "\n\tgrade='" + grade + '\'' +
                "\n\ttrainer=" + trainer +
                '}';
    }
}
