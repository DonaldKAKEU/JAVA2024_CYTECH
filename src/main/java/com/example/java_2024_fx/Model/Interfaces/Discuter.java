package com.example.java_2024_fx.Model.Interfaces;

import com.example.java_2024_fx.Model.Items.Items;
import com.example.java_2024_fx.Model.Personnages.Personnage;

public interface Discuter {

    /**
     * s'addresser à un personnage
     * @param destinataire
     * @return
     */
    public String parler(Personnage destinataire, String message);

    /**
     * donner un items à un Personnage
     * @param destinataire
     * @param items
     */
    public void donner(Personnage destinataire, Items items);

}
