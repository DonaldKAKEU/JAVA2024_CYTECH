package com.example.java_2024_fx.Presentation.PersonnageView;

import com.example.java_2024_fx.Model.Interfaces.Deplacer;
import javafx.scene.shape.Rectangle;

public class MonstreView extends PersonnageView{


    public MonstreView() {
        super(new Rectangle(20, 20, javafx.scene.paint.Color.RED));
    }
    @Override
    public void Deplacer(double dx, double dy) {
       super.Deplacer(dx, dy);
    }
}
