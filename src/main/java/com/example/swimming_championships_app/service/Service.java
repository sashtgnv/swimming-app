package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Sportsman;

import java.util.List;

public interface Service <T>{
    List<T> findAll();

    void delete(T t);

    T save(T t);
}
