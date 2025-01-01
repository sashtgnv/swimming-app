package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Request;
import com.example.swimming_championships_app.model.Result;

//интерфейс сервиса для репозитория result
public interface ResultService extends Service<Result> {
    // метод поиска записи по заявке
    Result findResultByRequest(Request request);
}
