package com.kevinolarte.ejr.trimestre3.t10.ejer07;

import java.util.HashMap;

public class Conversion implements IConversion {
    private final HashMap<Moneda, Float> conversor;

    public Conversion(){
        this.conversor = new HashMap<>();
    }

    public void addConversion(Moneda moneda, float valor){
        this.conversor.put(moneda, valor);
    }

    public float convertir(Moneda destino, float cantidad){
        return cantidad  * this.conversor.get(destino);
    } 
    
    
   



}


   
