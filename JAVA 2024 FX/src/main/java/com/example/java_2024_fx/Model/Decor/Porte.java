package com.example.java_2024_fx.Model.Decor;

import com.example.java_2024_fx.Model.Exceptions.BadCleException;
import com.example.java_2024_fx.Model.Interfaces.Traversable;
import com.example.java_2024_fx.Model.Items.Cle;
import com.example.java_2024_fx.Model.Items.Items;
import javafx.scene.paint.Color;


import java.util.Objects;

public class Porte extends ElementDecor implements Traversable {

    /**
     * Dimension d'une porte
     */
    public final static int LONGUEUR = 45;
    public final static int LARGEUR = 10;

    /**
     * Class Cle representé par un code
     */
    private final Cle cle;

    public Cle getCle() {
        return this.cle;
    }

    private boolean estOuvert;

    public Porte(Cle cle){
        super(LARGEUR,LONGUEUR, Color.BROWN);
        this.cle = cle;
        this.estOuvert = false;
    }


    public boolean getEstOuvert() {
        return this.estOuvert;
    }

    public void setEstOuvert(boolean b){
        this.estOuvert = b;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Porte) {
            Porte porte = (Porte) o;
            return this.getCle() == porte.getCle();
        }

        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cle, estOuvert);
    }

    /**
     * Ouvrir la porte
     * @param cle
     * @return true si la porte est ouverte et false sinon dans ce cas il s'agit d'une mauvaise cle
     */
    private Boolean ouvrir(Cle cle) {
        if (cle == this.getCle()) {
            this.setEstOuvert(true);
            return true;
        }
        return false;
    }

    @Override
    public void action(Items items) throws BadCleException {

        if (items instanceof Cle) {
            Cle cle = (Cle) items;
            if(this.ouvrir(cle)){
                this.setEstOuvert(true);
                System.out.println("La porte est ouverte");
            } else {
                throw new BadCleException("Mauvaise cle");
            }

        }
    }

    @Override
    public void action() {
        // impossible d'ouvrir une porte sans cle
    }
}
