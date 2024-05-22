package Personnages;

import Interfaces.Controlable;
import Interfaces.Deplacement;
import Interfaces.Discuter;
import Interfaces.Interagir;
import Items.ArmeDefensive;
import Items.ArmeOffensive;
import Items.Items;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;




public class PJ extends Personnage implements Deplacement, Discuter, Interagir, Controlable {

    public final static Circle formeJoueur = new Circle(15, Color.RED);

    public Circle getFormeJoueur(){
        return this.formeJoueur;
    }


    /**
     * niveau de vie
     * definit la quantité de sang
     */
    private int pointVie;

    /**
     * puissance de son attaque
     */
    private int Puissance;

    public PJ(String pseudo, List<Items> inventaire) {
        super(pseudo, inventaire);
    }

    public void afficherPosition() {

    }

    public void donner(Personnage destinataire, Items items){

    }

    public String parler(Personnage destinataire,String message){
        return message;
    }

    public void subirDegats(int degats) {
        this.pointVie -= degats;
        if (this.pointVie <= 0) {
            /**
             * le personnage meurt
             */
        }
    }

    @Override
    public void utiliserBouclier(ArmeDefensive arme) {

    }

    public void attaquer(Personnage cible) {

    }

    @Override
    public void attaquer(Personnage cible, ArmeOffensive arme) {

    }

    @Override
    public void seDeplacer() {

    }

    @Override
    public void seDeplacer(double deltaX, double deltaY) {
        getFormeJoueur().relocate(getFormeJoueur().getLayoutX() + deltaX, getFormeJoueur().getLayoutY() + deltaY);
    }

    @Override
    public void controler(Scene scene) {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                    case UP:
                        seDeplacer(0, -10);
                        System.out.println(event.getCharacter().toString());
                        break;
                    case DOWN:
                        seDeplacer(0, 10);
                        System.out.println(event.getCharacter().toString());
                        break;
                    case LEFT:
                        seDeplacer(-10, 0);
                        System.out.println(event.getCharacter().toString());
                        break;
                    case RIGHT:
                        seDeplacer(10, 0);
                        System.out.println(event.getCharacter().toString());
                        break;
                }
            }
        });

    }
}
