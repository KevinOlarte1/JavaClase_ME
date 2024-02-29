package javaclase.con.kevinolarte.ejr.tema07_2.Hospital2;

import net.datafaker.Faker;
import javaclase.con.kevinolarte.ejr.tema07_2.Hospital2.lib.ColaPacientes;

public class Medico {
    private int cont = 0;
    private int secondCont = 0;
    private final String nombre;
    private ColaPacientes cola;
    
    public Medico( ){
        this.nombre = new Faker().name().firstName();
        this.cola = new ColaPacientes();
        
    }

    public String obtenerTiquet(){
        if (cola.isFull()) 
            return null;
        
        if (cont == 10) {
            cont = 0;
            secondCont++;
            if (secondCont == 10)
                secondCont = 0; 
        }

        String ingreso = String.valueOf(nombre.charAt(0) + String.valueOf(secondCont) + String.valueOf(cont++));
        cola.add(ingreso);
        return ingreso;
    }
    
    public boolean atenderPaciente( ){
        System.out.println(cola.remove());
        //TODO: metodo intermediario de ejercico y centro medico. Donde hara todo los procesos hasta dar el alta reutilizadno el codigo.
        return true;
    }


    public String getNombre() {
        return nombre;
    }


    public ColaPacientes getCola() {
        return cola;
    }

    

    



}
