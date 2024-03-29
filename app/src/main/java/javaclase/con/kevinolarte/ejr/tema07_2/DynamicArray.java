package javaclase.con.kevinolarte.ejr.tema07_2;

import java.util.Arrays;

public class DynamicArray {
    private String valores[];
    private int puntero = 0;
    public DynamicArray(){
        this.valores = new String[10];
        this.puntero = 0;
    }


    /**
     * Metodo para añadir un valor a nuestro array dymaico en la utlima posicion
     * @param value valor añadido
     */
    public boolean add(String value){
        if(puntero == valores.length)
            incrementar();
        valores[puntero++] = value;
        return true;
    }
    /**
     * Metodo para añadir un valor a nuestro array dynamico en indice ingresado
     * @param index indice daonde se añadira el valor
     * @param value valor añadido
     * @return booleano que devuelve si se ha podido realizar
     */
    public boolean add(int index, String value){
        if (index < 0 || index > puntero)
            return false;

        if (puntero == valores.length)
            incrementar();
        
        
        for (int i = puntero; i >= index; i--) {
            valores[i] = valores[i -1];
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
    public String remove(int index){
        if (index < 0 || index > puntero )
            return null;
        String valor = valores[index];
        for (int i = index; i < puntero - 1; i++) {
            valores[i] = valores[i +1];
        }
        puntero--;
        return valor;
    }

    /**
     * Elimiar un valor por valor 
     * @param value valor que se eliminara, la primera ocurrencia.
     * @return booleano que devuelve si se ha podido realizar
     */
    public String remove(String value){
        int index;
        String encontrado = null;
        for (int i = 0; i <= puntero; i++) {
            if (valores[i] == value) {
                encontrado = remove(i);
                break;
            }
        }
        return encontrado;
    }

    private void incrementar(){
        String valoresNuevos[] = new String[(int)(10 * 1.5)];
        for (int i = 0; i <= puntero; i++) {
            valoresNuevos[i]=  valores[i];
        }
        valores = valoresNuevos;
    }

    /**
     * Obtener un valor por su posicion
     * @param index indice donde obtendremos el valor
     * @return valor del indice correspondiente
     */
    public String get(int index){
        if (index < 0 | index > puntero) 
            return null;
        return valores[index];
    }

    

    /**
     * Cambiar un valor de una posicon especifica
     * @param index indice donde se cambiara el valor
     * @param value valor que se intercambiara
     * @return booleano que devuelve si se ha podido realizar.
     */
    public boolean set(int index, String value){
        if (index < 0 | index > puntero) 
            return false;
        valores[index] = value;
        return true;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(valores);
        result = prime * result + puntero;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DynamicArray other = (DynamicArray) obj;
        if (!Arrays.equals(valores, other.valores))
            return false;
        if (puntero != other.puntero)
            return false;
        return true;
    }

    
    
}
