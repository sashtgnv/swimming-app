package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.model.Discipline;
import com.example.swimming_championships_app.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// репозиторий сущности request
public interface RequestRepository extends JpaRepository<Request, Integer> {
    // метод поиска записей по соревнованию и дистанции
    List<Request> findByChampionshipAndDisciplineOrderByTimeInt(Championship championship, Discipline discipline);
}
