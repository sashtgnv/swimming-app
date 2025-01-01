package com.example.swimming_championships_app.ui.controller;

import com.example.swimming_championships_app.model.Organizer;
import com.example.swimming_championships_app.ui.MainStage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

// класс-контроллер главного окна
public class MainController {
    private Organizer currentUser;

    public void setCurrentUser(Organizer currentUser) {
        this.currentUser = currentUser;
    }

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
    private Button requestProtocolButton;

    @FXML
    private Button resultProtocolButton;

    @FXML
    private VBox vBoxx;

    @FXML
    private Label welcomeLabel;

    //метод перехода на страницу календаря соревнований
    @FXML
    void champButtonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("championship-views/all-championships-view.fxml"));
        root.setCenter(loader.load());
        AllChampionshipsController controller = loader.getController();
        controller.setParentController(this);
    }

    //метод перехода на страницу списка судей
    @FXML
    void judgeButtonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("judges-view.fxml"));
        root.setCenter(loader.load());
    }

    //метод перехода на страницу авторизации/страницы организатора
    @FXML
    void organizerButtonAction() throws IOException {
        FXMLLoader loader;
        if (currentUser == null) {
            loader = new FXMLLoader(MainStage.class.getResource("organizer-views/login-view.fxml"));
            root.setCenter(loader.load());
            LoginController loginController = loader.getController();
            loginController.setParentController(this);
        } else {
            loader = new FXMLLoader(MainStage.class.getResource("organizer-views/organizer-view.fxml"));
            root.setCenter(loader.load());
            OrganizerController organizerController = loader.getController();
            organizerController.setRoot(root);
        }
    }

    //метод перехода на страницу создания новой заявки
    @FXML
    void requestButtonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("new-request-view.fxml"));
        root.setCenter(loader.load());
    }

    //метод перехода на страницу протокола заявок
    @FXML
    void requestProtocolButtonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("request-protocol-view.fxml"));
        root.setCenter(loader.load());
    }

    //метод перехода на страницу итогового протокола
    @FXML
    void resultProtocolButtonAction() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("result-protocol-view.fxml"));
        root.setCenter(loader.load());
    }

}
