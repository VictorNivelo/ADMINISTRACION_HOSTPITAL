package Modelo;

/**
 *
 * @author Victor
 */
public class Especialidad {

    private Integer id;
    private String nombre;
    private String descripcion;
    private static int contador = 0;

    public Especialidad() {
        contador += 1;
        id = contador;
    }

    public static Integer getContador() {
        return contador;
    }

    public static void setContador(Integer contador) {
        Especialidad.contador = contador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Especialidad " + this.nombre;
    }
}
