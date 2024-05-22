package Mondes;

import Decor.Mur;

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
    public Piece(String nom, int taille) {
        super(nom);

        Mur h1 = new Mur(taille,false);
        Mur h2 = new Mur(taille, false);
        Mur v1 = new Mur(taille, true);
        Mur v2 = new Mur(taille, true);

        this.lesMurs.add(h1);
        this.lesMurs.add(h2);
        this.lesMurs.add(v1);
        this.lesMurs.add(v2);

    }
}
