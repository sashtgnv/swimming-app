package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;

public interface SportsmanRepository extends JpaRepository<Sportsman,Integer> {
    Sportsman findSportsmanByNameAndPatronymicAndSurnameAndBirthDate(String name, String patronymic, String surname, LocalDate birthDate);
}
