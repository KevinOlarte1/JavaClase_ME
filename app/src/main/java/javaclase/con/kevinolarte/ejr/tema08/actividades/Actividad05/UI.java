package javaclase.con.kevinolarte.ejr.tema08.actividades.Actividad05;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UI {
    private JFrame frame;
    private JLabel numIntentos;
    private JTextField cajaTexto;
    private JButton boton;
    private AdivinarNumero juego;

    public UI() {
        juego = new AdivinarNumero();
        setupUI();
    }

    private void setupUI() {
        frame = new JFrame("Adivina el numero!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLayout(null);

        numIntentos = new JLabel("Intentos restantes: " + juego.numIntentos);
        numIntentos.setBounds(10, 10, 250, 25);
        frame.add(numIntentos);

        cajaTexto = new JTextField();
        cajaTexto.setBounds(10, 40, 250, 25);
        frame.add(cajaTexto);

        boton = new JButton("intenta adivinar");
        boton.setBounds(10, 70, 250, 25);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(cajaTexto.getText().trim());
                int result = juego.intentoAdivinar(guess);
                switch (result) {
                    case -1:
                        showMessage("Mala suerte haz perdido, el numero correcto es: " + juego.numAdivinar);
                        if (promptNewGame()) {
                            juego.reinicar();
                            updateAttempts();
                        } else {
                            System.exit(0);
                        }
                        break;
                    case 1:
                        updateAttempts();
                        break;
                    case 0:
                        showMessage("Felicidades, ganaste");
                        if (promptNewGame()) {
                            juego.reinicar();
                            updateAttempts();
                        } else {
                            System.exit(0);
                        }
                }
            }
        });
        frame.add(boton);

        frame.setVisible(true);
    }

    private void updateAttempts() {
        numIntentos.setText("Intentos restantes: " + juego.numIntentos);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    private boolean promptNewGame() {
        int response = JOptionPane.showConfirmDialog(frame, "¿Te gustaría volver a jugar?", "Nuevo juego",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return response == JOptionPane.YES_OPTION;
    }
}
