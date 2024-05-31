package com.kevinolarte.ejr.trimestre3.t10.ejer11;

public class Aula {
    private static int countid = 0;

    private final String id;
    private final int metrosCuadrados;

    private  Aula( String id, int metrosCuadrados){
        this.id = id;
        this.metrosCuadrados = metrosCuadrados;
    }

    public Aula(int metrosCuadrados) {
        this("Aula" + countid++, metrosCuadrados);
    }
    
    public Aula(Aula aula) {
        this(aula.id, aula.metrosCuadrados);
    }

    public String getCodigo() {
        return id;
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
        Aula other = (Aula) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aula [id=" + id + ", metrosCuadrados=" + metrosCuadrados + "]";
    }

    
}
