package javaclase.con.kevinolarte.ejr.tema08;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculadora implements ActionListener {
    private JFrame frame;
    private JTextField texto;
    private JButton numeroBotones[];
    private JButton funcionalBotones[];
    private JButton limpiarBoton;
    private JPanel panel;
    private Toolkit toolkit;
    private Dimension dimension;
    private int width;
    private int height;
    private int x;
    private int y;
    public Calculadora(){
        frame = new JFrame("Calculadora");
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        
        width = 420;
        height = 550;
        numeroBotones = new JButton[10];
        funcionalBotones = new JButton[6];

        x = (int)(dimension.getWidth() / 2f) - Math.round(width / 2f);
        y = (int)(dimension.getHeight() / 2f) - Math.round(height / 2f);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(x, y, width, height);
        frame.setLayout(null);
        
        texto = new JTextField("asd");
        texto.setBounds(25, 20, width - 50, 50);
        texto.setEditable(false);


        funcionalBotones[0] = new JButton("+");
        funcionalBotones[1] = new JButton("-");
        funcionalBotones[2] = new JButton("*");
        funcionalBotones[3] = new JButton("/");
        funcionalBotones[4] = new JButton(".");
        funcionalBotones[5] = new JButton("=");

        for (int i = 0; i < funcionalBotones.length; i++) {
            funcionalBotones[i].addActionListener(this);
            funcionalBotones[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(25, 100, width - 50, height - 150);
        panel.setLayout(new GridLayout(4,4, 5, 5));

        for (int i = 0; i < numeroBotones.length; i++) {
            numeroBotones[i] = new JButton(String.valueOf(i));
            numeroBotones[i].addActionListener(this);
            numeroBotones[i].setFocusable(false);
            panel.add(numeroBotones[i]);

        }
        panel.add(new JButton("="));
        panel.add(new JButton("Borrar"));
        
        
    
        

        


        frame.add(panel);
        frame.add(texto);
        frame.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}

}
