package com.kevinolarte.ejr.trimestre3.t10.ejer09;

import com.kevinolarte.lib.LibRandom;

public class JuegoDiccionario {
    private final static int MAX_PLAYER_SAFE= 5;
    private final static int NAME_PLAYER_MATRIZ = 0;
    private final static int SCORE_PLAYER_MATRIZ = 1;

    private final String[][] topJugadores;
    private final IDiccionario diccionario;
    private int jugadoresActualles;

    private int puntajeActual;
    private String palabraGanadora;


    public JuegoDiccionario(IDiccionario diccionario, int maxJugadores){
        this.diccionario = diccionario;
        this.topJugadores = new String[maxJugadores][2];
        this.jugadoresActualles = 0;
        this.puntajeActual = 0;
    }
    public JuegoDiccionario(IDiccionario diccionario){
        this(diccionario, MAX_PLAYER_SAFE);
    }

    /**
     * Metodo para obtener una palarba random del diccionario, sera usada 
     * para intentar adividar la palabra.
     */
    public void sacarNuevaPalabraGanadora(){
        this.palabraGanadora = this.diccionario.getPalabras()[LibRandom.randomInt(0, this.diccionario.getPalabras().length)];
    }

    /**
     * Metodo para obtener la definicion de la palabra ganadora
     * @return String con la definicion de la palabra ganadora
     */
    public String getDefinicionPalabraGanadora(){
        return this.diccionario.getDefinicion(this.palabraGanadora);
    }

    /**
     * Metodo para jugar, se le pide al jugador que adivine la palabra
     * si la adivina se le suma un punto.
     */
    public boolean jugadaUnica(String palabraJugador){
        if (palabraJugador.equals(this.palabraGanadora)) {
            this.puntajeActual++;
            return true;   
        }
        else{
            return false;
        }

    }

    /**
     * Metodo para obtener el puntaje actual del jugador
     * @return int con el puntaje actual del jugador
     */
    public boolean isTopJugadores(){
        // Si el puntaje es 0 no se puede indexar porque no hay puntaje
        if(this.puntajeActual == 0)
            return false;

        // Si hay espacio en el top de jugadores permitir la indexacion automatica
        if (this.jugadoresActualles < this.topJugadores.length) 
            return true;
        
        
        for (int i = 0; i < jugadoresActualles; i++) {
            if (this.puntajeActual > Integer.parseInt(this.topJugadores[i][SCORE_PLAYER_MATRIZ])) {
                return true;
            }
        }
        this.puntajeActual = 0;
        return false;
    }

    /**
     * Metodo para añadir un jugador al top de jugadores
     * @param nombre String con el nombre del jugador
     * @return int con la posicion del jugador en el top de jugadores
     */
    public int addJugador(String nombre){
        if (this.puntajeActual == 0) {
            return -1;
        }
        if (this.jugadoresActualles < this.topJugadores.length) {
            this.topJugadores[this.jugadoresActualles][NAME_PLAYER_MATRIZ] = nombre;
            this.topJugadores[this.jugadoresActualles][SCORE_PLAYER_MATRIZ] = String.valueOf(this.puntajeActual);
            this.jugadoresActualles++;
            this.puntajeActual = 0;
            return this.jugadoresActualles - 1;
            
        }
        //!Importante ordendar la matriz para antes de indexar
        ordendarMatriz();
        System.out.println("Puntaje: " + this.puntajeActual);
        // Si no hay espacio en el top de jugadores indexarlo si es mayor que alguno de los actuales
        for (int i = 0; i < jugadoresActualles; i++) {
            if (this.puntajeActual > Integer.parseInt(this.topJugadores[i][SCORE_PLAYER_MATRIZ])) {
                this.topJugadores[i][NAME_PLAYER_MATRIZ] = nombre;
                this.topJugadores[i][SCORE_PLAYER_MATRIZ] = String.valueOf(this.puntajeActual);
                this.puntajeActual = 0;
                return i;
            }
        }
        this.puntajeActual = 0;
        return -1;
    }

    /**
     * Metodo par ordenar la matriz de los valores ganadores. */ 
    private void ordendarMatriz(){
        for (int i = 0; i < jugadoresActualles; i++) {
            for (int j = 0; j < this.topJugadores[i].length; j++) {
                if (Integer.parseInt(this.topJugadores[i][SCORE_PLAYER_MATRIZ]) > Integer.parseInt(this.topJugadores[j][SCORE_PLAYER_MATRIZ])) {
                    String[] aux = this.topJugadores[i];
                    this.topJugadores[i] = this.topJugadores[j];
                    this.topJugadores[j] = aux;
                }
            }
        }
    }

    public String getTopJugadores(){
        ordendarMatriz();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jugadoresActualles; i++) {
            sb.append(this.topJugadores[i][NAME_PLAYER_MATRIZ] + " - " + this.topJugadores[i][SCORE_PLAYER_MATRIZ] + "\n");
        }
        return sb.toString();
    }
    public int getPuntajeActual() {
        return puntajeActual;
    }


    
}
