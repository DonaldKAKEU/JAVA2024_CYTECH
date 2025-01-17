package com.example.demo
import Controller.Dao;
import Controller.CenterAdministratorControler
import Controller.PersonInNeedController;
import groovy.transform.CompileStatic
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

@CompileStatic
class HelloApplication extends Application {
    @Override
    void start(Stage stage) {
        def fxmlLoader = new FXMLLoader(getClass().getResource("dashboard.fxml"))
        def scene = new Scene(fxmlLoader.load() as Parent, 1100, 600)
        stage.setTitle("Hello!")
        stage.setScene(scene)
        stage.show()
    }



    static void main(String[] args) {
        launch(HelloApplication)
    }
}