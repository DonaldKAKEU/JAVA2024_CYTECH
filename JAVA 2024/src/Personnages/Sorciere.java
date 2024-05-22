package Personnages;

import Items.Potion;

import Items.Items;

import java.util.List;

public class Sorciere extends PNJ{


    public Sorciere() {
        super(new Potion());
    }

    @Override
    public void donner(Personnage destinataire, Items items) {

        Potion potion =(Potion)items;

        destinataire.addItemsToIventaire(potion);

    }

    @Override
    public String parler(Personnage destinataire,String message){
        return "Sorciere :" + message;
    }

    @Override
    public void seDeplacer(double dx, double dy) {

    }
}
