package javaclase.con.kevinolarte.ejr.tema07.ejr06;



import javaclase.con.kevinolarte.lib.Conf;
import javaclase.con.kevinolarte.lib.Input;
import javaclase.con.kevinolarte.lib.Menus;

public class MainEjer06 {
    private Tienda t = new Tienda();
    public MainEjer06(){
        boolean salir = false;
        do{
            Menus.print(new String[]{" GESTIÓN DE BICICLETAS ", "Añadir bicicletas...","Veder bicicletas","Consultar bicicleta...", "Mostrar stock"});
            int valor = Input.pedirInt("Seleccione una opcioón");
            switch (valor) {
                case 1:
                    comprarBici();
                    break;
                case 2:
                    venderBici();
                    System.out.println("Continar...");
                    Input.scanner.nextLine();
                    break;
                case 3:
                    consultaBici();
                    break;
                case 4:
                    mostarStock();
                    System.out.println("Continar...");
                    Input.scanner.nextLine();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Fuera de rango");
                    Conf.sleep(400);
                    break;
            }
        }while(!salir);
    }

    /**Metodo para mostrar subMenu de consutla */
    private void consultaBici(){
        boolean salir = false;

        do{
            Menus.print(new String[]{"CONSULTA BICIS", "Consulta por referencia...", "Consulta por marca...", "Conuslta por modelo..."});
            int valor = Input.pedirInt("Seleccione una opcioón");
            switch (valor) {
                case 1:
                    consRef();
                    System.out.println("Continuar....");
                    Input.scanner.nextLine();
                    break;
                case 2:
                    consMarc();
                    System.out.println("Continuar....");
                    Input.scanner.nextLine();
                    break;
                case 3:
                    consMod();
                    System.out.println("Continuar....");
                    Input.scanner.nextLine();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Fuera de rango");
                    Conf.sleep(400);
                    break;
            }

        }while(!salir);
    }

    /**Buscar una bici por Referencia */
    private void consRef(){
        String referencia = String.valueOf(Input.pedirIntPositivo("INgresa la referencia"));
        Bicicleta biciCopia = t.obtenerBicisRef(referencia);
        if (biciCopia == null) 
            System.out.println("No existe esa bici");
        else    
            System.out.println(biciCopia.toString());
        
    }

    /**Buscar una bici por Marca */
    private void consMarc(){
        String marca = Input.pedirStringTexto("Ingresa la marca de la bici");
        Bicicleta[] bicidMar = t.obtenerBicisMarca(marca); 
        if (bicidMar == null) 
            System.out.println("No se ha encontrado");
        else{
            for (Bicicleta bicicleta : bicidMar) {
                System.out.println(bicicleta.toString());
            }
        }
    }
    /**Buscar una bici por Modelo */
    private void consMod(){
        String modelo = Input.pedirStringTexto("Ingresa el modelo de la bici");
        Bicicleta[] bicidMod = t.obtenerBicisModelo(modelo); 
        if (bicidMod == null) 
            System.out.println("No se ha encontrado");
        else{
            for (Bicicleta bicicleta : bicidMod) {
                System.out.println(bicicleta.toString());
            }
        }
    }

    /*** Metodo para comprarBicis */
    private void comprarBici(){
        String marca =Input.pedirStringTexto("Ingrese el numero de la marca");
        String modelo = Input.pedirStringTexto("Pedir modelo de la marca");
        double peso = Input.pedirDoublePositivo("Ingresa el peso de la bici"); 
        double tamañoRuedas = Input.pedirDoublePositivo("Ingresa el tamaño de la rueda"); 
        boolean motor = Input.pedirBoolean("La bici tine motor?"); 
        String fehca = Input.pedirFecha("Ingrese la fecha de la fabricacion");
        t.comprarBici(marca, modelo, peso, tamañoRuedas, motor, fehca);
    }

    /** Metodo para vender las bicis */
    private void venderBici(){
        String referencai = String.valueOf(Input.pedirIntPositivo("Ingrese el numero de referencia"));
        int result = t.venderBici(referencai);
        if (result > -1) 
            System.out.println("Bici " + referencai + "ha sido vendida");
        else if(result == -1)
            System.out.println("No hay Stock");
        else
            System.out.println("La referencia " + referencai + " no existe");
        
    }


    /** Metodo para mostar el stock de las bicis. */
    private void mostarStock(){
        Bicicleta[] sotck = t.obtenerStock();
        if (sotck == null) {
            System.out.println("No hay stock");
        }
        else{
            for (Bicicleta bicicleta : sotck) {
                System.out.println(bicicleta.toString());
            }
        }
    }
    
}
