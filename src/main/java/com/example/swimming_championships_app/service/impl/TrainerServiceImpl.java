package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Trainer;
import com.example.swimming_championships_app.repository.TrainerRepository;
import com.example.swimming_championships_app.service.TrainerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//реализация интерфейса trainerService
@Service
public class TrainerServiceImpl implements TrainerService {
    TrainerRepository repository;

    public TrainerServiceImpl(TrainerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Trainer> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Trainer trainer) {
        repository.delete(trainer);
    }

    @Override
    public Trainer save(Trainer trainer) {
        return repository.save(trainer);
    }

    @Override
    public Trainer findTrainerByNameAndPatronymicAndSurnameAndBirthDate(String name, String patronymic, String surname, LocalDate birthDate) {
        return repository.findTrainerByNameAndPatronymicAndSurnameAndBirthDate(name, patronymic, surname, birthDate);
    }
}
