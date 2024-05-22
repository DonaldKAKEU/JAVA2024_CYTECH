package Interfaces;

import Exceptions.BadCleException;
import Items.Cle;

public interface Traversable {

    public void ouvrir(Cle cle) throws BadCleException;
    public void fermer();
}
