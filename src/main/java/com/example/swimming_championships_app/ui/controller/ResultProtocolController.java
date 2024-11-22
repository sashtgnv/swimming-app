package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.model.*;
import com.example.swimming_championships_app.service.impl.ChampionshipServiceImpl;
import com.example.swimming_championships_app.service.impl.RequestServiceImpl;
import com.example.swimming_championships_app.service.impl.ResultServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class ResultProtocolController implements Initializable {

    private ResultServiceImpl resultService;
    private RequestServiceImpl requestService;
    private ChampionshipServiceImpl championshipService;

    @FXML
    private VBox vBox;

    @FXML
    private ComboBox<Championship> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultService = SwimmingChampionshipsApplication.context.
                getBean("resultServiceImpl", ResultServiceImpl.class);
        requestService = SwimmingChampionshipsApplication.context.
                getBean("requestServiceImpl", RequestServiceImpl.class);
        championshipService = SwimmingChampionshipsApplication.context.
                getBean("championshipServiceImpl", ChampionshipServiceImpl.class);
        List<Championship> championships = championshipService.findEarlyThan(new Date());
        comboBox.getItems().addAll(championships);
    }

    @FXML
    void showProtocol() {
        Championship championship = comboBox.getSelectionModel().getSelectedItem();
        List<Discipline> disciplines = championship.getDisciplines();
        for (Discipline discipline : disciplines) {
            List<Request> requests = requestService.findByChampionshipAndDiscipline(championship, discipline);
            // Заголовок дистанции
            Label disciplineLabel = new Label(discipline.getDistance() + "м " + discipline.getStyle());
            disciplineLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 20));
            vBox.getChildren().addAll(disciplineLabel, new Label("-".repeat(150)));
            List<Result> results = new ArrayList<>();
            // для каждой заявки нахожу результат (если есть)
            for (Request request : requests)
                if (resultService.findResultByRequest(request) != null)
                    results.add(resultService.findResultByRequest(request));
            // сортирую список результатов по времени
            if (results.size() > 1)
                results.sort(Comparator.comparingInt(result ->
                        result.getTimeInt()));
            // заполняю строки протокола
            for (int i = 0; i < results.size(); i++) {
                Result result = results.get(i);
                // строка протокола результатов
                if (result != null) {
                    Sportsman sportsman = result.getRequest().getSportsman();
                    StringBuilder s = new StringBuilder();
                    s.append((i + 1)).
                            append(' ').
                            append((i+1 > 9) ? "" : " ").
                            append((i+1 > 99) ? "" : " ").
                            append("| ").
                            append(sportsman.getSurname()).
                            append(' ').
                            append(sportsman.getName()).
                            append(' ').
                            append(sportsman.getPatronymic()).
                            append(' ').
                            append(" ".repeat(50 - s.length())).
                            append(" | ").
                            append(result.getResultTime());
                    Label sl = new Label(s.toString());
                    sl.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                    sl.setFont(Font.font("Monospaced", 18));
                    vBox.getChildren().add(sl);
                }
            }
        }
    }
}
