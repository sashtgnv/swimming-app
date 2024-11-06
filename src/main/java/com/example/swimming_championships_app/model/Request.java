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
    private Integer timeInt;
    @OneToOne(mappedBy = "request")
    private Result result;
    @Transient
    private Time requestTime;

    public Request() {
    }

    public Request(Integer id, Discipline discipline, Sportsman sportsman, Championship championship, Integer timeInt, Result result, Time requestTime) {
        this.id = id;
        this.discipline = discipline;
        this.sportsman = sportsman;
        this.championship = championship;
        this.result = result;
        this.timeInt = timeInt;
        this.requestTime = requestTime;
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Integer getTimeInt() {
        return timeInt;
    }

    public void setTimeInt(Integer timeInt) {
        this.timeInt = timeInt;
        this.requestTime = new Time(timeInt);
    }
    public Time getRequestTime() {
        return requestTime;
    }
    public void setRequestTime(Time requestTime) {
        this.requestTime = requestTime;
        this.timeInt = requestTime.getAll();
    }

    @PostLoad
    private void load(){
        this.requestTime = new Time(this.timeInt);
    }

    @Override
    public String toString() {
        return "Request{" +
                "\n\tid=" + id +
                "\n\tdiscipline=" + discipline +
                "\n\tsportsman=" + sportsman +
                "\n\tchampionship=" + championship +
                "\n\ttimeInt=" + timeInt +
                "\n\trequestTime=" + requestTime +
                '}';
    }
}
