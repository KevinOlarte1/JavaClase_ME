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
}
