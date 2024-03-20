package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad06;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Controlador implements ActionListener {
    private Modelo modelo;
    private Vista vista;
    public Controlador(Vista vista){
        this.modelo = new Modelo();
        this.vista = vista;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.resolver(vista.getAltura(), vista.getPeso());
        vista.getResultado().setText("IMC: " + modelo.getImc() + " (" + modelo.getClasificacion().toString() + ")");
        
    }
    
}
