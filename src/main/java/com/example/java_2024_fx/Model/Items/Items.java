package com.example.java_2024_fx.Model.Items;



public abstract class Items {

    private String nom;

    public Items(String nom){
        super();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
