package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Organizer;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrganizerService extends Service<Organizer> {
    Organizer findByLoginAndPassword(String login, String password);
}
