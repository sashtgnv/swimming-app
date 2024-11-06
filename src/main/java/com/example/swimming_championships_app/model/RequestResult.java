package com.example.swimming_championships_app.model;

import com.example.swimming_championships_app.util.Time;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.View;


@Entity
@Immutable
@Subselect("select * from request_result")
public class RequestResult {
    @Id
    @GeneratedValue()
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ch")
    private Championship championship;
    @Column(name = "full_name_s")
    private String sportsmanFullName;
    @Column(name = "full_name_tr")
    private String trainerFullName;
    private String style;
    private Integer distance;
    private String discipline;
    @Column(name = "request_time")
    private Integer requestTimeInt;
    @Column(name = "result_time")
    private Integer resultTimeInt;
    @Transient
    private Time requestTime;
    @Transient
    private Time resultTime;


    public RequestResult() {
    }

    public RequestResult(Integer id, Championship championship, String sportsmanFullName, String trainerFullName, String style, Integer distance, String discipline, Integer requestTimeInt, Integer resultTimeInt, Time requestTime, Time resultTime) {
        this.id = id;
        this.championship = championship;
        this.sportsmanFullName = sportsmanFullName;
        this.trainerFullName = trainerFullName;
        this.style = style;
        this.distance = distance;
        this.discipline = discipline;
        this.requestTimeInt = requestTimeInt;
        this.resultTimeInt = resultTimeInt;
        this.requestTime = requestTime;
        this.resultTime = resultTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    public String getSportsmanFullName() {
        return sportsmanFullName;
    }

    public void setSportsmanFullName(String sportsmanFullName) {
        this.sportsmanFullName = sportsmanFullName;
    }

    public String getTrainerFullName() {
        return trainerFullName;
    }

    public void setTrainerFullName(String trainerFullName) {
        this.trainerFullName = trainerFullName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Integer getRequestTimeInt() {
        return requestTimeInt;
    }

    public void setRequestTimeInt(Integer requestTimeInt) {
        this.requestTimeInt = requestTimeInt;
        this.requestTime = new Time(requestTimeInt);
    }

    public Integer getResultTimeInt() {
        return resultTimeInt;
    }

    public void setResultTimeInt(Integer resultTimeInt) {
        this.resultTimeInt = resultTimeInt;
        this.resultTime = new Time(resultTimeInt);
    }

    public Time getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Time requestTime) {
        this.requestTime = requestTime;
        this.requestTimeInt = requestTime.getAll();
    }

    public Time getResultTime() {
        return resultTime;
    }

    public void setResultTime(Time resultTime) {
        this.resultTime = resultTime;
        this.resultTimeInt = resultTime.getAll();
    }
}
