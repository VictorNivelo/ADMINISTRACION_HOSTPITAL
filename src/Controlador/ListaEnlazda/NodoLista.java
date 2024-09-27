package Controlador.ListaEnlazda;

/**
 *
 * @author Victor
 */
public class NodoLista<E> {

    private E dato;
    private NodoLista<E> siguiente;

    public NodoLista(E dato, NodoLista<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoLista<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista<E> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoLista() {
    }

    @Override
    public String toString() {
        return dato.toString();
    }
}
