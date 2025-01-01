package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.model.*;
import com.example.swimming_championships_app.service.impl.ChampionshipServiceImpl;
import com.example.swimming_championships_app.service.impl.RequestServiceImpl;
import com.example.swimming_championships_app.service.impl.ResultServiceImpl;
import com.example.swimming_championships_app.util.Time;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

//класс-контроллер страницы заполнения итоговых протоколов
public class FillResultProtocolController implements Initializable {
    @FXML
    private ComboBox<Championship> championshipChoose;

    @FXML
    private ComboBox<Discipline> disciplineChoose;

    @FXML
    private VBox vBox;


    private ResultServiceImpl resultService;
    private RequestServiceImpl requestService;
    private ChampionshipServiceImpl championshipService;

    //    метод инициализации контроллера
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultService = SwimmingChampionshipsApplication.context.
                getBean("resultServiceImpl", ResultServiceImpl.class);
        requestService = SwimmingChampionshipsApplication.context.
                getBean("requestServiceImpl", RequestServiceImpl.class);
        championshipService = SwimmingChampionshipsApplication.context.
                getBean("championshipServiceImpl", ChampionshipServiceImpl.class);
        List<Championship> championships = championshipService.findEarlyThan(LocalDate.now());
        championshipChoose.getItems().setAll(championships);
    }

    // метод показа протокола для заполнения
    @FXML
    void showProtocol() {
        Championship championship = championshipChoose.getSelectionModel().getSelectedItem();
        Discipline discipline = disciplineChoose.getSelectionModel().getSelectedItem();
        vBox.getChildren().clear();
        if (discipline != null) {
            Label disciplineLabel = new Label(discipline.getDistance() + "м " + discipline.getStyle());
            disciplineLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 20));
            vBox.getChildren().add(disciplineLabel);
            List<TextField> textFields = new ArrayList<>();
            List<Request> requests = requestService.findByChampionshipAndDiscipline(championship, discipline);
            for (int i = 0; i < requests.size(); i++) {

                if (i % 5 == 0) { // номер заплыва
                    Label swim = new Label("Заплыв №" + (i / 5 + 1));
                    swim.setFont(Font.font("Monospaced", 18));
                    vBox.getChildren().addAll(new Label("-".repeat(150)), swim);
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
                        append(" ".repeat(40 - s.length()));
                Label sl = new Label(s.toString());
                sl.setMinSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
                sl.setFont(Font.font("Monospaced", 18));
                HBox h = new HBox();
                TextField textField = new TextField();
                textField.setPromptText("мин:сек.мс");
                Label wlbl = new Label("Введите время в нужном формате");
                wlbl.setVisible(false);
                h.getChildren().addAll(sl, textField, wlbl);
                textField.setOnKeyTyped(keyEvent -> {
                    wlbl.setVisible(false);
                    Time time = null;
                    try {
                        time = new Time(textField.getText());
                    } catch (Exception e) {
                        time = null;
                        wlbl.setVisible(true);
                    }
                });
                vBox.getChildren().add(h);
                textFields.add(textField);
            }
            Label success = new Label("Сохранено");
            Label notSuccess = new Label("Пожалуйста, заполните все поля правильно");
            success.setTextFill(Color.web("#10c400"));
            notSuccess.setTextFill(Color.RED);
            Button saveButton = new Button("Сохранить протокол");
            saveButton.setOnAction(actionEvent -> {
                success.setVisible(false);
                notSuccess.setVisible(false);
                List<String> texts = new ArrayList<>();
                for (TextField t : textFields) {
                    texts.add(t.getText());
                }
                for (String t : texts) {
                    if (!t.isEmpty()) {
                        try {
                            Time time = new Time(t);
                        } catch (Exception e) {
                            notSuccess.setVisible(true);
                            return;
                        }
                    } else {
                        notSuccess.setVisible(true);
                        return;
                    }
                }
                for (int i = 0; i < requests.size(); i++) {
                    resultService.save(new Result(null, requests.get(i), new Time(textFields.get(i).getText()).getAll(), null));
                }
                success.setVisible(true);

            });
            vBox.getChildren().addAll(success, notSuccess, saveButton);
            success.setVisible(false);
            notSuccess.setVisible(false);
        }
    }

    //метод заполнения комбобокса дистанций
    @FXML
    void fillDistances() {
        if (championshipChoose.getSelectionModel().getSelectedItem() != null) {
            disciplineChoose.getItems().setAll(championshipChoose.getSelectionModel().getSelectedItem().getDisciplines());
        }
    }
}
