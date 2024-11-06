package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Sportsman;
import com.example.swimming_championships_app.repository.SportsmanRepository;
import com.example.swimming_championships_app.service.SportsmanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsmanServiceImpl implements SportsmanService {
    SportsmanRepository repository;

    public SportsmanServiceImpl(SportsmanRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sportsman> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Sportsman sportsman) {
        repository.delete(sportsman);
    }

    @Override
    public Sportsman save(Sportsman sportsman) {
        return repository.save(sportsman);
    }
}
