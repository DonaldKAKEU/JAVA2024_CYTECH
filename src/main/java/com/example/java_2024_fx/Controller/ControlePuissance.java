package com.example.java_2024_fx.Controller;

import com.example.java_2024_fx.Model.Personnages.Personnage;
import javafx.scene.control.Label;

import java.util.Observable;
import java.util.Observer;

public class ControlePuissance implements Observer {

    private Label label;
    private int puissance;

    public ControlePuissance(int puissance, Label label) {
        this.puissance = puissance;
        this.label = label;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Personnage) {
            Personnage personnage = (Personnage) o;
            this.getLabel().setText("Puissance : " + personnage.getPuissance() + "/5");
        }
    }
}
