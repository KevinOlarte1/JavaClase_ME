package javaclase.con.kevinolarte.lib;

import javax.swing.*;
import java.awt.*;

/**
 * LibUI
 * License: 🅮 Public Domain
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-03-01
 * @since 0.1, 2024-03-01
 **/
public class LibUI {

    public static void setMonitor(JFrame frame, int monitor, boolean centered) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        if (gd.length == 0)
            throw new RuntimeException( "Upps! No screens found" );

        if (monitor < 0 || monitor >= gd.length) {
            // Se ha seleccionado un monitor que no existe
            // Establecemos el primero por defecto
            monitor = 0;
        }
        // Cogemos el rectángulo que define los límites del monitor seleccionado
        Rectangle monitorBounds = gd[monitor].getDefaultConfiguration().getBounds();
        // Tomamos de base las coordenadas de inicio del monitor
        int xMonitor = monitorBounds.x;
        int yMonitor = monitorBounds.y;
        if (centered) {
            // Si debe estar centrado necesitamos el ancho del monitor y el ancho del frame para hacer los cálculos
            int width = monitorBounds.width;
            int height = monitorBounds.height;
            xMonitor = Math.round((width / 2f) - (frame.getSize().width / 2f) + xMonitor);
            yMonitor = Math.round((height / 2f) - (frame.getSize().height / 2f) + yMonitor);
        }
        frame.setLocation(xMonitor, yMonitor);
    }

    public static void setMonitor(JFrame frame, int monitor) {
        setMonitor(frame, monitor, true);
    }
}
