package com.example.java_2024_fx.Model.Personnages;

import com.example.java_2024_fx.Model.Interfaces.Deplacer;

import java.util.Observable;

public class Position extends Observable implements Deplacer {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
        this.setChanged();
        this.notifyObservers();
    }

    public void setY(double y) {
        this.y = y;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public void seDeplacer(double dx, double dy) {
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);
        this.setChanged();
        this.notifyObservers();
    }
}
