package com.kevinolarte.ejr.trimestre3.t10.ejer10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Empleado {
    private final String dni;
    private final String nombre;
    private final LocalDate fehcaNacimiento;
    private final float salario;
    private ArrayList<Hijo> hijos;

    public Empleado(String dni, String nombre, LocalDate fechaNacimiento, float salario){
        this.dni = dni;
        this.nombre = nombre;
        this.fehcaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.hijos = null; 
    }

    public Empleado(Empleado empleado){
        this(empleado.dni, empleado.nombre, empleado.fehcaNacimiento, empleado.salario);
    }

    /**
     * Metodo para añadir un hijo a al empleado
     * @param dniPadre String del dni del padre
     * @param nombre String nombre del hijo
     * @param edad int edad del padre
     * @return
     */
    public boolean addHijo(String dniPadre, String nombre, int edad){
        if (this.hijos == null) {
            this.hijos = new ArrayList<>();
        }

        hijos.add(new Hijo(dniPadre, nombre, edad));
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
        Empleado other = (Empleado) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empleado [dni=" + dni + ", nombre=" + nombre + ", fehcaNacimiento=" + fehcaNacimiento + ", salario="
                + salario + ", hijos=" + Arrays.toString(hijos) + "]";
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFehcaNacimiento() {
        return fehcaNacimiento;
    }

    public float getSalario() {
        return salario;
    }

    public Hijo[] getHijos() {
        return hijos;
    }


    
    


    



}
