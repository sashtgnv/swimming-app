package com.example.swimming_championships_app.ui.controllers;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.service.impl.JudgeServiceImpl;
import com.example.swimming_championships_app.model.Judge;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class JudgesController implements Initializable {
    private JudgeServiceImpl judgeService;

    @FXML
    private VBox vBox;

    @FXML
    private ScrollPane scrollPane;

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
                    append(",\t").
                    append(j.getDeserts());
            Label l = new Label(text.toString());
            vBox.getChildren().add(l);
        }
    }
}
