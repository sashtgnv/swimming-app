package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Request;
import com.example.swimming_championships_app.model.Result;
import com.example.swimming_championships_app.repository.ResultRepository;
import com.example.swimming_championships_app.service.ResultService;
import com.example.swimming_championships_app.util.Time;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public Result findResultByRequest(Request request) {
        return repository.findResultByRequest(request);
    }
}
