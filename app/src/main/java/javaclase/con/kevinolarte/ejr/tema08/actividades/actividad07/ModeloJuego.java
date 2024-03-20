package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad07;

import javaclase.con.kevinolarte.ejr.tema08.calcProfe.Calculadora.Estado;
import java.util.Random;

public class ModeloJuego {
    private final static int PUNTOS_GANAR_DEFAULT = 5;
    private final Elemento[] elementos;
    private final Random rnd;
    private final Elemento[][] diagramaEstados;
    private Elemento jugadaJugador;
    private Elemento jugadaCpu;
    private int puntosJugador;
    private int puntuacionCpu;

    public ModeloJuego(){
        this.elementos = Elemento.values();
        this.rnd = new Random();
        this.puntosJugador = 0;
        this.puntuacionCpu = 0;
        //! Un diagrama de combate. Ultima posicon representa el empate con esa jugada.
        this.diagramaEstados = new Elemento[][]{ 
            {Elemento.TIJERAS, Elemento.PIEDRA},
            {Elemento.PIEDRA, Elemento.PAPEL},
            {Elemento.PAPEL, Elemento.TIJERAS}
        }; 
    }

    /**
     * Metodo para jugar Piedra papel o tujeras
     * @param jugadaJugador jugada del jugador.
     */
    public void jugar(Elemento jugadaJugador){
        if (puntosJugador == PUNTOS_GANAR_DEFAULT || puntuacionCpu == PUNTOS_GANAR_DEFAULT) {
            reset();
        }
        this.jugadaJugador = jugadaJugador;
        this.jugadaCpu = generarJugada();
        int jugadaJugadorPos = -1;
        for (int i = 0; i < elementos.length; i++) {
            if (jugadaJugador == elementos[i]) {
                jugadaJugadorPos = i;
            }
        }
        
        if (jugadaJugadorPos == -1){
            System.exit(1);
        }

        boolean x = true;

        //x representa si es empate que no le de puntos a la COPU
        //Recorre el diagrama para ver si se encuentre significa que le gana o empate
        for (int i = 0; i < diagramaEstados[jugadaJugadorPos].length; i++) {
            if (diagramaEstados[jugadaJugadorPos][i] == jugadaCpu) {
                x = false;
                if (i == diagramaEstados[jugadaJugadorPos].length -1) 
                    break;  
                puntosJugador++;
                break;      
            }
        }
        
        if (x) {
            puntuacionCpu++;
        }
        System.out.println(Conf.ANSI_RED);
        System.out.println("PuntosJugador: " + puntosJugador);
        System.out.println("PuntCPU:" + puntuacionCpu);
        System.out.println(Conf.ANSI_RESET);
        
    }

    /**
     * Metodo para restablecer todo a 0
     */
    private void reset(){
        this.puntosJugador = 0;
        this.puntuacionCpu = 0;
    }


    /**
     * Metodo para generar la jugada de la CPU
     * @return deuvelve la jugada
     */
    private Elemento generarJugada(){
        int valor = rnd.nextInt(0, elementos.length);
        return elementos[valor];
    }

    public int getPuntosJugador() {
        return puntosJugador;
    }

    public int getPuntuacionCpu() {
        return puntuacionCpu;
    }

    public Elemento getJugadaCpu() {
        return jugadaCpu;
    }
    

}
