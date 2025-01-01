package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

// репозиторий сущности organizer
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    // метод поиска записи по логину и паролю
    Organizer findByLoginAndPassword(String login, String password);
}
