package com.example.swimming_championships_app.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

//сущность "judge"
@Entity
public class Judge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private String deserts;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "judges_championships",
            joinColumns = @JoinColumn(name = "id_judge"),
            inverseJoinColumns = @JoinColumn(name = "id_champ"))
    private List<Championship> championships;

    public Judge() {
    }


    public Integer getId() {
        return id;
    }

    public Judge(Integer id, String surname, String name, String patronymic, String deserts, List<Championship> championships) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.deserts = deserts;
        this.championships = championships;
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

    public List<Championship> getChampionships() {
        return championships;
    }

    public void setChampionships(List<Championship> championships) {
        this.championships = championships;
    }

    public String getDeserts() {
        return deserts;
    }

    public void setDeserts(String deserts) {
        this.deserts = deserts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Judge judge = (Judge) o;
        return Objects.equals(id, judge.id) && Objects.equals(surname, judge.surname) && Objects.equals(name, judge.name) && Objects.equals(patronymic, judge.patronymic) && Objects.equals(deserts, judge.deserts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, deserts);
    }

    @Override
    public String toString() {
        return surname + ' ' + name + ' ' + patronymic;
    }
}
