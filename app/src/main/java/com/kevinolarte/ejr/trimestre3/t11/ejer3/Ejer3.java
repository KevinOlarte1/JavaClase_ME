package com.kevinolarte.ejr.trimestre3.t11.ejer3;

import com.kevinolarte.lib.LibInput;

public class Ejer3 {
    
    public Ejer3(){
        Coche vehiculo;
        String matricula = LibInput.pedirTexto("Dame la matricula del coche");
        String modo = LibInput.pedirTexto("El coche es automatico o manual -- (AUTOMATICO O MANUAL)");
        while (!modo.equals("AUTOMATICO") && !modo.equals("MANUAL")) {
            modo = LibInput.pedirTexto("Seleccione el moddo de coche (AUTOMATICO O MANUAL)");
        }
        if (modo.equals("AUTOMATICO")) {
            vehiculo = new CocheCambioAutomatico(matricula);
        }
        else{
            vehiculo = new CocheCambioManula(matricula); 
        }

        System.out.println(vehiculo.toString());
        vehiculo.acelerar(30);

        System.out.println(vehiculo.toString());
        vehiculo.frenar(10);
        System.out.println(vehiculo.toString());

    }       
}
