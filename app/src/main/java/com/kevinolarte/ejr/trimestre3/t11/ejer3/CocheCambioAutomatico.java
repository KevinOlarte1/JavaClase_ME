package com.kevinolarte.ejr.trimestre3.t11.ejer3;

public class CocheCambioAutomatico extends Coche {

    public CocheCambioAutomatico(String matricula) {
        super(matricula);
        //TODO Auto-generated constructor stub
    }
    
    /**
     * Metodo para acelerar el choche de fomrma automatica
     */
    public void acelerar(int velocidadAcelerar){
        
        if (velocidadAcelerar > 0 || velocidadAcelerar < getVelocidad()) {
            for (int i = getNumMarchas().length-1; i > 0 ; i--) {
                if (velocidadAcelerar <= getNumMarchas()[i]) {
                    setVelocidad(velocidadAcelerar);
                    setMarchaActual(i);
                }
            }
        }
    }

    /**
     * Metodo para frenar el coche de forma automatica
     */
    public void frenar(int velocidadFrenar){
        if (velocidadFrenar > 0 || velocidadFrenar > getVelocidad()) {
            for (int i = getNumMarchas().length-1; i > 0 ; i--) {
                if (velocidadFrenar <= getNumMarchas()[i]) {
                    setVelocidad(velocidadFrenar);
                    setMarchaActual(i);
                }
            }
        }
    }
}
