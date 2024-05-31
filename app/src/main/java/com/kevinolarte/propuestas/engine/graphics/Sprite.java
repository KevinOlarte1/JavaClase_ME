package com.kevinolarte.propuestas.engine.graphics;

import java.awt.image.BufferedImage;

public class Sprite {
    //!TODO: Buscar mejor opcion.
    private BufferedImage image;
    private final float xRight;
    private final float xLeft;
    private final float yUp;
    private final float yDown;
    public Sprite(BufferedImage image, float xRight, float xLeft, float yUp, float yDown) {
        this.image = image;
        this.xRight = xRight;
        this.xLeft = xLeft;
        this.yUp = yUp;
        this.yDown = yDown;
    }

    
}
