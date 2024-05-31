package com.kevinolarte.ejr.trimestre3.t11.ejer4;

public class Television  extends Electrodomestico{
    
    private static final int PULGADAS_DEFAULT = 20;
    private static final boolean SMART_TV_DEFAULT = false;

    private int pulgadas;
    private boolean smartTV;   
    
    public Television(){
        super();
        this.pulgadas = PULGADAS_DEFAULT;
        this.smartTV = SMART_TV_DEFAULT;
    }

    public Television(double precio, double peso){
        super(precio, peso);
        this.pulgadas = PULGADAS_DEFAULT;
        this.smartTV = SMART_TV_DEFAULT;
    }

    public Television(double precioBase, String color, char consumoEnergetico, double peso, int pulgadas, boolean smartTV){
        super(precioBase, color, consumoEnergetico, peso);
        this.pulgadas = pulgadas;
        this.smartTV = smartTV;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    @Override
    public double precioFinal(){
        double precio = super.precioFinal();
        if (pulgadas > 40){
            precio += precio * 0.3;
        }
        if (smartTV){
            precio += 50;
        }
        return precio;
    }
}
