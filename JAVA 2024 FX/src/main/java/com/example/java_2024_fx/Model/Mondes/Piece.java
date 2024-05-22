/**package com.example.java_2024_fx.Model.Mondes;

import com.example.java_2024_fx.Model.Decor.Mur;
import javafx.scene.paint.Color;

import java.util.List;

public class Piece extends Monde{

    private List<Mur> lesMurs;

    public List<Mur> getLesMurs(){
        return lesMurs;
    }

    /**
     *  @param nom
     * @param taille longueur des mur, ils sont tous de même taille
     */
  /**  public Piece(String nom, int taille, Color couleur) {
        super(nom, couleur);

        Mur h1 = new Mur(line, taille,false);
        Mur h2 = new Mur(line, taille, false);
        Mur v1 = new Mur(line, taille, true);
        Mur v2 = new Mur(line, taille, true);

        this.lesMurs.add(h1);
        this.lesMurs.add(h2);
        this.lesMurs.add(v1);
        this.lesMurs.add(v2);

    }
}
**/