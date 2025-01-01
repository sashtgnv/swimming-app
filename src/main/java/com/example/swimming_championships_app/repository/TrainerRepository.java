package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

// репозиторий сущности trainer
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
    // метод поиска записи по имени, отчеству, фамилии, и дате рождения
    Trainer findTrainerByNameAndPatronymicAndSurnameAndBirthDate(String name, String patronymic, String surname, LocalDate birthDate);
}
