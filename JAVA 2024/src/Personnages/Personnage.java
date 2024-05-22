package Personnages;

import Interfaces.Deplacement;
import Interfaces.Discuter;
import Interfaces.Interagir;
import Items.Items;
import Items.ArmeOffensive;
import Position.Position;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



import java.util.List;

public abstract class Personnage extends Position implements Discuter, Deplacement, Interagir {


    private final String pseudo;

    /**
     * niveau de vie
     * definit la quantité de sang
     */
    private int pointVie;

    /**
     * puissance de son attaque
     * entier entre 1 et 5 en fonction du personnage
     */
    private int puissance;

    /**
     * liste d'items que peux utilser le personnage
     */
    private List<Items> inventaire;

    /**
     * constructeurs
     * @param pseudo
     * @param inventaire
     */


    public Personnage(String pseudo, List<Items> inventaire) {
        this.pseudo = pseudo;
        this.inventaire = inventaire;
    }

    /**
     * accesseurs
     * @return
     */

    public String getPseudo() {
        return pseudo;
    }

    public List<Items> getInventaire() {
        return inventaire;
    }

    public int getPointVie(){
        return this.pointVie;
    }

    public int getPuissance(){
        return this.puissance;
    }

    public void setPointVie(int pointVie){
        this.pointVie = pointVie;
    }

    public void setPuissance(int puissance){
        this.puissance = puissance;
    }

    //**

    public void addItemsToIventaire( Items items){
        this.getInventaire().add(items);
    }
    public void deleteItemsToIventaire(Items items){
        if (inventaire.contains(items))
            this.getInventaire().remove(items);
    }



    @Override
    public String parler(Personnage destinataire, String message) {
        return this.getPseudo() + " : " +  message;
    }

    public void donner(Personnage destinataire, Items items) {
        destinataire.addItemsToIventaire(items);
    }

    public void seDeplacer( double dx, double dy) {
        super.setX(dx);
        super.setY(dy);
    }


    public void subirDegats(int degats) {
        this.pointVie -= degats;
        if (this.pointVie <= 0) {
            /**
             * le personnage meurt
             */
        }
    }
    public void attaquer(Personnage cible) {
        cible.subirDegats(this.getPuissance());
    }
     public void attaquer(Personnage cible, ArmeOffensive armeOffensive){
        cible.subirDegats(this.getPuissance()*armeOffensive.getCoef());
     }

    public abstract void seDeplacer();
}
