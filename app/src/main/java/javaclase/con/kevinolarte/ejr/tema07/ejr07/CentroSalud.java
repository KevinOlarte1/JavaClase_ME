package javaclase.con.kevinolarte.ejr.tema07.ejr07;

import java.time.LocalDate;

public class CentroSalud {
    private static final int LIMIT_VALOR_DEFAULT = 40;
    private final Paciente pacientes[];
    private final Consultas pacientesTotal[];
    private int posActual;
    private int posActualTotal;

    public CentroSalud(int limit){
        this.pacientes = new Paciente[limit = limit < 1? LIMIT_VALOR_DEFAULT : limit];
        this.pacientesTotal = new Consultas[limit = limit < 1? (LIMIT_VALOR_DEFAULT * 30) : (limit *30)];
        this.posActual = 0;
        this.posActualTotal = 0;
    }


    /**
     * Metodo para hacer el chequeo al paciente.
     * @param sip sip del paciente
     * @param temperatura temperatura del paciente
     * @param pulsaciones pulsaciones del paciente
     * @param arteriaSis arteriasis del paciente
     * @param arteriaDia arteriadia del paciente
     * @return devuelve un booleano diciendo si ha sido posible.    
     */
    public boolean atenderPaciente(String sip, double temperatura, double pulsaciones, double arteriaSis, double arteriaDia){
        if (!validarSip(sip) || temperatura < 1 || pulsaciones < 1 || arteriaSis < 1 || arteriaDia < 1) return false;
    
        for (int i = 0; i < posActualTotal; i++) {
            if (pacientesTotal[i].getPaciente().getSip().equals(sip) && pacientesTotal[i].getConstantes()[0] == 0) {
                pacientesTotal[i].chequeo(temperatura, pulsaciones, arteriaSis, arteriaDia);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para realizar el alta del Paciente
     * @param sip sip del paciente
     * @param fecha fehca que se le dio el alta
     * @param motivo motivo del alta.
     * @return
     */
    public boolean darAltaPaciente(String sip, LocalDate fecha, String motivo){
        if(obtenerPacientesSip(sip)[obtenerPacientesSip(sip).length -1].getPaciente().getFecha().isAfter(fecha)) return false;

        for (int i = 0; i < posActualTotal; i++) {
            if (pacientesTotal[i].getPaciente().getSip().equals(sip) && pacientesTotal[i].isPoderAlta()) {
                pacientesTotal[i].darAlta(fecha, motivo);
                //Sacar ese pacente de nuestros pacientes diarios para que pueda entrar en espera otro paciente.
                for (int j = 0; j < posActual; j++) {
                    if (pacientes[j].getSip().equals(sip)) 
                    {
                        pacientes[j] = pacientes[posActual -1];
                        pacientes[posActual - 1] = null;
                    }
                        
                }
                return true;
            }
        }
        return false;

    }

    /**
     * Metodo para obtener nuevo paciente
     * @param sip sip del pacioente
     * @param nombre nombre del paciente
     * @param sexo sexo del paciente
     * @param edad edad del paciente
     * @param fehca fecha de entrada del paciente
     * @param sintomatologia sintomas que padece el paciente
     * @return devuelve un booleano si se ha podido realizar
     */
    public boolean nuevoPaciente(String sip, String nombre, boolean sexo,int edad, LocalDate fehca, /*String hora ,*/ String sintomas){
        if (!validarSip(sip) || edad < 0 || posActual == LIMIT_VALOR_DEFAULT) return false;
        if(obtenerPacientesSip(sip) != null){
            Consultas pacientehistoruco = obtenerPacientesSip(sip)[cantidadPacientesSip(sip) -1];
            if ( pacientehistoruco.getMotivo() == null) return false; 
    
        }
        pacientes[posActual++] = new Paciente(sip,nombre,sexo,edad,fehca);
        pacientesTotal[posActualTotal++] = new Consultas(new Paciente(pacientes[posActual-1]), sintomas);
        return true;
    }

    /**
     * Metodo para obtener la persona con un cierto sip.
     * @param sip sip que buscaremos
     * @return la persona, si no se encuentra se devuelve null.
     */
    public Consultas[] obtenerPacientesSip(String sip){ //? pacienets totalde al otra clase esperar
        if (!validarSip(sip) || cantidadPacientesSip(sip) == 0) return null;
        Consultas pacienterepetido[] = new Consultas[cantidadPacientesSip(sip)];
        
        int cont  =0;
        for (int i = 0; i < posActualTotal; i++) {
            if (pacientesTotal[i].getPaciente().getSip().equals(sip)) {
                pacienterepetido[cont++] = pacientesTotal[i]; //TODO: copia, cambiar luego
            }
        }
        
        return pacienterepetido;
    } 

    /**
     * Metodo para buscar en el historial todos los pacientes ingresado en una fecha hasta hoy
     * @param fecha fecha minima hasta hoy
     * @return devuelve los pacientes con todo.
     */
    public Consultas[] otenerPacientesFecha(LocalDate fecha){ //? pacienets totalde al otra clase esperar
        if (LocalDate.now().isBefore(fecha) == true || cantidadPacientesFecha(fecha, LocalDate.now()) < 1) return null;
        System.out.println("metodo no cumple bien");
        int cant = cantidadPacientesFecha(fecha, LocalDate.now());
        int cont = 0;
        
        Consultas pacientesFecha[] = new Consultas[cant];
        for (int i = 0; i < posActualTotal; i++) {
            if (fecha.isBefore(pacientesTotal[i].getPaciente().getFecha()) && LocalDate.now().isAfter(pacientesTotal[i].getPaciente().getFecha())) {
                pacientesFecha[cont++] = pacientesTotal[i]; //TODO: copia, cambiar luego
            }
        } 
        return pacientesFecha;
    }
    
    /**
     * Metodo para buscar en el historial todos los pacientes ingresado en un rango e fecha
     * @param fechaIni fecha de inicio
     * @param fechaFin fehcha de fin
     * @return devuelve un array con todas las coincidencias.
     */
    public Consultas[] otenerPacientesFecha(LocalDate fechaIni, LocalDate fechaFin){ //? pacienets totalde al otra clase esperar
        if (fechaFin.isBefore(fechaIni) || cantidadPacientesFecha(fechaIni, fechaFin) < 1) return null;
        int cant = cantidadPacientesFecha(fechaIni, LocalDate.now());
        int cont = 0;
        Consultas pacientesFecha[] = new Consultas[cant];
        for (int i = 0; i < posActualTotal; i++) {
            if (fechaIni.isBefore(pacientesTotal[i].getPaciente().getFecha()) && fechaFin.isAfter(pacientesTotal[i].getPaciente().getFecha())) {
                pacientesFecha[cont++] = pacientesTotal[i]; //TODO: copia, cambiar luego
            }
        } 
        return pacientesFecha;
    }
    /**
     * Metodo para mostar las estadisticas.
     * @return
     */
    public String estadisticas(){
        String p = " ";
        double temperaturaMedia = 0;
        double pulsacionesMedia = 0;
        double edadMedia = 0;
        double hombrePorcentaje = 0;
        double mujeresPorcentaje = 0;
        int cont = 0;
        for (int i = 0; i < posActualTotal; i++) {
            if (pacientesTotal[i].isPoderAlta()) {
                cont++;
                temperaturaMedia += pacientesTotal[i].getConstantes()[0];
                pulsacionesMedia += pacientesTotal[i].getConstantes()[1]; // The static method getPulsaciones() from the type Consultas should be accessed in a static wayJava(603979893)
                edadMedia += pacientesTotal[i].getPaciente().getEdad();
                hombrePorcentaje += pacientesTotal[i].getPaciente().isSexo() == true ? 1 : 0;
                mujeresPorcentaje += pacientesTotal[i].getPaciente().isSexo() == false ? 1 : 0;
            }
        }
        temperaturaMedia /= cont;
        pulsacionesMedia /= cont;
        edadMedia /= cont;
        hombrePorcentaje /= cont;
        mujeresPorcentaje /= cont;
        
        p = "Temperatura media: " + temperaturaMedia + "\nPulsaciones por minuto: " + pulsacionesMedia + 
            "\nEdad media: " + edadMedia + "\nPorcentaje de hombres: " + (hombrePorcentaje*100) + "%\nPorcentaje de mujeres :" + (mujeresPorcentaje*100) + "%";
        
            return p;
    }

    
    /**
     * Metodo para saber cunatos paceientes tenemos en cierta fecha
     * @param fechaInicio fehca de incio
     * @param fechaFinal  fecha de final
     * @return devuele la cantidad de cleintes
     */
    private int cantidadPacientesFecha(LocalDate fechaInicio, LocalDate fechaFinal){ //? pacienets totalde al otra clase esperar
        int cont = 0;
        for (int i = 0; i < posActualTotal; i++) {
            if (fechaInicio.isBefore(pacientesTotal[i].getPaciente().getFecha()) && fechaFinal.isAfter(pacientesTotal[i].getPaciente().getFecha())) {
               cont++;
            }
        }
        return cont;
    }
  
    /**
     * Meotodo para saber cuantas veces a sido atendido o esta siendo atendido
     * @param sip parametro por donde se busca
     * @return devuelve las veces que se ha encontrado
     */
    private int cantidadPacientesSip(String sip){ //? pacienets totalde al otra clase esperar
        int cont = 0;
        for (int i = 0; i < posActualTotal; i++) {
            if (pacientesTotal[i].getPaciente().getSip().equals(sip)) {
               cont++;
            }
        }
        return cont;
    }
    /**
     * Metodo para mostrar todos los pacientes del mes
     * @return devuelve un string con todos ellos
     */
    public String mostarHistorico(){
        if (posActualTotal == 0) return " ";
        String p = " ";
        for (int i = 0; i < posActualTotal; i++) {
            p += pacientesTotal[i].toString() + "\n";
        }
        return p;

    }
    /**
     * Metodo para validar si la sip es correcta
     * @param sip ingreso que se validara
     * @return booleano afirmando la correccion
     */
    private boolean validarSip(String sip){
        return sip.matches("\\d{8}");
    }


    /**
     * Metodo para sacar el ultimo paciente actual
     * @param sip
     * @return
     */
    public Consultas ultimoPacienteSip(String sip){
        if (cantidadPacientesSip(sip) == 0) return null;

        
        for (int i = posActualTotal -1; i >= 0; i--) {
            if (pacientesTotal[i].getPaciente().getSip().equals(sip)) {
                return pacientesTotal[i];
            }
        }
        return null;
    }

}
