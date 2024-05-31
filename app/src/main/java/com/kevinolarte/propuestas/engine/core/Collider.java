package com.kevinolarte.propuestas.engine.core;

import java.awt.Rectangle;
public class Collider {
    
    private float xRight;
    private float xLeft;
    private float yUp;
    private float yDown;
    private int mask;

    public Collider(float xRight, float xLeft, float yUp, float yDown, int mask) {
        this.xRight = xRight;
        this.xLeft = xLeft;
        this.yUp = yUp;
        this.yDown = yDown;
        this.mask = mask;
    }

    public float getxRight() {
        return xRight;
    }

    public float getxLeft() {
        return xLeft;
    }

    public float getyUp() {
        return yUp;
    }

    public float getyDown() {
        return yDown;
    }

    public void setxRight(float xRight) {
        this.xRight = xRight;
    }

    public void setxLeft(float xLeft) {
        this.xLeft = xLeft;
    }

    public void setyUp(float yUp) {
        this.yUp = yUp;
    }

    public void setyDown(float yDown) {
        this.yDown = yDown;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    

    
}
