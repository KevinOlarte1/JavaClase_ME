package com.kevinolarte.ejr.trimestre3.t10.ejer07;

import com.kevinolarte.ejr.trimestre3.t10.ejer02.IEstadisticas;

public class Ejer07 {
    private final IConversion conversion;
    public Ejer07(Conversion estadisticas) {
        this.conversion = estadisticas;
        start();
    }
    public Ejer07() {
        this(new Conversion());
    }

    public void start(){
        conversion.addConversion(Moneda.USD, 1.069689f);
        conversion.addConversion(Moneda.GBP, 0.87295f);
        conversion.addConversion(Moneda.INR, 76.0f);
        conversion.addConversion(Moneda.AUD, 1.0f);
        conversion.addConversion(Moneda.CAD, 1.0f);
        conversion.addConversion(Moneda.ARS, 1.0f);
        conversion.addConversion(Moneda.BOB, 1.0f);
        conversion.addConversion(Moneda.CLP, 1.0f);
        conversion.addConversion(Moneda.VEZ, 1.0f);
        conversion.addConversion(Moneda.CRC, 1.0f);
        conversion.addConversion(Moneda.CUP, 1.0f);
        conversion.addConversion(Moneda.DOP, 1.0f);
        conversion.addConversion(Moneda.MXN, 1.0f);
        
        
        System.out.println(conversion.convertir(Moneda.USD, 100));
        System.out.println(conversion.convertir(Moneda.GBP, 100));
        System.out.println(conversion.convertir(Moneda.INR, 100));
        System.out.println(conversion.convertir(Moneda.AUD, 100));
        System.out.println(conversion.convertir(Moneda.CAD, 100));
        System.out.println(conversion.convertir(Moneda.ARS, 100));
        System.out.println(conversion.convertir(Moneda.BOB, 100));
        System.out.println(conversion.convertir(Moneda.CLP, 100));
        System.out.println(conversion.convertir(Moneda.VEZ, 100));
        System.out.println(conversion.convertir(Moneda.CRC, 100));
        System.out.println(conversion.convertir(Moneda.CUP, 100));
        System.out.println(conversion.convertir(Moneda.DOP, 100));
        System.out.println(conversion.convertir(Moneda.MXN, 100));
    }
}
