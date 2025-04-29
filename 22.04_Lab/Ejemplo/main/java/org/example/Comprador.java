package org.example;

class Comprador{
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        sonido = null;
        vuelto = 0;

        if (m==null) return;

        Producto b = exp.comprarBebida(m,cualBebida);
        if (b!=null){
            sonido = b.accion();
            Moneda monedaVuelto;
            while ((monedaVuelto = exp.getVuelto()) != null) {
                vuelto += monedaVuelto.getValor();
            }
        } else {
            Moneda monedaVuelto;
            while ((monedaVuelto = exp.getVuelto()) != null) {
                vuelto += monedaVuelto.getValor();
            }
        }

    }
    public int cuantoVuelto(){
        return vuelto;
    }

    public String queBebiste(){
        return sonido;
    }
}
