package javaclase.con.kevinolarte.ejr.tema07_2;
import java.util.Stack;

import net.datafaker.providers.entertainment.Tron.Character;
import javaclase.con.kevinolarte.lib.Comprobate;

public class CalculadoraPolacaInversa {
   
    //Calcula usando las expersiones 
    public double calcular(String expresion) {
        String[] valores = expresion.split(" ");
        PilaDouble pila = new PilaDouble(5);
    
        for (String valor : valores) {
            if (pila.size() == 1 && !Comprobate.comprobarNumerRealPositivo(valor)) {
                return Double.POSITIVE_INFINITY;
            }
            switch (valor) {
                case "+":
                    pila.push(pila.pop() + pila.pop());
                    break;
                case "-":
                    double substraendo = pila.pop();
                    pila.push(pila.pop() - substraendo);
                    break;
                case "*":
                    pila.push(pila.pop() * pila.pop());
                    break;
                case "/":
                    double divisor = pila.pop();
                    pila.push(pila.pop() / divisor);
                    break;
                default:
                    pila.push(Double.parseDouble(valor));
            }
        }
    
        return pila.pop();
    }
   
}