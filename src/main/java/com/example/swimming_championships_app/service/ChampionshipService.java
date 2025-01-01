package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Championship;

import java.time.LocalDate;
import java.util.List;

//интерфейс сервиса для репозитория championship
public interface ChampionshipService extends Service<Championship> {
    // метод поиска соревнования раньше выбранной даты
    List<Championship> findEarlyThan(LocalDate date);

    // метод поиска соревнования позже выбранной даты
    List<Championship> findByDateGreaterThanEqualOrderByDateAsc(LocalDate date);
}
