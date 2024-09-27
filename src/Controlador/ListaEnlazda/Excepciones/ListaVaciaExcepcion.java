package Controlador.ListaEnlazda.Excepciones;

/**
 *
 * @author Victor
 */
public class ListaVaciaExcepcion extends Exception {

    public ListaVaciaExcepcion(String msg) {
        super(msg);
    }

    public ListaVaciaExcepcion() {
        super("La lista esta vacia");
    }
}
