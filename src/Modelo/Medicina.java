package Modelo;

/**
 *
 * @author Victor
 */
public class Medicina {

    private String id;
    private String nombre;
    private String marca;
    private String stock;
    private String fechaAgregado;
    private String fechaCaducidad;

    public Medicina(String nombre, String stock, String fechaAgregado, String fechaCaducidad) {
        this.nombre = nombre;
        this.stock = stock;
        this.fechaAgregado = fechaAgregado;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(String fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + marca + ")";
    }

    public String obtenerDetalleMedicina() {
        String result = "";
        result += "Nombre: " + (nombre == null ? "No definido" : nombre) + "\n";
        result += "Marca: " + (marca == null ? "No definido" : marca) + "\n";
        result += "Stock: " + (stock == null ? "No definido" : stock) + "\n";
        result += "Fecha de registro: " + (fechaAgregado == null ? "No definido" : fechaAgregado) + "\n";
        result += "Fecha de caducidad: " + (fechaCaducidad == null ? "No definido" : fechaCaducidad) + "\n";
        return result;
    }
}
