package com.example.java_2024_fx.Model.Personnages;
import com.example.java_2024_fx.Model.Interfaces.Deplacer;
import com.example.java_2024_fx.Model.Interfaces.Discuter;
import com.example.java_2024_fx.Model.Items.Items;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public abstract class PNJ implements Discuter {


    private final Items items;

    public PNJ(Items items) {
        this.items = items;
    }

    public Items getItems(){
        return this.items;
    }

    public String parler(Personnage destinataire,String message){
        return message;
    }

    public void donner(Personnage destinataire, Items items){

    }

}
