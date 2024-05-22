package com.example.demo2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Compteur  extends Application {

    Button play = new Button("Play");
    Button back = new Button("<<");
    TextField textField = new TextField("Volume");
    Slider slider = new Slider(0, 100,50);

Media media = new Media("kdsl");
MediaPlayer controlPlayer = new MediaPlayer(media);

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Lecteur Audio");

        FlowPane pane = new FlowPane();
        pane.setVgap(10);

        pane.getChildren().addAll(play, back, textField, slider);


        Scene scene = new Scene(pane);

        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args){
        launch();
    }
}
