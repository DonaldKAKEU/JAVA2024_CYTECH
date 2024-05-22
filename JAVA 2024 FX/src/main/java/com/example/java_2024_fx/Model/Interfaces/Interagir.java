package com.example.java_2024_fx.Model.Interfaces;

import com.example.java_2024_fx.Model.Items.ArmeDefensive;
import com.example.java_2024_fx.Model.Items.ArmeOffensive;
import com.example.java_2024_fx.Model.Personnages.Personnage;

public interface Interagir {

    public  abstract void attaquer(Personnage cible);

    public abstract void attaquer(Personnage cible, ArmeOffensive arme);

    public void subirDegats(int degats);

    public void utiliserBouclier(ArmeDefensive arme);
}
