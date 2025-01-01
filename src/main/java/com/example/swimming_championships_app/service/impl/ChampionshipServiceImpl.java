package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.repository.ChampionshipRepository;
import com.example.swimming_championships_app.service.ChampionshipService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//реализация интерфейса championshipService
@Service
public class ChampionshipServiceImpl implements ChampionshipService {
    ChampionshipRepository repository;

    public ChampionshipServiceImpl(ChampionshipRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Championship> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Championship championship) {
        repository.delete(championship);
    }

    @Override
    public Championship save(Championship championship) {
        return repository.save(championship);
    }

    @Override
    public List<Championship> findEarlyThan(LocalDate date) {
        return repository.findByDateLessThanEqualOrderByDateAsc(date);
    }
    @Override
    public List<Championship> findByDateGreaterThanEqualOrderByDateAsc(LocalDate date) {
        return repository.findByDateGreaterThanEqualOrderByDateAsc(date);
    }
}
