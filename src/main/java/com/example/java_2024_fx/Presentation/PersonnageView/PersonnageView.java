package com.example.java_2024_fx.Presentation.PersonnageView;

import com.example.java_2024_fx.Model.Interfaces.Deplacer;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.shape.Shape;

public abstract class PersonnageView{

    /**
     * forme du personnage
     */
    private Shape shape;

    /**
     * constructeur
     * @param shape
     */
    public PersonnageView(Shape shape){
        this.shape = shape;
    }


    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void Deplacer(double dx, double dy) {
        this.getShape().setLayoutX(this.getShape().getLayoutX() + dx);
        this.getShape().setLayoutY(this.getShape().getLayoutY() + dy);
    }

}
