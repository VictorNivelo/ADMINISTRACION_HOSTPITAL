package Controlador;

import java.io.IOException;
import Modelo.Especialidad;
import Utilidades.UtilidadesJSON;

/**
 *
 * @author Victor
 */
public class ControladorEspecialidades {
    private final Integer MAXIMO_ESPECIALIDADES = 25;
    private final Especialidad listaEspecialidades[] = new Especialidad[MAXIMO_ESPECIALIDADES];

    public Especialidad[] getEspecialidades() {
        return this.listaEspecialidades;
    }

    public ControladorEspecialidades() {
        
    }

    public void registrarEspecialidad(Especialidad nueva) throws Exception {
        Integer index = UtilidadesJSON.ultimoElementoNoVacio(listaEspecialidades);
        if(index == null) throw new Exception("Ya no se pueden agregar más especialidades");
        listaEspecialidades[index] = nueva;
        guardar();
    }

    public void guardar() throws IOException {
        UtilidadesJSON.guardarJson(this, "ControladorEspecialidades");
    }
}
