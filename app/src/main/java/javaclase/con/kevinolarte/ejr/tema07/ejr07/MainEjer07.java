package javaclase.con.kevinolarte.ejr.tema07.ejr07;

import java.time.LocalDate;

import javaclase.con.kevinolarte.lib.Conf;
import javaclase.con.kevinolarte.lib.Input;
import javaclase.con.kevinolarte.lib.Menus;

public class MainEjer07 {

    CentroSalud centro = new CentroSalud(0);
    public MainEjer07(){
        
        int ingreso = 0;
        do{
            Menus.print(new String[]{"      URGENCIAS      ", "Nuevo paciente...","Atender Paciente...","Consultas...","Alta Medica..."});
            ingreso = Input.pedirIntPositivo("Ingrese un valor del menu");
            switch (ingreso) {
                case 1:
                    nuevoPaciente();
                    Input.scanner.nextLine();
                    break;
                case 2:
                    atenderPaciente();
                    Input.scanner.nextLine();
                    break;
                case 3:
                    consultas();
                    Input.scanner.nextLine();
                    break;
                case 4:
                    altaMedica();
                    Input.scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    Conf.sleep(400);
                    break;

                case 9:
                    generar();
                    Input.scanner.nextLine();
                    break;
                default:
                    System.out.println("Numero fuera de rango");
                    Conf.sleep(400);
                    break;
            }
        }while(ingreso != 0);
    }

    private void altaMedica(){
        String sip = Input.pedirString("Ingresa el sip del paciente");
        String fecha = Input.pedirFecha("Ingresa la fecha de entreada del siguente formato yyyy/:-MM/:-dd ");
        String motivo = Input.pedirString("Ingresa el motivo del alta");
        boolean darAlta = centro.darAltaPaciente(sip, LocalDate.parse(fecha), motivo);
        if (darAlta) {
            System.out.println("Alta realizada");
        }
        else
            System.out.println("Error");
    }
    /**Metodo para dar el alta */
    private void atenderPaciente(){
        String sip = Input.pedirString("Ingresa el sip del paciente");
        double temperatura = Input.pedirDoublePositivo("Ingrese la temperatura del paciente");
        double pulsaciones = Input.pedirDoublePositivo("Ingrese las pulsaciones por minuto del paciente");
        double arteriaSis = Input.pedirDoublePositivo("Ingrese el valorde la arteriaSis..");
        double arteriaDia = Input.pedirDoublePositivo("Ingrese el valor de la arteria Dia...");
        boolean atendido = centro.atenderPaciente(sip, temperatura, pulsaciones, arteriaSis, arteriaDia);
        if (atendido) 
            System.out.println("Paciente antendido correctamente");
        
        else
            System.out.println("Error");
    }
    

    /**
     * Metodo para añadir nuevo paciente
     */
    private void nuevoPaciente(){
        System.out.print("\033[H\033[2J");
        String sip = Input.pedirString("Ingresa el sip del paciente");
        String nombre = Input.pedirString("Ingresa el nombre del paciente");
        boolean sexo = Input.pedirBoolean("Hombre(Si) - Mujer(No)");
        int edad = Input.pedirInt("Ingresa la edad del paciente");
        String fecha = Input.pedirFecha("Ingresa la fecha de entreada del siguente formato yyyy/:-MM/:-dd ");
        String sintomas = Input.pedirString("Ingrese los sintomas del paciente");
        boolean conseguir = centro.nuevoPaciente(sip, nombre, sexo, edad, LocalDate.parse(fecha), sintomas);
        if (conseguir) 
            System.out.println("Nuevo paciente añadido");
        else
            System.out.println("Error");
    }
    private void generar(){
        System.out.print("\033[H\033[2J");
        String sip = "12345678";
        String nombre = "kevin";
        boolean sexo = true;
        int edad = 18;
        String fecha = "2024-01-01";
        String sintomas = "nada";
        boolean conseguir = centro.nuevoPaciente(sip, nombre, sexo, edad, LocalDate.parse(fecha), sintomas);
        if (conseguir) 
            System.out.println("Nuevo paciente añadido");
        else
            System.out.println("Error");
    }

    /**SubMenu */
    private void consultas(){
        int ingreso = 0;
        do{
            Menus.print(new String[]{"      Consultas      ", "Por sip...", "por fecha...", "Estadisticas", "Mostrar historico mensual"});
            ingreso = Input.pedirIntPositivo("Ingrese un numero del menu");
            switch (ingreso) {
                case 1:
                    porSip();
                    Input.scanner.nextLine();
                    break;
                case 2:
                    porFecha();
                    Input.scanner.nextLine();
                    break;
                case 3:
                    estadisticas();
                    Input.scanner.nextLine();
                    break;
                case 4:
                    mostrarHistorico();
                    Input.scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    Conf.sleep(400);
                    break;
                default:
                    System.out.println("Numero fuera de rango");
                    Conf.sleep(400);
                    break;
            }
        }while(ingreso != 0);
    }
    
    private void estadisticas(){
        System.out.print("\033[H\033[2J");
        System.out.println(centro.estadisticas());
    }
    
    private void porFecha(){
        System.out.print("\033[H\033[2J");
        String fechaInico = Input.pedirFecha("Ingresa la fecha de entreada del siguente formato yyyy-MM-dd");
        boolean fin = Input.pedirBoolean("Queres ingresar fecha fin si o no");
        String fechaFin;
        Consultas c[];
        if (fin) 
        {
            fechaFin = Input.pedirFecha("Ingresa la fecha de entreada del siguente formato yyyy-MM-dd HH:mm:ss");
             c= centro.otenerPacientesFecha(LocalDate.parse(fechaInico), LocalDate.parse(fechaFin));
        }
        else{
            c = centro.otenerPacientesFecha(LocalDate.parse(fechaInico));
        }
        if (c == null) {
            System.out.println("No se ha encontrado nada");
        }
        else{
            for (Consultas consultas : c) {
                System.out.println(consultas.toString());
            }
        }
        
        

        
    }

    /*
     * Metodo para mostrar los Pacientes por sip.
     */
    private void porSip(){
        System.out.print("\033[H\033[2J");
        String sip = Input.pedirString("Ingrese el sip del paciente");
        Consultas c[] = centro.obtenerPacientesSip(sip);
        for (Consultas consultas : c) {
            System.out.println(consultas.toString());
        }
    }

    /**Metodo para ver todo el historico del celtro */
    private void mostrarHistorico(){
        System.out.print("\033[H\033[2J");
        System.out.println(centro.mostarHistorico());
    }
}