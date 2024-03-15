package javaclase.con.kevinolarte.ejr.tema08.actividades.Actividad05;

import java.util.Random;
import javax.swing.*;
public class AdivinarNumero {
    private static final int MAX_ATTEMPTS = 5;
    public int numIntentos = MAX_ATTEMPTS;
    public int numAdivinar;

    public AdivinarNumero() {
        reinicar();
    }

    public void reinicar() {
        numIntentos = MAX_ATTEMPTS;
        numAdivinar = new Random().nextInt(101);
    }

    public int intentoAdivinar(int guess) {
        if (guess == numAdivinar) {
            return 0; // Ganas
        } else {
            numIntentos--;
            if (numIntentos == 0) {
                return -1; // Pierdes
            } else {
                return 1; // El juego continua
            }
        }
    }