package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.model.Discipline;
import com.example.swimming_championships_app.model.Request;

import java.util.List;

public interface RequestService extends Service<Request>{
    List<Request> findByChampionshipAndDiscipline(Championship championship, Discipline discipline);
}
