package com.example.java_2024_fx;

import com.example.java_2024_fx.Controller.*;
import com.example.java_2024_fx.Model.Decor.ElementDecor;
import com.example.java_2024_fx.Model.Decor.Porte;
import com.example.java_2024_fx.Model.Items.Cle;
import com.example.java_2024_fx.Model.Items.Items;
import com.example.java_2024_fx.Model.Items.Potion;
import com.example.java_2024_fx.Model.Mondes.LesMondes;
import com.example.java_2024_fx.Model.Mondes.Monde;
import com.example.java_2024_fx.Model.Personnages.PJ;
import com.example.java_2024_fx.Presentation.DecorView.ElementDecorView;
import com.example.java_2024_fx.Presentation.DecorView.PorteView;
import com.example.java_2024_fx.Presentation.MondeView.MondeView;
import com.example.java_2024_fx.Presentation.PersonnageView.PjView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JeuView extends Application {

    Items cle = new Cle(12);
    Items potion = new Potion("Potion");

    PJ pj = new PJ("Andy");
    PjView pjView = new PjView();

    Monde monde = new Monde("Monde 1", Color.BEIGE);
    Monde monde2 = new Monde("Monde 2", Color.BLACK);

    MondeView mondeView = new MondeView(Color.BEIGE);
    MondeView mondeView2 = new MondeView(Color.BLACK);

    ElementDecor porte = new Porte(new Cle(12));
    ElementDecorView porteView = new PorteView(porte.getLongueur(), porte.getLargeur(), porte.getCouleur());

    LesMondes lesMondes = new LesMondes();



    /**
     * Initialiser Controllers
     */
    ControleMonde mondeController = new ControleMonde(monde, mondeView);

    ControleElementDecor porteController = new ControleElementDecor(porteView, porte);

    ControleInventaire controleInventaire = new ControleInventaire(pj.getInventaireString(),pjView.getInventaire());

    ControleListeMonde controleListeMonde = new ControleListeMonde(new ListView<>(), lesMondes);

    ControlePointVie controlePointVie = new ControlePointVie(pjView.getBarreDeVie(), pj.getPointVie());

    ControlePersonnage controlePersonnage = new ControlePersonnage(pjView.getShape(), pj, mondeView.getRoot());

    ControleZoneJeu controleZoneJeu = new ControleZoneJeu(mondeView.getRoot(), mondeController);


    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Game!");


        /**
         * ajouter les observateurs
         */
       // pj.addObserver(personnageController);
        porte.addObserver(porteController);
        pj.addObserver(controleInventaire);
        lesMondes.addObserver(controleListeMonde);
        pj.addObserver(controlePointVie);
        lesMondes.addObserver(controleZoneJeu);
        pj.addObserver(controlePersonnage);

        /**
         * Changer la position de l'element decor
         */
        porteController.setElementDecorPosition(205, 300);
        pj.setPointVie(45);

        pj.addItems(cle);
        pj.addItems(potion);

        lesMondes.addMondes(monde);
        lesMondes.addMondes(monde2);
        lesMondes.setIndexCourant(1);
        System.out.println("Le monde courant est : " + lesMondes.getMondeCourant().getNom());


        /**
         * panneau info personnage
         */
        FlowPane flowPane = new FlowPane();
        flowPane.setVgap(10);
        flowPane.setHgap(10);
        flowPane.setPrefWrapLength(100);
        //flowPane.getChildren().add(personnageController.afficherPseudo());
        flowPane.getChildren().add(controlePointVie.getLabel());


        BorderPane unite = new BorderPane();

        unite.setCenter(controleZoneJeu.getZoneJeu());
        System.out.println(controleZoneJeu.getMondeController().getMonde().getNom());
        unite.setTop(flowPane);
        unite.setRight(controleListeMonde.getListMonde());
        System.out.println(controleListeMonde.getListMonde().getItems());
        unite.setLeft(controleInventaire.getListView());
        System.out.println(controleInventaire.getListView().getItems());
        System.out.println(unite);

        disableArrowKeys(controleInventaire.getListView(), mondeView);
        disableArrowKeys(controleListeMonde.getListMonde(), mondeView);

        /**
         * ajouter les controllers dans le mondeController
         */
        mondeController.addPersonnage(controlePersonnage.getShape());
        mondeController.addElementDecor(porteController);




        Scene scene = new Scene(unite, 1000, 600);

        /**
         * controler le personnage
         */
       // personnageController.controler(mondeView.getRoot());
        mondeView.getRoot().setFocusTraversable(true);
        mondeView.getRoot().requestFocus();

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Désactive l'interaction avec les flèches du clavier pour un ListView
     * @param container
     * @param mondeView
     */
    private void disableArrowKeys(ListView<String> container, MondeView mondeView) {
        container.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN ||
                    event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {
                event.consume();  // Consomme l'événement pour éviter de perdre le focus
                mondeView.getRoot().requestFocus();  // Redonne le focus à la zone de jeu
            }
        });
    }


    public static void main(String[] args){ launch(args);}
}

//BorderPane@286adfe7
