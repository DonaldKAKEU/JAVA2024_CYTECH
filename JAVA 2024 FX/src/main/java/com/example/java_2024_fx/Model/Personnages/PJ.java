package com.example.java_2024_fx.Model.Personnages;

import com.example.java_2024_fx.Model.Items.ArmeOffensive;
import com.example.java_2024_fx.Model.Items.Items;
import javafx.collections.ObservableList;

import java.util.Observable;


public class PJ extends Personnage {



    /**
     * Constructeur de la classe PJ
     */
    public PJ(String pseudo) {
        super(pseudo, 3);
    }

    @Override
    public void setPointVie(int pointVie) {
        super.setPointVie(pointVie);
        if (super.getPointVie() <= 0) {
            super.setEstVivant(false);
        }
        super.setChanged();
        super.notifyObservers();
    }

    @Override
    public void setX(double x) {
        super.setX(x);
        super.setChanged();
        super.notifyObservers();
    }

    @Override
    public void setY(double y) {
        super.setY(y);
        super.setChanged();
        super.notifyObservers();
    }

    @Override
    public void seDeplacer(double dx, double dy) {
        super.seDeplacer(dx, dy);
        super.setChanged();
        super.notifyObservers();
    }

    @Override
    public void attaquer(Personnage cible) {
        cible.subirDegats(super.getPuissance());
    }

    @Override
    public void attaquer(Personnage cible, ArmeOffensive arme) {
        cible.subirDegats(arme.getCoef()*super.getPuissance());
    }

    public ObservableList<Items> getInventaire() {
        return super.getInventaire();
    }

    public void addItems(Items item) {
        super.addItems(item);
    }

}
