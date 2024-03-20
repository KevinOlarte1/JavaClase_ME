package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad07;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class ContoladorJuego implements ActionListener{
    private final VistaJuego vista;
    private final ModeloJuego modelo;
    
    public ContoladorJuego(VistaJuego vista){
        this.vista = vista;
        this.modelo = new ModeloJuego();
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton boton = getButton(e);
        Elemento elementoJugador = getElemento(boton.getClientProperty("opcion"));
        modelo.jugar(elementoJugador);

        vista.getLabelPuntuacionJugador().setText("Jugador: " + modelo.getPuntosJugador());
        vista.getLabelPuntuacionCPU().setText("CPU: " + modelo.getPuntuacionCpu());
        vista.mostrarVentana("El Jugador saco :" + elementoJugador + "\n    La CPU saco :" + modelo.getJugadaCpu(), modelo.getJugadaCpu());
    
    }

    private JButton getButton(ActionEvent e){
        if (e.getSource() instanceof JButton) {
            return (JButton) e.getSource();
        }
        return null;
    }

    private Elemento getElemento(Object a){
        if (a instanceof Elemento) {
            return (Elemento) a;
        }
        return null;
        
    }

    
}
