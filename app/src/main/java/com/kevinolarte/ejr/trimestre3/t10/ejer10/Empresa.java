package com.kevinolarte.ejr.trimestre3.t10.ejer10;

import java.util.Date;

import com.kevinolarte.lib.LibInput;

import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {
    private final static int CANT_DEFAULT = 30;

    private final ArrayList<Empleado> empleados;

    public Empresa(int cantEmpleados){
        this.empleados = new ArrayList<>(cantEmpleados);
    }
    public Empresa(){
        this(CANT_DEFAULT);
        rellenarEmpresa();
    }

    private void rellenarEmpresa(){
        /**Crea empleados usando el metod add EMpleaodo con datos alazar pero la fecha debe ser 1991-01-01*/
        addEmpleado("12345678A", "Pepe", LocalDate.of(1991, 1, 1), 1000);
        addEmpleado("12345678B", "Juan", LocalDate.of(1991, 1, 1), 2000);
        addEmpleado("12345678C", "Luis", LocalDate.of(1991, 1, 1), 3000);
        addEmpleado("12345678D", "Maria", LocalDate.of(1991, 1, 1), 4000);
        addEmpleado("12345678E", "Ana", LocalDate.of(1991, 1, 1), 5000);
        addEmpleado("123", "kevin", LocalDate.of(2005, 8, 8), 100);
        addHijo("123", "Pepito", 10);

    }

    /**
     * Metodo para obtener un objeto Empleado a partir de un campo dni
     * @param dni String que representa el dni unico de un Empleado
     * @return devuelve un Empleado o null si no es encontrado
     */
    public Empleado getEmpleadoDni(String dni){
        for (Empleado empleado : empleados) {
            if (empleado.getDni().equals(dni)) {
                return new Empleado(empleado);
            }
        }
        return null;
    }
    /**
     * Metodo para obtener un objeto Empleado a partir de un campo dni
     * @param dni String que representa el dni unico de un Empleado
     * @return devuelve un Empleado o null si no es encontrado
     */
    private Empleado getEmpleadoDniOriginal(String dni){
        for (Empleado empleado : empleados) {
            if (empleado.getDni().equals(dni)) {
                return empleado;
            }
        }
        return null;
    }


    /**
     * Metodo para añadir un empleado a nuestra Empresa, por defecto no tendra hijos,
     *  luego es opcional llamar al metodo addHijo()
     * @param dni String que represaenta el valor unico de un objeto Empleado
     * @param nombre String que representa el nombre del objeto Empkleado
     * @param fechaNacimiento Date que representa la fehca del nacimiento
     * @param salario float que representa el salario del Objeto empleado
     * @return devuelve un booleano notificando si se ha podido crear el Empleado,
     * false: si ya existe, true: se ha reado correctamente.
     */
    public boolean   addEmpleado(String dni, String nombre, LocalDate fechaNacimiento, float salario){
        if (getEmpleadoDni(dni) != null) {
            return false;
        }
        empleados.add(new Empleado(dni, nombre, fechaNacimiento, salario));
        return true;
    }


    /**
     * añade un hijo a un empleado mediante el dni del padre
     * @param dniPadre dni del padre formato String
     * @param nombre nombre del hijo formato String
     * @param edad edad del hijo formato int
     * @return devuelve un booleano notificando si se ha podido añadir el hijo,
     */
    public boolean addHijo(String dniPadre, String nombre, int edad){
        Empleado empleado = getEmpleadoDniOriginal(dniPadre);
        if (empleado == null) {
            return false;
        }
        empleado.addHijo(nombre, edad);
        return true;

    }


    /**
     * Metodo para modificar el salario de un empleado a partir de su dni
     * @param dni String que representa el dni unico de un Empleado
     * @param salario float que representa el nuevo salario
     * @return devuelve un booleano notificando si se ha podido modificar el salario,
     */
    public boolean modificarSalario(String dni, float salario){
        Empleado empleado = getEmpleadoDniOriginal(dni);
        if (empleado == null) {
            return false;
        }
        empleado.setSalario(salario);
        return true;
    }

    /**
     * Metodo para borrar un empleado a partir de su dni
     * @param dni String que representa el dni unico de un Empleado
     * @return devuelve un booleano notificando si se ha podido borrar el empleado.
     */
    public boolean removeEmpleado(String dni){
        Empleado empleado = getEmpleadoDniOriginal(dni);
        if (empleado == null) {
            return false;
        }
        empleados.remove(empleado);
        return true;
    }

    /**
     * Metodo para borrar un hijo de un empleado a partir de su nombre
     * @param dniPadre dni del padre formato String
     * @param nombre nombre del hijo formato String
     * @return devuelve un booleano notificando si se ha podido borrar el hijo.
     */
    public boolean removeHijo(String dniPadre, String nombre){
        Empleado empleado = getEmpleadoDniOriginal(dniPadre);
        if (empleado == null) {
            return false;
        }
        return empleado.removeHijo(nombre);
    }

    /*
     * ***********************
* CONSULTAS EMPLEADOS *
***********************
1. Buscar por NIF
3. Buscar por rango de edad.
4. Buscar por rango de sueldo.
5. Buscar por hijos menores de edad
     */

     /**
      * Metodo para obtener un array de empleados a partir de un nombre
      * @param nombre String que representa el nombre de un empleado
      * @return devuelve un array de empleados con el nombre indicado
      */
     public Empleado[] getEmpleadosNombre(String nombre){
         ArrayList<Empleado> empleadosNombre = new ArrayList<>();
         for (Empleado empleado : empleados) {
             if (empleado.getNombre().equals(nombre)) {
                 empleadosNombre.add(new Empleado(empleado));
             }
         }
         return empleadosNombre.toArray(new Empleado[0]);
     }

     /**
      * Metodo para obtener un array de empleados a partir de un rango de edad
      * @param edadMin int edad minima
      * @param edadMax int edad maxima
      * @return devuelve un array de empleados con la edad indicada
      */
     public Empleado[] getEmpleadoRangoEdad(int edadMin, int edadMax){
         ArrayList<Empleado> empleadosEdad = new ArrayList<>();
         for (Empleado empleado : empleados) {
             if (empleado.getEdad() >= edadMin && empleado.getEdad() <= edadMax) {
                 empleadosEdad.add(new Empleado(empleado));
             }
         }
         return empleadosEdad.toArray(new Empleado[0]);
     }

     /**
      * Metodo para obtener un array de empleados a partir de un rango de salario
      * @param salarioMin float salario minimo
      * @param salarioMax float salario maximo
      * @return devuelve un array de empleados con el salario indicado
      */
     public Empleado[] getEmpleadosRangoSalario(float salarioMin, float salarioMax){
         ArrayList<Empleado> empleadosSalario = new ArrayList<>();
         for (Empleado empleado : empleados) {
             if (empleado.getSalario() >= salarioMin && empleado.getSalario() <= salarioMax) {
                 empleadosSalario.add(new Empleado(empleado));
             }
         }
         return empleadosSalario.toArray(new Empleado[0]);
     }

        /**
        * Metodo para obtener un array de empleados con hijos menores de edad
        * @return devuelve un array de empleados con hijos menores de edad
        */
     public Empleado[] getEmpleadosHijosMenoresEdad(){
         ArrayList<Empleado> empleadosHijosMenores = new ArrayList<>();
         for (Empleado empleado : empleados) {
            for (Hijo hijo : empleado.getHijos()) {
                if (hijo.getEdad() < 18) {
                    empleadosHijosMenores.add(new Empleado(empleado));
                    break;
                }
            }
         }
         return empleadosHijosMenores.toArray(new Empleado[0]);
     }

}
