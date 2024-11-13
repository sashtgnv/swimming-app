package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Trainer;
import com.example.swimming_championships_app.repository.TrainerRepository;
import com.example.swimming_championships_app.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    TrainerRepository repository;

    public TrainerServiceImpl(TrainerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Trainer> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Trainer trainer) {
        repository.delete(trainer);
    }

    @Override
    public Trainer save(Trainer trainer) {
        return repository.save(trainer);
    }
}
