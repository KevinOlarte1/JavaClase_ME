package com.kevinolarte.lib;

public class LibAnsi {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    //TODO: Implementar metodos para cambiar el color de la consola.

    /**
     * Metodo para limpiar la consola.
     */
    public static void limpiar() {
        System.out.print("\033[H\033[2J");
    }
}
