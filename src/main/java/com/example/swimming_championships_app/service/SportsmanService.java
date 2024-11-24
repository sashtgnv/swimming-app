package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Sportsman;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SportsmanService extends Service<Sportsman>{
    Sportsman findSportsmanByNameAndPatronymicAndSurnameAndBirthDate(String name, String patronymic, String surname, LocalDate birthDate);

}
