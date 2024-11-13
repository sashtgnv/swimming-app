package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Judge;
import com.example.swimming_championships_app.repository.JudgeRepository;
import com.example.swimming_championships_app.service.JudgeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeServiceImpl implements JudgeService {
    JudgeRepository repository;

    public JudgeServiceImpl(JudgeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Judge> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Judge judge) {
        repository.delete(judge);
    }

    @Override
    public Judge save(Judge judge) {
        return repository.save(judge);
    }
}
