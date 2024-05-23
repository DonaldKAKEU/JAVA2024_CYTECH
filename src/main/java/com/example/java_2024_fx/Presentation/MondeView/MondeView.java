package com.example.java_2024_fx.Presentation.MondeView;

import com.example.java_2024_fx.Presentation.DecorView.ElementDecorView;
import com.example.java_2024_fx.Presentation.PersonnageView.PersonnageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class MondeView {

    private Pane root;
    private Color backgroundColor;

    public MondeView(Color backgroundColor) {

        Pane root = new Pane();
        this.root = root;
        this.backgroundColor = backgroundColor;
        root.setPrefSize(800,600);
        //root.setStyle(backgroundColor.toString());
        root.setStyle("-fx-background-color: " + backgroundColor.toString().replace("0x", "#") + ";");

    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void ajouterPersonnageView(PersonnageView personnageView) {
        this.getRoot().getChildren().add(personnageView.getShape());
        //this.getRoot().setCenter(personnageView.getShape());
    }

    public void ajouterPersonnageView(Shape shape) {
        this.getRoot().getChildren().add(shape);
    }


    public void supprimerPersonnageView(PersonnageView personnageView) {
        this.getRoot().getChildren().remove(personnageView.getShape());
    }

    public void ajouterElementDecorView(ElementDecorView elementDecorView) {
        this.getRoot().getChildren().add(elementDecorView.getShape());
        //this.getRoot().setCenter(elementDecorView.getShape());
    }
}
