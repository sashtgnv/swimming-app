package com.example.swimming_championships_app.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Championship implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Date date;
    private String document;
    private String adress;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "judges_championships",
                joinColumns = @JoinColumn(name = "id_champ"),
                inverseJoinColumns = @JoinColumn(name = "id_judge"))
    private List<Judge> judges;

    public Championship() {
    }

    public Championship(Integer id, String name, Date date, String document, String adress, List<Judge> judges) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.document = document;
        this.adress = adress;
        this.judges = judges;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Judge> getJudges() {
        return judges;
    }

    public void setJudges(List<Judge> judges) {
        this.judges = judges;
    }

    @Override
    public String toString() {
        return "Championship{" +
                "\n\tid=" + id +
                "\n\tname='" + name + '\'' +
                "\n\tdate=" + date +
                "\n\tdocument='" + document + '\'' +
                "\n\tadress='" + adress + '\'' +
                "\n\tjudges='" + judges +
                "\n}";
    }
}
