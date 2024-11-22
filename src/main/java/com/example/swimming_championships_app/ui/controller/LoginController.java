package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.model.Organizer;
import com.example.swimming_championships_app.service.impl.OrganizerServiceImpl;
import com.example.swimming_championships_app.ui.MainStage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
    private MainController parentController;
    private OrganizerServiceImpl organizerService;

    public void setParentController(MainController parentController) {
        this.parentController = parentController;
    }

    @FXML
    private Button authorizeButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label wrongAuthLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ApplicationContext context = SwimmingChampionshipsApplication.context;
        organizerService = context.getBean("organizerServiceImpl", OrganizerServiceImpl.class);

        wrongAuthLabel.setVisible(false);
        wrongAuthLabel.setManaged(false);
    }

    @FXML
    void authorize() throws IOException {
        if (loginField.getText()!=null && passwordField.getText()!=null){
            Organizer user = organizerService.findByLoginAndPassword(loginField.getText(),passwordField.getText());
            if (user!=null) {
                parentController.setCurrentUser(user);
                FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("organizer-views/organizer-view.fxml"));
                BorderPane root = parentController.getRoot();
                root.setCenter(loader.load());
            } else {
                wrongAuthLabel.setVisible(true);
                wrongAuthLabel.setManaged(true);
            }

        }
    }
}
