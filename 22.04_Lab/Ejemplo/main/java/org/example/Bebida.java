package org.example;

abstract class Bebida{
    private int serie;

    public Bebida(int numero){
        serie = numero;
    }

    public int getSerie() {
        return serie;
    }

    public abstract String beber();
}