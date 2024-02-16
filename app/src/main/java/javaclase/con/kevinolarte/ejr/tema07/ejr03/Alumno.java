package javaclase.con.kevinolarte.ejr.tema07.ejr03;

import java.text.SimpleDateFormat;

import javaclase.con.kevinolarte.lib.Conf;
import javaclase.con.kevinolarte.lib.Randmos;


public class Alumno {
     
    private String nia;
    private final String nombre;
    private final String apellido;
    private final String fechaNacimiento;
    private final String grupo;
    private final String telefono;

    //#region Constructores
    public Alumno(){
        
       // this(Conf.fakerEs.name().firstName(), Conf.fakerEs.name().lastName(), new SimpleDateFormat("dd-MM-yyyy").format(Conf.fakerEs.date().birthday(12, 16)), (String)("Grupo0" + Randmos.rnd.nextInt(1,5)), (String)Conf.fakerEs.phoneNumber().cellPhone());
        this("Conf.fakerEs.name().firstName()", "Conf.fakerEs.name().lastName()", new SimpleDateFormat("dd-MM-yyyy").format("Conf.fakerEs.date().birthday(12, 16)"), (String)("Grupo0" + Randmos.rnd.nextInt(1,5)), (String)"Conf.fakerEs.phoneNumber().cellPhone()");
    }

    public Alumno(String nombre, String apellido, String fechaNacimiento, String grupo, String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this. grupo = grupo;
        this.telefono = telefono;
    
        this.nia = calcularNia(nombre, apellido, fechaNacimiento);
    }
    //#endregion
    /***
     * Metodo para calcular el Nia
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @return el nia con un calculo creado.
     */
    public static String calcularNia(String nombre, String apellido, String fechaNacimiento){
        int calc = 0;
        for (int i = 0; i < nombre.length(); i++) {
            calc += (int) nombre.charAt(i);
        }
        for (int i = 0; i < apellido.length(); i++) {
            calc+= (int) apellido.charAt(i);
        }
        return String.valueOf(calc) + formatFecha(fechaNacimiento);

    }

    /**
     * Meotodo para obtener la fecha en 4 digitos, suma del mes y dia con el año
     * @param fecha fecha donde se sacaran los datos
     * @return valor en string de la suma de la fecha
     */
    private static String formatFecha(String fecha){
        return String.valueOf(Integer.parseInt(fecha.substring(0,2)) + Integer.parseInt(fecha.substring(4, 5)) + Integer.parseInt(fecha.substring(6, fecha.length())));
    }
    
    
    //#region Override
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nia == null) ? 0 : nia.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
        result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
        result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        if (nia == null) {
            if (other.nia != null)
                return false;
        } else if (!nia.equals(other.nia))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (apellido == null) {
            if (other.apellido != null)
                return false;
        } else if (!apellido.equals(other.apellido))
            return false;
        if (fechaNacimiento == null) {
            if (other.fechaNacimiento != null)
                return false;
        } else if (!fechaNacimiento.equals(other.fechaNacimiento))
            return false;
        if (grupo == null) {
            if (other.grupo != null)
                return false;
        } else if (!grupo.equals(other.grupo))
            return false;
        if (telefono == null) {
            if (other.telefono != null)
                return false;
        } else if (!telefono.equals(other.telefono))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento + ", grupo=" + grupo + ", telefono=" + telefono + "]";
    }
    //#endregion Override

    //#region Getters
    public String getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getTelefono() {
        return telefono;
    }

    //#endregion

    
    
}
