package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;

public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
    Trainer findTrainerByNameAndPatronymicAndSurnameAndBirthDate(String name, String patronymic, String surname, LocalDate birthDate);

    Trainer findTrainerByName(String name);
}
