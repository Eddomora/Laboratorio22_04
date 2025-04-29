package org.example;

abstract class Producto {
        private int serie;

        public Producto(int numero){
            serie = numero;
        }

        public int getSerie() {
            return serie;
        }

        public abstract String accion();
}
