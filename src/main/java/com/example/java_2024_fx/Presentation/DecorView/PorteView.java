package com.example.java_2024_fx.Presentation.DecorView;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class PorteView extends ElementDecorView{

    public PorteView(double longueur, double largeur, Color color) {
        super(new javafx.scene.shape.Rectangle(longueur, largeur, color));
    }
}
