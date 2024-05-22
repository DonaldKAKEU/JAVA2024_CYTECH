package com.example.java_2024_fx.Model.Personnages;

import com.example.java_2024_fx.Model.Items.Items;
import com.example.java_2024_fx.Model.Items.Cle;
import com.example.java_2024_fx.Model.Items.Items;

import java.util.List;

public class Artisant extends PNJ{


    public Artisant(Cle cle) {
        super(cle);
    }

    /**
     * constructeur utilisé dans le cas où l'interlocuteur demande
     * à l'artisant de fabriquer une cle
     */
    public Artisant(){
        super(null);
    }

    /**
     * donner l'items en sa position
     * @param destinataire
     * @param items
     */
    @Override
    public void donner(Personnage destinataire, Items items) {

        Cle cle =(Cle) items;

        destinataire.addItems(cle);

    }

    /**
     * parler à un interlocuteur
     * @param destinataire
     * @param message
     * @return
     */
    @Override
    public String parler(Personnage destinataire,String message){
        return "Artisant :" + message;
    }

    /**
     * peut fabriquer une cle
     * @param code
     * @return
     */
    public Cle makeCle(int code){
        Cle cle = new Cle(code);

        return cle;
    }
}
