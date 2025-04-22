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

class Sprite extends Bebida{
    public Sprite(int numero) {
        super(numero);
    }

    public String beber() {
        return "sprite";
    }
}

class CocaCola extends Bebida{
    public CocaCola(int numero) {
        super(numero);
    }

    public String beber() {
        return "cocacola";
    }
}
