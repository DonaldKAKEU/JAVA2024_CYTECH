package com.example.java_2024_fx.Controller;

import com.example.java_2024_fx.Model.Mondes.LesMondes;
import com.example.java_2024_fx.Presentation.MondeView.MondeView;
import javafx.scene.layout.Pane;

import java.util.Observable;
import java.util.Observer;

public class ControleZoneJeu implements Observer {

    private Pane zoneJeu;

    ControleMonde mondeController;

    public ControleMonde getMondeController(){
        return mondeController;
    }

    public void setMondeController(ControleMonde mondeController){
        this.mondeController = mondeController;
    }

    public Pane getZoneJeu(){
        return zoneJeu;
    }

    public void setZoneJeu(Pane zoneJeu){
        this.zoneJeu = zoneJeu;
    }


    public ControleZoneJeu(Pane zoneJeu, ControleMonde mondeController){
        this.zoneJeu = zoneJeu;
        this.mondeController = mondeController;
    }

    @Override
    public void update(Observable o, Object arg) {
        LesMondes mondes = (LesMondes) o;
        Integer i = (Integer) arg;
        if(i == LesMondes.CHANGEMENT_MONDE_COURANT)
                this.getMondeController().setMonde(mondes.getMonde(i));
               // this.getMondeController().setMondeView(new MondeView(((LesMondes) o).getMondeCourant().getBackgroundColor()));
               //  this.getMondeController().setMondeView();
                System.out.println(i.toString() + "Monde suivant");
    }
}
