package com.kevinolarte.ejr.trimestre3.t10.ejer08;

public interface IDiccionario{

    /**
     * Añade una nueva palabra en el diccionario, Se indexara usando un hashMap
     * donde la clave es la palabra y el valor es la definicion. Representando asi 
     * un diccionario de palabras.
     * @param palabra Clave de la indexacion al diccionario representando la palabra
     * @param definicion Valor de la indexacion al diccionario representando la definicion de la palabra
     * @throws IllegalArgumentException Si la palabra ya indexada en el diccionario
     */
    void addPalabra(String palabra, String definicion)throws IllegalArgumentException;

    /**
     * Eliminar la indexacion de una palabra en el diccionario mediante su clave 
     * que representa una de las palabras del diccionario   
     * @param palabra Clave de la indexacion al diccionario representando la palabra
     * @return Valor de la indexacion al diccionario representando la definicion de la palabra
     */
    String removePalabra(String palabra);

    /**
     * Actualiza la definicion de una palabra en el diccionario mediante su clave 
     * que representa una de las palabras del diccionario   
     * @param palabra Clave de la indexacion al diccionario representando la palabra
     * @param definicion Valor de la indexacion al diccionario representando la definicion de la palabra\
     */
    void updatePalabra(String palabra, String definicion) throws IllegalArgumentException;

    /**
     * Obtiene la definicion de una palabra en el diccionario mediante su clave 
     * que representa una de las palabras del diccionario   
     * @param palabra Clave de la indexacion al diccionario representando la palabra
     * @return Valor de la indexacion al diccionario representando la definicion de la palabra
     */
    String getDefinicion(String palabra);

    /**
     * Obtiene todas las palabras y definiciones indexadas en el diccionario 
     * @return Todas las palabras y definiciones indexadas en el diccionario
     */
    String getPalabras();

}
