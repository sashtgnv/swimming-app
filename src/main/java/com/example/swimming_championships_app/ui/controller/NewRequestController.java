package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.model.*;
import com.example.swimming_championships_app.service.impl.ChampionshipServiceImpl;
import com.example.swimming_championships_app.service.impl.RequestServiceImpl;
import com.example.swimming_championships_app.service.impl.SportsmanServiceImpl;
import com.example.swimming_championships_app.service.impl.TrainerServiceImpl;
import com.example.swimming_championships_app.util.Time;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class NewRequestController implements Initializable {
    @FXML
    private ComboBox<Championship> championshipChoose;

    @FXML
    private ComboBox<Discipline> disciplineChoose;

    @FXML
    private TextField requestTimeField;

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
    private ComboBox<String> trainerGrade;

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
    private VBox pageBody;

    @FXML
    private Label notSuccessLbl;

    private RequestServiceImpl requestService;
    private SportsmanServiceImpl sportsmanService;
    private ChampionshipServiceImpl championshipService;
    private TrainerServiceImpl trainerService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        trainerLabel.setVisible(false);
        requestService = SwimmingChampionshipsApplication.context.
                getBean("requestServiceImpl", RequestServiceImpl.class);
        championshipService = SwimmingChampionshipsApplication.context.
                getBean("championshipServiceImpl", ChampionshipServiceImpl.class);
        sportsmanService = SwimmingChampionshipsApplication.context.
                getBean("sportsmanServiceImpl", SportsmanServiceImpl.class);
        trainerService = SwimmingChampionshipsApplication.context.
                getBean("trainerServiceImpl", TrainerServiceImpl.class);
        List<Championship> championships = championshipService.findEarlyThan(new Date());
        championshipChoose.getItems().addAll(championships);
        pageBody.setVisible(false);
        trainerLabel.setManaged(false);
    }

    @FXML
    void setTrainerVisible() {
        trainerLabel.setVisible(!trainerLabel.isVisible());
        trainerLabel.setManaged(!trainerLabel.isManaged());
    }

    @FXML
    void validateBirthDate(KeyEvent event) {
        TextField dateField = (TextField) event.getSource();
        Label warning = (dateField.equals(sportsmanDateField)) ? sportsmanWarningLbl : trainerWarningLbl;
        try {
            warning.setVisible(false);
            LocalDate date = LocalDate.parse(dateField.getText(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        } catch (Exception e) {
            warning.setVisible(true);
        }
    }

    @FXML
    void selectChampionship() {
        pageBody.setVisible(true);
        Championship championship = championshipChoose.getSelectionModel().getSelectedItem();
        List<Discipline> disciplines = championship.getDisciplines();
        disciplineChoose.getItems().addAll(disciplines);
    }

    @FXML
    void validateTime(){
        Time time = null;
        try {
            time = new Time(requestTimeField.getText());
        } catch (Exception e) {
            time = null;
        }
    }

    @FXML
    void addRequest(){
        LocalDate sportsmanDate = null;
        LocalDate trainerDate = null;
        Time time = null;
        try {
            sportsmanDate = LocalDate.parse(sportsmanDateField.getText(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            time = new Time(requestTimeField.getText());
            trainerDate = LocalDate.parse(trainerDateField.getText(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        } catch (Exception ignored) {}

        String sportsmanNameText = sportsmanName.getText();
        String sportsmanPatronymicText = sportsmanPatronymic.getText();
        String sportsmanSurnameText = sportsmanSurname.getText();
        String trainerNameText = trainerName.getText();
        String trainerPatronymicText = trainerPatronymic.getText();
        String trainerSurnameText = trainerSurname.getText();
        Discipline discipline = disciplineChoose.getSelectionModel().getSelectedItem();

        if ((!sportsmanNameText.isEmpty() &&
                !sportsmanPatronymicText.isEmpty() &&
                !sportsmanSurnameText.isEmpty() &&
                sportsmanDate!=null &&
                time!=null &&
                discipline!=null) &&
                (!trainerCheckBox.isSelected() ||
                        trainerCheckBox.isSelected() &&
                        !trainerNameText.isEmpty() &&
                        !trainerPatronymicText.isEmpty() &&
                        !trainerSurnameText.isEmpty() &&
                        trainerDate!=null))
        {
            Trainer trainer = null;
            if (trainerCheckBox.isSelected()) {
                trainer = trainerService.findTrainerByNameAndPatronymicAndSurnameAndBirthDate(trainerNameText, trainerPatronymicText, trainerSurnameText, trainerDate);
                if (trainer == null) {
                    trainer = new Trainer(null,
                            sportsmanSurnameText,
                            sportsmanNameText,
                            sportsmanPatronymicText,
                            sportsmanDate,
                            trainerGrade.getSelectionModel().getSelectedItem(),
                            null);
                }
            }

            Sportsman sportsman = sportsmanService.findSportsmanByNameAndPatronymicAndSurnameAndBirthDate(sportsmanNameText,sportsmanPatronymicText,sportsmanSurnameText,sportsmanDate);
            if (sportsman == null) {
                sportsman = new Sportsman(null,
                        sportsmanSurnameText,
                        sportsmanNameText,
                        sportsmanPatronymicText,
                        sportsmanDate,
                        sportsmanGrade.getSelectionModel().getSelectedItem(),
                        null);
            }
            trainerService.save(trainer);
            trainer = trainerService.findTrainerByNameAndPatronymicAndSurnameAndBirthDate(trainerNameText, trainerPatronymicText, trainerSurnameText, trainerDate);
            if ( trainer != null && (sportsman.getTrainer() == null)) {
                System.out.println("yes");
                sportsman.setTrainer(trainer);
            }
            System.out.println(sportsman);
            sportsmanService.save(sportsman);

            requestService.save(new Request(null,
                    discipline,
                    sportsman,
                    championshipChoose.getSelectionModel().getSelectedItem(),
                    time.getAll(),
                    null,null
                    ));
        } else {
            notSuccessLbl.setVisible(true);
        }
    }

}
