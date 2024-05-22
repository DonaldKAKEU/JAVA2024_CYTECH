package com.example.java_2024_fx.Controller;

import com.example.java_2024_fx.Model.Decor.ElementDecor;
import com.example.java_2024_fx.Model.Decor.Porte;
import com.example.java_2024_fx.Model.Personnages.PJ;
import com.example.java_2024_fx.Presentation.DecorView.ElementDecorView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.Observable;
import java.util.Observer;

public class ControleElementDecor implements Observer, ChangeListener{

    private ElementDecorView elementDecorView;
    private ElementDecor elementDecor;

    public ControleElementDecor(ElementDecorView elementDecorView, ElementDecor elementDecor) {
        this.elementDecorView = elementDecorView;
        this.elementDecor = elementDecor;
    }

    public ElementDecorView getElementDecorView() {
        return elementDecorView;
    }

    public void setElementDecorView(ElementDecorView elementDecorView) {
        this.elementDecorView = elementDecorView;
    }

    public ElementDecor getElementDecor() {
        return elementDecor;
    }

    public void setElementDecor(ElementDecor elementDecor) {
        this.elementDecor = elementDecor;
    }

    public void Deplacer(double dx, double dy) {
        this.elementDecorView.Deplacer(dx, dy);
    }

    public void setElementDecorPosition(double x, double y) {
        this.elementDecor.setPos(x, y);
    }

    public boolean ouvrirUnePorte(PJ pj) {
        if (this.elementDecor instanceof Porte) {
            Porte porte = (Porte) this.elementDecor;
                porte.action();
                return true;
        }
        return false;
    }

        @Override
        public void update(Observable o, Object arg) {

            if (o instanceof ElementDecor) {
                this.setElementDecor((ElementDecor) o);
                this.getElementDecorView().Deplacer(elementDecor.getX(), elementDecor.getY());
                System.out.println("ElementDecorController update");
            }
        }

        @Override
        public void changed(ObservableValue observableValue, Object o, Object t1) {

        }

}
