package Personnages;

import Interfaces.Deplacement;
import Interfaces.Discuter;
import Items.Items;
import Position.Position;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class PNJ extends Position implements Discuter, Deplacement {

    public final static Circle formeJoueur = new Circle(15, Color.YELLOW);

    public Circle getFormeJoueur(){
        return this.formeJoueur;
    }

    private final Items items;

    public PNJ(Items items) {
        this.items = items;
    }

    public Items getItems(){
        return this.items;
    }

    public String parler(Personnage destinataire,String message){
        return message;
    }

    public void donner(Personnage destinataire, Items items){

    }

    /**
     * un deplacement aléatoire
     */
    public void seDeplacer(){

    }

    public void afficherPosition(){

    }
}
