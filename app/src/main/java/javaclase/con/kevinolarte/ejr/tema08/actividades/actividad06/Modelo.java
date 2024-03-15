package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad06;

public class Modelo {
    private float peso;
    private float altura;
    private float imc;
    private String clasificacion;

    /**
     * Metodo para calcular el imc y la clasificacion de tu peso
     */
    public void resolver(float altura, float peso){
        if (peso < 1 || altura < 1) {
            return;
        }
        imc = peso / (altura * altura);
        clasificar();
    }

    public float getImc() {
        return imc;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    private void clasificar(){
        if (imc < 16) {
            clasificacion = "Delgadez severa";
        } else if (imc < 17) {
            clasificacion = "Delgadez moderada";
        } else if (imc < 18.5) {
            clasificacion = "Delgadez aceptable";
        } else if (imc < 25) {
            clasificacion = "Peso normal";
        } else if (imc < 30) {
            clasificacion = "Sobrepeso";
        } else if (imc < 35) {
            clasificacion = "Obeso: Tipo I";
        } else if (imc < 40) {
            clasificacion = "Obeso: Tipo II";
        } else {
            clasificacion = "Obeso: Tipo III";
        }
    }
}
