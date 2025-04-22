package org.example;

class Expendedor {
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    private int precio;
    public static final int  COCA=1;
    public static final int  SPRITE=2;

    public Expendedor(int numBebidas, int precioBebidas){
        coca = new Deposito<Bebida>();
        sprite = new Deposito<Bebida>();
        monVu = new Deposito<Moneda>();
        precio = precioBebidas;

        Bebida stock;
        for (int i = 0; i < numBebidas; i++){
            stock = new CocaCola(100+i);
            coca.addCosa(stock);
        }
        for (int i = 0; i < numBebidas; i++){
            stock = new Sprite(200+i);
            sprite.addCosa(stock);
        }
    }

    public Bebida comprarBebida(Moneda m, int cual) {
        if (m == null) return null;
        int cambio= m.getValor() - precio;
        if (cambio<0) {
            monVu.addCosa(m);
            return null;
        }
        Bebida b=null;
        switch (cual) {
            case COCA:
                b = coca.getCosa();
                break;
            case SPRITE:
                b = sprite.getCosa();
                break;
            default:
                monVu.addCosa(m);
                return b;
        }

        if (b==null){
            monVu.addCosa(m);
            return null;
        }

        while (cambio >= 100) {
            monVu.addCosa(new Moneda100());
            cambio -= 100;
        }
        return b;
    }

    public Moneda getVuelto(){
        return monVu.getCosa();
    }

    public int getPrecio() {
        return precio;
    }
}
