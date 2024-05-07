package com.kevinolarte.ejr.trimestre3.t10.ejer11;

public class Asignatura {
    
    private final String codigo;
    private final String nombre;
    private final Profesor profesor;

    public Asignatura(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public Asignatura(Asignatura asignatura) {
        this(asignatura.codigo, asignatura.nombre, asignatura.profesor);
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }
}
