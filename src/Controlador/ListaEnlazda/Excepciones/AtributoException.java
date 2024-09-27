package Controlador.ListaEnlazda.Excepciones;

/**
 *
 * @author Victor
 */
public class AtributoException extends Exception {

    public AtributoException(String msg) {
        super(msg);
    }

    public AtributoException() {
        super("No se puede encuentra el atributo dado");
    }
}
