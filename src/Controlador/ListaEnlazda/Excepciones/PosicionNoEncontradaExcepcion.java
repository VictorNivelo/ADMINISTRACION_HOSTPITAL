package Controlador.ListaEnlazda.Excepciones;

/**
 *
 * @author Victor
 */
public class PosicionNoEncontradaExcepcion extends Exception {

    public PosicionNoEncontradaExcepcion(String msg) {
        super(msg);
    }

    public PosicionNoEncontradaExcepcion() {
        super("La posición esta fuera de los limites");
    }
}
