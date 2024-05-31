package com.kevinolarte.ejr.trimestre3.t10.ejer09;

public interface IDiccionario{


    
    void addPalabra(String palabra, String definicion)throws IllegalArgumentException;

    
    String removePalabra(String palabra);

    void updatePalabra(String palabra, String definicion) throws IllegalArgumentException;

    String getDefinicion(String palabra);

    String getPalabrasDef();

    String[] getPalabras();

}
