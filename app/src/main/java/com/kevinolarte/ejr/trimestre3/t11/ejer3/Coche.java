package com.kevinolarte.ejr.trimestre3.t11.ejer3;

import java.util.Arrays;

public class Coche {
    private final String matricula;
    private int velocidad;
    private int marchaActual;
    private int[] numMarchas;

    public Coche(String matricula){
        this.matricula = matricula;
        this.velocidad = 0;
        this.marchaActual = 0;
        this.numMarchas = new int[]{0,10,20,30,40,50,200};
    }

    /**
     * Metodo para accelerar el veiluco incrementado la velocidad
     * @param velocidadAcelerar incremento que añadir a la velocidad.
     */
    public void acelerar(int velocidadAcelerar){
        if (velocidadAcelerar > 0 || velocidadAcelerar > this.velocidad) 
            this.velocidad = velocidadAcelerar;
    }

    /**
     * Metodo para frenar el vehiculo, deicrementar la velocidad
     * @param velocidadFrenar velocidad que se deincrementa.
     */
    public void frenar(int velocidadFrenar){
        if (velocidadFrenar > 0 && velocidadFrenar < this.velocidad) {
            this.velocidad = velocidadFrenar;
        }
    }

    /**
     * Metodo para cambiar la marcha del vehiculo 
     * @param numMarchas marcha a la que se cambia
     */
    protected void cambiarMarcha(int numMarchas){
        if (numMarchas > 0 && numMarchas > this.numMarchas.length-1) {
            this.marchaActual = numMarchas;
        }
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getMarchaActual() {
        return marchaActual;
    }

    public void setMarchaActual(int marchaActual) {
        this.marchaActual = marchaActual;
    }

    public int[] getNumMarchas() {
        return numMarchas;
    }

    public void setNumMarchas(int[] numMarchas) {
        this.numMarchas = numMarchas;
    }

    @Override
    public String toString() {
        return "Coche [matricula=" + matricula + ", velocidad=" + velocidad + ", marchaActual=" + marchaActual
                + ", numMarchas=" + Arrays.toString(numMarchas) + "]";
    }

        

    
}
