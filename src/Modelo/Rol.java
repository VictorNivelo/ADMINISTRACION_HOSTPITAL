package Modelo;

import Utilidades.Utilidades;
import java.util.Arrays;

/**
 *
 * @author Victor
 */
public class Rol {

    private Integer id;
    private String nombre;
    private String descripcion;
    private static final String[] ROLES_PERMITIDOS = new String[]{Roles.getRolByIndex(0).toString(), Roles.getRolByIndex(1).toString(), Roles.getRolByIndex(2).toString(), Roles.getRolByIndex(3).toString()};

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
        if (!Utilidades.contains(ROLES_PERMITIDOS, nombre)) {
            throw new Error("Los roles permitidos son: " + Arrays.toString(ROLES_PERMITIDOS));
        }
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
