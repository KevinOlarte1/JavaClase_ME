package com.kevinolarte.ejr.trimestre3.t10.ejer02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadisticas{
    private static final int DEFAULT_VALUE = 10;

    public ArrayListEstadisticas(){
       this(DEFAULT_VALUE);
    }

    public ArrayListEstadisticas(int capacidad){
        super(capacidad);
    }

    public ArrayListEstadisticas(Collection c){
        super(c);
    }

    @Override
    public double minimo() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < size(); i++) {
            if (min > get(i)) {
                min = get(i);
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = Double.MIN_NORMAL;
        for (int i = 0; i < size(); i++) {
            if (max < get(i)) {
                max = get(i);
            }
        }
        return max;
    }

    @Override
    public double sumatorio() {
        double sum = 0;

        for (int i = 0; i < size(); i++) {
            sum += get(i);
        }
        return sum;
    }

    @Override
    public double media() {
        double sum = 0;

        for (int i = 0; i < size(); i++) {
            sum += get(i);
        }
        return sum / size()-1;
    }

    @Override
    public double moda() {
        String[] valores = new String[size()];
        for (int i = 0; i < size(); i++) {
            valores[i] = String.valueOf(get(i));
        }
       
        int contMax = 0;
        double valorMax = 0;

        int contMed = 0;
        double valorMed = 0;
        for (int i = 0; i < valores.length; i++) {
            valorMed = Double.parseDouble(valores[i]);
            for (int j = i; j < valores.length; j++) {
                if (valores[i].equals(valores[j])) {
                    contMed++;
                }
            }
            if (contMed > contMax) {
                contMax = contMed;
                valorMax = valorMed;
            }
                        
        }
        return valorMax;

        
    }

    public double moda2(){
        HashMap<Double, Integer> has = new HashMap<>();
        int maxReps = 0;
        double valorMasRepetido = 0;
        for (int i = 0; i < size(); i++) {
            double numero = get(i);
            int valor = 0;
            Integer reps = has.get(numero);
            
            if (reps != null) {
                valor += i; 
            }

            if (maxReps < reps) {
                valorMasRepetido = get(i);
                maxReps = reps;
            }
            has.put(numero, valor);
        }

        return valorMasRepetido;
    }
    
    
    
} 
