package com.example.swimming_championships_app.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Discipline implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String style;
    private String distance;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "championships_disciplines",
            joinColumns = @JoinColumn(name = "id_discipline"),
            inverseJoinColumns = @JoinColumn(name = "id_champ")
    )
    private List<Championship> championships;

    public Discipline() {
    }

    public Discipline(Integer id, String style, String distance, List<Championship> championships) {
        this.id = id;
        this.style = style;
        this.distance = distance;
        this.championships = championships;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public List<Championship> getChampionships() {
        return championships;
    }

    public void setChampionships(List<Championship> championships) {
        this.championships = championships;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "\n\tid=" + id +
                "\n\tstyle='" + style + '\'' +
                "\n\tdistance='" + distance + '\'' +
                '}';
    }
}
