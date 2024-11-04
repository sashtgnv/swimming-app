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
    private Integer resulTimeInt;
    @Transient
    private Time resultTime;

    public Result() {
    }

    public Result(Integer id, Request request, Integer resulTimeInt) {
        this.id = id;
        this.request = request;
        this.resulTimeInt = resulTimeInt;
        this.resultTime = new Time(resulTimeInt);
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

    public Integer getResulTimeInt() {
        return resulTimeInt;
    }

    public void setResulTimeInt(Integer resulTimeInt) {
        this.resulTimeInt = resulTimeInt;
        this.resultTime = new Time(resulTimeInt);
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
