package com.example.java_2024_fx.Controller;

import com.example.java_2024_fx.Model.Interfaces.Controlable;
import com.example.java_2024_fx.Model.Personnages.Personnage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.util.Observable;
import java.util.Observer;

public class ControlePersonnage implements Observer{


    private Shape shape;

    private Personnage personnage;

    private Pane pane;

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void setPersonnage(Personnage personnage) {
        this.personnage = personnage;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public ControlePersonnage(Shape shape, Personnage personnage, Pane pane){
        this.shape = shape;
        this.personnage = personnage;
        this.pane = pane;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Personnage){
            this.setPersonnage((Personnage)o);
            this.getShape().setLayoutX(personnage.getX());
            this.getShape().setLayoutY(personnage.getY());
        }

        this.getPane().setOnKeyPressed(new EventHandler<KeyEvent>() {

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

}
