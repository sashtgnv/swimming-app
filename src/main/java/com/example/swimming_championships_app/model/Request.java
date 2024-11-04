package com.example.swimming_championships_app.model;

import com.example.swimming_championships_app.util.Time;
import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_d")
    private Discipline discipline;
    @ManyToOne
    @JoinColumn(name  = "id_s")
    private Sportsman sportsman;
    @ManyToOne
    @JoinColumn(name  = "id_ch")
    private Championship championship;
    @Column(name = "request_time")
    private Integer requestTimeInt;
    @OneToOne(mappedBy = "request")
    private Result result;
    @Transient
    private Time requestTime;

    public Request() {
    }

    public Request(Integer id, Discipline discipline, Sportsman sportsman, Championship championship, Integer requestTimeInt) {
        this.id = id;
        this.discipline = discipline;
        this.sportsman = sportsman;
        this.championship = championship;
        this.requestTimeInt = requestTimeInt;
        this.requestTime = new Time(requestTimeInt);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public Integer getRequestTimeInt() {
        return requestTimeInt;
    }

    public void setRequestTimeInt(Integer requestTimeInt) {
        this.requestTimeInt = requestTimeInt;
        this.requestTime = new Time(requestTimeInt);
    }

    @Override
    public String toString() {
        return "Request{" +
                "\n\tid=" + id +
                "\n\tdiscipline=" + discipline +
                "\n\tsportsman=" + sportsman +
                "\n\tchampionship=" + championship +
                "\n\trequestTime=" + requestTime +
                '}';
    }
}
