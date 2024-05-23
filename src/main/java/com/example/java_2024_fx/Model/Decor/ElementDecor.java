package com.example.java_2024_fx.Model.Decor;
import com.example.java_2024_fx.Model.Personnages.Position;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;



import javafx.scene.shape.Rectangle;


public  abstract class ElementDecor extends Position {

    private double longueur;

    private double largeur;

    private Color couleur;

    /**
     * Constructeur de la classe ElementDecor sans position
     * @param largeur
     * @param hauteur
     * @param couleur
     */
    public ElementDecor(double largeur, double hauteur, Color couleur) {
        super(0, 0);
        this.largeur = largeur;
        this.longueur = hauteur;
        this.setCouleur(couleur);
    }

    /**
     * Constructeur de la classe ElementDecor avec position
     * @param x
     * @param y
     * @param largeur
     * @param hauteur
     * @param couleur
     */
    public ElementDecor(double x, double y, double largeur, double hauteur, Color couleur) {
        super(x, y);
        this.largeur = largeur;
        this.longueur = hauteur;
        this.setCouleur(couleur);
    }



    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public void setPos(double x, double y) {
        super.setX(x);
        super.setY(y);
    }

    public double getX() {
        return super.getX();
    }

    public double getY() {
        return super.getY();
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
}
