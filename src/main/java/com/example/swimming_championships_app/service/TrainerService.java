package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Trainer;

import java.time.LocalDate;

//интерфейс сервиса для репозитория trainer
public interface TrainerService extends Service<Trainer> {
    // метод поиска записи по имени, отчеству, фамилии, и дате рождения
    Trainer findTrainerByNameAndPatronymicAndSurnameAndBirthDate(String name, String patronymic, String surname, LocalDate birthDate);
}
