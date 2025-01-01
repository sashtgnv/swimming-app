package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.model.Discipline;
import com.example.swimming_championships_app.model.Judge;
import com.example.swimming_championships_app.service.impl.ChampionshipServiceImpl;
import com.example.swimming_championships_app.service.impl.DisciplineServiceImpl;
import com.example.swimming_championships_app.service.impl.JudgeServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

// метод создания нового соревнования
public class NewChampionshipController implements Initializable {

    @FXML
    private Button addChampionshipButton;

    @FXML
    private TextField adressField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField documentField;

    @FXML
    private Label pageTitleLbl;

    @FXML
    private TextField photoFiled;

    @FXML
    private TextArea nameField;

    @FXML
    private Label warningDateLbl;

    @FXML
    private Label warningLbl;

    @FXML
    private ComboBox<Judge> judgesChoose;

    @FXML
    private Button addJudgeButton;

    @FXML
    private ComboBox<Discipline> disciplinesChoose;

    @FXML
    private ListView<Discipline> disciplinesListView;

    @FXML
    private Button addDisciplineButton;

    @FXML
    private ListView<Judge> judgesListView;

    @FXML
    private Label successLabel;

    private JudgeServiceImpl judgeService;

    private ChampionshipServiceImpl championshipService;

    private DisciplineServiceImpl disciplineService;

    //    метод инициализации контроллера
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        championshipService = SwimmingChampionshipsApplication.context.
                getBean("championshipServiceImpl", ChampionshipServiceImpl.class);
        judgeService = SwimmingChampionshipsApplication.context.getBean("judgeServiceImpl",
                JudgeServiceImpl.class);
        disciplineService = SwimmingChampionshipsApplication.context.getBean("disciplineServiceImpl",
                DisciplineServiceImpl.class);
        disciplinesChoose.getItems().addAll(disciplineService.findAll());
        judgesChoose.getItems().addAll(judgeService.findAll());
    }

    //метод валидации даты
    @FXML
    void validateDate(KeyEvent event) {
        try {
            warningDateLbl.setVisible(false);
            LocalDate.parse(dateField.getText(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        } catch (Exception e) {
            warningDateLbl.setVisible(true);
        }
    }

    // метод добавления соревнования в бд
    @FXML
    void addChampionship() {
        LocalDate date = null;
        warningLbl.setVisible(false);
        successLabel.setVisible(false);
        try {
            date = LocalDate.parse(dateField.getText(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        } catch (Exception ignored) {
            warningDateLbl.setVisible(true);
        }
        String name = nameField.getText();
        String documentLink = documentField.getText();
        String address = adressField.getText();
        String photoLink = photoFiled.getText();
        List<Judge> judges = judgesListView.getItems();
        List<Discipline> disciplines = disciplinesListView.getItems();
        if (!name.isEmpty() && date != null && !documentLink.isEmpty() && !address.isEmpty() && !photoLink.isEmpty() && !judges.isEmpty() && !disciplines.isEmpty()) {
            championshipService.save(new Championship(null, name, date, documentLink, address, photoLink, judges, disciplines));
            successLabel.setVisible(true);
            nameField.setText("");
            dateField.setText("");
            documentField.setText("");
            adressField.setText("");
            photoFiled.setText("");
            judgesChoose.getSelectionModel().clearSelection();
            disciplinesChoose.getSelectionModel().clearSelection();
            judgesListView.getItems().clear();
            disciplinesListView.getItems().clear();
        } else {
            warningLbl.setVisible(true);
        }
    }

    //метод добавления судьи
    @FXML
    void addJudge() {
        Judge judge = judgesChoose.getSelectionModel().getSelectedItem();
        if (judge != null && !judgesListView.getItems().contains(judge)) {
            judgesListView.getItems().add(judge);
        }
    }

    //метод добавления дистанций
    @FXML
    void addDiscipline() {
        Discipline discipline = disciplinesChoose.getSelectionModel().getSelectedItem();
        if (discipline != null && !disciplinesListView.getItems().contains(discipline)) {
            disciplinesListView.getItems().add(discipline);
        }
    }
}
