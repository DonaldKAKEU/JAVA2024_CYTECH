package com.example.java_2024_fx.Model.Mondes;

import com.example.java_2024_fx.Model.Interfaces.Mondes;
import com.example.java_2024_fx.Model.Items.Items;
import com.example.java_2024_fx.Model.Personnages.Monstre;
import com.example.java_2024_fx.Model.Personnages.PNJ;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


import java.util.ArrayList;
import java.util.List;

public class Monde implements Mondes {

    /**
     * Nom du monde
     */
    private String nom;

    private Color backgroundColor;

    public Color getBackgroundColor(){
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
    }

    /**
     * accesseur et mutateur du nom
     * @param nom
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }


    /**
     * verifie si le monde a été parcouru
     *
     */
    private boolean estParcouru;

    public boolean getEstParcouru(){
        return this.estParcouru;
    }
    public void setEstParcouru(boolean estParcouru){
        this.estParcouru = estParcouru;
    }


    /**
     * Egalité entre deux mondes
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Monde){
            Monde monde = (Monde) obj;
            return this.getNom().equals(monde.getNom());
        }
        return false;
    }

    /**
     * Liste des monstres qui protège le monde
     */
    private List<Monstre> monstres;
    public List<Monstre> getMonstres(){
        return this.monstres;
    }

    /**
     * Liste des personnage qui peuplent le monde
     */
    private List<PNJ> pnjs;
    public List<PNJ> getPnjs(){
        return this.pnjs;
    }

    /**
     * Liste des items qui peuplent le monde
     */
    private List<Items> items;
    public List<Items> getItems(){
        return this.items;
    }

    public Monde(String nom, Color backgroundColor){

        this.pnjs = new ArrayList<>();
        this.items = new ArrayList<>();
        this.backgroundColor = backgroundColor;

        this.nom = nom;
    }

    public void addPNJ(PNJ pnj){
        this.pnjs.add(pnj);
    }

    public void addItems(Items items){
        this.items.add(items);
    }

}
