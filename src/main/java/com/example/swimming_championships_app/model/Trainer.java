package com.example.swimming_championships_app.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

//сущность "trainer"
@Entity
public class Trainer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthDate;
    private String grade;
    @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER)
    private List<Sportsman> sportsmen;

    public Trainer() {
    }

    public Trainer(Integer id, String surname, String name, String patronymic, LocalDate birthDate, String grade, List<Sportsman> sportsmen) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.grade = grade;
        this.sportsmen = sportsmen;
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

    public List<Sportsman> getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(List<Sportsman> sportsmen) {
        this.sportsmen = sportsmen;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "\n\tid=" + id +
                "\n\tsurname='" + surname + '\'' +
                "\n\tname='" + name + '\'' +
                "\n\tpatronymic='" + patronymic + '\'' +
                "\n\tbirthDate=" + birthDate +
                "\n\tgrade='" + grade + '\'' +
                '}';
    }
}
