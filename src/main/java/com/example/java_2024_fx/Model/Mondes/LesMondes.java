package com.example.java_2024_fx.Model.Mondes;

import com.example.java_2024_fx.Model.Interfaces.Mondes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.ArrayList;
import java.util.Observable;

public class LesMondes extends Observable {

    public static final Integer CHANGEMENT_MONDE_COURANT = new Integer(0); // PAC
    public static final Integer CHANGEMENT_TAILLE = new Integer(1); // PAC
    public static final Integer NOUVEAU_MONDE = new Integer(2); // PAC


    private ObservableList<Monde> lesMondes;

    private int indexCourant;

    public void setIndexCourant(int indexCourant) {
        this.indexCourant = indexCourant;
        this.setChanged();
        this.notifyObservers(CHANGEMENT_MONDE_COURANT);
    }

    public LesMondes(ObservableList<Monde> lesMondes) {
        this.lesMondes = lesMondes;
        this.indexCourant = 0;
    }

    public LesMondes() {
        this.lesMondes = FXCollections.observableArrayList();
        this.indexCourant = 0;
    }

    public int getSize() {
        return this.lesMondes.size();
    }

    public ObservableList<Monde> getLesMondes() {
        return this.lesMondes;
    }

    public void setLesMondes(ObservableList<Monde> lesMondes) {
        this.lesMondes = lesMondes;
    }

    public ObservableList<String> getLesMondesString() {
        ObservableList<String> lesNomsMondes = FXCollections.observableArrayList();
        for (Monde monde : this.lesMondes) {
            lesNomsMondes.add(monde.getNom());
        }
        return lesNomsMondes;
    }

    public void addMondes(Monde monde) {
        this.lesMondes.add(monde);
        this.setChanged();
        this.notifyObservers(NOUVEAU_MONDE);
    }

    public void removeMondes(Monde monde) {
        this.lesMondes.remove(monde);
        this.setChanged();
        this.notifyObservers(NOUVEAU_MONDE);
    }

    public Monde getMondeCourant() {
        return this.lesMondes.get(this.indexCourant);
    }

    public Monde getMonde(int index) {
        return this.lesMondes.get(index);
    }

}
