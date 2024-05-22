package com.example.java_2024_fx.Controller;

import com.example.java_2024_fx.Model.Interfaces.Mondes;
import com.example.java_2024_fx.Model.Mondes.Monde;
import com.example.java_2024_fx.Presentation.MondeView.MondeView;
import javafx.scene.shape.Shape;

import java.util.Observable;
import java.util.Observer;

public class ControleMonde extends Observable implements Observer {
    private Monde monde;
    private MondeView mondeView;

    public ControleMonde(Monde monde, MondeView mondeView) {
        this.monde = monde;
        this.mondeView = mondeView;
    }

    public Monde getMonde() {
        return monde;
    }

    public void setMonde(Monde monde) {
        this.monde = monde;
        this.setChanged();
        this.notifyObservers();
    }

    public MondeView getMondeView() {
        return mondeView;
    }

    public void setMondeView(MondeView mondeView) {
        this.mondeView = mondeView;
    }

    public void addPersonnage(PersonnageController personnageController) {
        this.getMondeView().ajouterPersonnageView(personnageController.getPersonnageView());
    }

    public void addPersonnage(Shape shape) {
        this.getMondeView().ajouterPersonnageView(shape);
    }

    public void addElementDecor(ControleElementDecor elementDecorController) {
        this.getMondeView().ajouterElementDecorView(elementDecorController.getElementDecorView());
    }

    @Override
    public void update(Observable o, Object arg) {
        //this.setMonde((Monde) o);
    }
}
