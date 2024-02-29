package javaclase.con.kevinolarte.ejr.tema07_2.Hospital2.lib;

import java.util.Arrays;

import javaclase.con.kevinolarte.ejr.tema07_2.Hospital2.Medico;

public class ColaMedico {
    private static final int MAX_VALUE_DEFAULT = 5;
    private final Medico cola[];
    private int head;
    private int tail;
    private int cont;
    private int max;

    public ColaMedico(int max){
        this.cola = new Medico[max];
        this.head = 0;
        this.tail = 0;
        this.cont = 0;
        this.max = max;
    }
    
    public ColaMedico(){
        this(MAX_VALUE_DEFAULT);
    }

    /**
     * Añadir valores a la cola
     * @param num valor añadido
     * @return
     */
    public boolean add(Medico num){
        if (isFull())
            return false;
        cola[head] = num;
        if(head == max -1)
            head = 0;
        else
            head++;
        cont++;
        
        return true;
    }
    
    /**
     * Sacar el ultimo de la cola
     * @return el ultimo valor.
     */
    public Medico remove(){
        if(isEmpty())
            return null;
        
        Medico num = cola[tail]; 
        cola[tail] = null;
        cont--;
        if(tail == max - 1)
            tail = 0;
        else 
            tail++;
        return num;
    }

    

    public boolean isFull(){
        return cont == max;
    }

    public boolean isEmpty(){
        return cont == 0;
    }

    @Override
    public String toString() {
        return "ColaCirucular [cola=" + Arrays.toString(cola) + ", head=" + head + ", tail=" + tail + "]";
    }
    
    
}
