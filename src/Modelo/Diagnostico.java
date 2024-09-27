package Modelo;

/**
 *
 * @author Victor
 */
public class Diagnostico {

    private Enfermedad enfermedad;
    private String receta;
    private String observaciones;

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad Enfermedad) {
        this.enfermedad = Enfermedad;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
