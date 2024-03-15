package javaclase.con.kevinolarte.ejr.tema08.actividades;

import javax.swing.*;

public class Actv02 {
    private JFrame frame;
    private JTextField texto;
    public Actv02() {
        System.out.println("actv01");
        frame = new JFrame("Hola Swing");
        texto = new JTextField("HBienvenidoal mundo de las interfaces graficas");
        frame.setSize(800, 600);
        
        frame.setVisible(true);

        frame.getContentPane().add(texto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
