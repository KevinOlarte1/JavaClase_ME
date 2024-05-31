package com.kevinolarte.ejr.trimestre3.t11.ejer3;

public class CocheCambioManula extends Coche {

    public CocheCambioManula(String matricula) {
        super(matricula);
        //TODO Auto-generated constructor stub
    }

    public void cambiarMarcha(int marchaCambiar){
        if(marchaCambiar > 0){
            setMarchaActual(marchaCambiar);
        }
    }
    
}
