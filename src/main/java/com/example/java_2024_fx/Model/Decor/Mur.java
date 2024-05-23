package com.example.java_2024_fx.Model.Decor;

import com.example.java_2024_fx.Model.Items.Cle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Mur  extends ElementDecor{


    /**
     * Liste des portes du mur
     */
    private ArrayList<Porte> Portes;

    public ArrayList<Porte> getPortes() {
        return Portes;
    }

    /**
     * Constructeur de la classe Mur avec porte
     * @param portes
     * @param largeur
     * @param hauteur
     */
    public Mur(ArrayList<Porte> portes, double largeur, double hauteur){
        super(largeur, hauteur, Color.WHITE);
        this.Portes = portes;
    }
    /**
     * Constructeur de la classe Mur sans porte
     * @param largeur
     * @param hauteur
     */
    public Mur(double largeur, double hauteur){
        super(largeur, hauteur, Color.WHITE);
        this.Portes = new ArrayList<Porte>();
    }

    /**
     * Constructeur de la classe Mur avec porte et position
     * @param portes
     * @param x
     * @param y
     * @param largeur
     * @param hauteur
     */
    public Mur(ArrayList<Porte> portes, double x, double y, double largeur, double hauteur){
        super(x, y, largeur, hauteur, Color.WHITE);
        this.Portes = portes;
    }

    /**
     * Ajouter une nouvelle porte au mur
     */
    public void addPorte(Porte p){
        this.Portes.add(p);
    }

    public void removePorte(Porte p){
        this.Portes.remove(p);
    }

    public void removePorte(int index){
        this.Portes.remove(index);
    }

}
