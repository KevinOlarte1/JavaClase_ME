package com.kevinolarte.propuestas.engine.math;

public class Vector2 {
    private float x;
    private float y;

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String toString(){
        return "Vector 2[ x : " + this.x + ", y : " + this.y + "]";
    }
}
