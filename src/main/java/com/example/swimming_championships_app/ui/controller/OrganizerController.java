package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.ui.MainStage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

//класс-контроллер страницы организатора
public class OrganizerController {
    @FXML
    private Button fillResultProtocolButton;

    @FXML
    private Button newChampionshipButton;

    private BorderPane root;

    //сеттер
    public void setRoot(BorderPane root) {
        this.root = root;
    }

    //метод перехода на страницу заполнения итоговых протоколов
    @FXML
    void fillResultProtocol() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("organizer-views/fill-result-protocol-view.fxml"));
        root.setCenter(loader.load());
    }

    //метод перехода на страницу создания нового соревнования
    @FXML
    void newChampionship() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("organizer-views/new-championship-view.fxml"));
        root.setCenter(loader.load());
    }
}
