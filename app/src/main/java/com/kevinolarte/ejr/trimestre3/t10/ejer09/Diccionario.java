package com.kevinolarte.ejr.trimestre3.t10.ejer09;

import java.util.HashMap;

import com.kevinolarte.lib.LibAnsi;
import com.kevinolarte.lib.LibRandom;

public class Diccionario implements IDiccionario{
    private final HashMap<String, String> diccionario;

    public Diccionario(){
        this.diccionario = new HashMap<>();
    }

    /**
     * Añade una nueva palabra en el diccionario, Se indexara usando un hashMap
     * donde la clave es la palabra y el valor es la definicion. Representando asi 
     * un diccionario de palabras.
     * @param palabra Clave de la indexacion al diccionario representando la palabra
     * @param definicion Valor de la indexacion al diccionario representando la definicion de la palabra
     * @throws IllegalArgumentException Si la palabra ya indexada en el diccionario
     */
    @Override
    public void addPalabra(String palabra, String definicion) throws IllegalArgumentException{
        if (!this.diccionario.containsKey(palabra)) {
            this.diccionario.put(palabra, definicion);
        } else 
            throw new IllegalArgumentException("La palabra ya existe en el diccionario");
            
        
    }

    /**
     * Eliminar la indexacion de una palabra en el diccionario mediante su clave 
     * que representa una de las palabras del diccionario   
     * @param palabra Clave de la indexacion al diccionario representando la palabra
     * @return Valor de la indexacion al diccionario representando la definicion de la palabra
     */
    @Override
    public String removePalabra(String palabra) {
        return this.diccionario.remove(palabra);
    }

    /**
     * Actualiza la definicion de una palabra en el diccionario mediante su clave 
     * que representa una de las palabras del diccionario   
     * @param palabra Clave de la indexacion al diccionario representando la palabra
     * @param definicion Valor de la indexacion al diccionario representando la definicion de la palabra\
     */
    @Override
    public void updatePalabra(String palabra, String definicion) throws IllegalArgumentException{
        if (!this.diccionario.containsKey(palabra)) {
            throw new IllegalArgumentException("La palabra no existe en el diccionario");
        }
        this.diccionario.put(palabra, definicion);
    }

    /**
     * Obtiene la definicion de una palabra en el diccionario mediante su clave 
     * que representa una de las palabras del diccionario   
     * @param palabra Clave de la indexacion al diccionario representando la palabra
     * @return Valor de la indexacion al diccionario representando la definicion de la palabra
     */
    @Override
    public String getDefinicion(String palabra) {
        return this.diccionario.get(palabra);
    }

    /**
     * Obtiene todas las palabras y definiciones indexadas en el diccionario 
     * @return Todas las palabras y definiciones indexadas en el diccionario
     */
    @Override
    public String getPalabrasDef() {
        StringBuilder sb = new StringBuilder();
        for (String palabra : this.diccionario.keySet()) {
            sb.append(LibAnsi.ANSI_BLUE).append(palabra).append(LibAnsi.ANSI_RESET).append(": ").append(this.diccionario.get(palabra)).append("\n\n");
        }
        return sb.toString();
    }

    /**
     * Obtiene una palabra aleatoria del diccionario
     * @return Palabra aleatoria del diccionario
     */
    @Override
    public String[] getPalabras() {
        String[] palabras = this.diccionario.keySet().toArray(new String[0]);
        return palabras;
    }
    
}
