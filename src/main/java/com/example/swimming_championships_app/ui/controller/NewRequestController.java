package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.model.Discipline;
import com.example.swimming_championships_app.model.Request;
import com.example.swimming_championships_app.service.impl.ChampionshipServiceImpl;
import com.example.swimming_championships_app.service.impl.RequestServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import javax.swing.text.DateFormatter;
import java.net.URL;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class NewRequestController implements Initializable {
    @FXML
    private ComboBox<Championship> championshipChoose;

    @FXML
    private ComboBox<Discipline> distanceChoose;

    @FXML
    private ListView<Request> listView;

    @FXML
    private TextField requestTimeField;

    @FXML
    private Button saveRequestsButton;

    @FXML
    private Label sportsmanWarningLbl;

    @FXML
    private ComboBox<String> sportsmanGrade;

    @FXML
    private TextField sportsmanName;

    @FXML
    private TextField sportsmanPatronymic;

    @FXML
    private TextField sportsmanSurname;

    @FXML
    private CheckBox trainerCheckBox;

    @FXML
    private ComboBox<?> trainerGrade;

    @FXML
    private TextField trainerName;

    @FXML
    private TextField trainerPatronymic;

    @FXML
    private TextField trainerSurname;

    @FXML
    private Label trainerLabel;

    @FXML
    private Label trainerWarningLbl;

    @FXML
    private TextField sportsmanDateField;

    @FXML
    private TextField trainerDateField;

    @FXML
    private HBox pageBody;

    private RequestServiceImpl requestService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trainerLabel.setVisible(false);
        requestService = SwimmingChampionshipsApplication.context.
                getBean("requestServiceImpl", RequestServiceImpl.class);
        ChampionshipServiceImpl championshipService = SwimmingChampionshipsApplication.context.
                getBean("championshipServiceImpl", ChampionshipServiceImpl.class);
        List<Championship> championships = championshipService.findEarlyThan(new Date());
        championshipChoose.getItems().addAll(championships);
        pageBody.setVisible(false);
    }

    @FXML
    void setTrainerVisible() {
        trainerLabel.setVisible(!trainerLabel.isVisible());
    }

    @FXML
    void validateBirthDate(KeyEvent event) {
        TextField dateField = (TextField) event.getSource();
        Label warning = (dateField.equals(sportsmanDateField)) ? sportsmanWarningLbl : trainerWarningLbl;
        try {
            warning.setVisible(false);
            LocalDate date = LocalDate.parse(dateField.getText(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            System.out.println(date);
        } catch (Exception e) {
            warning.setVisible(true);
        }
    }

    @FXML
    void selectChampionship() {
        pageBody.setVisible(true);
        distanceChoose.getItems().addAll();
    }
}
