package javaclase.con.kevinolarte.ejr.tema07_2;

public class AnalizadorTexto {
    private final Pila<String> pila;
    private final String texto;
    public AnalizadorTexto(Pila pila, String texto) {
        this.pila = pila;
        this.texto = texto;
    }
    public boolean correctorCodigo(){
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i ) == '(' || texto.charAt(i)  == '{' || texto.charAt(i) == '[') 
                pila.push(String.valueOf(texto.charAt(i)));
            else if (texto.charAt(i ) == ')' || texto.charAt(i)  == '}' || texto.charAt(i) == ']') {
                if(pila.isEmpty())
                    return false;
                String aux = pila.pop();

                if (texto.charAt(i) == '(' && !aux.equals(")")) 
                    return false;
                if (texto.charAt(i) == '{' && !aux.equals("}")) 
                    return false;
                if (texto.charAt(i) == '[' && !aux.equals("]"))
                    return false; 
            }
        }
        return pila.isEmpty();
    
    }
}
