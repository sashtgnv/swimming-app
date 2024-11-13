package com.example.swimming_championships_app.ui.controllers;

import com.example.swimming_championships_app.model.Championship;
import com.example.swimming_championships_app.ui.MainStage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MiniChampionshipController {

    private Championship championship;

    public void setChampionship(Championship championship) {
        this.championship = championship;
    }

    private MainController parentController;

    public void setParentController(MainController parentController) {
        this.parentController = parentController;
    }


    @FXML
    private Label descLabel;

    @FXML
    private ImageView imgView;

    @FXML
    private Label nameLabel;

    public Label getDescLabel() {
        return descLabel;
    }

    public ImageView getImgView() {
        return imgView;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    @FXML
    void onDoubleClick(MouseEvent event) throws IOException {
        if (event.getClickCount() > 1) {
            FXMLLoader loader = new FXMLLoader(MainStage.class.getResource("championship-views/championship-view.fxml"));
            BorderPane root = parentController.getRoot();
            root.setCenter(loader.load());
            ChampionshipController controller = loader.getController();
            controller.setChampionship(championship);
            controller.init();
        }
    }
}
