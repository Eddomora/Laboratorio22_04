package org.example;

public enum Precios {
    COCACOLA(1500),
    SPRITE(1000),
    FANTA(1100),
    SUPER8(2000),
    SNICKERS(2500);
    private final int precio;
    Precios(int precio) {
        this.precio = precio;
    }
    public int getPrecio() {
        return precio;
    }
}
