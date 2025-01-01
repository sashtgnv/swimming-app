package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Judge;
import org.springframework.data.jpa.repository.JpaRepository;

// репозиторий сущности judge
public interface JudgeRepository extends JpaRepository<Judge, Integer> {
}


