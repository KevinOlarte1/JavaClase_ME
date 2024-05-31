package com.kevinolarte.ejr.trimestre3.t10.ejer11;

public class Grupo {
    private final String codigo;
    private final String nombre;
    private final Aula aula;

    public Grupo(String codigo, String nombre, Aula aula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.aula = aula;
    }

    public Grupo(Grupo grupo) {
        this(grupo.codigo, grupo.nombre, grupo.aula);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        Grupo other = (Grupo) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Grupo [codigo=" + codigo + ", nombre=" + nombre + ", aula=" + aula + "]";
    }

    
}
