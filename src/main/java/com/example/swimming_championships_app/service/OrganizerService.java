package com.example.swimming_championships_app.service;

import com.example.swimming_championships_app.model.Organizer;

//интерфейс сервиса для репозитория organizer
public interface OrganizerService extends Service<Organizer> {
    // метод поиска записи по логину и паролю
    Organizer findByLoginAndPassword(String login, String password);
}
