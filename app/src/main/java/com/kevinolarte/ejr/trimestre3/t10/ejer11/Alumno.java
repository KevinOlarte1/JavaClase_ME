package com.kevinolarte.ejr.trimestre3.t10.ejer11;

import java.util.List;

public class Alumno {
    private static int countid = 0;

    private final String id;
    private final String nombre;
    private final Grupo grupo;
    private final List<Asignatura> asignaturas;

    private Alumno(String id, String nombre, Grupo grupo, List <Asignatura> asignaturas) {
        this.id = id;
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignaturas = asignaturas;
    }

    public Alumno(String nombre, Grupo grupo, List <Asignatura> asignaturas) {
        this("Alumno" + countid++, nombre, grupo, asignaturas);
    }

    public Alumno(Alumno alumno) {
        this(alumno.id, alumno.nombre, alumno.grupo, alumno.asignaturas);
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    public Grupo getGrupo() {
        return grupo;
    }
}
