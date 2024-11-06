package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Result;
import com.example.swimming_championships_app.repository.ResultRepository;
import com.example.swimming_championships_app.service.ResultService;
import com.example.swimming_championships_app.util.Time;

import java.util.List;

public class ResultServiceImpl implements ResultService {
    ResultRepository repository;

    public ResultServiceImpl(ResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Result> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Result result) {
        repository.delete(result);
    }

    @Override
    public Result save(Result result) {
        return repository.save(result);
    }
}
