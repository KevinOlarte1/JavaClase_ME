package javaclase.con.kevinolarte.lib;

//import com.google.common.base.Objects;

public class Arrayss {

     
    /**
     * Generar numeros Random para un array.
     * @param array array donde se generara los numeros random
     */
    public static void randomArray(int[] array, int num){
        for (int i = 0; i < array.length; i++) {
            array[i] = Randmos.rnd.nextInt(1, num); 
        }
    }

    /**
     * Metodo para visualizar el contenido de la lista de enteros int
     * @param lista
     */
    public static void visualitzarArrayInt(int [] lista){
        for (int i : lista) {
            System.out.println(i);
        }
    }

    /**
     * Metodo para añdir valores random a u array te tipo int
     * @param array array donde se le podra los valores
     * @param min valor minimo del ingreso en el array
     * @param max valor maximo del ingreso en el array
     */
    public static void randomArrayEnteros(int [] array, int min, int max){
        for (int i = 0; i < array.length; i++) {
            array[i] = Randmos.rnd.nextInt(min, max);
        }
    }

    /**
     * Metodo para obtener un array contando las veces que toca el num 
     * @param nums array dodne se buscara los numeros
     * @param max numero maximo que puede tener el array.
     * @return array con las veces que se repite un numero.
     */
    public static int[] ArrayCountingShort (int nums[], int max){
        int numReps[] = new int[max];
        for (int i : nums) {
            numReps[i]++;
        }
        return numReps;
    }
    /**
     * Metodo para ordeanr el array de menor a mayor
     * @param num array donde se haran los cambios
     */
    public static void ordenarArrayMenorMayor(int num[]){
        int tmp = 0;
        for (int i = 0; i < num.length-1; i++) {
            for (int j = i+1; j < num.length; j++) {
                if(num[i] > num[j]){
                    tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
            
        }
    }

    /**
     * Metodo para ordenar el array de mayor a menor
     * @param num array donde se haran los cambios
     */
    public static void ordenarArrayMayorMenor(int num[]){
        int tmp = 0;
        for (int i = 0; i < num.length-1; i++) {
            for (int j = i+1; j < num.length; j++) {
                if(num[i] < num[j]){
                    tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
            
        }
    }

    /**
     * Metodo para verificar si un array esta ordenado, si esta ordenador 
     * devuelve 0, sino devuelve la posición del primer numero encontrado.
     * @param nums array donde se buscara
     * @return devuelve -2 si hay error, -1 si esta todo correcto,
     *  num positivo si encuentra un numero no en su posición.
     */
    public static int verificarOrdenarMenorMayor(int nums[]){
        if (nums == null || nums.length < 2) 
            return -2;

        int pointx;
        int pointz;
        
        for (int i = 0; i < nums.length - 1; i++) {
            pointx = i;
            pointz = i +1;

            if (nums[pointx] > nums[pointz])     
                return pointx;
        }
        return -1;
    }

}