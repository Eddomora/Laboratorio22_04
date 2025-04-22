package org.example;
import java.util.ArrayList;


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

abstract class Moneda{
    public Moneda(){
    }

    public Moneda getSerie() {
        Moneda m = this;
        return m;
    }

    public abstract int getValor();
}

class Moneda1500 extends Moneda{

    public Moneda1500(){
        super();
    }

    public int getValor() {
        return 1500;
    }


}

class Moneda1000 extends Moneda{

    public Moneda1000(){
        super();
    }

    public int getValor() {
        return 1000;
    }

}

class Moneda500 extends Moneda{
    public Moneda500(){
        super();
    }

    public int getValor() {
        return 500;
    }

}

class Moneda100 extends Moneda{
    public Moneda100(){
        super();
    }

    public int getValor() {
        return 100;
    }
}

class Comprador{
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        sonido = null;
        vuelto = 0;

        if (m==null) return;

        Bebida b = exp.comprarBebida(m,cualBebida);
        if (b!=null){
            sonido = b.beber();
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

class Deposito<T>{
    private ArrayList<T> dep;

    public Deposito(){
        dep = new ArrayList<T>();
    }

    public void addCosa(T cosa){
        dep.add(cosa);
    }

    public T getCosa() {
        if (dep.size() == 0) {
            return null;
        }
        return dep.remove(0);
    }

    public int size(){
        return dep.size();
    }
}

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

public class Main{
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(3,300);
        Moneda m = null;
        Comprador c=null;
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());
        m = new Moneda1000();
        c = new Comprador(m,Expendedor.COCA,exp);
        System.out.println(c.queBebiste()+", "+c.cuantoVuelto());

    }
}