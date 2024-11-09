package com.example.swimming_championships_app.repository;

import com.example.swimming_championships_app.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
    Organizer findByLoginAndPassword(String login, String password);
}
