package com.kevinolarte.ejr.trimestre3.t10.ejer05;

import java.time.LocalDate;

import com.kevinolarte.ejr.trimestre3.t10.ejer05.enums.Genero;
import com.kevinolarte.ejr.trimestre3.t10.ejer05.enums.Imc;
import com.kevinolarte.lib.LibConf;
import com.kevinolarte.lib.LibRandom;

public class Centro implements ICentroEstadistica<Paciente>{
    private final Paciente pacientes[];
    private int pacienteActual;

    public Centro(int numPacientes){
        this.pacientes = new Paciente[numPacientes];
        this.pacienteActual = 0;
    }
    public Centro(int numPacientes, int generarPacientes){
        if (numPacientes <= generarPacientes) 
            throw new IndexOutOfBoundsException();
        this.pacientes = new Paciente[numPacientes];
        this.pacienteActual = generarPacientes;
        generarPacientes(generarPacientes);

        
    }

    private void generarPacientes(int num){
        for (int i = 0; i < num; i++) {
            int rnd = LibRandom.randomInt(0, 2);
            String valor = LibConf.faker.date().birthday(18, 65).toString().substring(0,10);
            LocalDate date = LocalDate.parse(valor);
            Genero genero = rnd == 1? Genero.Hombre: Genero.Mujer; 
            //Crar un paciente con nombre, fecha de nacimiento, genero, peso y altura aleatorio
            pacientes[i] = new Paciente(
                LibConf.faker.name().firstName(), 
                date, 
                genero, 
                LibRandom.randomInt(10,100), 
                LibRandom.randomInt(10, 20));
            }
    }
    
    /**
     * Metodo para obtener la posicion de los dos pacientes con la mayor y menor edad
     * @param pacientes array de los pacientes donde se buscara
     * @return devuelve un array con un int de dos posiciones la primera la minima edad y la otra la maxima edad
     * @throws EmptyPacientArray salta cunado no tienes pacientes en el centro
     */
    @Override
    public int[] mayorMenor(Paciente[] pacientes)throws EmptyPacientArray{
        if (pacienteActual == 0) {
            throw new EmptyPacientArray("You don't have any patients");
        }
        int nums[] = new int[2];
        nums[0] = 0;
        nums[1] = 0;
        for (int i = 1; i < pacienteActual; i++) {
            if ( pacientes[i].getFechaNacimiento().isAfter(pacientes[nums[0]].getFechaNacimiento())) {
                nums[0] = i;
            }
            else if(pacientes[i].getFechaNacimiento().isBefore(pacientes[nums[1]].getFechaNacimiento())){
                nums[1] = i;
            }
        }
        return nums;


    }
    /**
     * Optener la cantidad de Hombres y mujes hay en centro
     * @param paciemtes pacientes donde se mirara el genero
     * @return la cantidad de hombres y mujeres que hay.
     */
    @Override
    public int[] pacientsPorSexo(Paciente[] pacientes) {
        int genero[] = new int[2];
        for (int i = 0; i < pacienteActual; i++) {
            if (pacientes[i].getGenero() == Genero.Hombre) {
                genero[0]++;
            }
            else
                genero[1]++;
        }
        return genero;
    }

    /**
     * Calcular el imc de un paciente
     * @param paciente paciente que se calculara el imc
     * @return el imc del paciente
     * @throws ArithmeticException si la altura del paciente es .
     */
    @Override
    public double indiceMasaCorporal(Paciente paciente) throws ArithmeticException {
        if (paciente.getAlturaM() == 0) {
            throw new ArithmeticException();
        }
        return (paciente.getPesoKg()/ (paciente.getAlturaM() * paciente.getAlturaM()));
    }
    
    /**Metdo para calcualr la edad de un paciente */
    @Override
    public int calcularEdadPaciente(Paciente paciente) {
        return paciente.getEdad();
    }
    
    /**
     * Muestra un infrome de el imc de toods los pacientes
     * @param pacientes pacientes de los que se informaran
     * @return string con el ingforme
     */
    @Override
    public String mensajeMasaCorporal(Paciente[] pacientes){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pacienteActual; i++) {
            Paciente paciente = pacientes[i];
            sb.append("Paciente " + paciente.getId() + ": " + paciente.getNombre() + " - ");
            double imc = indiceMasaCorporal(paciente);
            if (imc < 18.5) {
                sb.append(Imc.PESO_INSUFICIENTE + "\n");
            } else if (imc < 24.9) {
                sb.append(Imc.PESO_NORMAL + "\n");
            } else if (imc < 26.9) {
                sb.append(Imc.SOBREPESO_GRADO_I + "\n");
            } else if (imc < 29.9) {
                sb.append(Imc.SOBREPESO_GRADO_II + "\n");
            } else {
                sb.append(Imc.SOBREPESO_GRADO_III + "\n");
            }
        }

        return sb.toString();
    }
    
    public Paciente[] getPacientes() {
        return pacientes;
    }
    public int getPacienteActual() {
        return pacienteActual;
    }
    


}
