package com.example.swimming_championships_app.ui.controllers;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.model.Discipline;
import com.example.swimming_championships_app.model.Request;
import com.example.swimming_championships_app.model.Sportsman;
import com.example.swimming_championships_app.service.impl.ChampionshipServiceImpl;
import com.example.swimming_championships_app.service.impl.RequestServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class RequestProtocolController implements Initializable {

    private RequestServiceImpl requestService;
    private ChampionshipServiceImpl championshipService;

    @FXML
    private VBox vBox;

    @FXML
    private ComboBox<Championship> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
            disciplineLabel.setFont(Font.font("Monospaced", FontWeight.BOLD,20));
            vBox.getChildren().add(disciplineLabel);

            for (int i = 0; i < requests.size(); i++) {

                if (i % 5 == 0) { // номер заплыва
                    Label swim = new Label("Заплыв №" +  (i / 5 + 1));
                    swim.setFont(Font.font("Monospaced",18));
                    vBox.getChildren().addAll(new Label("-".repeat(150)),swim);
                }

                Sportsman sportsman = requests.get(i).getSportsman();
                // строка из таблицы заплыва
                StringBuilder s = new StringBuilder();
                s.append((i % 5 + 1)).
                        append(" | ").
                        append(sportsman.getSurname()).
                        append(' ').
                        append(sportsman.getName()).
                        append(' ').
                        append(sportsman.getPatronymic()).
                        append(" ".repeat(40 - s.length())).
                        append(" | ").
                        append(sportsman.getGrade()).
                        append(" ".repeat(6 - sportsman.getGrade().length())).
                        append(" | ").append(requests.get(i).getRequestTime());

                Label sl = new Label(s.toString());
                sl.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                sl.setFont(Font.font("Monospaced",18));

                vBox.getChildren().add(sl);
            }
        }
    }
}
