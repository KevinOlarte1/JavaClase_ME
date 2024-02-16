package javaclase.con.kevinolarte.ejr.tema07.ejr07;

import java.time.LocalDate;
import java.util.Arrays;

public class Consultas {
    private static final int TEMPERATURA = 0;
    private static final int PULSACIONES = 1;
    private static final int ARTERIA_SISTOLICA  =2;
    private static final int ARTERIA_DIASTOLICA = 3;

    private final Paciente paciente;
    private final String simtomas;

    private double constantes[] = new double[4];

    private boolean poderalta = false;
    private LocalDate fechaAlta;  
    private String motivo;

    
    public Consultas(Paciente paciente, String sintomas){
        this.paciente = paciente;
        this.simtomas = sintomas;
    }

    public void chequeo(double temperatura, double pulsaciones,double arteriaSis, double arteriaDia){
        if (temperatura >= 1 && pulsaciones >= 1 && arteriaDia >= 1 && arteriaSis >= 1) {
            this.constantes[TEMPERATURA] = temperatura;
            this.constantes[PULSACIONES] = pulsaciones;
            this.constantes[ARTERIA_SISTOLICA] = arteriaSis;
            this.constantes[ARTERIA_DIASTOLICA] = arteriaDia;
            this.poderalta = true;
        }
       
        
    }

    /**
     * Metodo para dar el alta al paciente
     * @param fecha fecha del alta
     * @param motivo motivo del alta
     * @return devuelv un booleano true si se ha podido hacer
     */
    public void darAlta(LocalDate fecha,String motivo){
        if(LocalDate.now().isBefore(fecha)){
            this.fechaAlta = fecha;
            this.motivo= motivo;
            this.poderalta = false;
        }
    }

    //#region Getters
    public Paciente getPaciente() {
        return paciente;
    }

    public boolean isPoderAlta() {
        return poderalta;
    }
    
    public String getSimtomas() {
        return simtomas;
    }
    
    public double[] getConstantes() {
        return constantes;
    }

    public static int getTemperatura() {
        return TEMPERATURA;
    }

    public static int getPulsaciones() {
        return PULSACIONES;
    }

    public static int getArteriaSistolica() {
        return ARTERIA_SISTOLICA;
    }

    public static int getArteriaDiastolica() {
        return ARTERIA_DIASTOLICA;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public String getMotivo() {
        return motivo;
    }
     //#endregion Getters



    @Override
    public String toString() {
        return "Consultas [paciente=" + paciente.toString() + ", simtomas=" + simtomas + ", constantes="
                + Arrays.toString(constantes) + ", fechaAlta=" + fechaAlta + ", motivo=" + motivo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
        result = prime * result + ((simtomas == null) ? 0 : simtomas.hashCode());
        result = prime * result + Arrays.hashCode(constantes);
        result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
        result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
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
        Consultas other = (Consultas) obj;
        if (paciente == null) {
            if (other.paciente != null)
                return false;
        } else if (!paciente.equals(other.paciente))
            return false;
        if (simtomas == null) {
            if (other.simtomas != null)
                return false;
        } else if (!simtomas.equals(other.simtomas))
            return false;
        if (!Arrays.equals(constantes, other.constantes))
            return false;
        if (fechaAlta == null) {
            if (other.fechaAlta != null)
                return false;
        } else if (!fechaAlta.equals(other.fechaAlta))
            return false;
        if (motivo == null) {
            if (other.motivo != null)
                return false;
        } else if (!motivo.equals(other.motivo))
            return false;
        return true;
    }

    

    
   


    

}
