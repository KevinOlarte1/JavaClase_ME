package javaclase.con.kevinolarte.ejr.tema07_2;

import java.util.ArrayList;

public class GenericPila<T> {
    private ArrayList<T> lista;
    public GenericPila() {
    lista = new ArrayList<>();
    }
    public T push(T e) {
    lista.add(e);
    return e;
    }
    public T pop() {
    T e = top();
    lista.remove(lista.size()-1);
    return e;
    }
    public int size() {
    return lista.size();
    }
    public T top() {
    return lista.get(lista.size()-1);
    }
    public boolean isEmpty() {
    return lista.isEmpty();
    }
    public String toString() {
    return lista.toString();
    }
    }
