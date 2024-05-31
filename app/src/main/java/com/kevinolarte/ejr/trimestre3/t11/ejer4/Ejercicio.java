package com.kevinolarte.ejr.trimestre3.t11.ejer4;

import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.units.qual.C;

import com.kevinolarte.lib.LibRandom;

import com.kevinolarte.ejr.trimestre3.t11.ejer4.Colores;

public class Ejercicio {
    private static final int SIZE_DEFAULT = 10;
    private List<Electrodomestico> list;

    public Ejercicio(){
        list = new ArrayList<>(SIZE_DEFAULT);
        rellenarObjetos();

        double precioTelevision = 0;
        double precioLavadora = 0;
        for (Electrodomestico electrodomestico : list) {
            if (electrodomestico instanceof Television) {
                precioTelevision += electrodomestico.precioFinal();
            } else {
                precioLavadora += electrodomestico.precioFinal();
            }
        }

        System.out.println("Precio total de las televisiones: " + precioTelevision);
        System.out.println("Precio total de las lavadoras: " + precioLavadora);
    }

    /**
     * Rellena la Lista con objtos rnd.
     */
    private void rellenarObjetos(){
        for (int i = 0; i < SIZE_DEFAULT; i++) {
            list.add(objetoRanom());
        }
    }

    /**
     * Metodo para generar un objeto heredada de Electrodomestico de forma aleatoria.
     * @return Electrodomestico
     */
    private Electrodomestico objetoRanom(){
        int rnd = LibRandom.randomInt(0, 2);
        char letra[] = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};

        if (rnd == 1) 
            return new Lavadora(LibRandom.randomDouble(100, 300),
                                Colores.values()[2].toString(), 
                                letra[LibRandom.randomInt(0, 5)], 
                                LibRandom.randomDouble(5, 50), 
                                LibRandom.randomDouble(5, 50));
        
        return new Television(LibRandom.randomDouble(100, 300),
                                Colores.values()[2].toString(), 
                                letra[LibRandom.randomInt(0, 5)], 
                                LibRandom.randomDouble(5, 50), 
                                LibRandom.randomInt(20, 50), 
                                LibRandom.randomBoolean());
    }
}
