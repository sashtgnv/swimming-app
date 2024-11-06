package com.example.swimming_championships_app.model;

import com.example.swimming_championships_app.service.RequestService;
import com.example.swimming_championships_app.util.Time;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Result implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_request")
    private Request request;
    @Column(name = "result_time")
    private Integer timeInt;
    @Transient
    private Time resultTime;

    public Result() {
    }

    public Result(Integer id, Request request, Integer timeInt, Time resultTime) {
        this.id = id;
        this.request = request;
        this.timeInt = timeInt;
        this.resultTime = resultTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Integer getTimeInt() {
        return timeInt;
    }

    public void setTimeInt(Integer timeInt) {
        this.timeInt = timeInt;
        this.resultTime = new Time(timeInt);
    }

    public Time getResultTime() {
        return resultTime;
    }

    public void setResultTime(Time resultTime) {
        this.resultTime = resultTime;
        this.timeInt = resultTime.getAll();
    }

    @Override
    public String toString() {
        return "Result{" +
                "\n\tid=" + id +
                "\n\trequest=" + request +
                "\n\tresultTime=" + resultTime +
                '}';
    }
}
