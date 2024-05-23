package com.example.java_2024_fx.Model.Game;

import com.example.java_2024_fx.Model.Decor.ElementDecor;
import com.example.java_2024_fx.Model.Items.Items;
import com.example.java_2024_fx.Model.Mondes.Monde;
import com.example.java_2024_fx.Model.Personnages.PJ;
import com.example.java_2024_fx.Model.Personnages.PNJ;

import java.util.ArrayList;

public class Jeu {
    private ArrayList<Monde> mondes;
    private PJ joueur;
    private ArrayList<PNJ> pnjs;
    private ArrayList<Items> items;
    private ArrayList<ElementDecor> elementsDecors;

    public Jeu(ArrayList<Monde> mondes, PJ joueur, ArrayList<PNJ> pnjs, ArrayList<Items> items, ArrayList<ElementDecor> elementsDecors) {
        this.mondes = mondes;
        this.joueur = joueur;
        this.pnjs = pnjs;
        this.items = items;
        this.elementsDecors = elementsDecors;
    }

    public ArrayList<Monde> getMondes() {
        return mondes;
    }
    public void setMondes(ArrayList<Monde> mondes) {
        this.mondes = mondes;
    }
    public PJ getJoueur() {
        return joueur;
    }
    public void setJoueur(PJ joueur) {
        this.joueur = joueur;
    }
    public ArrayList<PNJ> getPnjs() {
        return pnjs;
    }
    public void setPnjs(ArrayList<PNJ> pnjs) {
        this.pnjs = pnjs;
    }
    public ArrayList<Items> getItems() {
        return items;
    }
    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
    public ArrayList<ElementDecor> getElementsDecors() {
        return elementsDecors;
    }
    public void setElementsDecors(ArrayList<ElementDecor> elementsDecors) {
        this.elementsDecors = elementsDecors;
    }

    public void ajouterMonde(Monde monde){
        this.getMondes().add(monde);
    }

    public void ajouterPNJ(PNJ pnj){
        this.getPnjs().add(pnj);
    }

    public void ajouterItem(Items item){
        this.getItems().add(item);
    }

    public void ajouterElementDecor(ElementDecor elementDecor){
        this.getElementsDecors().add(elementDecor);
    }

    public void supprimerMonde(Monde monde){
        this.getMondes().remove(monde);
    }

    public void supprimerPNJ(PNJ pnj){
        this.getPnjs().remove(pnj);
    }

    public void supprimerItem(Items item){
        this.getItems().remove(item);
    }

    public void supprimerElementDecor(ElementDecor elementDecor){
        this.getElementsDecors().remove(elementDecor);
    }

}
