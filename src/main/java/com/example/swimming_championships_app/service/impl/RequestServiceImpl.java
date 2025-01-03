package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.model.Discipline;
import com.example.swimming_championships_app.model.Request;
import com.example.swimming_championships_app.repository.RequestRepository;
import com.example.swimming_championships_app.service.RequestService;
import org.springframework.stereotype.Service;

import java.util.List;

//реализация интерфейса requestService
@Service
public class RequestServiceImpl implements RequestService {
    RequestRepository repository;

    public RequestServiceImpl(RequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Request> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Request request) {
        repository.delete(request);
    }

    @Override
    public Request save(Request request) {
        return repository.save(request);
    }

    @Override
    public List<Request> findByChampionshipAndDiscipline(Championship championship, Discipline discipline) {
        return repository.findByChampionshipAndDisciplineOrderByTimeInt(championship, discipline);
    }
}
