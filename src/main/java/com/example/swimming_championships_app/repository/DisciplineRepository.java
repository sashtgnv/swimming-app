package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

// репозиторий сущности discipline
public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
}
