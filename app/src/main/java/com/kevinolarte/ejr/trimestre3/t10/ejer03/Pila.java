package com.kevinolarte.ejr.trimestre3.t10.ejer03;

import java.util.ArrayList;
import java.util.EmptyStackException;

import org.checkerframework.checker.units.qual.t;


public class Pila<T> implements IPila<T>{
    private ArrayList<T> pila;
    
    public Pila(int lenghts){
        pila = new ArrayList<>(lenghts);
    }

    
    public T push(T item) {
        pila.add(item);
        return item;
    }
    /**
     * Elimina el elemento en la cima de la pila y lo devuelve.
     * @throws EmptyStackException si la pila está vacía
     */
    @Override
    public T pop() throws EmptyStackException {
        if(size() == 0){
            throw new EmptyStackException();
        }
        return pila.remove(pila.size() - 1);
    }

    /**
     * Devuelve el número de elementos en la pila.
     */
    @Override
    public int size() {
        return pila.size();
    }

    @Override
    public T top() throws EmptyStackException {
        if(size() == 0){
            throw new EmptyStackException();
        }
        return pila.get(pila.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return pila.isEmpty();
    }
    
}
