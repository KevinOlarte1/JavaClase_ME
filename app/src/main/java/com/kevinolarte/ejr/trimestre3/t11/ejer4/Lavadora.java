package com.kevinolarte.ejr.trimestre3.t11.ejer4;

import org.checkerframework.checker.units.qual.s;

public class Lavadora extends Electrodomestico{
    private static final double CARGA_DEFAULT = 5;

    private double carga;

    public Lavadora(){
        super();
        this.carga = CARGA_DEFAULT;
    }

    public Lavadora(double precio, double peso){
        super(precio, peso);
        this.carga = CARGA_DEFAULT;
    }

    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga){
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    @Override
    public double precioFinal(){
        double precio = super.precioFinal();
        if (carga > 30){
            precio += 50;
        }
        return precio;
    }


}
