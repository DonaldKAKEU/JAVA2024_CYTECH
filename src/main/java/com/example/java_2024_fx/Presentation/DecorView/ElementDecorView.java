package com.example.java_2024_fx.Presentation.DecorView;

import javafx.scene.shape.Shape;

public abstract class ElementDecorView {

    private Shape shape;

    public ElementDecorView(Shape shape){
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * pour déplacer un élément visuellement
     * @param dx
     * @param dy
     */
    public void Deplacer(double dx, double dy) {
        this.getShape().setLayoutX(this.getShape().getLayoutX() + dx);
        this.getShape().setLayoutY(this.getShape().getLayoutY() + dy);
    }

}
