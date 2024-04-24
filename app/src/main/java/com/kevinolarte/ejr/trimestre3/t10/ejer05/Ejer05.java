package com.kevinolarte.ejr.trimestre3.t10.ejer05;

public class Ejer05 {
    public Ejer05(){
        Centro c = new Centro(20, 15);
        System.out.println("asd");
        Paciente[] pacientes = c.getPacientes();
        System.out.println(c.mensajeMasaCorporal(pacientes));
    }
}
