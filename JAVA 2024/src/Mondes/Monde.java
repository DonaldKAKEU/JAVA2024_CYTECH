package Mondes;

import Interfaces.Mondes;
import Items.Items;
import Personnages.PNJ;


import java.util.ArrayList;
import java.util.List;

public class Monde implements Mondes {

    private String nom;

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(String nom){
        return this.nom;
    }

   // private List<Monstre> monstres

    private List<PNJ> pnjs;

    private List<Items> items;

    public Monde( String nom){

        this.pnjs = new ArrayList<>();
        this.items = new ArrayList<>();

        this.nom = nom;
    }

    public void addPNJ(PNJ pnj){
        this.pnjs.add(pnj);
    }

    public void addItems(Items items){
        this.items.add(items);
    }

}
