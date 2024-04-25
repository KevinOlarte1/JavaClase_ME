package com.kevinolarte.ejr.trimestre3.t10.ejer07;

public interface IConversion {
    void addConversion(Moneda moneda, float valor);
    float convertir(Moneda destino, float cantidad);
    
} 
