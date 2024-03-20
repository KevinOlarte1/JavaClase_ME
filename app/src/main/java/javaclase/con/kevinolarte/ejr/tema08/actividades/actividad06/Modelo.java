package javaclase.con.kevinolarte.ejr.tema08.actividades.actividad06;

public class Modelo {
    private float peso;
    private float altura;
    private float imc;
    private ClasificacionPeso clasificacion;

    /**
     * Metodo para calcular el imc y la clasificacion de tu peso
     */
    public void resolver(float altura, float peso){
        if (peso < 1 || altura < 1) {
            
            imc = 0.0f;
            clasificacion = ClasificacionPeso.ERROR ;
            return;
        }
        imc = peso / (altura * altura);
        clasificar();
    }

    public float getImc() {
        return imc;
    }

    public ClasificacionPeso getClasificacion() {
        return clasificacion;
    }

    private void clasificar(){
        if (imc < 18.50) {
            if (imc < 16) {
                clasificacion = ClasificacionPeso.DELGADEZ_SEVERA;
            }
            else if(imc < 16.99){
                clasificacion = ClasificacionPeso.DELGADEZ_MODERADA;
            }
            else
                clasificacion = ClasificacionPeso.DELGADEZ_LEVE;
        }
        else if(imc < 24.99){
            clasificacion = ClasificacionPeso.NORMAL;
        }
        else{
            if (imc < 34.99) {
                    clasificacion = ClasificacionPeso.PREOBESIDAD;  
            }
            else if(imc < 39.99){
                clasificacion = ClasificacionPeso.OBESIDAD_MEDIA;
            }
            else
                clasificacion = ClasificacionPeso.OBESIDAD_MORBIDA;
        }
    }
}
