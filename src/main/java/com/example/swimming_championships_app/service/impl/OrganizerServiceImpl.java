package com.example.swimming_championships_app.service.impl;

import com.example.swimming_championships_app.model.Organizer;
import com.example.swimming_championships_app.repository.OrganizerRepository;
import com.example.swimming_championships_app.service.OrganizerService;
import org.springframework.stereotype.Service;

import java.util.List;

//реализация интерфейса organizerService
@Service
public class OrganizerServiceImpl implements OrganizerService {
    OrganizerRepository repository;

    public OrganizerServiceImpl(OrganizerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Organizer> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Organizer organizer) {
        repository.delete(organizer);
    }

    @Override
    public Organizer save(Organizer organizer) {
        return repository.save(organizer);
    }

    @Override
    public Organizer findByLoginAndPassword(String login, String password) {
        return repository.findByLoginAndPassword(login, password);
    }
}
