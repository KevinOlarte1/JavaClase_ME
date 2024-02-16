package javaclase.con.kevinolarte.ejr.tema07.ejr06;

public class Tienda {
    private static final int LIMIT_VAMOR_DEFAULT = 10;
    private final Bicicleta bicis[];
    private int posActual = 0;

    public Tienda(){
        this.bicis = new Bicicleta[LIMIT_VAMOR_DEFAULT];
    }

    /*** Metodo para comprarBicis */
    public void comprarBici(String marca, String modelo, double peso, double tamañoRuedas, boolean motor, String fehca ){
        
        bicis[posActual] = new Bicicleta(marca, modelo, peso, tamañoRuedas, motor, fehca);
        posActual++;
    }


    /**
     * Metodo para vender bicis
     * @return -1 no hay stock, -2 no se ha encontrado, positivo num se ha encontrado. 
     */
    public int venderBici(String referencai){
        if (posActual == 0) 
            return -1;
        
       
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getReferecncia().equals(referencai)) {
                bicis[i] = null;
                if (posActual > 1) {
                    bicis[i] = bicis[posActual];
                    bicis[posActual] = null;
                }
                posActual --;
                return posActual;
            }
        }
        return -2;
        
    }

    /**
     * Meotod para obtener todas las bicis en stock
     * @return devuelve un array de una copia de nuestras bicis.
     */
    public Bicicleta[] obtenerStock(){
        if (posActual == 0) {
            return null;
        }
        Bicicleta[] stock = new Bicicleta[posActual];
        for (int i = 0; i < posActual; i++) {
            stock[i] = new Bicicleta(bicis[i]);
        }
        return stock;
    }

    /**
     * Meotod que devuelve un array con todas las bicis de ese modelo
     * @param modelo modelo que se busca
     * @return
     */
    public Bicicleta[] obtenerBicisModelo(String modelo){
        int cont = 0;
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getModelo().equals(modelo)) {
                cont++;
            }
        }
        if (cont == 0)
            return null;

        Bicicleta[] modeloBici = new Bicicleta[cont]; 
        boolean encontrado = false;
        int posicioncopia = 0;
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getModelo().equals(modelo)) {
                modeloBici[posicioncopia] = new Bicicleta(bicis[i]); 
                encontrado = true;
                posicioncopia++;
            }
        }
        if (encontrado == false) {
            return null;
        }
        return modeloBici;
    }

    /**
     * Meotod que devuelve un array con todas las bicis de ese marca
     * @param mraca marca que se busca
     * @return
     */
    public Bicicleta[] obtenerBicisMarca(String marca){
        int cont = 0;
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getMarca().equals(marca)) {
                cont++;
            }
        }
        if (cont == 0)
            return null;

        Bicicleta[] marcaBici = new Bicicleta[cont]; 
        boolean encontrado = false;
        int posicioncopia = 0;
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getMarca().equals(marca)) {
                marcaBici[posicioncopia] = new Bicicleta(bicis[i]); 
                encontrado = true;
                posicioncopia++;
            }
        }
        if (encontrado == false) {
            return null;
        }
        return marcaBici;
    }

    /**
     * Meotod que devuelve una copia de bici con esa referencia
     * @param refereinca referencia que se busca
     * @return
     */
    public Bicicleta obtenerBicisRef(String marca){
        int cont = 0;
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getMarca().equals(marca)) {
                cont++;
            }
        }
        if (cont == 0)
            return null;

        Bicicleta marcaBici = null; 
        boolean encontrado = false;
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getMarca().equals(marca)) {
                marcaBici = new Bicicleta(bicis[i]); 
                encontrado = true;
                
            }
        }
        if (encontrado == false) {
            return null;
        }
        return marcaBici;
    }


}
