package Interfaces;

import Items.Items;
import Personnages.Personnage;

public interface Discuter {

    /**
     * s'addresser à un personnage
     * @param destinataire
     * @return
     */
    public String parler(Personnage destinataire,String message);

    /**
     * donner un items à un Personnage
     * @param destinataire
     * @param items
     */
    public void donner(Personnage destinataire, Items items);

}
