package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

// репозиторий сущности sportsman
public interface SportsmanRepository extends JpaRepository<Sportsman, Integer> {
    // метод поиска записи по имени, отчеству, фамилии, и дате рождения
    Sportsman findSportsmanByNameAndPatronymicAndSurnameAndBirthDate(String name, String patronymic, String surname, LocalDate birthDate);
}
