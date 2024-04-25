package com.kevinolarte.ejr.trimestre3.t10.ejer08;

import java.util.HashMap;

import com.kevinolarte.lib.LibAnsi;

public class Diccionario implements IDiccionario{
    private final HashMap<String, String> diccionario;

    public Diccionario(){
        this.diccionario = new HashMap<>();
    }

    @Override
    public void addPalabra(String palabra, String definicion) throws IllegalArgumentException{
        if (!this.diccionario.containsKey(palabra)) {
            this.diccionario.put(palabra, definicion);
        } else 
            throw new IllegalArgumentException("La palabra ya existe en el diccionario");
            
        
    }
    @Override
    public String removePalabra(String palabra) {
        return this.diccionario.remove(palabra);
    }

    @Override
    public void updatePalabra(String palabra, String definicion) throws IllegalArgumentException{
        if (!this.diccionario.containsKey(palabra)) {
            throw new IllegalArgumentException("La palabra no existe en el diccionario");
        }
        this.diccionario.put(palabra, definicion);
    }

    @Override
    public String getDefinicion(String palabra) {
        return this.diccionario.get(palabra);
    }

    @Override
    public String getPalabras() {
        StringBuilder sb = new StringBuilder();
        for (String palabra : this.diccionario.keySet()) {
            sb.append(LibAnsi.ANSI_BLUE).append(palabra).append(LibAnsi.ANSI_RESET).append(": ").append(this.diccionario.get(palabra)).append("\n\n");
        }
        return sb.toString();
    }
    
}
