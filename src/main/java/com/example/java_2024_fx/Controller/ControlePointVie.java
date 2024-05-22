package com.example.java_2024_fx.Controller;

import com.example.java_2024_fx.Model.Mondes.LesMondes;
import com.example.java_2024_fx.Model.Personnages.PJ;
import com.example.java_2024_fx.Model.Personnages.Personnage;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.Observer;

public class ControlePointVie implements Observer {

    private Label label;
    private int pointVie;

    public ControlePointVie(Label label, int pointVie){
        this.label = label;
        this.pointVie = pointVie;
    }

    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }

    public int getPointVie() {
        return pointVie;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Label getLabel() {
        return label;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Personnage){
            Personnage personnage = (Personnage) o;
            this.getLabel().setText("Point de vie : " + personnage.getPointVie() + "/100");
        }
    }
}
