package com.example.java_2024_fx.Controller;

import com.example.java_2024_fx.Model.Mondes.LesMondes;
import com.example.java_2024_fx.Presentation.MondeView.MondeView;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ControleListeMonde extends Observable implements Observer {

    private ListView<String> listMonde;
    private LesMondes lesMondes;

    public ListView<String> getListMonde() {
        return listMonde;
    }

    public void setListMonde(ListView<String> listMonde) {
        this.listMonde = listMonde;
    }

    public LesMondes getLesMondes() {
        return lesMondes;
    }

    public void setLesMondes(LesMondes lesMondes) {
        this.lesMondes = lesMondes;
        this.setChanged();
        this.notifyObservers();
    }

    public ControleListeMonde(ListView<String> listMonde, LesMondes lesMondes) {
        this.listMonde = listMonde;
        this.lesMondes = lesMondes;
        this.initialize();
    }

    private void initialize(){
        this.listMonde.setItems(this.lesMondes.getLesMondesString());
        this.setChanged();
        this.notifyObservers();
        //this.setLesMondes(this.lesMondes);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof LesMondes){
            LesMondes mondes = (LesMondes) o;
            this.getListMonde().setItems(mondes.getLesMondesString());
        }
    }
}
