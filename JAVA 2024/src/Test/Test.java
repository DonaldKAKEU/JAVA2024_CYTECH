package Test;

import Personnages.PJ;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Test extends Application {

    PJ joueur = new PJ("Andy", new ArrayList<>());


    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();

        joueur.getFormeJoueur().relocate(150,100);
        root.getChildren().add(joueur.getFormeJoueur());

        stage.setTitle("Game");

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            // Obtenir le code de la touche pressée
            System.out.println("Code de la touche : " + event.getCode());
        });

        stage.setScene(scene);




        stage.show();
    }

    public static void main(String[] args){ launch(args);}
}
