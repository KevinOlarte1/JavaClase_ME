package javaclase.con.kevinolarte.ejr.tema07_2;

public class DynamicArray {
    private double valores[];
    private int puntero = 0;
    public DynamicArray(){
        this.valores = new double[10];
        this.puntero = 0;
    }


    /**
     * Metodo para añadir un valor a nuestro array dymaico en la utlima posicion
     * @param value valor añadido
     */
    public void add(double value){
        if(puntero == valores.length)
            incrementar();
        valores[puntero++] = value;
    }
    /**
     * Metodo para añadir un valor a nuestro array dynamico en indice ingresado
     * @param index indice daonde se añadira el valor
     * @param value valor añadido
     * @return booleano que devuelve si se ha podido realizar
     */
    public boolean add(int index, double value){
        if (puntero == valores.length)
            incrementar();
        if (index < 0 || index > puntero)
            return false;
        
        for (int i = puntero; i >= index; i--) {
            valores[i + 1] = valores[i];
        }
        valores[index] = value;
        puntero++;
        return true;
    }
    /**
     * Elimiar un vor por indice
     * @param index indice donde borraremos un valor
     * @return booleano que devuelve si se ha podido realizar
     */
    public boolean remove(int index){
        if (index < 0 || index > puntero )
            return false;
        for (int i = index; i < valores.length; i++) {
            valores[i] = valores[i +1];
        }
        puntero--;
        return true;
    }

    /**
     * Elimiar un valor por valor 
     * @param value valor que se eliminara, la primera ocurrencia.
     * @return booleano que devuelve si se ha podido realizar
     */
    public boolean remove(double value){
        int index;
        boolean encontrado = false;
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] == value) {
                encontrado = remove(i);
                break;
            }
        }
        return encontrado;
    }

    private void incrementar(){
        double valoresNuevos[] = new double[(int)(10 * 1.5)];
        for (int i = 0; i < valores.length; i++) {
            valoresNuevos[i]=  valores[i];
        }
        valores = valoresNuevos;
    }

    /**
     * Obtener un valor por su posicion
     * @param index indice donde obtendremos el valor
     * @return valor del indice correspondiente
     */
    public double get(int index){
        if (index < 0 | index > puntero) 
            return Double.MIN_VALUE;
        return valores[index];
    }

    /**
     * Cambiar un valor de una posicon especifica
     * @param index indice donde se cambiara el valor
     * @param value valor que se intercambiara
     * @return booleano que devuelve si se ha podido realizar.
     */
    public boolean set(int index, double value){
        if (index < 0 | index > puntero) 
            return false;
        valores[index] = value;
        return true;
    }
    
}
