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

class Snickers extends Dulces {
    public Snickers(int numero) {
        super(numero);
    }

    public String comer() {
        return "sprite";
    }
}

class Super8 extends Dulces{
    public Super8(int numero) {
        super(numero);
    }

    public String comer() {
        return "cocacola";
    }
}
