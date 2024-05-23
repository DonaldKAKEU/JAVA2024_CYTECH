package com.example.java_2024_fx.Model.Interfaces;

import com.example.java_2024_fx.Model.Exceptions.BadCleException;
import com.example.java_2024_fx.Model.Items.Cle;
import com.example.java_2024_fx.Model.Items.Items;

public interface Traversable {

    /**
     * agit sur l'objet en fonction de l'item dans le but de le traverser
     * @param items
     * @throws BadCleException
     */
    public void action(Items items) throws BadCleException;

    /**
     * agit sur l'objet sans item dans le but de le traverser
     */
    public void action();
}
