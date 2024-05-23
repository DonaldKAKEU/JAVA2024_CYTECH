package com.example.demo3.control;

import com.example.demo3.Album;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Observer;

public class controlPhotoCentre  implements Observer {

    private ImageView imageView;
    private Album album;

    public controlPhotoCentre(ImageView imageView, Album album){
        this.album = album;
        this.imageView = imageView;

    }

    @Override
    public void update(Observable o, Object arg) {
        Integer i =(Integer)arg;

    }
}
