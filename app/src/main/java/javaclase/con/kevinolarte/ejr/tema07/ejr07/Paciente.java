package javaclase.con.kevinolarte.ejr.tema07.ejr07;

import java.time.LocalDate;

public class Paciente {

    private final String sip;
    private final String nombre;
    private final boolean sexo;
    private final int edad;
    private final LocalDate fecha;
    //private final String hora;

    public Paciente(String sip,String nombre, boolean sexo, int edad, LocalDate fecha /*String hora*/){
        this.sip = sip;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.fecha = fecha;
        //this.hora = hora;
    }

    public Paciente(Paciente p){
        this(p.getSip(), p.getNombre(), p.isSexo(), p.getEdad(), p.getFecha()/* , p.getHora()*/);
    }

    //#region Getters
    public String getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    //#endregion Getters

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sip == null) ? 0 : sip.hashCode());
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
        Paciente other = (Paciente) obj;
        if (sip == null) {
            if (other.sip != null)
                return false;
        } else if (!sip.equals(other.sip))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Paciente [sip=" + sip + ", nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + ", fecha=" + fecha
                + "]";
    }

   
   
   
   
   
    /* 

    public String getHora() {
        return hora;
    }
    */
    

    


















    

}
