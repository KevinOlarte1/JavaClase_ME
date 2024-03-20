package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad07;

import java.awt.*;
import javax.swing.*;

public class VistaJuego extends JFrame {
    
    private JLabel labelResultado;
    private JLabel labelPuntuacionJugador;
    private JLabel labelPuntuacionCPU;
    private int puntuacionJugador = 0;
    private int puntuacionCpu = 0;
    
     
    public VistaJuego(){
        Boton textoBotones[] ={ new Boton("Piedra", Elemento.PIEDRA), 
                                new Boton("Papel", Elemento.PAPEL),
                                new Boton("Tijeras", Elemento.TIJERAS)};
        JButton botones[] = new JButton[textoBotones.length];

        setTitle("Juego Piedra, Papel o Tijera");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3));

        ContoladorJuego controlador = new ContoladorJuego(this);
        for (int i = 0; i < botones.length; i++) {
            Boton boton = textoBotones[i];
            botones[i] = new JButton(boton.getTexto());
            botones[i].putClientProperty("opcion", textoBotones[i].getElemento());
            botones[i].addActionListener(controlador);
            panelBotones.add(botones[i]);
        }
        
        add(panelBotones, BorderLayout.CENTER);

        JPanel panelResultados = new JPanel();
        panelResultados.setLayout(new GridLayout(3, 1));

        labelResultado = new JLabel("¡Haz tu elección!");
        labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
        panelResultados.add(labelResultado);

        labelPuntuacionJugador = new JLabel("Jugador: " + puntuacionJugador);
        labelPuntuacionJugador.setHorizontalAlignment(SwingConstants.CENTER);
        panelResultados.add(labelPuntuacionJugador);

        labelPuntuacionCPU = new JLabel("CPU: " + puntuacionCpu);
        labelPuntuacionCPU.setHorizontalAlignment(SwingConstants.CENTER);
        panelResultados.add(labelPuntuacionCPU);

        add(panelResultados, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void mostrarVentana(String mensaje, Elemento elemento){
        ImageIcon iconoOriginal;
        if (elemento == Elemento.PIEDRA) {
            iconoOriginal = new ImageIcon("./app/src/main/java/javaclase/con/kevinolarte/ejr/tema08/actividades/actividad07/IMG/piedra.png");
        }
        else if(elemento == Elemento.PAPEL){
            iconoOriginal = new ImageIcon("./app/src/main/java/javaclase/con/kevinolarte/ejr/tema08/actividades/actividad07/IMG/papel.png");
        }
        else
            iconoOriginal = new ImageIcon("./app/src/main/java/javaclase/con/kevinolarte/ejr/tema08/actividades/actividad07/IMG/tijeras.png");
        
        Image imagenOriginal = iconoOriginal.getImage();
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(80, 40, Image.SCALE_SMOOTH); // Nuevo tamaño: 300x200

        
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

        JOptionPane.showMessageDialog(null,mensaje, "dialogo", JOptionPane.INFORMATION_MESSAGE, iconoRedimensionado);
    } 

    public JLabel getLabelPuntuacionJugador() {
        return labelPuntuacionJugador;
    }

    public JLabel getLabelPuntuacionCPU() {
        return labelPuntuacionCPU;
    }

    
}
