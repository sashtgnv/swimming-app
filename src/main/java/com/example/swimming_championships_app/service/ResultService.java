package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Request;
import com.example.swimming_championships_app.model.Result;

import java.util.List;

public interface ResultService extends Service<Result>{
    Result findResultByRequest(Request request);
}
