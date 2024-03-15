package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad06;

import javax.swing.*;
import java.awt.*;
import javaclase.con.kevinolarte.lib.Comprobate;

public class Vista {
    private final JFrame frame;
    private final JPanel panel;
    private final JTextField altura;
    private final JTextField peso;
    private final JButton button;
    private float imc;
    private String resultado;
    private float pesoF;
    protected float alturaF;

    public Vista() {
      
        frame = new JFrame("Suma de dos numeros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        altura = new JTextField();
        peso = new JTextField();

        Controlador controlador = new Controlador(this);
        button = new JButton("Calcular");
        button.addActionListener(controlador);
      //  button.addActionListener();

        panel.add(new JLabel("Altura"));
        panel.add(altura);
        panel.add(new JLabel("Peso:"));
        panel.add(peso);
        panel.add(new JLabel("IMC"));
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        
    }

    public float getAltura() {
        if (!Comprobate.comprobarNumerRealPositivo(altura.getText())) {
            return 0.0f;
        }
        alturaF = Float.parseFloat(resultado);
        return alturaF;
    }

    public float getPeso() {
        if (!Comprobate.comprobarNumerRealPositivo(peso.getText())) {
            return 0.0f;
        }
        pesoF = Float.parseFloat(peso.getText());
        return pesoF;
    }
}
