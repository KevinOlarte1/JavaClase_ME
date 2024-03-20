package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad06;
import javax.swing.*;
import javaclase.con.kevinolarte.lib.Comprobate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    private JLabel alturaEtiqueta;
    private JTextField altura;

    private JLabel pesoEtiqueta;
    private JTextField peso;

    private JLabel resultado;
    private JButton calcular;
    private JPanel panel;
    
    private GridBagConstraints constraints;
    private Controlador controlador;

    private float pesoF;
    private float alturaF;

    public Vista() {
        controlador = new Controlador(this);
        setTitle("Calculadora de IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.insets = new Insets(20, 20, 20, 20); 

        alturaEtiqueta = new JLabel("Altura (m):");
        altura = new JTextField(10);
        pesoEtiqueta = new JLabel("Peso (kg):");
        peso = new JTextField(10);
        calcular = new JButton("Calcuar");
        calcular.addActionListener(controlador);
        resultado = new JLabel("");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.NONE; // Establecer fill en NONE para que los componentes no cambien de tamaño
        panel.add(alturaEtiqueta, constraints);

        constraints.gridx = 1;
        panel.add(altura, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(pesoEtiqueta, constraints);

        constraints.gridx = 1;
        panel.add(peso, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(calcular, constraints);

        constraints.gridy = 3;
        panel.add(resultado, constraints);

        add(panel);

        pack();
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false);
        setVisible(true);
    }

    public float getAltura() {
        if (!Comprobate.comprobarNumerRealPositivo(altura.getText())) {
            return 0.0f;
        }
        alturaF = Float.parseFloat(altura.getText());
        return alturaF;
    }

    public float getPeso() {
        if (!Comprobate.comprobarNumerRealPositivo(peso.getText())) {
            return 0.0f;
        }
        pesoF = Float.parseFloat(peso.getText());
        return pesoF;
    }

    public JLabel getResultado() {
        return resultado;
    }
}
