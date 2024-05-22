package com.example.java_2024_fx.Model.Personnages;

import com.example.java_2024_fx.Model.Interfaces.Discuter;
import com.example.java_2024_fx.Model.Interfaces.Interagir;
import com.example.java_2024_fx.Model.Items.ArmeDefensive;
import com.example.java_2024_fx.Model.Items.ArmeOffensive;
import com.example.java_2024_fx.Model.Items.Items;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Personnage extends Position implements Discuter, Interagir{

    /**
     * verifie si le personnage est vivant
     */
    private boolean estVivant;

    /**
     * accesseurs
     * @return
     */
    public boolean getEstVivant(){
        return this.estVivant;
    }

    public void setEstVivant(boolean estVivant){
        this.estVivant = estVivant;
    }

    /**
     * pseudo du personnage
     */
    private String pseudo;

    /**
     * accesseurs
     * @return
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * niveau de vie
     * definit la quantité de sang
     */
    private int pointVie;

    /**
     * accesseurs
     * @return
     */
    public int getPointVie() {
        return pointVie;
    }

    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
        super.setChanged();
        super.notifyObservers();

    }

    /**
     * puissance de son attaque
     * entier entre 1 et 5 en fonction du personnage
     */
    private int puissance;

    /**
     * accesseurs
     * @return
     */
    public int getPuissance() {
        return this.puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    /**
     * liste d'items que peux utilser le personnage
     */
    private ObservableList<Items> inventaire;

    public ObservableList<Items> getInventaire() {
        return this.inventaire;
    }

    public ObservableList<String> getInventaireString(){
        ObservableList<String> list = FXCollections.observableArrayList();
        for (Items item : this.inventaire){
            list.add(item.getNom());
        }
        return list;
    }

    public void setInventaire(ObservableList<Items> inventaire) {
        this.inventaire = inventaire;
        super.setChanged();
        super.notifyObservers();
    }

    private final java.util.Observable observable = new java.util.Observable();

    /**
     * constructeurs
     * @param pseudo
     * @param puissance
     */
    public Personnage(String pseudo, int puissance) {
        this.pseudo = pseudo;
        this.inventaire = FXCollections.observableArrayList();
        this.puissance = puissance;
        this.estVivant = true;
        this.pointVie = 100;

    }



    public void addItems( Items items){
        this.getInventaire().add(items);
        super.setChanged();
        super.notifyObservers();
    }

    public void removeItems(Items items){
        if (this.inventaire.contains(items))
            this.getInventaire().remove(items);
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

    /**
     *Interface Discuter
     */
    @Override
    public String parler(Personnage destinataire, String message) {
       return this.getPseudo() + " : " +  message;
    }

    @Override
    public void donner(Personnage destinataire, Items items) {
       destinataire.addItems(items);
    }

    /**
     * Interface Interagir
     */
    @Override
    public void subirDegats(int degats) {

        this.setPointVie(this.getPointVie() - degats);

        if (this.getPointVie() <= 0) {
            /**
             * le personnage meurt
             */
        }
    }

    @Override
    public void utiliserBouclier(ArmeDefensive arme) {

    }

    /**
     * attaque un personnage
     * @param cible
     */
    @Override
    public void attaquer(Personnage cible) {
        cible.subirDegats(this.getPuissance());
    }

    /**
     * attaque un personnage avec une arme offensive
     * @param cible
     * @param armeOffensive
     */
    @Override
     public void attaquer(Personnage cible, ArmeOffensive armeOffensive){
        cible.subirDegats(this.getPuissance()*armeOffensive.getCoef());
     }

     @Override
     public void seDeplacer(double dx, double dy){
         super.seDeplacer(dx, dy);
         super.setChanged();
         super.notifyObservers();
     }

     /**
      * verifie si le personnage possede un item
      * @param items si l'item est dans l'inventaire et retourne sa position si non retourne -1
      * @return
      */
     public boolean hasItems(Items items){
         if (this.getInventaire().contains(items))
             return true;
         else
             return false;
     }

     public double getItemsPosition(Items items){
         if (this.getInventaire().contains(items))
             return this.getInventaire().indexOf(items);
         else
             return -1;
     }

}
