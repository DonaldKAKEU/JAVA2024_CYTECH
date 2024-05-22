package Decor;

import javax.sound.sampled.Port;
import java.util.ArrayList;

public class Mur  extends ElementDecor{

    private static final String couleur = "Marron";

    private final int longueur;


    /**
     * false = horizontale
     * true = vertical
     */
    private final Boolean orientation;

    private ArrayList<Porte> Portes;

    public Mur(int longueur, boolean orientation){
        super();
        this.longueur = longueur;
        this.orientation = orientation;
    }

    public Mur(int longueur, boolean orientation, double x, double y){
        super(x, y);
        this.longueur = longueur;
        this.orientation = orientation;
    }

    public void addPorte(Porte p){
        p.setX(this.getX());
        p.setY(this.getY());
        this.Portes.add(p);
    }

    public int getLongueur() {
        return longueur;
    }

    public Boolean getOrientation() {
        return orientation;
    }
}
