package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Discipline;
import com.example.swimming_championships_app.repository.DisciplineRepository;
import com.example.swimming_championships_app.service.DisciplineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    DisciplineRepository repository;

    public DisciplineServiceImpl(DisciplineRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Discipline> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Discipline discipline) {
        repository.delete(discipline);
    }

    @Override
    public Discipline save(Discipline discipline) {
        return repository.save(discipline);
    }
}
