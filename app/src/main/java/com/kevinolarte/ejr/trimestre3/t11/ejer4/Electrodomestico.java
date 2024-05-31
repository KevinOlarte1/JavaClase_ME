package com.kevinolarte.ejr.trimestre3.t11.ejer4;

import java.util.Arrays;

public abstract class Electrodomestico {
    
    private static final double PRECIO_DEFAULT = 100;
    private static final String COLOR_DEFAULT = Colores.BLANCO.toString();
    private static final char CONSUMO_ENERGETICO_DEFAULT = 'F';
    private static final double PESO_DEFAULT  = 5;

    private  double precioBase;
    private  String color;
    private  char consumoEnergetico;
    private  double peso;

    public Electrodomestico(){
        this(PRECIO_DEFAULT,COLOR_DEFAULT,CONSUMO_ENERGETICO_DEFAULT,PESO_DEFAULT);
    }
    public Electrodomestico(double precioBase, double peso){
        this(PRECIO_DEFAULT,COLOR_DEFAULT,CONSUMO_ENERGETICO_DEFAULT, peso);
    }

    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso){
        this.precioBase = precioBase;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
        comprobarConsumoEnergetico(consumoEnergetico);
        comprobarColor(color);

    }

    public double getPrecioBase() {
        return precioBase;
    }
    public String getColor() {
        return color;
    }
    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }
    public double getPeso() {
        return peso;
    }

    private void comprobarConsumoEnergetico(char c){
        //TODO: Cambiar a enum
        int letra = String.valueOf(c).toUpperCase().charAt(0);
        if (letra > 64 && letra < 71) 
            consumoEnergetico = (char)letra;
        else
            consumoEnergetico = CONSUMO_ENERGETICO_DEFAULT;
    }

    private void comprobarColor(String color){
        if (!Arrays.stream(Colores.values()).anyMatch(c -> c.name().equals(color))) {
            this.color = COLOR_DEFAULT;
        }

    }

    public double precioFinal(){
        double precio = precioBase;
        switch (consumoEnergetico) {
            case 'A':
                precio += 100;
                break;
            case 'B':
                precio += 80;
                break;
            case 'C':
                precio += 60;
                break;
            case 'D':
                precio += 50;
                break;
            case 'E':
                precio += 30;
                break;
            case 'F':
                precio += 10;
                break;
            default:
                break;
        }
        if (peso >= 0 && peso < 20) {
            precio += 10;
        } else if (peso < 50) {
            precio += 50;
        } else if ( peso < 80) {
            precio += 80;
        } else if (peso >= 80) {
            precio += 100;
        }
        return precio;
    }

    
}
