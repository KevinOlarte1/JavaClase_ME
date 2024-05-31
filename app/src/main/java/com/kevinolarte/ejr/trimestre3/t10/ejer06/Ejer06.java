package com.kevinolarte.ejr.trimestre3.t10.ejer06;

import com.kevinolarte.lib.LibConf;
import com.kevinolarte.lib.LibInput;
import com.kevinolarte.lib.LibMenu;

public class Ejer06 {
    private final ITraductor traductor;

    public Ejer06(ITraductor traductor){
        this.traductor = traductor;
        start();
    }
    public Ejer06(){
        this(new TraductorVI());
        
    }

    public void start(){
        int ingreso = 0;
        do{
            LibMenu.print(new String[]{"Menu Principal", "Introducir pareja de palabras", "Traduce"});
            ingreso = LibInput.pedirIntPositivo("Elije una de las opciones: ");
            switch (ingreso) {
                case 1:
                    ingresarPalabras();
                    break;
            
                case 2:
                    traducir();
                    break;
                case 0:
                    System.out.println("Saliendo....");
                    break;
                default:
                    System.out.println("Valor no valido");
                    break;
            }
        }while(ingreso != 0);
    }

    public void ingresarPalabras(){
        int ingreso = 0;
        do{
            ingreso = LibInput.pedirIntPositivo("Ingresa la cantidad de palabras que quieres ingresar palabras");
        }while(ingreso == 0);
        String valenciano;
        String ingles;
        for (int i = 0; i < ingreso; i++) {
            valenciano = LibInput.pedirTexto("Intruduce la palabra en valencino");
            ingles = LibInput.pedirTexto("Ingresa la palabra en ingles");

            traductor.colocar(valenciano, ingles);
        }
    }

    public void traducir(){
        String palabra = LibInput.pedirTexto("Buscar palabra - Valencino");

        System.out.println(traductor.traducir(palabra));
        LibConf.sleep();
    }
    
}
