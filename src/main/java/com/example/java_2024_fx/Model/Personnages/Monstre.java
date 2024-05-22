package com.example.java_2024_fx.Model.Personnages;

import com.example.java_2024_fx.Model.Items.Arme;
import com.example.java_2024_fx.Model.Items.ArmeOffensive;

public class Monstre extends Personnage{


    /**
     * Constructeur de la classe Monstre
     */
    public Monstre(String pseudo, Arme arme, int puissance) {

        super(pseudo, puissance);
        super.addItems(arme);
    }

    @Override
    public void attaquer(Personnage cible) {

    }

    @Override
    public void attaquer(Personnage cible, ArmeOffensive arme) {

    }

}
