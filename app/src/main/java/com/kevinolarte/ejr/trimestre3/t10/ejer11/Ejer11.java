package com.kevinolarte.ejr.trimestre3.t10.ejer11;

import com.kevinolarte.lib.LibConf;
import com.kevinolarte.lib.LibInput;
import com.kevinolarte.lib.LibMenu;

public class Ejer11 {
    
    private final Centro centro;

    public Ejer11(Centro centro) {
        this.centro = centro;
        start();
    }

    private void start() {
        int ingreso = 0;
        do{
            LibMenu.print(new String[]{"Centro Escolar", "Dar alta", "Mostrar", "Consulta"});
            ingreso = LibInput.pedirIntPositivo("Elije una opcion de estas:");
            
            switch (ingreso) {
                case 1:
                    alta();
                    break;
            
                case 2:
                    mostrar();
                    break;

                case 3:
                    consulta();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    LibConf.sleep();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    LibConf.sleep();
                    break;
            }
        }while(ingreso != 0);
    }

    private void consulta(){
        int ingreso = 0;
        do{
            LibMenu.print(new String[]{"Mostrar todo", "Mostrar por codigo"});
            ingreso = LibInput.pedirIntPositivo("Elije una opcion de estas:");
            
            switch (ingreso) {
                case 1:
                    mostrarTodo();
                    break;
                case 2:
                    mostrarPorCodigo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    LibConf.sleep();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    LibConf.sleep();
                    break;
            }
        }while(ingreso != 0);
    }

    private void mostrarPorCodigo() {
        int ingreso;
        do{
            LibMenu.print(new String[]{"Mostrar por codigo", "Alumno", "Profesor", "Asignatura", "Grupo", "Aula"});
            ingreso = LibInput.pedirInt("Elije una opcion de estas:");

            switch (ingreso) {
                case 1:
                    monstrarAlumnoPorCodigo();
                    break;
                case 2:
                    mostrarProfesorPorCodigo();
                    break;
                case 3:
                    mostrarAsignaturaPorCodigo();
                    break;
                case 4:
                    mostrarGrupoPorCodigo();
                    break;
                case 5:
                    mostrarAulaPorCodigo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    LibConf.sleep();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    LibConf.sleep();
                    break;
            }
        }while(ingreso != 0);
        LibInput.scanner.nextLine();
    }

    private void mostrarTodo() {
        int opcion;
        do{
            LibMenu.print(new String[]{"Mostrar todo", "Alumnos", "Profesores", "Asignaturas", "Grupos", "Aulas"});
            opcion = LibInput.pedirInt("Elije una opcion de estas:");
            
            switch(opcion){
                case 1:
                    System.out.println(centro.getAlumnos().toString());
                    LibInput.scanner.nextLine();
                    break;
                case 2:
                    System.out.println(centro.getProfesores().toString());
                    LibInput.scanner.nextLine();
                    break;
                case 3:
                    System.out.println(centro.getAsignaturas().toString());
                    LibInput.scanner.nextLine();
                    break;
                case 4:
                    System.out.println(centro.getGrupos().toString());
                    LibInput.scanner.nextLine();
                    break;
                case 5:
                    System.out.println(centro.getAulas().toString());
                    LibInput.scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    LibConf.sleep();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    LibConf.sleep();
                    break;
            }
        }while(opcion != 0);
    }
    /**
     * Menu para dar de alta a un alumno, profesor, asignatura, grupo o aula
     */
    private void alta() {
        int ingreso = 0;
        do{
            LibMenu.print(new String[]{"Dar alta","Alumno", "Profesor", "Asignatura", "Grupo", "Aula"});
            ingreso = LibInput.pedirIntPositivo("Elije una opcion de estas:");
            
            switch (ingreso) {
                case 1:
                    altaAlumno();
                    break;
                case 2:
                    altaProfesor();
                    break;
                case 3:
                    altaAsignatura();
                    break;
                
                case 4:
                    altaGrupo();
                    break;
                case 5:
                    altaAula();
                    break;
                
                case 0:
                    System.out.println("Saliendo...");
                    LibConf.sleep();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    LibConf.sleep();
                    break;
            }
        }while(ingreso != 0);
    }

    /**
     * Mostrar un aula por su codigo
     */
    private void mostrarAulaPorCodigo(){
        String codigo;
        codigo = LibInput.pedirTexto("Ingrese el codigo del aula");
        Aula aula = centro.getAula(codigo);
        if (aula == null) {
            System.out.println("No se encontro el aula");
        }
        else{
            System.out.println(aula.toString());
        }
        LibInput.scanner.nextLine();
    }
    /**
     * Mostrar un aula por su codigo
     */
    private void mostrarGrupoPorCodigo(){
        String codigo;
        codigo = LibInput.pedirTexto("Ingrese el codigo del grupo");
        Grupo grupo = centro.getGrupo(codigo);
        if (grupo == null) {
            System.out.println("No se encontro el grupo");
        }
        else{
            System.out.println(grupo.toString());
        }
        LibInput.scanner.nextLine();
    }
    /**
     * Mostrar una asignatura por su codigo
     */
    private void mostrarAsignaturaPorCodigo(){
        String codigo;
        codigo = LibInput.pedirTexto("Ingrese el codigo de la asignatura");
        Asignatura asignatura = centro.getAsignatura(codigo);
        if (asignatura == null) {
            System.out.println("No se encontro la asignatura");
        }
        else{
            System.out.println(asignatura.toString());
        }
        LibInput.scanner.nextLine();
    }

    /**
     * Mostrar un profesor por su codigo
     */
    private void mostrarProfesorPorCodigo(){
        String dni;
        dni = LibInput.pedirTexto("Ingrese el dni del profesor");
        Profesor profesor = centro.getProfesor(dni);
        if (profesor == null) {
            System.out.println("No se encontro el profesor");
        }
        else{
            System.out.println(profesor.toString());
        }
        LibInput.scanner.nextLine();
    }
    /**
     * Mostrar un alumno por su codigo
     */
    private void monstrarAlumnoPorCodigo() {
        String codigo;
        codigo = LibInput.pedirTexto("Ingrese el codigo del alumno");
        Alumno alumno = centro.getAlumno(codigo);
        if (alumno == null) {
            System.out.println("No se encontro el alumno");
        }
        else{
            System.out.println(alumno.toString());
        }
        LibInput.scanner.nextLine();
    }

    private void altaAlumno(){
        String nombre;
        String codigoGrupo;
        String asignaturas[];
        int cantidad;
        
        nombre = LibInput.pedirTexto("Ingrese el nombre del alumno");
        do{
            codigoGrupo = LibInput.pedirTexto("Ingrese el codigo del grupo || 0 para salir: \n" + centro.getGrupos().toString());
        }while(centro.getGrupo(codigoGrupo) == null || codigoGrupo.equals("0"));
        if (codigoGrupo.equals("0")) {
            return;
        }
        cantidad = LibInput.pedirIntPositivo("Ingrese la cantidad de asignaturas que tiene el alumno");
        asignaturas = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            asignaturas[i] = LibInput.pedirTexto("Ingrese el codigo de la asignatura || 0 para salir: \n" + centro.getAsignaturas().toString());
            if (asignaturas[i].equals("0")) {
                return;
            }
        }
        Salida salida = centro.addAlumno(nombre, codigoGrupo, asignaturas);
        if (salida == Salida.PARAMETROS_NO_VALIDO) {
            System.out.println("Los parametros no pueden estar vacios");
        }
        else{
            System.out.println("Alumno creado con exito");
        }
        LibInput.scanner.nextLine();
    }

    private void altaAsignatura(){
        String codigo;
        String nombre;
        String dniProfesor;
        do{
            codigo = LibInput.pedirTexto("Ingrese el codigo de la asignatura || 0 para salir: ");
        }while(centro.getAsignatura(codigo) != null || codigo.equals("0"));
        if (codigo.equals("0")) {
            return;
        }
        nombre = LibInput.pedirTexto("Ingrese el nombre de la asignatura");
        do{
            dniProfesor = LibInput.pedirTexto("Ingrese el dni del profesor || 0 para salir: \n" + centro.getProfesores().toString());
        }while(centro.getProfesor(dniProfesor) == null || dniProfesor.equals("0"));
        if (dniProfesor.equals("0")) {
            return;
        }
        Salida salida = centro.addAsignatura(codigo, nombre, dniProfesor);
        if (salida == Salida.PARAMETROS_NO_VALIDO) {
            System.out.println("Los parametros no pueden estar vacios");
        }
        else{
            System.out.println("Asignatura creada con exito");
        }
        LibInput.scanner.nextLine();
    }

    /**
     * Dar de alta a un GRUPO nuevo
     */
    private void altaGrupo(){
        String codigo;
        String nombre;
        String codigoAula;
        do{
            codigo = LibInput.pedirTexto("Ingrese el codigo del grupo || 0 para salir:");
        }while(centro.getGrupo(codigo) != null || codigo.equals("0"));
        if (codigo.equals("0")) {
            return;
        }
        nombre = LibInput.pedirTexto("Ingrese el nombre del grupo");
        do{
            codigoAula = LibInput.pedirTexto("Ingrese el codigo del aula || 0 para salir: \n" + centro.getAulas().toString());
        }while(centro.getAula(codigoAula) == null || codigoAula.equals("0"));
        if (codigoAula.equals("0")) {
            return;
        }
        Salida salida = centro.addGrupo(codigo, nombre, codigoAula);
        if (salida == Salida.PARAMETROS_NO_VALIDO) {
            System.out.println("Los parametros no pueden estar vacios");
        }
        else{
            System.out.println("Grupo creado con exito");
        }
      
        LibInput.scanner.nextLine();
    }
 

    /**
     * Dar de alta a un alumno nuevo
     */
    private void altaAula() {
        int metrosCuadrados = LibInput.pedirIntPositivo("Ingrese los metros cuadrados del aula");
        Salida salida = centro.addAula(metrosCuadrados);
        if (salida == Salida.PARAMETROS_NO_VALIDO) {
            System.out.println("Las dimensiones no pueden ser inferior a 1");
        }
        else{
            System.out.println("Aula creada con exito");
        }
        LibInput.scanner.nextLine();
    }

    /**
     * Dar de alta a un profesor nuevo
     */
    private void altaProfesor(){
        String dni;
        String nombre;
        float salario;
        do{
            dni = LibInput.pedirTexto("Ingrese si dni || 0 para salir: ");
        }while(centro.getProfesor(dni) != null || dni.equals("0"));
        if (dni.equals("0")) {
            return;
        }
        nombre = LibInput.pedirTexto("Ingrese su nombre");
        salario = LibInput.pedirFloat("Ingrese su salario");

       Salida salida = centro.addProfesor(dni, nombre, salario);
        
       if (salida == Salida.PARAMETROS_NO_VALIDO) {
            System.out.println("Los parametros no pueden estar vacios");
            
       }
       else{
           System.out.println("Profesor creado con exito");
       }
       LibInput.scanner.nextLine();
    }
    /**
     * Menu para ver los alumnos por agrupaciones
     */
    private void mostrar(){
        int ingreso  = 0;
        do{
            LibMenu.print(new String[]{"Mostrar","Mostrar Alumos Por grupo", "Mostrar Alumno por Profesor"});
            ingreso = LibInput.pedirIntPositivo("Elije una opcion de estas:");
            
            switch (ingreso) {
                case 1:
                    System.out.println(centro.mostrarAlumnosPorGrupo());
                    LibInput.scanner.nextLine();
                    break;
                case 2:
                    System.out.println(centro.mostrarAlunmosPorPorfesor());
                    LibInput.scanner.nextLine();
                    break;
                
                case 0:
                    System.out.println("Saliendo...");
                    LibConf.sleep();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    LibConf.sleep();
                    break;
            }
    }while(ingreso != 0);
    }



}
