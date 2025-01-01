package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Request;
import com.example.swimming_championships_app.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

// репозиторий сущности result
public interface ResultRepository extends JpaRepository<Result,Integer> {
    // метод поиска записи по заявке
    Result findResultByRequest(Request request);
}
