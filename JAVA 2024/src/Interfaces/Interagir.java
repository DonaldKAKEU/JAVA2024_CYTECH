package Interfaces;

import Items.ArmeDefensive;
import Items.ArmeOffensive;
import Personnages.Personnage;

public interface Interagir {

    public void attaquer(Personnage cible);

    public void attaquer(Personnage cible, ArmeOffensive arme);

    public void subirDegats(int degats);

    public void utiliserBouclier(ArmeDefensive arme);
}
