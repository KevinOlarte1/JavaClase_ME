package com.kevinolarte.ejr.trimestre3.t10.ejer05;

import java.time.LocalDate;
import java.time.Period;

import com.kevinolarte.ejr.trimestre3.t10.ejer02.IEstadisticas;
import com.kevinolarte.ejr.trimestre3.t10.ejer05.enums.Genero;

public class Paciente {
    private static int count_id = 0;
    private final String id;
    private final String nombre;
    private final LocalDate fechaNacimiento;
    private final Genero genero;
    private final int alturaM;
    private final int pesoKg;

    private Paciente(String id, String nombre, LocalDate fechaNacimineto, Genero genero, int alturaM, int pesoKg){
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimineto;
        this.genero = genero;
        this.alturaM = alturaM;
        this.pesoKg = pesoKg;
    }
    public Paciente(String nombre, LocalDate fechaNacimineto, Genero genero, int alturaM, int pesoKg){
        this(String.valueOf(++count_id), nombre, fechaNacimineto, genero, alturaM, pesoKg);
    }
    public Paciente(Paciente p){
        this(p.getId(), p.getNombre(), p.getFechaNacimiento(), p.getGenero(), p.getAlturaM(), p.getPesoKg());
    }

    public int getEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public Genero getGenero() {
        return genero;
    }
    public int getAlturaM() {
        return alturaM;
    }
    public int getPesoKg() {
        return pesoKg;
    }
    
    

    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento +  "( " + getEdad()  + ")" + ", genero="
                + genero + ", alturaM=" + alturaM + ", pesoKg=" + pesoKg + "]";
    }
   
    

    
}
