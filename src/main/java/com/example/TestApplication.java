package com.example;


import com.example.java_2024_fx.Controller.ControleJeu;
import com.example.java_2024_fx.Model.Mondes.Monde;
import com.example.java_2024_fx.Model.Personnages.PJ;
import com.example.java_2024_fx.Model.Personnages.Personnage;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;


public class TestApplication extends Application {

        @Override
        public void start(Stage stage) throws Exception {
            Scene scene = new Scene(new BorderPane(), 800, 600);
            stage.setTitle("Game!");

            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args){ launch(args);}
}
