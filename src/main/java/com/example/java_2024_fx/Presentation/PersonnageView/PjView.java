package com.example.java_2024_fx.Presentation.PersonnageView;

import com.example.java_2024_fx.Model.Interfaces.Deplacer;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;

public class PjView extends PersonnageView {


    /**
     * represente la barre de vie du personnage
     */
    private Label barreDeVie;

    /**
     * represente l'inventaire du personnage
     */
    private ListView<String> inventaire;


    public PjView() {
        super(new javafx.scene.shape.Circle(20, javafx.scene.paint.Color.BLUE));
        this.barreDeVie = new Label();
        this.inventaire = new ListView<>();
    }

    @Override
    public void Deplacer(double dx, double dy) {
        super.Deplacer(dx, dy);
    }

    public Label getBarreDeVie() {
        return this.barreDeVie;
    }

    public void setBarreDeVie(Label barreDeVie) {
        this.barreDeVie = barreDeVie;
    }

    public ListView<String> getInventaire() {
        return this.inventaire;
    }

    public void setInventaire(ListView<String> inventaire) {
        this.inventaire = inventaire;
    }
}
