package com.example.java_2024_fx.Controller;

import com.example.java_2024_fx.Model.Interfaces.Controlable;
import com.example.java_2024_fx.Model.Personnages.PJ;
import com.example.java_2024_fx.Model.Personnages.Personnage;
import com.example.java_2024_fx.Model.Personnages.Position;
import com.example.java_2024_fx.Presentation.PersonnageView.PersonnageView;
import com.example.java_2024_fx.Presentation.PersonnageView.PjView;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Observer;

public class PersonnageController /*implements Observer, ChangeListener, Controlable*/ {

    private PersonnageView personnageView;
    private Personnage personnage;

    public PersonnageController(PersonnageView personnageView, Personnage personnage){
        this.personnageView = personnageView;
        this.personnage = personnage;
    }

    public PersonnageView getPersonnageView() {
        return this.personnageView;
    }

    public Personnage getPersonnage() {
        return personnage;
    }


    public void attaquer(Personnage cible){
        this.getPersonnage().attaquer(cible);
    }

    /**
     * Permet de mettre à jour la position du personnage
     * @param o
     * @param arg

    public void update(java.util.Observable o, Object arg) {

    if( o instanceof Personnage) {


        //this.getPersonnageView().getShape().setLayoutX(this.getPersonnage().getX());
        //this.getPersonnageView().getShape().setLayoutY(this.getPersonnage().getY());

/**
        if (this.getPersonnageView() instanceof PjView) {

            PjView pjView = (PjView) this.getPersonnageView();

            System.out.println("X : " + this.getPersonnage().getX() + "/" + this.getPersonnage().getY());

            }


        }
    }

    /**
     * Permet de changer la valeur de la position du personnage
     * @param observable
     * @param oldValue
     * @param newValue

    @Override
    public void changed(javafx.beans.value.ObservableValue observable, Object oldValue, Object newValue) {
       // this.getPersonnage().setX((double) newValue);
    }

    /**
     * Permet de controler le personnage
     * @param scene

    @Override
    public void controler(Pane scene) {


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                        getPersonnage().seDeplacer(0, -10);
                        System.out.println("UP");
                        break;
                    case DOWN:
                        getPersonnage().seDeplacer(0, 10);
                        System.out.println("DOWN");
                        break;
                    case LEFT:
                        getPersonnage().seDeplacer(-10, 0);
                        System.out.println("LEFT");
                        break;
                    case RIGHT:
                        getPersonnage().seDeplacer(10, 0);
                        System.out.println("RIGHT");
                        break;
                    case ENTER:
                        System.out.println("ATTAQUE");
                        break;
                    default:
                        System.out.println("Touche non reconnue");
                        break;
                }

            }

        });
    }

    /**
     * Permet d'afficher la barre de vie du personnage
     * @return

    public Pane afficherPointVie(){

        if(this.getPersonnageView() instanceof PjView) {
           // ((PjView) this.getPersonnageView()).getBarreDeVie().setValue(this.getPersonnage().getPointVie());
            PjView pjView = (PjView) this.getPersonnageView();
            FlowPane pane = new FlowPane();
            pane.getChildren().addAll(pjView.getBarreDeVie());
            pane.setPrefSize(200, 25);
            pane.setStyle("-fx-background-color: #FFFFFF;");
            return pane;
        }
        return null;
    }

    public Label afficherPseudo(){
        if(this.getPersonnage() instanceof PJ) {
            PJ pj = (PJ) this.getPersonnage();
            Label label = new Label();
            label.setText(pj.getPseudo());
            label.setStyle("-fx-font-size: 20px;");
            return label;
        }
        return null;
    }
/**
    public ListView afficherInventaire(){
        if(this.getPersonnageView() instanceof PjView) {
            PjView pjView = (PjView) this.getPersonnageView();
            Personnage personnage = this.getPersonnage();

            String[] inventaire = new String[personnage.getInventaire().size()];
            for (int i = 0; i < personnage.getInventaire().size(); i++) {
                inventaire[i] = personnage.getInventaire().get(i).toString();
            }

            ListView listView = pjView.getInventaire();

            listView.setItems(this.getPersonnage().getInventaire());
            listView.setPrefSize(200, 200);
            return listView;
        }
        return null;
    }
**/
}
