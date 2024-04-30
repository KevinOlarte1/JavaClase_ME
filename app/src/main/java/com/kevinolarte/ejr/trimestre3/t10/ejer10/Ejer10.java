package com.kevinolarte.ejr.trimestre3.t10.ejer10;

import java.time.LocalDate;

import com.kevinolarte.lib.LibConf;
import com.kevinolarte.lib.LibConversion;
import com.kevinolarte.lib.LibInput;
import com.kevinolarte.lib.LibMenu;

public class Ejer10 {
    private Empresa empresa;

    public Ejer10(){
        this.empresa = new Empresa();
        start();
    }

    private void start(){
        boolean salir = false;
        do{
            LibMenu.print(new String[]{"Gestion de empleados", "Nuevo empleado", "Nuevo Hijo", "Modificar sueldo", "Borrar empleado","Borrar hijo", "Cunsulta"});
            int opcion = LibInput.pedirIntPositivo("Introduce una opcion: ");

            switch (opcion) {
                case 1:
                    nuevoEmpleado();
                    LibConf.sleep();
                    break;
                case 2:
                    nuevoHijo();
                    LibConf.sleep();
                    break;
                case 3:
                    modificarSueldo();
                    LibConf.sleep();
                    break;
                case 4:
                    borrarEmpleado();
                    LibConf.sleep();
                    break;
                case 5:
                    borrarHijo();
                    LibConf.sleep();
                    break;
                case 6:
                    consulta();
                    LibConf.sleep();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo...");
                    LibConf.sleep();
                    break;
                default:
                    System.out.println("Ingreso no valido!");
                    break;
            }
        }while(!salir);
    }

    /**
     * Metodo para crear un nuevo empleado
     */
    private void nuevoEmpleado(){
        String dni;
        String nombre;
        LocalDate fechaNacimiento;
        float salario;
        int edad;
        do{
            dni = LibInput.pedirTexto("Introduce el dni del empleado: ");
        }while(empresa.getEmpleadoDni(dni) != null);
        nombre = LibInput.pedirTexto("Introduce el nombre del empleado: "); 
        fechaNacimiento = LibConversion.dateToLocalDate(LibInput.pedirFecha("Introduce la fecha de nacimiento del empleado: "));
        salario = LibInput.pedirFloat("Introduce el salario del empleado: ");
        empresa.addEmpleado(dni, nombre, fechaNacimiento,  salario);
        boolean ingreso = LibInput.pedirBoolean("Tiene hijos? (s/n): ");
        if (ingreso) {
            int cantidad = LibInput.pedirIntPositivo("Cuantos hijos tiene?: ");
            for (int i = 0; i < cantidad; i++) {
                String nombreHijo = LibInput.pedirTexto("Introduce el nombre del hijo: ");
                int edadHijo = LibInput.pedirIntPositivo("Introduce la edad del hijo: ");
                boolean correcto = empresa.addHijo(dni, nombreHijo, edadHijo);
                if (!correcto) {
                    i--;
                }
            }
        }
        System.out.println("Empleado creado correctamente");
        LibInput.scanner.nextLine();
        
    }

    /**
     * Metodo para crear un nuevo hijo
     */
    private void nuevoHijo(){
        String dniPadre;
        String nombreHijo;
        int edadHijo;
        do{
            dniPadre = LibInput.pedirTexto("Introduce el dni del padre: ");
        }while(empresa.getEmpleadoDni(dniPadre) == null);
        nombreHijo = LibInput.pedirTexto("Introduce el nombre del hijo: ");
        edadHijo = LibInput.pedirIntPositivo("Introduce la edad del hijo: ");
        empresa.addHijo(dniPadre, nombreHijo, edadHijo);
        System.out.println("Hijo creado correctamente");
        LibInput.scanner.nextLine();
        

    }

    /**
     * Metodo para modificar el sueldo de un empleado
     */
    private void modificarSueldo(){
        String dni;
        float salario;
        
        do{
            dni = LibInput.pedirTexto("Introduce el dni del empleado: ");
        }while(empresa.getEmpleadoDni(dni) == null);
        salario = LibInput.pedirFloat("Introduce el nuevo salario: ");
        empresa.modificarSalario(dni, salario);
        System.out.println("Salario modificado correctamente");
        LibInput.scanner.nextLine();
    }

    /**
     * Metodo para borrar un empleado
     */
    private void borrarEmpleado(){
        String dni;
        do{
            dni = LibInput.pedirTexto("Introduce el dni del empleado: ");
        }while(empresa.getEmpleadoDni(dni) == null);
        empresa.removeEmpleado(dni);
        System.out.println("Empleado borrado correctamente");
        LibInput.scanner.nextLine();
    }

    /**
     * Metodo para borrar un hijo
     */
    private void borrarHijo(){
        String dni;
        String nombre;
        do{
            dni = LibInput.pedirTexto("Introduce el dni del empleado: ");
        }while(empresa.getEmpleadoDni(dni) == null);
        nombre = LibInput.pedirTexto("Introduce el nombre del hijo: ");
        empresa.removeHijo(dni, nombre);
        System.out.println("Hijo borrado correctamente");
        LibInput.scanner.nextLine();
    }

    private void consulta(){
        boolean salir = false;
        int opcion;

        do{
            LibMenu.print(new String[]{"Consultas","Buscar por NIF", "Buscar por nombre", "Buscar por rango de edad", "Buscar por rango de sueldo", "Buscar por hijos menores de edad"});
            opcion = LibInput.pedirIntPositivo("Introduce una opcion: ");
            switch (opcion) {
                case 1:
                    buscarPorNif();
                    break;
                case 2:
                    buscarPorNombre();
                    break;
                case 3:
                    buscarPorRangoEdad();
                    break;
                case 4:
                    buscarPorRangoSueldo();
                    break;
                case 5:
                    buscarPorHijosMenores();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo...");
                    LibConf.sleep();
                    break;
                default:
                    System.out.println("Ingreso no valido!");
                    LibConf.sleep();
                    break;
            }
        }while(!salir);
    }

    /**
     * Metodo para buscar un empleado por su nif
     */
    public void buscarPorNif(){
        String dni = LibInput.pedirTexto("Introduce el dni del empleado: ");
        Empleado empleado = empresa.getEmpleadoDni(dni);
        if (empleado != null) {
            System.out.println(empleado.toString());
        } else {
            System.out.println("Empleado no encontrado");
        }

        LibInput.scanner.nextLine();
    }

    /**
     * Metodo para buscar un empleado por su nombre
     */
    public void buscarPorNombre(){
        String nombre = LibInput.pedirTexto("Introduce el nombre del empleado: ");
        Empleado[] empleado = empresa.getEmpleadosNombre(nombre);
        if (empleado != null) {
            for (Empleado empleado2 : empleado) {
                System.out.println(empleado2.toString());
            }
        } else {
            System.out.println("Empleado no encontrado");
        }

        LibInput.scanner.nextLine();
    }

    /**
     * Metodo para buscar empleados por rango de edad
     */
    public void buscarPorRangoEdad(){
        int edadMin = LibInput.pedirIntPositivo("Introduce la edad minima: ");
        int edadMax = LibInput.pedirIntPositivo("Introduce la edad maxima: ");
        Empleado[] empleados =  empresa.getEmpleadoRangoEdad(edadMin, edadMax);
        if (empleados != null) {
            for (Empleado empleado : empleados) {
                System.out.println(empleado.toString());
            }
        } else {
            System.out.println("No se han encontrado empleados");
        }
        LibInput.scanner.nextLine();
    }

    /*
     * Metodo para buscar empleados por rango de sueldo
     */
    public void buscarPorRangoSueldo(){
        float sueldoMin = LibInput.pedirFloat("Introduce el sueldo minimo: ");
        float sueldoMax = LibInput.pedirFloat("Introduce el sueldo maximo: ");
        Empleado[] empleados = empresa.getEmpleadosRangoSalario(sueldoMin, sueldoMax);
        if (empleados != null) {
            for (Empleado empleado : empleados) {
                System.out.println(empleado.toString());
            }
        } else {
            System.out.println("No se han encontrado empleados");
        }
        LibInput.scanner.nextLine();
    }

    /**
     * Metodo para buscar empleados con hijos menores de edad
     */
    public void buscarPorHijosMenores(){
        Empleado[] empleados = empresa.getEmpleadosHijosMenoresEdad();
        if (empleados != null) {
            for (Empleado empleado : empleados) {
                System.out.println(empleado.toString());
            }
        } else {
            System.out.println("No se han encontrado empleados");
        }
        LibInput.scanner.nextLine();
    }


}
