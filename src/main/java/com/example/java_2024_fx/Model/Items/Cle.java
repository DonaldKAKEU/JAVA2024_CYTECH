package com.example.java_2024_fx.Model.Items;

import java.util.Objects;

public class Cle extends Items{

    private final int code;

    public Cle(int code){
        super("Cle");
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cle) {
            Cle cle = (Cle) o;
            return this.getCode() == cle.getCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
