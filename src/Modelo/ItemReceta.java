package Modelo;

/**
 *
 * @author Victor
 */
public class ItemReceta {

    private Medicina medicina;
    private Integer cantidad = 1;

    public Medicina getMedicina() {
        return medicina;
    }

    public void setMedicina(Medicina medicina) {
        this.medicina = medicina;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
