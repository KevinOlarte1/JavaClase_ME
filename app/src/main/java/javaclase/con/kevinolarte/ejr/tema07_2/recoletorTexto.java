package javaclase.con.kevinolarte.ejr.tema07_2;

import java.util.Scanner;

public class recoletorTexto {
    private final String texto;
    public recoletorTexto(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stb = new StringBuilder();

        while (scanner.hasNext()) {
            stb.append(scanner.nextLine()).append(" ");   
        }
        String texto  = stb.toString();
        this.texto = texto.replaceAll("\\s+", " ");
        
    }
    public String getTexto() {
        return texto;
    }

    
}
