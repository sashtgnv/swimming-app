package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Championship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

// репозиторий сущности championship
public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {
    // метод поиска соревнования раньше выбранной даты
    List<Championship> findByDateLessThanEqualOrderByDateAsc(LocalDate date);

    // метод поиска соревнования позже выбранной даты
    List<Championship> findByDateGreaterThanEqualOrderByDateAsc(LocalDate date);
}
