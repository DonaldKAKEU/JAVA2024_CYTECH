package com.example.demo3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class Visionneuse extends Application {

   Album album = new Album("H:\\Documents\\GIA1\\JAVA\\IHM\\images\\images");

   ImageView imageView = new ImageView(album.getPhotoCourante().getImage());

    @Override
    public void start(Stage stage) throws Exception {
        /**
         * modifie le titre
         * title
         */
        stage.setTitle("Album Photo");

        /**
         * creer la surface latérale de la fenêtre
         */
        BorderPane root = new BorderPane();
        root.setCenter(creerCentre());
        root.setRight(creerSlide());
        root.setLeft(creerListe());
        root.setBottom(creerBandeauBas());

        /**
         * creer la surface principale de la fenêtre
         */
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case RIGHT:
                    album.setIndexCourant(album.getIndexCourant()+1);
                    imageView.setImage(album.getPhotoCourante().getImage());
                    break;
                case LEFT:
                    album.setIndexCourant(album.getIndexCourant()-1);
                    imageView.setImage(album.getPhotoCourante().getImage());
                    break;
            }
        });

        /**
         * ajouter la surface à la fenêtre
         */
        stage.setScene(scene);

        /**
         * afficher la fenêtre
         */
        stage.show();


    }

    /**
     * retourne la photo courante dans surface principale d'affichage de photo de la fenêtre
     * @return Pane
     */
    private Pane creerCentre(){

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.BASELINE_LEFT);
        flowPane.setPrefSize(600,450);
        flowPane.getChildren().add(imageView);

        return flowPane;

    }

    private Slider creerSlide(){
        Slider slider = new Slider(0,300,100);
        slider.setMajorTickUnit(100);
        slider.setMinorTickCount(10);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        slider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
           album.redimensionnerPhotoCourante(newValue.floatValue());
            imageView.setImage(album.getPhotoCourante().getImage());
        } );

        slider.setOrientation(Orientation.VERTICAL);
        return slider;
    }

    private ListView<String> creerListe(){

        /**
         * liste de nom de photo d'album
         */
        String[] tabNoms = new String[album.getSize()];
        /**
         * Initialiser le tableau
         */
        for (int i=0; i< album.getSize(); i++){
            tabNoms[i] = album.getPhoto(i).getNom();
        }
        /**
         * creer une liste affichable avec les nom du tableau
         * return ListView  : Class JAVAFX
         */
        ListView<String> liste = new ListView<>(
                FXCollections.observableArrayList(tabNoms)
        );

        /**
         * Afficher les nom de chaque photo via la liste ListView
         */
        liste.getSelectionModel().select(album.getPhotoCourante().getNom());

        liste.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {
            int indice = liste.getSelectionModel().getSelectedIndex();
            album.setIndexCourant(indice);
            imageView.setImage(album.getPhotoCourante().getImage());
        }));

        return liste;
    }

    private Pane creerBandeauBas(){
        FlowPane panes = new FlowPane();

        for(int i=0;i< album.getSize();i++){
            Button button = new Button();

            Image photoArrPlan = album.getPhoto(i).getIcone();
            BackgroundImage arrplan = new BackgroundImage(photoArrPlan, BackgroundRepeat.NO_REPEAT,  BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    new BackgroundSize(1000, 800, false, false, true, false));
            button.setBackground(new Background(arrplan));
            panes.getChildren().add(button);
            panes.setPrefSize(200, 50);
        }

        return  panes;
    }
    public static void main(String[] args){ launch(args);}
}
