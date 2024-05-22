package com.example.java_2024_fx.Model.Items;

public class Potion  extends Items{

    /**
     * quantite de potion present dans la goude en Litre
     * rajoute des point de vie a l'utilisateur
    */
    private int quantite;

    public Potion(String libelle) {
        super(libelle);
        this.quantite = 10;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
