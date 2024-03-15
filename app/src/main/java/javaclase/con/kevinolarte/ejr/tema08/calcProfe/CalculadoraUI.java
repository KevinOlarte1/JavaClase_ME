package javaclase.con.kevinolarte.ejr.tema08.calcProfe;

//import com.germangascon.libs.LibUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CalculadoraUI
 * License: 🅮 Public Domain
 * Calculadora
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-02-29
 * @since 0.1, 2024-02-29
 **/
public class CalculadoraUI {
    public CalculadoraUI(int width, int height) {
        Boton[][] textoBotones = {
                {new Boton("ON", Boton.Accion.ON),  new Boton("OFF", Boton.Accion.OFF), new Boton("%", Boton.Accion.OPERADOR), new Boton("/", Boton.Accion.OPERADOR)},
                {new Boton("7", Boton.Accion.DIGITO), new Boton("8", Boton.Accion.DIGITO), new Boton("9", Boton.Accion.DIGITO), new Boton("*", Boton.Accion.OPERADOR)},
                {new Boton("4", Boton.Accion.DIGITO), new Boton("5", Boton.Accion.DIGITO), new Boton("6", Boton.Accion.DIGITO), new Boton("-", Boton.Accion.OPERADOR)},
                {new Boton("1", Boton.Accion.DIGITO), new Boton("2", Boton.Accion.DIGITO), new Boton("3", Boton.Accion.DIGITO), new Boton("+", Boton.Accion.OPERADOR)},
                {new Boton("0", Boton.Accion.DIGITO), new Boton(".", Boton.Accion.PUNTO), new Boton("AC", Boton.Accion.AC), new Boton("=", Boton.Accion.IGUAL)},
        };

        CalculadoraController calculadoraController = new CalculadoraController();

        JButton[] buttons = new JButton[textoBotones.length * textoBotones[0].length];
        JFrame ventana = new JFrame("Calculadora");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        long x = Math.round(dimension.getWidth() / 2 - width / 2f);
        long y = Math.round(dimension.getHeight() / 2 - height / 2f);

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        // Panel display calculadora
        JPanel panelDisplay = new JPanel();
        panelDisplay.setLayout(new GridLayout(1, 1, 5, 5));
        JLabel display = new JLabel("0", SwingConstants.RIGHT);
        display.setBackground(Color.GREEN);
        display.setOpaque(true);
        display.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelDisplay.add(display);
        panelPrincipal.add(panelDisplay);

        // Panel botones
        JPanel panelBotones = new JPanel();
        GridLayout gridLayout = new GridLayout(textoBotones.length, textoBotones[0].length, 10, 10);
        panelBotones.setLayout(gridLayout);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Se ha pulsado el botón");
            }
        };
        int cont = 0;
        for (int i = 0; i < textoBotones.length; i++) {
            for (int j = 0; j < textoBotones[i].length; j++) {
                Boton boton = textoBotones[i][j];
                buttons[cont] = new JButton(boton.getTexto());
                switch (boton.getAccion()) {
                    case DIGITO:
                        buttons[cont].addActionListener(calculadoraController.getActionDigito());
                        break;
                    default:

                }
                panelBotones.add(buttons[cont]);
                cont++;
            }
        }
        panelPrincipal.add(panelBotones);

        ventana.setContentPane(panelPrincipal);
        ventana.setBounds((int)x, (int)y, width, height);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        //LibUI.setMonitor(ventana, 0);
        ventana.setVisible(true);
        // ventana.pack();
    }
}
