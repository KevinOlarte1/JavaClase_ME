package com.kevinolarte.ejr.trimestre3.t10.ejer10;

import org.checkerframework.common.returnsreceiver.qual.This;

public class Hijo {
    private static int COUNT_ID = 0;
    private final String id;

    private final String nombre;
    private final int edad;

    private Hijo(String id, String nombre, int edad){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Hijo(String nombre, int edad){
        this(String.valueOf(++COUNT_ID), nombre, edad);
    }

    public Hijo(Hijo hijo){
        this(hijo.id, hijo.nombre, hijo.edad);
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
        Hijo other = (Hijo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Hijo [nombre=" + nombre + ", edad=" + edad + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    

    
}
