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
    @Column(name = "document_url")
    private String document;
    private String adress;
    @Column(name = "photo_url")
    private String photo;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "judges_championships",
                joinColumns = @JoinColumn(name = "id_champ"),
                inverseJoinColumns = @JoinColumn(name = "id_judge"))
    private List<Judge> judges;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "championships_disciplines",
            joinColumns = @JoinColumn(name = "id_champ"),
            inverseJoinColumns = @JoinColumn(name = "id_discipline")
    )
    private List<Discipline> disciplines;


    public Championship() {
    }

    public Championship(Integer id, String name, Date date, String document, String adress, String photo, List<Judge> judges, List<Discipline> disciplines) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.document = document;
        this.adress = adress;
        this.photo = photo;
        this.judges = judges;
        this.disciplines = disciplines;
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

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Championship{" +
                "\n\tid=" + id +
                "\n\tname='" + name + '\'' +
                "\n\tdate=" + date +
                "\n\tdocument='" + document + '\'' +
                "\n\tphoto='" + photo + '\'' +
                "\n\tadress='" + adress + '\'' +
                "\n\tjudges='" + judges +
                "\n}";
    }
}
