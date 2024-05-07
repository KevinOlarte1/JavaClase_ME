package com.kevinolarte.ejr.trimestre3.t10.ejer11;

public class Profesor {
    private final String dni;
    private final String nombre;
    private final float salario;

    public Profesor(String dni, String nombre, float salario) {
        this.dni = dni;
        this.nombre = nombre;
        this.salario = salario;
    }

    public Profesor(Profesor profesor) {
        this(profesor.dni, profesor.nombre, profesor.salario);
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
        Profesor other = (Profesor) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
}
