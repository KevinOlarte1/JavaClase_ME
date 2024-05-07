package com.kevinolarte.ejr.trimestre3.t10.ejer11;

import java.util.List;

import com.kevinolarte.lib.LibConf;
import com.kevinolarte.lib.LibRandom;
import java.util.ArrayList;

public class Centro {
    private final String nombre;
    private final List<Alumno> alumnos;
    private final List<Grupo> grupos;
    private final List<Asignatura> asignaturas;
    private final List<Profesor> profesores;
    private final List<Aula> aulas;

    public Centro(String nombre, List<Alumno> alumnos, List<Grupo> grupos, List<Asignatura> asignaturas, List<Profesor> profesores, List<Aula> aulas) {
        this.nombre = nombre;
        this.alumnos = alumnos;
        this.grupos = grupos;
        this.asignaturas = asignaturas;
        this.profesores = profesores;
        this.aulas = aulas;
        rellenar();
    }

    public Centro( ) {
        this(LibConf.faker.name().firstName(), new ArrayList<Alumno>(), new ArrayList<Grupo>(), new ArrayList<Asignatura>(), new ArrayList<Profesor>(), new ArrayList<Aula>());
    }

    /**
     * Metodo que rellena los arrays de profesores, aulas, grupos, asignaturas y alumnos de forma aleatoria
     */
    private void rellenar(){
        Materias[] materias = Materias.values();
        for (int i = 0; i < 10; i++) {
            this.profesores.add(new Profesor(LibConf.faker.idNumber().validPtNif(), LibConf.faker.name().firstName(), LibRandom.randomFloat(1000, 2001)));
            this.aulas.add(new Aula(LibRandom.randomInt(1, 101)));
        }

        for (int i = 0; i < 10; i++) {
            this.grupos.add(new Grupo(LibConf.faker.idNumber().validPtNif(), LibConf.faker.name().firstName(), aulas.get(LibRandom.randomInt(0, aulas.size()))));
            this.asignaturas.add(new Asignatura(LibConf.faker.idNumber().validPtNif(), materias[LibRandom.randomInt(0, materias.length)].toString(), profesores.get(LibRandom.randomInt(0, profesores.size()))));
        }

        for (int i = 0; i < 10; i++) {
            ArrayList<Asignatura> asignaturasAlumno = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                asignaturasAlumno.add(new Asignatura(LibConf.faker.idNumber().validPtNif(), materias[LibRandom.randomInt(0, materias.length)].toString(), profesores.get(LibRandom.randomInt(0, profesores.size()))));
            }
            this.alumnos.add(new Alumno(LibConf.faker.name().firstName(), grupos.get(LibRandom.randomInt(0, grupos.size())), asignaturasAlumno));
        }

    }

    /**
     * Muestra los alumnos de un profesor
     * @return String con los alumnos de cada profesor
     */
    public String mostrarAlunmosPorPorfesor(){
        if (profesores.isEmpty()){
            return "No hay profesores";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.nombre).append("\n\n");
        for (Profesor profesor : profesores) {
            sb.append("Profesor: ").append(profesor.getNombre()).append(" (" + profesor.getDni()).append(")\n");
            for (Alumno alumno : alumnos){
                for (Asignatura asignatura : alumno.getAsignaturas()){
                    if (asignatura.getProfesor().equals(profesor)){
                        sb.append("\tAlumno: ").append(alumno.getNombre()).append(" (" + alumno.getId()).append(")\n");
                        break;
                    }

                }
            } 
        }

        return sb.toString();
    }

    /**
     * Muestra los alumnos de tpdps los grupo
     * @return String con los alumnos de cada grupo
     */
    public String mostrarAlumnosPorGrupo(){
        if (grupos.isEmpty()){
            return "No hay grupos";
        }
        StringBuilder sb = new StringBuilder();
        for (Grupo grupo : grupos) {
            sb.append("Grupo: ").append(grupo.getNombre()).append(" (" + grupo.getCodigo()).append(")\n");
            for (Alumno alumno : alumnos){
                if (alumno.getGrupo().equals(grupo)){
                    sb.append("\tAlumno: ").append(alumno.getNombre()).append(" (" + alumno.getId()).append(")\n");
                    break;
                }
            } 
        }

        return sb.toString();
    }

    /**
     * Obtener un profesor por su dni
     * @param dni Dni del profesor
     * @return Profesor con el dni pasado por parametro
     */
    public Profesor getProfesor(String dni){
        for (Profesor profesor : profesores) {
            if (profesor.getDni().equals(dni)){
                return new Profesor(profesor);
            }
        }
        return null;
    }

    /**
     * Obtener una lista de profesores
     * @return Lista de profesores
     */
    public List<Profesor> getProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for (Profesor profesor : this.profesores) {
            profesores.add(new Profesor(profesor));
        }
        return profesores;
    }

    /**
     * Obtener una aula por su codigo
     * @param codigo Codigo del aula
     * @return Aula con el codigo pasado por parametro
     */
    public Aula getAula(String codigo){
        for (Aula aula : aulas) {
            if (aula.getCodigo().equals(codigo)){
                return new Aula(aula);
            }
        }
        return null;
    }

    /**
     * Obtener una lista de aulas
     * @return Lista de aulas
     */
    public List<Aula> getAulas() {
        List<Aula> aulas = new ArrayList<>();
        for (Aula aula : this.aulas) {
            aulas.add(new Aula(aula));
        }
        return aulas;
    }
    /**
     * Obtener una asignatura por su codigo
     * @param codigo Codigo de la asignatura
     * @return Asignatura con el codigo pasado por parametro
     */
    public Asignatura getAsignatura(String codigo){
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(codigo)){
                return new Asignatura(asignatura);
            }
        }
        return null;
    }

    /**
     * Obtener una lista de asignaturas
     * @return Lista de asignaturas
     */
    public List<Asignatura> getAsignaturas() {
        List<Asignatura> asignaturas = new ArrayList<>();
        for (Asignatura asignatura : this.asignaturas) {
            asignaturas.add(new Asignatura(asignatura));
        }
        return asignaturas;
    }

    /**
     * Obtener un grupo por su codigo
     * @param codigo Codigo del grupo
     * @return Grupo con el codigo pasado por parametro
     */
    public Grupo getGrupo(String codigo){
        for (Grupo grupo : grupos) {
            if (grupo.getCodigo().equals(codigo)){
                return new Grupo(grupo);
            }
        }
        return null;
    }

    /**
     * Obtener una lista de grupos
     * @return Lista de grupos
     */
    public List<Grupo> getGrupos() {
        List<Grupo> grupos = new ArrayList<>();
        for (Grupo grupo : this.grupos) {
            grupos.add(new Grupo(grupo));
        }
        return grupos;
    }

    /**
     * Obtener un alumno por su id
     * @param id Id del alumno
     * @return Alumno con el id pasado por parametro
     */
    public Alumno getAlumno(String id){
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(id)){
                return new Alumno(alumno);
            }
        }
        return null;
    }

    /**
     * Obtener una lista de alumnos
     * @return Lista de alumnos
     */
    public List<Alumno> getAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        for (Alumno alumno : this.alumnos) {
            alumnos.add(new Alumno(alumno));
        }
        return alumnos;
    }

    /**
     * Añade un alumno al centro
     * @param nombre Nombre del alumno
     * @param codigoGrupo Codigo del grupo del alumno
     * @param codigoAsignaturas Codigo de las asignaturas del alumno
     * @return PARAMETROS_NO_VALIDO si los parametros no son correctos,
     * GRUPO_NO_EXISTENTE si no existe un grupo con ese codigo,
     * ASIGNATURA_NO_EXISTENTE si no existe una asignatura con ese codigo,
     * CORRECTO si se ha añadido correctamente
     */
    public Salida addAlumno(String nombre,String codigoGrupo, String[] codigoAsignaturas){
        if (nombre.isEmpty() || codigoGrupo.isEmpty() || codigoAsignaturas == null || codigoAsignaturas.length == 0){
            return Salida.PARAMETROS_NO_VALIDO;
            
        }
        if (getGrupo(codigoGrupo) == null){
            return Salida.GRUPO_NO_EXISTENTE;
            
        }
        Grupo grupo = getGrupo(codigoGrupo);
        ArrayList<Asignatura> asignaturasAlumno = new ArrayList<>();
        for (String codigoAsignatura : codigoAsignaturas) {
            Asignatura asignatura = getAsignatura(codigoAsignatura);
            if (asignatura == null){
                return Salida.ASIGNATURA_NO_EXISTENTE;
            }
            asignaturasAlumno.add(asignatura);
        }
        alumnos.add(new Alumno(nombre, grupo, asignaturasAlumno));
        return Salida.CORRECTO;
    }

    /**
     * Obtener un grupo por su codigo
     * @param codigo Codigo del grupo
     * @param nombre Nombre del grupo
     * @param codigoAula Codigo del aula del grupo que hace referencia
     * @return PARAMETROS_NO_VALIDO si los parametros no son correctos,
     * GRUPO_EXISTENTE si ya existe un grupo con ese codigo,
     * AULA_NO_EXISTENTE si no existe un aula con ese codigo,
     * CORRECTO si se ha añadido correctamente
     */
    public Salida addGrupo(String codigo, String nombre, String codigoAula){
        if (codigo.isEmpty() || nombre.isEmpty() || codigoAula.isEmpty()){
            return Salida.PARAMETROS_NO_VALIDO;
        } 
        if (getGrupo(codigo) != null || getAula(codigoAula) == null){
            if (getGrupo(codigo) != null){
                return Salida.GRUPO_EXISTENTE;
            }
            return Salida.AULA_NO_EXISTENTE;
            
        }
        grupos.add(new Grupo(codigo, nombre, getAula(codigoAula)));
        return Salida.CORRECTO;
    }

    /**
     * Añade una asignatura al centro
     * @param codigo Codigo de la asignatura
     * @param nombre Nombre de la asignatura
     * @param dniProfesor Dni del profesor de la asignatura
     * @return  PARAMETROS_NO_VALIDO si los parametros no son correctos,
     * ASIGNATURA_EXISTENTE si ya existe una asignatura con ese codigo,
     * PROFESOR_NO_EXISTENTE si no existe un profesor con ese dni,
     * CORRECTO si se ha añadido correctamente
     */
    public Salida addAsignatura(String codigo, String nombre, String dniProfesor){
        if (codigo.isEmpty() || nombre.isEmpty() || dniProfesor.isEmpty()){
            return Salida.PARAMETROS_NO_VALIDO;
        } 
        if (getAsignatura(codigo) != null || getProfesor(dniProfesor) == null){
            if (getAsignatura(codigo) != null){ 
                return Salida.ASIGNATURA_EXISTENTE;
            }
            return Salida.PROFESOR_NO_EXISTENTE;
        }
        asignaturas.add(new Asignatura(codigo, nombre, getProfesor(dniProfesor)));
        return Salida.CORRECTO;
    }

    /**
     * Añade un profesor al centro
     * @param dni Dni del profesor
     * @param nombre Nombre del profesor
     * @param salario Salario del profesor
     * @return  PARAMETROS_NO_VALIDO si los parametros no son correctos, 
     * PROFESOR_EXISTENTE si ya existe un profesor con ese dni,
     * CORRECTO si se ha añadido correctamente
     */
    public Salida addProfesor(String dni, String nombre, float salario){
        if (dni.isEmpty() || nombre.isEmpty() || salario  < 1) {
            return Salida.PARAMETROS_NO_VALIDO;
        }
        if (getProfesor(dni) != null){
            return Salida.PROFESOR_EXISTENTE;
        }
        profesores.add(new Profesor(dni, nombre, salario));
        return Salida.CORRECTO;
    }

    /**
     * Añade un aula al centro
     * @param metros Metros cuadrados del aula
     * @return PARAMETROS_NO_VALIDO si los metros son menores que 1, 
     * CORRECTO si se ha añadido correctamente
     */
    public Salida addAula(int metros){
        if (metros < 1){
            return Salida.PARAMETROS_NO_VALIDO; 
        }
        aulas.add(new Aula(metros));
        return Salida.CORRECTO;
    }

    
}
