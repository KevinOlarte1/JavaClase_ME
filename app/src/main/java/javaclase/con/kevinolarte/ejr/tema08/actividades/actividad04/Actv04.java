 package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad04;
 import javax.swing.*;

import org.apache.commons.lang3.ObjectUtils.Null;

import java.awt.*;

public class Actv04 {
    private JFrame frame;
    private JLabel texto;
    private JPanel panel;

    public Actv04() {
        frame = new JFrame("Mis aficiones");
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        Texto txt[] = new Texto[5];
        txt[0] = new Texto("Programar", new Font("Serif", Font.PLAIN, 24), Color.RED);
        txt[1] = new Texto("Gimnasio", new Font("Monospaced", Font.ITALIC, 24), Color.BLUE);
        txt[2] = new Texto("LOL", new Font("SansSerif", Font.BOLD, 24), Color.GREEN);
        txt[3] = new Texto("CSG2", new Font("Arial", Font.BOLD, 24), Color.YELLOW);
        txt[4] = new Texto("Patinar", new Font("Cursive", Font.PLAIN, 24), Color.ORANGE);
        
        for (int index = 0; index < txt.length; index++) {
            JLabel etiqueta = new JLabel(txt[index].getAficion());
            etiqueta.setFont(txt[index].getFont());
            etiqueta.setForeground(txt[index].getColor());
            panel.add(etiqueta);
        }
        frame.add(panel);

        frame.setVisible(true);
    }
}
