package org.example;

abstract class Dulces {
    private int serie;

    public Dulces(int numero){
        serie = numero;
    }

    public int getSerie() {
        return serie;
    }

    public abstract String comer();
}