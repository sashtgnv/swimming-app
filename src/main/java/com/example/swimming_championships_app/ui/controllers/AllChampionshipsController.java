package com.example.swimming_championships_app.ui.controllers;

import com.example.swimming_championships_app.SwimmingChampionshipsApplication;
import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.service.impl.ChampionshipServiceImpl;
import com.example.swimming_championships_app.ui.MainStage;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import jdk.jfr.Threshold;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

public class AllChampionshipsController implements Initializable {

    private ChampionshipServiceImpl championshipService;

    private MainController parentController;

    public void setParentController(MainController parentController) {
        this.parentController = parentController;
    }

    @FXML
    private Label label;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setVisible(false);
        label.setManaged(false);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        championshipService = SwimmingChampionshipsApplication.context.getBean("championshipServiceImpl",
                ChampionshipServiceImpl.class);
        CompletableFuture.runAsync(()->fillPage());
    }

    private void fillPage() {
        List<Championship> championships = championshipService.findAll();
        List<VBox> vBoxes = new ArrayList<>();
        for (Championship ch : championships){
            FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("championship-views/mini-championship-view.fxml"));
            try {
                vBoxes.add(loader.load());
                MiniChampionshipController controller = loader.getController();
                controller.getNameLabel().setText(ch.getName());
                controller.getDescLabel().setText(
                        (String.valueOf(ch.getDate())).split(" ")[0]
                );
                controller.getImgView().setImage(new Image(ch.getPhoto()));
                controller.setChampionship(ch);
                controller.setParentController(parentController);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        synchronized (vBox){
            Platform.runLater(()->{
                vBox.getChildren().remove(1);
                vBox.getChildren().addAll(vBoxes);
                label.setVisible(true);
                label.setManaged(true);
            });
        }


    }
}
