package org.example;

import java.util.ArrayList;

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