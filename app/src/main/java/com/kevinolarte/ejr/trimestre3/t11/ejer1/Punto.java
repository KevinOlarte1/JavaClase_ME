package com.kevinolarte.ejr.trimestre3.t11.ejer1;

public class Punto {
    private double x;
    private double y;

    public Punto(){
        this(0,0);
    }
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Calcula la distanca entre dos puntos aplicando una pequela formula
     * @param p punto con la que se va calcular la distancia
     * @return devuelve un double con la distancia entre dos puntos.
     */
    public double distancia(Punto p){
        return Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2));
    }

    @Override
    public String toString(){
        return "(" + x + "," + y +")";
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    

}
