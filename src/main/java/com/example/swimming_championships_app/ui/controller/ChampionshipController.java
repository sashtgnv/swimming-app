package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.model.Discipline;
import com.example.swimming_championships_app.model.Judge;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

//класс-контроллер страницы соревнования
public class ChampionshipController implements Initializable {

    private Championship championship;

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    @FXML
    private Label adressLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label distancesLabel;

    @FXML
    private Label documentLabel;

    @FXML
    private Label judgesLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label copiedLabel;

    @FXML
    private VBox vBox;

    @FXML
    private Hyperlink hyperLink;

    //    метод инициализации контроллера
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adressLabel.setManaged(false);
        dateLabel.setManaged(false);
        distancesLabel.setManaged(false);
        documentLabel.setManaged(false);
        judgesLabel.setManaged(false);
        titleLabel.setManaged(false);
    }

    // метод пост-инициализации
    public void init() {
        //выполняется в отдельном потоке
        CompletableFuture.runAsync(() -> {
            String title = championship.getName();
            StringBuilder date = new StringBuilder("Дата проведения: \n").append('\t').append(championship.getDate().toString().split(" ")[0]);
            StringBuilder adress = new StringBuilder("Место проведения: \n").append('\t').append(championship.getAdress());
            StringBuilder distances = new StringBuilder("Дистанции:\n");
            for (Discipline d : championship.getDisciplines()) {
                distances.append('\t').append(d.getDistance()).append("м ").append(d.getStyle()).append('\n');
            }
            StringBuilder judges = new StringBuilder("Список судей соревнований:\n");
            for (Judge j : championship.getJudges()) {
                judges.append('\t').append(j.getName()).append(' ').append(j.getPatronymic()).append(' ').append(j.getSurname()).append('\n');
            }
            StringBuilder document = new StringBuilder("Ссылка на Положение о соревновании : ");
            Platform.runLater(() -> {
                adressLabel.setManaged(true);
                dateLabel.setManaged(true);
                distancesLabel.setManaged(true);
                documentLabel.setManaged(true);
                judgesLabel.setManaged(true);
                titleLabel.setManaged(true);
                vBox.getChildren().removeFirst();
                titleLabel.setText(title);
                dateLabel.setText(date.toString());
                adressLabel.setText(adress.toString());
                distancesLabel.setText(distances.toString());
                judgesLabel.setText(judges.toString());
                documentLabel.setText(document.toString());
                hyperLink.setText(championship.getDocument());
            });
        });
    }

    // метод копирования ссылки положения в буфер обмена
    @FXML
    void copyLink() {
        if (hyperLink.isVisited()) {
            final ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(hyperLink.getText());
            Clipboard.getSystemClipboard().setContent(clipboardContent);
            copiedLabel.setVisible(true);
        }
    }
}
