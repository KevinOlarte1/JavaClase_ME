package com.kevinolarte.ejr.trimestre3.t10.ejer03;

public interface IPila<T> {
    T push(T item);
    T pop();
    int size();
    T top();
    boolean isEmpty();
}
