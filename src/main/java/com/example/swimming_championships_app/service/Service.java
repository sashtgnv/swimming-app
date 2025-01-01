package com.example.swimming_championships_app.service;

import java.util.List;

//интерфейс сервиса для репозитория
public interface Service<T> {
    // метод поиска всех записей в таблице
    List<T> findAll();

    // метод удаления выбранной записи
    void delete(T t);

    // метод сохранения или обновления выбранной записи
    T save(T t);
}
