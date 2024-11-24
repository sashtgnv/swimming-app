package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Trainer;

import java.time.LocalDate;
import java.util.List;

public interface TrainerService extends Service<Trainer>{
    Trainer findTrainerByNameAndPatronymicAndSurnameAndBirthDate(String name, String patronymic, String surname, LocalDate birthDate);
}
