package com.kevinolarte.ejr.trimestre3.t10.ejer10;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Empleado {
    private final String dni;
    private final String nombre;
    private final LocalDate fehcaNacimiento;
    private  float salario;
    private ArrayList<Hijo> hijos;

    private Empleado(String dni, String nombre, LocalDate fechaNacimiento, float salario, ArrayList<Hijo> hijos){
        this.dni = dni;
        this.nombre = nombre;
        this.fehcaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.hijos = hijos;
    }
    public Empleado(String dni, String nombre, LocalDate fechaNacimiento, float salario){
        this(dni, nombre, fechaNacimiento, salario, new ArrayList<Hijo>());
    }

    public Empleado(Empleado empleado){
        this(empleado.dni, empleado.nombre, empleado.fehcaNacimiento, empleado.salario, empleado.hijos);
    }

    /**
     * Metodo para añadir un hijo a al empleado
     * @param nombre String nombre del hijo
     * @param edad int edad del padre
     * @return
     */
    public boolean addHijo( String nombre, int edad){
        
        hijos.add(new Hijo(nombre, edad));
        return true;
    }

    /**
     * Metodo para eliminar un hijo del empleado
     * @param nombre String nombre del hijo
     * @return boolean notificando si se ha podido eliminar el hijo
     */
    public boolean removeHijo(String nombre){
        for (Hijo hijo : hijos) {
            if (hijo.getNombre().equals(nombre)) {
                hijos.remove(hijo);
                return true;
            }
        }
        return false;
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
                + salario + ", hijos=" + hijos.toString() + "( " + hijos.size() + "]";
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

    public int getEdad() {
        
        return  Period.between(fehcaNacimiento, LocalDate.now()).getYears();
    }

    public Hijo[] getHijos() {
        Hijo[] array = new Hijo[hijos.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Hijo(hijos.get(i));
        }
        return array;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public class ComparatorNombre implements Comparator<Empleado> {

        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.nombre.compareTo(o2.nombre);
        }  
    }

    public class ComparatorDni implements Comparator<Empleado> {

        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.getDni().compareTo(o2.dni);
        }
    }

    
    


    
    


    



}
