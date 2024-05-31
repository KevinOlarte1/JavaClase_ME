package com.kevinolarte.lib;

public class LibComprobante {
    /**
     * Metodo para comprobar si tiene algun caracter que no sea un numero.
     * @param palabra palabra a comprobar si tiene caracter
     * @return devuelve un booleano comprobando si tiene algun caracter.
     */
    public static boolean contieneCaracteres(String palabra){
        boolean verdad = palabra.matches("\\d+");
        return verdad;
    }

    /**
     * Metodo para verificar si es un numero entero, positivo o negativo
     * @param palabra palabra a comprobar si tiene caracter
     * @return devuelve un booleano comprobando si es un numero entero
     */
    public static boolean comprobarNumeroEntero(String palabra){
        boolean verdad = palabra.matches("-?\\d+");
        return verdad;
    }

    /**
     * Metodo para verificar si es una fecha o no.
     * @param palabra palabra que se comprobara
     * @return devuelve un booleano comprobando si es una fecha.
     */
    public static boolean comprobarFecha(String palabra){
        boolean verdad = palabra.matches("\\d{4}[/\\-:](0[1-9]|1[0-2])[/\\-:](0[1-9]|[12][0-9]|3[01])");
        //  
        
        return verdad;
    }

    /**
     * Metodo para verificar si es texto o no.
     * @param palabra palabra que se comprobara
     * @return devuelve un booleano comprobando si es texto.
     */
    public static boolean comprobarTexto(String palabra){
        boolean verdad = palabra.matches("[a-zA-Z]+");
        return verdad;
    }

    /**
     * Metodo para comprobar si el string es un numbero real positivo
     * @param palabra palabra a comprobar 
     * @return devuelve un booleano, comprobando si cumple la codición
     */
    public static boolean comprobarNumerRealPositivo(String palabra){
        boolean verdad = palabra.matches("\\d*.?\\d+");
        return verdad;
    }

    /**
     * Metodo para comprobar si el string es un numero positivo entero.
     * @param palabra numero a comprobar
     * @return devuelve un booleano, comprobando su cumple la condición
     */
    public static boolean comprobarNumeroPositivoEntero(String palabra){
        boolean verdad = palabra.matches("\\d+");
        return verdad;
    }

    /**
     * Metodo para comprobar si el string es un numero telefono
     * @param palabra telefono a comprobar
     * @return devuelve un booleano, comprobando si cumple la condición
     */
    public static boolean comprobarNumeroTelefono(String palabra){
        boolean verdad = palabra.matches("^(\\+34)?( )?(\\d{9}|\\d{3} \\d{3} \\d{3})");
        return verdad;

    }
}
