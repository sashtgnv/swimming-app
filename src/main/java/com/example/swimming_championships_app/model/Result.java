package com.example.swimming_championships_app.model;

import com.example.swimming_championships_app.util.Time;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

//сущность "result"
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

    @PostLoad
    private void postLoad() {
        resultTime = new Time(timeInt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(id, result.id) && Objects.equals(request, result.request) && Objects.equals(timeInt, result.timeInt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, request, timeInt);
    }

    @Override
    public String toString() {
        return "Result{" +
                "\n\tid=" + id +
                "\n\trequest=" + request +
                "\n\ttimeInt=" + timeInt +
                "\n\tresultTime=" + resultTime +
                '}';
    }
}
