package com.kevinolarte.ejr.trimestre3.t10.ejer05;

public interface ICentroEstadistica<T> {

    int[] mayorMenor(T[] pacientes);
    int[] pacientsPorSexo(T[] pacientes);
    double indiceMasaCorporal(T pacientes);
    int calcularEdadPaciente(T paciente);
    String mensajeMasaCorporal (T[] pacientes);
}
