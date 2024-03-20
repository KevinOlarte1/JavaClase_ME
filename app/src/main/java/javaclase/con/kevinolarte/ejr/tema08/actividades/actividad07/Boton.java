package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad07;

public class Boton {
    private final String texto;
    private final Elemento elemento;

    public Boton(String texto, Elemento elemento){
        this.texto = texto;
        this.elemento = elemento;
    }

    public String getTexto() {
        return texto;
    }

    public Elemento getElemento() {
        return elemento;
    }

    
}
