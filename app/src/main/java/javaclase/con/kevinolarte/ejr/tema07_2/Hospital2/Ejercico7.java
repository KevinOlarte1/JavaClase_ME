package javaclase.con.kevinolarte.ejr.tema07_2.Hospital2;



import javaclase.con.kevinolarte.ejr.tema07_2.Hospital2.lib.Ansi;
import javaclase.con.kevinolarte.ejr.tema07_2.Hospital2.lib.Lib;
import javaclase.con.kevinolarte.lib.Input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ejercico7 {
    public static final int MAX_PACIENTES = 500;
    public static final int MAX_REGISTROS_HISTORICO = 2000;
    private final Scanner lector;
    private final CentroSalud centro;

    public Ejercico7() {
        lector = new Scanner(System.in);
        int opcion;
        centro = new CentroSalud(MAX_PACIENTES, MAX_REGISTROS_HISTORICO);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    introducirSip();
                    Lib.pause();
                    break;
                case 2:
                    llamarPaciente();
                    Lib.pause();
                    break;
                case 3:
                    consultas();
                    Lib.pause();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while (opcion != 0);

        lector.close();
    }

    /**
     * Solicita y valida los datos para el alta médica de un paciente
     */
    private void altaMedica() {
        int sip;
        int i = 1;
        boolean validado;
        int opcion;
        AtencionMedica atencionPaciente;
        System.out.println("Sip: ");
        sip = Integer.parseInt(lector.nextLine());
        atencionPaciente = centro.obtenerRegistroAtencionPaciente(sip);
        if (atencionPaciente != null) {
            do {
                System.out.println("*****************");
                System.out.println("** MOTIVO ALTA **");
                System.out.println("*****************");
                for (AtencionMedica.MotivoAlta motivoAlta : AtencionMedica.MotivoAlta.values()) {
                    System.out.println(i + ". " + motivoAlta);
                    i++;
                }
                System.out.print("\nElija un motivo: ");
                opcion = Integer.parseInt(lector.nextLine());
                validado = opcion >= 1 && opcion <= AtencionMedica.MotivoAlta.values().length;
                if (!validado) {
                    System.out.println("Elija una opción del menú");
                }
            } while (!validado);
            if (atencionPaciente.darAlta(AtencionMedica.MotivoAlta.fromInteger(opcion-1))) {
                System.out.println("El paciente ha sido de alta correctamente");
            } else {
                System.out.println("No se ha podido dar de alta al paciente");
            }
        } else {
            System.out.println("No se ha encontrado el paciente con sip " + sip);
        }
    }

    private void llamarPaciente(){
        if (!centro.atenderPacienteMedico()) {
            System.out.println("No hay pacientes.1");
        }
        
    }
    /**
     * Solicita y valida las constantes vitales de un paciente
     */
    private void atenderPaciente() {
        int sip;
        boolean validado;
        AtencionMedica atencionPaciente;
        System.out.println("Sip: ");
        sip = Integer.parseInt(lector.nextLine());
        atencionPaciente = centro.obtenerRegistroAtencionPaciente(sip);
        if (atencionPaciente != null) {
            float temperatura;
            float ppm;
            float tenSis;
            float tenDias;
            do {
                System.out.println("Temperatura: ");
                temperatura = Float.parseFloat(lector.nextLine());
                validado = temperatura >= AtencionMedica.MIN_TEMPERATURA && temperatura <= AtencionMedica.MAX_TEMPERATURA;
                if (!validado) {
                    System.out.println("Comprueba el rango de temperaturas [" + AtencionMedica.MIN_TEMPERATURA + "-" + AtencionMedica.MAX_TEMPERATURA + "] ");
                }
            } while (!validado);
            do {
                System.out.println("Pulsaciones por minuto: ");
                ppm = Float.parseFloat(lector.nextLine());
                validado = ppm >= AtencionMedica.MIN_PPM && ppm <= AtencionMedica.MAX_PPM;
                if (!validado) {
                    System.out.println("Comprueba el rango de ppm [" + AtencionMedica.MIN_PPM + "-" + AtencionMedica.MAX_PPM + "] ");
                }
            } while (!validado);
            do {
                System.out.println("Tensión sistólica: ");
                tenSis = Float.parseFloat(lector.nextLine());
                validado = tenSis >= AtencionMedica.MIN_TENSION_SISTOLICA && tenSis <= AtencionMedica.MAX_TENSION_SISTOLICA;
                if (!validado) {
                    System.out.println("Comprueba el rango de la tensión sistólica [" +
                            AtencionMedica.MIN_TENSION_SISTOLICA + "-" + AtencionMedica.MAX_TENSION_SISTOLICA + "] ");
                }
            } while (!validado);
            do {
                System.out.println("Tensión diastólica: ");
                tenDias = Float.parseFloat(lector.nextLine());
                validado = tenDias >= AtencionMedica.MIN_TENSION_DIASTOLICA && tenDias <= AtencionMedica.MAX_TENSION_DIASTOLICA;
                if (!validado) {
                    System.out.println("Comprueba el rango de la tensión diastólica [" +
                            AtencionMedica.MIN_TENSION_DIASTOLICA + "-" + AtencionMedica.MAX_TENSION_DIASTOLICA + "] ");
                }
            } while (!validado);
            if (centro.atenderPaciente(sip, temperatura, ppm, tenSis, tenDias)) {
                System.out.println("Paciente atendido correctamente");
            } else {
                System.out.println("El paciente no ha podido ser atendido");
            }
        } else {
            System.out.println("El paciente con sip " + sip + " no está registrado en el sistema");
        }
    }

    /**
     * Solicita y valida los datos para crear un nuevo paciente
     */
    private void introducirSip() {
        boolean validado;
        int sip;
        int pos;
        int medico;

        do {
            System.out.println("Sip: ");
            sip = Integer.parseInt(lector.nextLine());
            // Aquí iría la validación
            validado = sip > 100;
            if(!validado) {
                System.out.println("El sip debe ser un número mayor que 100");
                Lib.pause();
            }
        } while (!validado);

        do{
            System.out.println(centro.mostrarMedicos());
            medico = Integer.parseInt(lector.nextLine());
            validado = sip > 0 && sip < 6;
            if (!validado) {
                System.out.println("El ingreso debe estar entre 1 y 5");
            }
        }while(!validado);
        System.out.println(centro.obtenerTiquet(medico, sip));
        
            
    }

    /**
     * Muestra el menú principal de la aplicación
     * @return int con la opción elegida por el usuario
     */
    private int menuPrincipal() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("*********************");
            System.out.println("** H O S P I T A L **");
            System.out.println("*********************");
            System.out.println("1. Introducir Sip");
            System.out.println("2. Llamar a paciente");
            System.out.println("3. Consultas...");
            System.out.println("---------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if (opcion < 0 || opcion > 3) {
                System.out.println("Elija una opción del menú [0-3]");
                Lib.pause();
            }

        } while (opcion < 0 || opcion > 3);
        return opcion;
    }

    /**
     * Muestra el submenú de consultas
     * @return int la opción del submenú elegida por el usuario
     */
    private int menuConsultas() {
        int opcion = -1;
        do {
            Ansi.clearScreen();
            System.out.println("*********************");
            System.out.println("**C O N S U L T A S**");
            System.out.println("*********************");
            System.out.println("1. Citas de un paciente");
            System.out.println("2. Citas de un médico");
            System.out.println("3. Mostrar todos los pacientes");
            System.out.println("4. Mostrar todas las citas");
            System.out.println("------------------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(lector.nextLine());
            if(opcion < 0 || opcion > 4) {
                System.out.println("Elija una opción del menú [0-4]");
                Lib.pause();
            }
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }

    /**
     * Ejecuta la opción del submenú consultas elegida por el usuario
     */
    private void consultas() {
        int opcion;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    // Por sip
                    CitasPacientes();
                    break;
                case 2:
                    // Por fechas
                    consultaPorFechas();
                    break;
                case 3:
                    // Estadísticas
                    mostrarEstadisticas();
                    break;
                case 4:
                    // Mostrar histórico
                    mostrarHistorico();
                    break;
            }
        } while (opcion != 0);
    }

    /**
     * Muestra el histórico de atenciones a pacientes
     */
    private void mostrarHistorico() {
        int i;
        i = 0;
        boolean fin = false;
        AtencionMedica[] historial = centro.getHistorial();
        while (i < historial.length && !fin) {
            if (historial[i]!= null) {
                System.out.println(historial[i].toString());
                i++;
            } else {
                fin = true;
            }
        }
        Lib.pause();
    }

    /**
     * Muestra las estadísticas
     */
    private void mostrarEstadisticas() {
        // Podríamos haber implementado un método que calculara todas las medias con una sola pasada de bucle
        // pero cada uno por separado queda más claro
        float[] stats = centro.mediaPreRev();
        System.out.printf("Media temperatura: %.2f\n", stats[AtencionMedica.TEMPERATURA]);
        // También podríamos hacerlo mediante:
        // System.out.printf("Media temperatura: %.2f\n", centro.mediaTemperatura());
        System.out.printf("Media ppm: %.0f\n", stats[AtencionMedica.PPM]);
        // System.out.printf("Media ppm: %.0f\n", centro.mediaPpm());
        System.out.printf("Media tensión sistólica: %.0f\n", stats[AtencionMedica.TENSION_SISTOLICA]);
        // System.out.printf("Media tensión sistólica: %.0f", centro.mediaTenSis());
        System.out.printf("Media tensión diastólica: %.0f\n", stats[AtencionMedica.TENSION_DIASTOLICA]);
        // System.out.printf("Media tensión diastólica: %.0f", centro.mediaTenDias());
        System.out.printf("Media edad pacientes: %.1f\n", centro.mediaEdadPacientes());
        System.out.printf("Porcentaje hombres: %.2f\n", centro.porcentajeHombres());
        System.out.printf("Porcentaje mujeres: %.2f\n", centro.porcentajeMujeres());
        Lib.pause();
    }

    /**
     * Solicita y valida datos para la búsqueda en el histórico por fechas
     */
    private void consultaPorFechas() {
        boolean validado;
        int i;
        System.out.println("Fecha inicio (dd-mm-yyyy): ");
        String fechaInicioStr = lector.nextLine();
        GregorianCalendar fechaInicio = null;
        GregorianCalendar fechaFin = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date date = sdf.parse(fechaInicioStr + " 00:00");
            fechaInicio = new GregorianCalendar();
            fechaInicio.setTime(date);
            validado = true;
        } catch (ParseException pe) {
            validado = false;
            System.out.println("El formato de la fecha inicio no es correcto. Recuerde (dd-mm-yyyy).");
            Lib.pause();
        }
        if (validado) {
            System.out.println("Fecha fin (dd-mm-yyyy): ");
            String fechaFinStr = lector.nextLine();
            if (fechaFinStr.equals("")) {
                fechaFin = new GregorianCalendar();
            } else {
                try {
                    Date date = sdf.parse(fechaFinStr + " 23:59");
                    fechaFin = new GregorianCalendar();
                    fechaFin.setTime(date);
                } catch (ParseException pe) {
                    validado = false;
                    System.out.println("El formato de la fecha fin no es correcto. Recuerde (dd-mm-yyyy).");
                    Lib.pause();
                }
            }
            if (validado) {
                AtencionMedica[] historialFechas = centro.buscarHistoricoPorFechas(fechaInicio, fechaFin);
                if (historialFechas != null) {
                    for (i = 0; i < historialFechas.length; i++) {
                        System.out.println(historialFechas[i].toString());
                    }
                } else {
                    System.out.println("No se han encontrado registros");
                }
            }
        }
        Lib.pause();
    }

    /**
     * Solicita y valida datos para la búsqueda en el histórico por SIP
     */
    private void CitasPacientes() {
        int sip;
        System.out.println("Sip: ");
        sip = Integer.parseInt(lector.nextLine());
        
        System.out.println(centro.verCitasPaciente(sip));
    }
}
