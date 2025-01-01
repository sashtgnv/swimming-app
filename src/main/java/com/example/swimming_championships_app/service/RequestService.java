package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.model.Discipline;
import com.example.swimming_championships_app.model.Request;

import java.util.List;

//интерфейс сервиса для репозитория request
public interface RequestService extends Service<Request> {
    // метод поиска записей по соревнованию и дистанции
    List<Request> findByChampionshipAndDiscipline(Championship championship, Discipline discipline);
}
