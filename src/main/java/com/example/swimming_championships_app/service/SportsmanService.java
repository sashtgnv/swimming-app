package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Sportsman;

import java.time.LocalDate;

//интерфейс сервиса для репозитория sportsman
public interface SportsmanService extends Service<Sportsman> {
    // метод поиска записи по имени, отчеству, фамилии, и дате рождения
    Sportsman findSportsmanByNameAndPatronymicAndSurnameAndBirthDate(String name, String patronymic, String surname, LocalDate birthDate);
}
