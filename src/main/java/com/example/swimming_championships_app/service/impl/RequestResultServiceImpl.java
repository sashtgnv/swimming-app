package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.RequestResult;
import com.example.swimming_championships_app.repository.RequestResultRepository;
import com.example.swimming_championships_app.service.RequestResultService;
import com.example.swimming_championships_app.util.Time;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RequestResultServiceImpl implements RequestResultService {
    private final RequestResultRepository repository;

    public RequestResultServiceImpl(RequestResultRepository repository) {
        this.repository = repository;
    }

    public List<RequestResult> findAll(){
        return repository.findAll();
    }
}
