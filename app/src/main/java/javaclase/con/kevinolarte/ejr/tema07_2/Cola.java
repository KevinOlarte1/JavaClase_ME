package javaclase.con.kevinolarte.ejr.tema07_2;

import java.util.ArrayList;

public class Cola {
    ArrayList<Integer> cola = new ArrayList<>();

    public int size(){
        return cola.size();
    }

    public boolean add(int value){
        return cola.add(value);

    }

    public int remove(){
        if (cola.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return cola.remove(0);
    }

    public int peek(){
        if (cola.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return cola.get(0);
    }

    @Override
    public String toString() {
        return "Cola [cola=" + cola + "]";
    }
    
}
