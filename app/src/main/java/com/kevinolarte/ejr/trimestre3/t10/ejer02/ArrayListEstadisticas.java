package com.kevinolarte.ejr.trimestre3.t10.ejer02;

import java.util.ArrayList;
import java.util.Collection;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moda'");
    }
    
    
    
} 
