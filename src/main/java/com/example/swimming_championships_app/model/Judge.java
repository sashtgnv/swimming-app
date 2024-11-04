package com.example.swimming_championships_app.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Judge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "judges_championships",
                joinColumns = @JoinColumn(name = "id_judge"),
                inverseJoinColumns = @JoinColumn(name = "id_champ"))
    private List<Championship> championships;

    public Judge() {
    }

    public Judge(Integer id, String surname, String name, String patronymic, List<Championship> championships) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.championships = championships;
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

    public List<Championship> getChampionships() {
        return championships;
    }

    public void setChampionships(List<Championship> championships) {
        this.championships = championships;
    }

    @Override
    public String toString() {
        return "Judge{" +
                "\n\tid=" + id +
                "\n\tsurname='" + surname + '\'' +
                "\n\tname='" + name + '\'' +
                "\n\tpatronymic='" + patronymic + '\'' +
                '}';
    }
}
