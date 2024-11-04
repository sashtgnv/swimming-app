package com.example.swimming_championships_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Discipline implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String style;
    private String distance;

    public Discipline() {
    }

    public Discipline(Integer id, String style, String distance) {
        this.id = id;
        this.style = style;
        this.distance = distance;
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

    @Override
    public String toString() {
        return "Discipline{" +
                "\n\tid=" + id +
                "\n\tstyle='" + style + '\'' +
                "\n\tdistance='" + distance + '\'' +
                '}';
    }
}
