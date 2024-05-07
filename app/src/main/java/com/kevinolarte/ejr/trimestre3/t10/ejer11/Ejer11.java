package com.kevinolarte.ejr.trimestre3.t10.ejer11;

public class Ejer11 {
    
    private final Centro centro;

    public Ejer11(Centro centro) {
        this.centro = centro;
        start();
    }

    public void start() {
        System.out.println(centro.mostrarAlunmosPorPorfesor());
    }


}
