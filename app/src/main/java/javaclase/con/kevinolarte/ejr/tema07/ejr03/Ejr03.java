package javaclase.con.kevinolarte.ejr.tema07.ejr03;


import javaclase.con.kevinolarte.lib.Conf;
import javaclase.con.kevinolarte.lib.Input;


public class Ejr03 {
    static Alumno alumnos[];
    static int cantAct = 0;
    static int cantMax;
    static String cabezeraExt = "*********************";
    static String cabezeraLateral = "**";
    static String exitBarra = "----------------------";

    public Ejr03(){
        

        System.out.println("Binvenido al instituto I.E.S La Mar");
        cantMax = Input.pedirInt("Ingrese cuantos alumnos pueden estudiar en este centro:");
        alumnos = new Alumno[cantMax];
        alumnos[cantAct] = new Alumno();
        cantAct++;
        alumnos[cantAct] = new Alumno();
        cantAct++;
        

        do{
            System.out.print("\033[H\033[2J"); 
            System.out.println(cabezeraExt + "\n" + cabezeraLateral + " GESTIÓN ALUMNOS " + cabezeraLateral + "\n" + cabezeraExt);
            System.out.println("1. Nuevo alumno...\n2. Baja de alumno...\n3. Consultas...\n4.MostarTodo...\n" + exitBarra + "\n0. Salir");
            int ingreso = Input.pedirIntPositivo();
            switch (ingreso) {
                case 1:
                    Alumno alumno = alumnoNuevo();
                    if (alumno == null) 
                        break;                   
                    alumnos[cantAct] = alumno;
                    cantAct++;
                    break;
                case 2:
                    int num = obtenerPosicionAlumno();
                    if (num == -1)
                        break;
                    alumnos[num] = null;
                    ordenarArrayObjetosIncompleto(alumnos, cantAct);
                    cantAct--;
                    break;
                case 3:
                    consulta();
                    break;
                case 4:
                    mostrarTodo();
                    break;
                default:
                    System.out.println("Ingreso fuera de rango...");
                    Conf.sleep(350);
                    break;
            }

        }while(true);
        
        
    }
    private void mostrarTodo(){
        for (int i = 0; i < cantAct ; i++) {
            System.out.println(alumnos[i].toString());
        }
        Input.scanner.nextLine();
    }

    private void consulta(){
        do{
            System.out.print("\033[H\033[2J");
            System.out.println(cabezeraExt + "\n" + cabezeraLateral + "  CONSULTA  " + cabezeraLateral + "\n" + cabezeraExt);
            System.out.println("1. Por Grupo...\n2. Por edad...\n3. Por nia...\n" + "4. Por apellido\n" + exitBarra + "\n0. Salir");
            int ingreso = Input.pedirIntPositivo();
            switch (ingreso) {
                case 1:
                    mostarPorGrupos();
                    break;
                case 2:
                    mostrarPorEdad();
                    break;
                case 3:
                    mostrarPorNia();
                    break;
                case 4:
                    mostarPorApellido();
                    break;
                default:

                    break;
            }
            Conf.sleep(400);
        }while(true);
    }

    /**
     * Mostar los alumnos por apellido
     */
    private void mostarPorApellido(){
        String apellido = Input.pedirStringTexto("Ingresa el apellido");
        for (int i = 0; i < cantAct; i++) {
            if (alumnos[i].getApellido().equals(apellido)) {
                System.out.println(alumnos[i].toString());
            }
        }
        Input.scanner.nextLine();
    }
    /**
     * Metodo para imprimir los alumnos por nia
     */
    private void mostrarPorNia(){
        int num;
        do{
            num = Input.pedirIntPositivo("Ingrese el nia del alumno");
            if (String.valueOf(num).length() == 9) 
                break;
            System.out.println("Ese nia no esta registrado en nuestro centro");
        }while(true);

        for (int i = 0; i < cantAct; i++) {
            if (alumnos[i].getNia().equals(String.valueOf(num))) {
                System.out.println(alumnos[i].toString());
            }
        }
        Input.scanner.nextLine();
    }

    private void mostrarPorEdad(){
        //Data
    }

    /**
     * Metodo para imprimir todos los alumnos por los grupos
     */
    private void mostarPorGrupos(){
        int num;
        do{
            num = Input.pedirIntPositivo("Ingrese el grupo de la clase 1 - 4");
            if (num > 0 | num < 5) 
                break;
            System.out.println("Ese grupo no esta en nuestro centro");
        }while(true);

        for (int i = 0; i < cantAct; i++) {
            if (alumnos[i].getGrupo().equals("Grupo 0" +String.valueOf(num))) {
                System.out.println(alumnos[i].toString());
            }
        }
        Input.scanner.nextLine();
    }
    /**
     * Metodo para crear un alumno nuevo
     * @return devuelve el alumno creado, si no supera la cantiad maxima.
     */
    private static Alumno alumnoNuevo(){
        
        if (cantAct == cantMax) {
            System.out.println("No hay espacio para añadir nuevas personas");
            Conf.sleep(400);
            return null;
            
        }
        int grupoNum;
        System.out.print("\033[H\033[2J"); 
        System.out.println("Para añadir un nuevo alumno ingrese los siguientes parametros");
        String nombre = Input.pedirStringTexto("Nombre del alumno"); 
        String apellido = Input.pedirStringTexto("Apellido del alumno");
        String fechaNacimiento = Input.pedirFecha("Fecha de nacimiento del alumno");
        do{
            grupoNum = Input.pedirInt("Ingrese el grupo de estudiante");
            if (grupoNum > 1 && grupoNum < 5) 
                break;
        }while(true);
        
        String grupo = "Grupo 0" + grupoNum; 
        String telefono = Input.pedirnumTelf("Por favir ingrese un numero telefonico");
        for (int i = 0; i < cantAct; i++) {
            if (alumnos[i].getNia().equals(Alumno.calcularNia(nombre, apellido, fechaNacimiento)))
            {   
                System.out.println("Este alumno ta existe");
                Conf.sleep(400);
                return null;
            }
                
        }
        Alumno alumno = new Alumno(nombre, apellido, fechaNacimiento, grupo, telefono);
        return alumno;
        
        
    }
    
    /**
     * Buscar el la posicion del alumno a traves del NIA.
     * @return devuelve la posicion, si no es econtrado devuelve -1
     */
    private static int obtenerPosicionAlumno(){
        int nia = Input.pedirIntPositivo("Ingrese el nia del alumno");
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].getNia().equals(String.valueOf(nia))) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Metodo para ordenar el array, para que no queden null por el medio
     * @param lista array que se va ordenadr
     * @param limit hasta donde se va ordenadr
     */
    private static void ordenarArrayObjetosIncompleto(Alumno lista[], int limit){
        for (int i = 0; i < limit; i++) {
            if (lista[i] == null) {
                lista[i] = lista[i + 1];
                lista[i + 1] = null;
            }
        }
    }
}
