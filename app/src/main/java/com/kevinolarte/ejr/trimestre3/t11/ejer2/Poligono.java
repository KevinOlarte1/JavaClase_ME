package com.kevinolarte.ejr.trimestre3.t11.ejer2;

import java.util.List;

import org.checkerframework.common.reflection.qual.GetClass;

import com.kevinolarte.ejr.trimestre3.t11.ejer1.Punto;

public class Poligono {
    private List<Punto> vertices;

    private Poligono(List<Punto>vertices){
        this.vertices = vertices;
    }

    /**
     * Metodo para trasladar el poligono a cierta posicion
     * @param x desplazamiento en el eje x.
     * @param y desplazamiento en el eje y.
     */
    public void traslada(int x, int y){
        for (Punto punto : vertices) {
            punto.setX(punto.getX() + x);
            punto.setY(punto.getY() + y);
        }
    }

    /**
     * Metodo para obtener el numero de vertices
     * @return devuelve la cantidad de vertices que tiene ese poligono.
     */
    public int numVertices(){
        return vertices.size();
    }

    /**
     * Calcilar el perimetro del poligono
     * @return
     */
    public double perimetro(){
        if (vertices.size() < 3) 
            return Double.NEGATIVE_INFINITY;
        
        double res  = 0;

        for (int i = 0; i < vertices.size()-1; i++) 
            res += vertices.get(i).distancia(vertices.get(i+1));
        
        res += vertices.get(vertices.size()-1).distancia(vertices.get(0));
        return res; 
    
    }
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vertices.size(); i++) {
            sb.append("(").append(vertices.get(i).getX()).append(",").append(vertices.get(i).getY()).append(") ");
        }
        return sb.toString();
    }


}
