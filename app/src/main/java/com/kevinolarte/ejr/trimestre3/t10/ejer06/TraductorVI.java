package com.kevinolarte.ejr.trimestre3.t10.ejer06;

import java.util.HashMap;

public class TraductorVI implements ITraductor{
    private final  HashMap<String,String> has;

    public TraductorVI(){
        this.has = new HashMap<>();
    }

    public String colocar(String clave, String  valor){
        return has.put(clave, valor);
    }

    public String traducir(String clave){
        return has.get(clave) == null ? "La palabra no existe" : has.get(clave);
    }

    
}
