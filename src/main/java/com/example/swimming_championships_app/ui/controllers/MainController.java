package com.example.swimming_championships_app.ui.controllers;

import com.example.swimming_championships_app.model.Organizer;
import com.example.swimming_championships_app.ui.MainStage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Organizer currentUser;

    public void setCurrentUser(Organizer currentUser) {
        this.currentUser = currentUser;
    }

    @FXML
    private VBox centerContainer;

    public VBox getCenterContainer() {
        return centerContainer;
    }

    @FXML
    private Button champButton;

    @FXML
    private Button judgeButton;

    @FXML
    private Button organizerButton;

    @FXML
    private Button requestButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button statButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
    }

    @FXML
    void champButtonAction() {

    }

    @FXML
    void judgeButtonAction() {

    }

    @FXML
    void organizerButtonAction() throws IOException {
        if (currentUser == null) {
            FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("login-view.fxml"));
            centerContainer.getChildren().set(0,loader.load());
            LoginController loginController = loader.getController();
            loginController.setParentController(this);
        }
        else {
//TODO
        }
    }

    @FXML
    void requestButtonAction() {

    }

    @FXML
    void statButtonAction() {

    }

}
