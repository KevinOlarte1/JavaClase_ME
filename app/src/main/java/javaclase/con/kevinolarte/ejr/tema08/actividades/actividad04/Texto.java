package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad04;
import java.awt.*;

public class Texto {
    private final String aficion;
    private final Font font;
    private final Color color;

    public Texto(String aficion, Font font, Color color) {
        this.aficion = aficion;
        this.font = font;
        this.color = color;
    }

    public String getAficion() {
        return aficion;
    }

    public Font getFont() {
        return font;
    }

    public Color getColor() {
        return color;
    }
}
