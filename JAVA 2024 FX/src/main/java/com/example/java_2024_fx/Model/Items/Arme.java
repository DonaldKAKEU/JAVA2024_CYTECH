package com.example.java_2024_fx.Model.Items;

public  abstract class Arme extends Items{

    /**
     * entier mutiplication ou demultiplicateur(arme defensive) à la puissance de l'utilisateur pour porter un coup
     */
    private int coef;


    public Arme(int coef, String libelle){
        super(libelle);
        this.coef = coef;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

}
