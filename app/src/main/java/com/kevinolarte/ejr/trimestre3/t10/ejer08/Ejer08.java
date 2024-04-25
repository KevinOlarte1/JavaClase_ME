package com.kevinolarte.ejr.trimestre3.t10.ejer08;

import com.kevinolarte.lib.LibConf;
import com.kevinolarte.lib.LibInput;
import com.kevinolarte.lib.LibMenu;

public class Ejer08 {
    
    private final IDiccionario diccionario;

    public Ejer08(Diccionario diccionario){
        this.diccionario = diccionario;
        start();
    }

    public Ejer08(){
        this(new Diccionario());
    }

    private void start(){
        generarRegistros();
        int ingreso = 0;
        do{
            LibMenu.print(new String[]{"Gestion diccionario", "Añadir palabra", "Actualizar palabra", "Eliminar palabra", "Ver definicion", "Ver palabras"});
            ingreso = LibInput.pedirIntPositivo("Elija una opcion: ");
            switch (ingreso) {
                case 1:
                    addPalabra();
                    break;
                case 2:
                    updatePalabra();
                    break;
                case 3:
                    removePalabra();
                    break;
                case 4:
                    getDefinicion();
                    break;
                case 5:
                    getPalabras();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    LibConf.sleep();
                    break;
            }
            LibInput.scanner.nextLine();
        }while(ingreso != 0);

        
    }

    /**
     * Metodo que añade una palabra al diccionario
     */
    private void addPalabra(){
        String palabra = LibInput.pedirTexto("Ingrese la palabra: ");
        String definicion = LibInput.pedirTexto("Ingrese la definicion: ");
        try {
            diccionario.addPalabra(palabra, definicion);
            System.out.println("Palabra añadida correctamente");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        LibConf.sleep();
    }

    /**
     * Metodo que actualiza una palabra del diccionario
     */
    private void updatePalabra(){
        String palabra = LibInput.pedirTexto("Ingrese la palabra: ");
        if (diccionario.getDefinicion(palabra) == null) {
            System.out.println("La palabra no existe en el diccionario");
            LibConf.sleep();
            return;
        }
        String definicion = LibInput.pedirTexto("Ingrese la definicion: ");
        
        diccionario.updatePalabra(palabra, definicion);
        System.out.println("Palabra actualizada correctamente");
        LibConf.sleep();
    }

    /**
     * Metodo que elimina una palabra del diccionario
     */
    private void removePalabra(){
        String palabra = LibInput.pedirTexto("Ingrese la palabra: ");
        if (diccionario.getDefinicion(palabra) == null) {
            System.out.println("La palabra no xieste en el diccionario");
            LibConf.sleep();
            return;
        }
        diccionario.removePalabra(palabra);
        System.out.println("Palabra eliminada correctamente");
        LibConf.sleep();
    }


    /**
     * Metodo que obtiene la definicion de una palabra del diccionario
     */
    private void getDefinicion(){
        String palabra = LibInput.pedirTexto("Ingrese la palabra: ");
        String definicion = diccionario.getDefinicion(palabra);
        if (definicion == null) {
            System.out.println("La palabra no existe en el diccionario");
        } else {
            System.out.println(definicion);
        }
        LibConf.sleep();
    }

    /**
     * Metodo que obtiene todas las palabras del diccionario
     */
    private void getPalabras(){
        System.out.println(diccionario.getPalabras());
        LibConf.sleep();    
    }



    private void generarRegistros(){
        diccionario.addPalabra("casa", "Edificio de una o pocas plantas destinado a vivienda unifamiliar, en oposición a piso.");
        diccionario.addPalabra("hola", "Saludo con que se hace a alguien al encontrarlo o al empezar una conversación.");
        diccionario.addPalabra("perro", "Mamífero carnívoro doméstico de la familia de los cánidos, de tamaño, forma y pelaje muy diversos, según las razas.");
        diccionario.addPalabra("gato", " Mamífero carnívoro doméstico de la familia de los félidos, de unos 50 cm de longitud desde la cabeza hasta la inserción de la cola, que mide unos 30 cm, y de pelaje suave, espeso y erizado, generalmente de color gris, aunque hay muchas variedades.");
        diccionario.addPalabra("raton", "Mamífero roedor de unos 7 cm de largo, sin contar la cola, de pelaje gris oscuro por el dorso y más claro por el vientre, orejas grandes, ojos saltones, cola larga y fina, y patas cortas, que vive en madrigueras y se alimenta de semillas, frutos, raíces, etc.");
        diccionario.addPalabra("pajaro", "Ave, especialmente si es de pequeño tamaño.");
        diccionario.addPalabra("pez", "Animal vertebrado acuático, generalmente provisto de branquias, aletas y un cuerpo más o menos fusiforme, que puede ser más o menos grande, según las especies.");
        diccionario.addPalabra("caballo", " Mamífero équido, macho, de unos 160 cm de alzada, cabeza alargada, cuello largo, patas largas, cola poblada de cerdas largas y abundantes, y pelaje generalmente de color claro, domesticado desde antiguo y empleado como montura, animal de tiro, de carga, de carrera, etc.");
        
    }
}
