package javaclase.con.kevinolarte.ejr.tema07_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javaclase.con.kevinolarte.lib.Input;

public class AnalizadorWeb {
    private final Pila pila;
    private final String texto;

    public AnalizadorWeb(Pila pila, String texto){
        this.texto = texto;
        this.pila = pila;
    }

    public boolean analizar(){
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == '<') {
                //System.out.println("entrar");
                boolean atributo = false;
                for (int j = i; j < texto.length(); j++) {
                     
                    if ((texto.charAt(j) == '"' || texto.charAt(j) == '\'') ) 
                    {
                        atributo = !atributo;
                        //System.out.println("Abrir");
                    }
                    stb.append(texto.charAt(j));
                    if (texto.charAt(j) == '>' && !atributo){
                        //System.out.println("termina");
                        i = j;
                        break;
                    }     
                }
                //System.out.println(i);
                String comparar = eliminarAtributos(stb.toString()).toLowerCase();
                stb.setLength(0);
                    //System.out.println(comparar);
                //Input.scanner.nextLine();
                if (comparar.length() <= 2) {
                        //System.out.println("Pequeño");
                    return false;
                }
                else if (comparar.charAt(1) == '/') {
                    String aux = pila.pop();
                    if(aux == null) {
                        //System.out.println("nulo");
                        return false;
                    }
                        
                    comparar = comparar.substring(2, comparar.length() -1);
                    if (!comparar.equals(aux))
                    {
                            //System.out.println("Valor de la pila: " + aux + " Valor encotrado: " + comparar);
                        return false;
                    }
                        
                }
                else if (comparar.charAt(comparar.length() -2) != '/'){
                    comparar = comparar.substring(1, comparar.length() -1).toLowerCase();
                        // System.out.println("Push: " + comparar);
                    pila.push(comparar);
                }
                

                
            }

        }
        return pila.isEmpty();
    }
    public static String eliminarAtributos(String etiquetaHTML) {
       
        //Buscamos los atributos
        String etiquetaSinAtributos = etiquetaHTML.replaceAll("\\s+([a-zA-Z][a-zA-Z0-9_-]*)\\s*=\\s*\"[^\"]*\"", "");
        etiquetaSinAtributos = etiquetaSinAtributos.replaceAll("\\s+", "");
        return etiquetaSinAtributos;
    }
}
