package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad08;

import java.util.Random;

import java.lang.Character;

public class Cryptographia {
    
    public static String encryptar(String palabra){
        Random rnd = new Random(palabra.length());
        int numero;
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            numero = rnd.nextInt(palabra.length());
            char caracter = palabra.charAt(i);

            // Verificar si el carácter es una letra del alfabeto   
            if (Character.isLetter(caracter)) {
                
                int asciiCode = caracter;

                if (Character.isUpperCase(caracter)) {
                    asciiCode = ((asciiCode - 65 + numero) % 26) + 65;
                } else {
                    asciiCode = ((asciiCode - 97 + numero) % 26) + 97;
                }
                resultado.append((char)asciiCode);
            }
            resultado.append(caracter);

        }
        return resultado.toString();
         
    }

    public static String desencryptar(String palabra){
        Random rnd = new Random(palabra.length());
        int numero;
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            numero = rnd.nextInt(palabra.length());
            char caracter = palabra.charAt(i);

            // Verificar si el carácter es una letra del alfabeto   
            if (Character.isLetter(caracter)) {
                
                int asciiCode = caracter;

                if (Character.isUpperCase(caracter)) {
                    asciiCode = ((asciiCode - 65 + numero) % 26) + 65;
                } else {
                    asciiCode = ((asciiCode - 97 + numero) % 26) + 97;
                }
                resultado.append((char)asciiCode);
            }
            resultado.append(caracter);

        }
        return resultado.toString();
         
    }
    public static String cesar(String texto, int numero){
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            // Verificar si el carácter es una letra del alfabeto   
            if (Character.isLetter(caracter)) {
                
                int asciiCode = caracter;

                if (Character.isUpperCase(caracter)) {
                    asciiCode = ((asciiCode - 65 + numero) % 26) + 65;
                } else {
                    asciiCode = ((asciiCode - 97 + numero) % 26) + 97;
                }
                resultado.append((char) asciiCode);
            }
            resultado.append(caracter);
        }
        return resultado.toString();
    }
}
