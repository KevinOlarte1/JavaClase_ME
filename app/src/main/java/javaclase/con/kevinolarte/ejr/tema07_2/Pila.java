package javaclase.con.kevinolarte.ejr.tema07_2;

public class Pila<T> {
    private Object[] pila;
    private int tope;

    public Pila(int capacidad) {
        this.pila = new Object[capacidad];
        tope = -1;
    }
    // Metodo para agregar un elemento a la pila
    public void push(T dato) {
        if (tope == pila.length - 1) {
            aumentar();
        }
        pila[++tope] = dato;
        
    }

    // Metodo para sacar un elemento de la pila
    @SuppressWarnings("unchecked")
    public T pop() {
       if (tope == -1) {
            return null;
        } 
        return (T) pila[tope--];
        
    }
    // Metodo para obtener el tamaño de la pila
    public int size() {
        if (tope == -1) 
            return -1;
        return tope + 1;
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    //Metodo privado para aumentar el tamaño de la pila cuando ya este en su capacidad maxima.
    private void aumentar(){
        Object[] nuevaPila = new Object[pila.length * 2];
        for (int i = 0; i < pila.length; i++) {
            nuevaPila[i] = pila[i];
        }
        pila = nuevaPila;
    }
    
}
