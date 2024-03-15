package javaclase.con.kevinolarte.ejr.tema08.actividades;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Actv03 {
    private JFrame frame;
    private JLabel texto;
    public Actv03() {
        frame = new JFrame("Hola Swing");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        texto = new JLabel
        ("HBienvenidoal mundo de las interfaces graficas");
        texto.setBounds(20, 20, 500, 30);
        
        frame.getContentPane().add(texto);

        
        frame.setLayout(null);
        frame.setVisible(true);

        
        
    }
   
}