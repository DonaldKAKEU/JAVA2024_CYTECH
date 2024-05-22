package com.example.java_2024_fx.Controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class ControleJeu {

    Scene scene;

    PersonnageController personnageController;

    ControleMonde mondeController;


    public ControleJeu(   PersonnageController personnageController,    ControleMonde mondeController) {
        this.personnageController = personnageController;
        this.mondeController = mondeController;
    }

    public Scene Demarer() {

        BorderPane root = new BorderPane();

        Button button = new Button("Start");
        root.setCenter(button);
/**
 button.setOnAction(e -> {
 start();
 });
 **/
        scene = new Scene(root, 800, 600);
        return scene;
    }

    public void start() {

    }

    public void stop() {
    }

    public void pause() {
    }

    public void reprendre() {
    }

    public void sauvegarder() {
    }

    public void charger() {
    }
}
