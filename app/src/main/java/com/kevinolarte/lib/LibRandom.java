package com.kevinolarte.lib;

import java.util.Random;

public class LibRandom {
    public static Random rnd = new Random();

    /**
     * Genera un numero aleatorio entre int min y int max
     * @param min valro minimo
     * @param max valor maximo
     * @return devuelve un numero aleatorio entre min y max
     */
    public static int randomInt(int min, int max) {
        return rnd.nextInt(min, max);
    }

    /**
     * Genera un numero aleatorio entre double min y double max
     * @param min valro minimo
     * @param max valor maximo
     * @return devuelve un numero aleatorio entre min y max
     */
    public static double randomDouble(double min, double max) {
        return rnd.nextDouble(min, max);
    }

    /**
     * Genera un numero aleatorio entre float min y float max
     * @param min valro minimo
     * @param max valor maximo
     * @return devuelve un numero aleatorio entre min y max
     */
    public static float randomFloat(float min, float max) {
        return rnd.nextFloat(min, max);
    }

    /**
     * Genera un numero aleatorio entre long min y long max
     * @param min valro minimo
     * @param max valor maximo
     * @return devuelve un numero aleatorio entre min y max
     */

    public static long randomLong(long min, long max) {
        return rnd.nextLong(min, max);
    }




}
