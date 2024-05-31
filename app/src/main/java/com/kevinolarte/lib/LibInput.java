package com.kevinolarte.lib;

import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LibInput {
    //TODO: Implementar metodos para la entrada de datos.
    public static final Scanner scanner = new Scanner(System.in);


    /**
     * Metodo para pedir un numero HEXADECIMAL
     * @param mensaje Mensaje que mostrara por pantalla
     * @return devuelve un String de un HEXADECIMAL
     */
    public static String pedirHexadecimal(String mensaje){
        mensaje = mensaje.equals(" ") ? "Ingresa un numero hexadecimal." : mensaje; 
        String resultado = "";
        boolean valido  = false;

        do{
            try {
                System.out.println(mensaje);
                resultado = scanner.nextLine();
                Integer.parseInt(resultado, 16); // Intenta parsear la entrada como un número hexadecimal
                valido = true; // Marcar la entrada como válida si no se lanzó una excepción
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero hexadecimal valido");
            }
        }while(!valido);

        return resultado;
    }

    /**
     * Metodo para pedir un double
     * @param mensaje mensaje que mostrara por pantalla
     * @return deuvele un double
     */
    public static double pedirDouble(String mensaje){
        mensaje = mensaje.equals(" ") ? "Ingresa un numero decimal, positivo o negativo." : mensaje; 
        double resultado = 0;
        boolean valido  = false;

        do{
            System.out.println(mensaje);
            try {
                resultado = Double.parseDouble(scanner.nextLine());
                valido  = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese numeros no letras");
            }
            
        }while(valido);
        

        return resultado;
    }

    /**
     * metodo para pedir un numero long
     * @param mensaje mensaje que mostrara por pantalla
     * @return deuvelve un long
     */
    public static long pedirLong(String mensaje){
        mensaje = mensaje.equals(" ") ? "Ingresa un numero entero, positivo o negativo." : mensaje; 
        long resultado = 0;
        boolean valido  = false;

        do{
            System.out.println(mensaje);
            try {
                resultado = Long.parseLong(scanner.nextLine());
                valido  = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese numeros no letras");
            }
            
        }while(valido);
        

        return resultado;
    }

    /**
     * Metodo para pedir texto
     * @param mensaje mensaje que mostrara por pantalla
     * @return devuelve un String
     */
    public static String pedirTexto(String mensaje){
        mensaje = mensaje.equals(" ") ? "Ingresa un texto." : mensaje;
        boolean valido  = false;
        String resultado = "";

        do{
            System.out.println(mensaje);
            resultado = scanner.nextLine();
            if (resultado.isEmpty()) {
                System.out.println("No se permiten campos vacios");
                continue;
            }
            valido = true;
        }while(!valido);

        return resultado;
    }

    /**
     * Meoto para pedir un intero
     * @param mensaje mensaje que mostrara para solicitarlo
     * @return devuelve enterp
     */
    public static int pedirInt(String mensaje){
        
        mensaje = mensaje == " " ? "Ingresa un numero entero, positivo o negativo." : mensaje; 
        int resultado = 0;
        boolean valido  = false;

        do{
            System.out.println(mensaje);
            try {
                resultado = Integer.parseInt(scanner.nextLine());
                valido  = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese numeros no letras");
            }
            
        }while(!valido);
        

        return resultado;
    }

    public static int pedirIntPositivo(String mensaje){
        
        mensaje = mensaje == " " ? "Ingresa un numero entero positivo" : mensaje; 
        int resultado = 0;
        boolean valido  = false;

        do{
            System.out.println(mensaje);
            try {
                resultado = Integer.parseInt(scanner.nextLine());
                System.out.println("-------");
                if (resultado < 0) {
                    valido = false;
                }
                else
                    valido  = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese numeros no letras");
            }
            
        }while(!valido);
        

        return resultado;
    }


    /**
     * Metodo para pedir una fecha
     * @param mensaje mensaje que mostrara por pantalla
     * @return devuelve un Date
     */
    public static Date pedirFecha(String mensaje){
        mensaje = mensaje.equals(" ") ? "Ingresa una fecha." : mensaje;
        boolean valido  = false;
        Date resultado = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        do{
            System.out.println(mensaje);
            String fecha = scanner.nextLine();
            try {
                resultado = sdf.parse(fecha);
                valido = true;
            } catch (Exception e) {
                System.out.println("Ingrese una fecha valida");
            }
        }while(!valido);

        return resultado;
        
    }

    /**
     * Metodo para pedir un numero float
     * @param mensaje mensaje que mostrara por pantalla
     * @return devuelve un float
     */
    public static float pedirFloat(String mensaje){
        mensaje = mensaje.equals(" ") ? "Ingresa un numero decimal, positivo o negativo." : mensaje; 
        float resultado = 0;
        boolean valido  = false;

        do{
            System.out.println(mensaje);
            try {
                resultado = Float.parseFloat(scanner.nextLine());
                valido  = true;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese numeros no letras");
            }
            
        }while(!valido);
        

        return resultado;
    }

    /**
     * Metodo para pedir un boolean
     * @param mensaje mensaje que mostrara por pantalla
     * @return devuelve un boolean
     */
    public static boolean pedirBoolean(String mensaje){
        mensaje = mensaje.equals(" ") ? "Ingresa un booleano." : mensaje; 
        boolean resultado = false;
        boolean valido  = false;

        do{
            System.out.println(mensaje);
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("si") || entrada.equalsIgnoreCase("s") || entrada.equalsIgnoreCase("true") || entrada.equalsIgnoreCase("verdadero")) {
                resultado = true;
                valido = true;
            } else if (entrada.equalsIgnoreCase("no") || entrada.equalsIgnoreCase("n") || entrada.equalsIgnoreCase("false") || entrada.equalsIgnoreCase("falso")) {
                resultado = false;
                valido = true;
            } else {
                System.out.println("Ingrese si o no");
            }
        }while(!valido);

        return resultado;
    }
}
