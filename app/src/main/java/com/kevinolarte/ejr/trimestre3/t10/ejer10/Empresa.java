package com.kevinolarte.ejr.trimestre3.t10.ejer10;

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
        //RellenarEmpresa();
    }

    /**
     * Metodo para obtener un objeto Empleado a partir de un campo dni
     * @param dni String que representa el dni unico de un Empleado
     * @return devuelve un Empleado o null si no es encontrado
     */
    public Empleado getEmpleadoDni(String dni){
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
     * @param fechaNacimiento LocalDate que representa la fehca del nacimiento
     * @param salario float que representa el salario del Objeto empleado
     * @return devuelve un booleano notificando si se ha podido crear el Empleado,
     * false: si ya existe, true: se ha reado correctamente.
     */
    public boolean addEmpleado(String dni, String nombre, LocalDate fechaNacimiento, float salario){
        if (getEmpleadoDni(dni) != null) {
            return false;
        }
        empleados.add(new Empleado(dni, nombre, fechaNacimiento, salario));
        return true;
    }


    public boolean addHijo(String dniPadre, String nombre, int edad){
        Empleado empleado = getEmpleadoDni(dniPadre);
        if (empleado == null) {
            return false;
        }
        
        return true;

    }
}
