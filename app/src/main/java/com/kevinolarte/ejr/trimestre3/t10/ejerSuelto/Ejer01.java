package com.kevinolarte.ejr.trimestre3.t10.ejerSuelto;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import com.kevinolarte.lib.LibArray;

public class Ejer01 {
    
    public Ejer01(){

        int[] nums = LibArray.randomEnteros(10, 0, 50);
        
        ArrayList<Integer> numreos =  (ArrayList<Integer>) paresPrimeros(nums);

        System.out.println(numreos.toString());
    }

    /**
     * metodo para devilver los numeros pares primero y luego los impares
     * @param num lista de numeros desordenados
     * @return devuelve una Lista ordendado por pares e imparres extremo a extremo
     */
    public  List<Integer> paresPrimeros(int num[]){
        if (num == null) {
            return null;
        }
        
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            numeros.add(0);
        }
        int contPares = 0;
        int contImpa = num.length -1;
        System.out.println(contImpa);
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                numeros.set(contPares++, num[i]);
            }
            else
                numeros.set(contImpa--, num[i]);
        }

        return numeros;
    }
   
}
