package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.model.Judge;
import com.example.swimming_championships_app.service.impl.JudgeServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

// класс-контроллер страницы судей федерации
public class JudgesController implements Initializable {
    private JudgeServiceImpl judgeService;

    @FXML
    private HBox hBox;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label titleLabel;

    @FXML
    private VBox vBox;

    //    метод инициализации контроллера
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        judgeService = SwimmingChampionshipsApplication.context.getBean("judgeServiceImpl",
                JudgeServiceImpl.class);
        List<Judge> judges = judgeService.findAll();
        for (Judge j : judges) {
            StringBuilder text = new StringBuilder(j.getName()).
                    append(' ').
                    append(j.getPatronymic()).
                    append(' ').
                    append(j.getSurname()).
                    append(", ").
                    append(j.getDeserts());
            Label l = new Label(text.toString());
            l.setFont(Font.font(20));
            vBox.getChildren().add(l);
        }
    }
}
