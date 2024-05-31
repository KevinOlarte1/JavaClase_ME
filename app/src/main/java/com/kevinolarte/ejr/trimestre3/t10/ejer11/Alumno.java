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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Alumno [id=" + id + ", nombre=" + nombre + ", grupo=" + grupo + ", asignaturas=" + asignaturas + "]";
    }

    
}
