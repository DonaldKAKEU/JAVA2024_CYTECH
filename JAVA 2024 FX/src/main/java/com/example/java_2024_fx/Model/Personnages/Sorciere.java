package com.example.java_2024_fx.Model.Personnages;


import com.example.java_2024_fx.Model.Items.Items;
import com.example.java_2024_fx.Model.Items.Potion;

import java.util.List;

public class Sorciere extends PNJ{


    public Sorciere(String libelle) {
        super(new Potion(libelle));
    }

    @Override
    public void donner(Personnage destinataire, Items items) {

        Potion potion =(Potion)items;

        destinataire.addItems(potion);

    }

    @Override
    public String parler(Personnage destinataire,String message){
        return "Sorciere :" + message;
    }

}
