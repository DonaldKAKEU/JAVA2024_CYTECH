package com.example.java_2024_fx.Controller;

import com.example.java_2024_fx.Model.Personnages.PJ;
import com.example.java_2024_fx.Model.Personnages.Personnage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.Observable;
import java.util.Observer;

public class ControleInventaire implements Observer,  ChangeListener<String>{

  private ObservableList<String> inventaire;
  private ListView<String> listView;

  public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public ObservableList<String> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ObservableList<String> inventaire) {
        this.inventaire = inventaire;
  }

    public ControleInventaire(ObservableList<String> inventaire, ListView<String> listView){
        this.inventaire = inventaire;
        this.listView = listView;
        this.initialize();
    }

    private void initialize() {
        this.getListView().setItems(this.getInventaire());
    }

    @Override
    public void update(Observable o, Object arg) {
        //this.listView.setItems(this.inventaire);

        if (o instanceof Personnage) {
            Personnage pj = (Personnage) o;
            this.getListView().setItems(pj.getInventaireString());
        }
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

    }
}
