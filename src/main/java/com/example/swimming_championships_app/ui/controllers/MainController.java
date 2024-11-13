package com.example.swimming_championships_app.ui.controllers;

import com.example.swimming_championships_app.model.Organizer;
import com.example.swimming_championships_app.ui.MainStage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
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
    private VBox vBox;

    @FXML
    private BorderPane root;

    public BorderPane getRoot() {
        return root;
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
    void champButtonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("championship-views/all-championships-view.fxml"));
        root.setCenter(loader.load());
        AllChampionshipsController controller = loader.getController();
        controller.setParentController(this);
    }

    @FXML
    void judgeButtonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("judges-view.fxml"));
        root.setCenter(loader.load());
    }

    @FXML
    void organizerButtonAction() throws IOException {
        FXMLLoader loader;
        if (currentUser == null) {
            loader = new FXMLLoader(MainStage.class.getResource("login-view.fxml"));
            root.setCenter(loader.load());
            LoginController loginController = loader.getController();
            loginController.setParentController(this);
        }
        else {
            loader = new FXMLLoader(MainStage.class.getResource("organizer-view.fxml"));
            root.setCenter(loader.load());
        }
    }

    @FXML
    void requestButtonAction() {

    }


    @FXML
    void requestProtocolButtonAction() {

    }

    @FXML
    void resultProtocolButtonAction() {

    }


    @FXML
    void statButtonAction() {

    }

}
