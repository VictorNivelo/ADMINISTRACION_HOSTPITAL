package Controlador.ListaEnlazda;

import Controlador.ListaEnlazda.Excepciones.AtributoException;
import Controlador.ListaEnlazda.Excepciones.ListaVaciaExcepcion;
import Controlador.ListaEnlazda.Excepciones.PosicionNoEncontradaExcepcion;
import Utilidades.Utilidades_Generales;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 *
 * @author Victor
 * @param <E>
 */
public class ListaEnlazada<E> extends AbstractSequentialList<E> implements List<E>, java.io.Serializable {

    private NodoLista<E> cabecera;
    private Integer size = 0;
    private final Integer ascendente = 1;
    private final Integer descendente = 2;

    public void print() {
        NodoLista<E> aux = cabecera;
        System.out.println("---------------------LISTA ENLAZADA------------------");
        while (aux != null) {
            System.out.println(aux.getDato().toString() + "    ");
            aux = aux.getSiguiente();
        }
        System.out.println("-----------------------------------------------------");
    }

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean estaVacia() {
        return cabecera == null;
    }

    public float generarNumeroAleatorio() {
        float numAleatorio = 0;
        numAleatorio = (float) (Math.random() * 1000);
        return numAleatorio;
    }

    public void llenarLista(Integer tamanio) {
        Object aux;
        for (int i = 0; i < tamanio; i++) {
            aux = generarNumeroAleatorio();
            insertar((E) aux);
        }
    }

    public void vaciar() {
        this.cabecera = null;
        this.size = 0;
    }

    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            this.cabecera = nodo;
        } 
        else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
        System.out.println("Nuevo tamaño lista " + size);
    }

    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } 
        else {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }

    public E obtener(Integer pos) throws ListaVaciaExcepcion, PosicionNoEncontradaExcepcion {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } 
                else {
                    NodoLista<E> aux = cabecera;

                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } 
            else {
                throw new PosicionNoEncontradaExcepcion();
            }
            return dato;
        } 
        else {
            throw new ListaVaciaExcepcion();
        }
    }

    public E eliminar(Integer pos) throws ListaVaciaExcepcion, PosicionNoEncontradaExcepcion {
        if (!estaVacia()) {
            E dato = null;
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } 
                else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
            } 
            else {
                throw new PosicionNoEncontradaExcepcion();
            }
            return dato;
        } 
        else {
            throw new ListaVaciaExcepcion();
        }
    }

    public E[] ComvertirEnArray() {
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                aux = aux.getSiguiente();
            }
        }
        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    public ListaEnlazada<E> QuickSort(String atributo, Integer tipoOrdenacion) {
        E[] arreglo = ComvertirEnArray();
        Class<E> clazz = null;
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();
        }
        if (arreglo != null) {
            toList(arreglo);
        }
        return this;
    }

    public void QuickRecursivo(E[] arreglo, Integer primero, Integer ultimo, Integer tipoOrdenacion) {
        Integer i, j, central;
        E pivote;
        Object aux;
        central = (primero + ultimo) / 2;
        pivote = arreglo[central];
        i = primero;
        j = ultimo;
        Class clazz = (Class<E>) cabecera.getDato().getClass();
        do {
            if (Utilidades_Generales.isString(clazz)) {
                if (tipoOrdenacion == ascendente) {
                    while (arreglo[i].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) < 0) {
                        i++;
                    }
                    while (arreglo[j].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) > 0) {
                        j--;
                    }
                } 
                else {
                    while (arreglo[i].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) > 0) {
                        i++;
                    }
                    while (arreglo[j].toString().toLowerCase().compareTo(pivote.toString().toLowerCase()) < 0) {
                        j--;
                    }
                }
            }
        } 
        while (i <= j);
        if (primero < j) {
            QuickRecursivo(arreglo, primero, j, tipoOrdenacion);
        }
        if (i < ultimo) {
            QuickRecursivo(arreglo, i, ultimo, tipoOrdenacion);
        }
    }

    public void cambioDatoQuick(E[] arreglo, Integer i, Integer j) {
        Class clazz = arreglo[0].getClass();
        Object aux;
        if (Utilidades_Generales.isString(clazz)) {
            aux = (String) arreglo[j];
            arreglo[j] = arreglo[i];
            arreglo[i] = (E) aux;
        }
    }

    public void cambioObjectoQuick(E[] arreglo, Integer i, Integer j, Object auxI) {
        Class clazz = auxI.getClass();
        Object aux;
        if (Utilidades_Generales.isString(clazz)) {
            aux = arreglo[j];
            arreglo[j] = arreglo[i];
            arreglo[i] = (E) aux;
        }
    }

    public void ObjetoQuickRecursivo(E[] arreglo, Integer primero, Integer ultimo, Integer tipoOrdenacion, String atributo) throws Exception {
        Integer i, j, central;
        E pivote;
        Object a, b, c;
        central = (primero + ultimo) / 2;
        pivote = arreglo[central];
        i = primero;
        j = ultimo;
        Class clazz = (Class<E>) cabecera.getDato().getClass();
        Field field = Utilidades_Generales.ObtencionDeAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } 
        else {
            field.setAccessible(true);
            a = field.get(arreglo[i]);
            b = field.get(arreglo[j]);
            c = field.get(pivote);
        }
        System.out.println(arreglo[i] + "\n" + arreglo[j] + "\n" + pivote);
        System.out.println(a + "\n" + b + "\n" + c);
        do {

        } while (i <= j);
        if (primero < j) {
            ObjetoQuickRecursivo(arreglo, primero, j, tipoOrdenacion, atributo);
        }
        if (i < ultimo) {
            ObjetoQuickRecursivo(arreglo, i, ultimo, tipoOrdenacion, atributo);
        }
    }

    public ListaEnlazada<E> busquedaSecuencial(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        if (size > 0) {
            E[] arreglo = ComvertirEnArray();
            clazz = (Class<E>) cabecera.getDato().getClass();
        }
        return resultado;
    }

    public ListaEnlazada<E> busquedaBinariaSecuencial(String atributo, Object dato) throws Exception {
        Class<E> clazz = null;
        ListaEnlazada<E> resultado = new ListaEnlazada<>();
        E[] arreglo = ComvertirEnArray();
        Integer bajo = 0;
        Integer alto = arreglo.length - 1;
        Integer central = (bajo + alto) / 2;
        clazz = (Class<E>) cabecera.getDato().getClass();
        Object valorCentral = arreglo[central];
        return resultado;
    }

    private void compararObjetos(ListaEnlazada<E> resultado, E[] arreglo, Integer bajo, Integer alto, Integer central, Class clazz, String atributo, Object dato, Object valorCentral) throws Exception {
        Object a;
        Field field = Utilidades_Generales.ObtencionDeAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } 
        else {
            field.setAccessible(true);
            a = field.get(valorCentral);
        }
        if (Utilidades_Generales.isString(a.getClass())) {
            if (dato.toString().toLowerCase().equals(a.toString().toLowerCase())) {
            } 
            else if (dato.toString().toLowerCase().compareTo(a.toString().toLowerCase()) < 0) {
                alto = central;
                bajo = 0;
            } 
            else {
                alto = arreglo.length - 1;
                bajo = central;
            }
            busquedaDeObjetos(resultado, bajo, alto, arreglo, clazz, atributo, dato);
        }
    }

    private void busquedaDeObjetos(ListaEnlazada<E> resultado, Integer bajo, Integer alto, E[] arreglo, Class clazz, String atributo, Object dato) throws Exception {
        Boolean band;
        for (int aux = bajo; bajo < alto + 1; bajo++) {
            band = EvaluacionBusquedaObjeto(arreglo[bajo], dato, clazz, atributo);
            if (band) {
            }
        }
    }

    private Boolean EvaluacionBusquedaObjeto(E aux, Object dato, Class clazz, String atributo) throws Exception {
        Field field = Utilidades_Generales.ObtencionDeAtributo(clazz, atributo);
        if (field == null) {
            throw new AtributoException();
        } 
        else {
            field.setAccessible(true);
            Object a = field.get(aux);
        }
        return null;
    }

    int Tamano = 0;
    Nodo<E> inicio;
    transient Nodo<E> ultimo;

    public ListaEnlazada() {
        
    }

    public ListaEnlazada(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    private void listarPrimero(E e) {
        final Nodo<E> fin = inicio;
        final Nodo<E> nuevoNodo = new Nodo<>(null, e, fin);
        inicio = nuevoNodo;
        if (fin == null) {
            ultimo = nuevoNodo;
        } 
        else {
            fin.anterior = nuevoNodo;
        }
        Tamano++;
        modCount++;
    }

    void enlazarlista(E e) {
        final Nodo<E> l = ultimo;
        final Nodo<E> nuevoNodo = new Nodo<>(l, e, null);
        ultimo = nuevoNodo;
        if (l == null) {
            inicio = nuevoNodo;
        } 
        else {
            l.siguiente = nuevoNodo;
        }
        Tamano++;
        modCount++;
    }

    void linkBefore(E e, Nodo<E> exitoso) {
        final Nodo<E> objec = exitoso.anterior;
        final Nodo<E> nuevoNodo = new Nodo<>(objec, e, exitoso);
        exitoso.anterior = nuevoNodo;
        if (objec == null) {
            inicio = nuevoNodo;
        } 
        else {
            objec.siguiente = nuevoNodo;
        }
        Tamano++;
        modCount++;
    }

    private E DesvincularPrimero(Nodo<E> f) {
        final E element = f.item;
        final Nodo<E> next = f.siguiente;
        f.item = null;
        f.siguiente = null;
        inicio = next;
        if (next == null) {
            ultimo = null;
        } 
        else {
            next.anterior = null;
        }
        Tamano--;
        modCount++;
        return element;
    }

    private E DesvincularUltimo(Nodo<E> obje) {
        final E element = obje.item;
        final Nodo<E> prev = obje.anterior;
        obje.item = null;
        obje.anterior = null;
        ultimo = prev;
        if (prev == null) {
            inicio = null;
        } 
        else {
            prev.siguiente = null;
        }
        Tamano--;
        modCount++;
        return element;
    }

    E Desvincular(Nodo<E> obj) {
        final E elemento = obj.item;
        final Nodo<E> siguiente = obj.siguiente;
        final Nodo<E> anterior = obj.anterior;
        if (anterior == null) {
            inicio = siguiente;
        } 
        else {
            anterior.siguiente = siguiente;
            obj.anterior = null;
        }
        if (siguiente == null) {
            ultimo = anterior;
        } 
        else {
            siguiente.anterior = anterior;
            obj.siguiente = null;
        }
        obj.item = null;
        Tamano--;
        modCount++;
        return elemento;
    }

    public E getFirst() {
        final Nodo<E> f = inicio;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.item;
    }

    public E getLast() {
        final Nodo<E> l = ultimo;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.item;
    }

    public E removeFirst() {
        final Nodo<E> f = inicio;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return DesvincularPrimero(f);
    }

    public E removeLast() {
        final Nodo<E> l = ultimo;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return DesvincularUltimo(l);
    }

    public void addFirst(E e) {
        listarPrimero(e);
    }

    public void addLast(E e) {
        enlazarlista(e);
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public int size() {
        return Tamano;
    }

    public boolean add(E e) {
        enlazarlista(e);
        return true;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Nodo<E> x = inicio; x != null; x = x.siguiente) {
                if (x.item == null) {
                    Desvincular(x);
                    return true;
                }
            }
        } 
        else {
            for (Nodo<E> x = inicio; x != null; x = x.siguiente) {
                if (o.equals(x.item)) {
                    Desvincular(x);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return addAll(Tamano, c);
    }

    public boolean addAll(int Indice, Collection<? extends E> c) {
        revisarPocicionIndice(Indice);
        Object[] a = c.toArray();
        int nuevoNumero = a.length;
        if (nuevoNumero == 0) {
            return false;
        }
        Nodo<E> previo, Exito;
        if (Indice == Tamano) {
            Exito = null;
            previo = ultimo;
        } 
        else {
            Exito = node(Indice);
            previo = Exito.anterior;
        }
        for (Object o : a) {
            @SuppressWarnings("Sin revisar")
            E e = (E) o;
            Nodo<E> nuevoNodo = new Nodo<>(previo, e, null);
            if (previo == null) {
                inicio = nuevoNodo;
            } else {
                previo.siguiente = nuevoNodo;
            }
            previo = nuevoNodo;
        }
        if (Exito == null) {
            ultimo = previo;
        } 
        else {
            previo.siguiente = Exito;
            Exito.anterior = previo;
        }
        Tamano += nuevoNumero;
        modCount++;
        return true;
    }

    public E get(int indice) {
        revisarElemento(indice);
        return node(indice).item;
    }

    public E set(int indice, E elemento) {
        revisarElemento(indice);
        Nodo<E> x = node(indice);
        E antiguo = x.item;
        x.item = elemento;
        return antiguo;
    }

    private boolean isElementIndex(int indice) {
        return indice >= 0 && indice < Tamano;
    }

    private boolean isPositionIndex(int indice) {
        return indice >= 0 && indice <= Tamano;
    }

    private String outOfBoundsMsg(int indice) {
        return "indice: " + indice + ", tamano: " + Tamano;
    }

    private void revisarElemento(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void revisarPocicionIndice(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    Nodo<E> node(int index) {
        if (index < (Tamano >> 1)) {
            Nodo<E> x = inicio;
            for (int i = 0; i < index; i++) {
                x = x.siguiente;
            }
            return x;
        } 
        else {
            Nodo<E> x = ultimo;
            for (int i = Tamano - 1; i > index; i--) {
                x = x.anterior;
            }
            return x;
        }
    }

    public E peek() {
        final Nodo<E> f = inicio;
        return (f == null) ? null : f.item;
    }

    public E element() {
        return getFirst();
    }

    public E poll() {
        final Nodo<E> f = inicio;
        return (f == null) ? null : DesvincularPrimero(f);
    }

    public E remove() {
        return removeFirst();
    }

    public boolean offer(E e) {
        return add(e);
    }

    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    public E peekFirst() {
        final Nodo<E> f = inicio;
        return (f == null) ? null : f.item;
    }

    public E peekLast() {
        final Nodo<E> l = ultimo;
        return (l == null) ? null : l.item;
    }

    public E pollFirst() {
        final Nodo<E> f = inicio;
        return (f == null) ? null : DesvincularPrimero(f);
    }

    public E pollLast() {
        final Nodo<E> l = ultimo;
        return (l == null) ? null : DesvincularUltimo(l);
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }

    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Nodo<E> x = ultimo; x != null; x = x.anterior) {
                if (x.item == null) {
                    Desvincular(x);
                    return true;
                }
            }
        } 
        else {
            for (Nodo<E> x = ultimo; x != null; x = x.anterior) {
                if (o.equals(x.item)) {
                    Desvincular(x);
                    return true;
                }
            }
        }
        return false;
    }

    public ListIterator<E> listIterator(int index) {
        revisarPocicionIndice(index);
        return new ListaIterador(index);
    }

    private class ListaIterador implements ListIterator<E> {

        private Nodo<E> ultimoretorno;
        private Nodo<E> siguiente;
        private int indicesiguiente;
        private int sumafinal = modCount;

        ListaIterador(int index) {
            siguiente = (index == Tamano) ? null : node(index);
            indicesiguiente = index;
        }

        public boolean hasNext() {
            return indicesiguiente < Tamano;
        }

        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ultimoretorno = siguiente;
            siguiente = siguiente.siguiente;
            indicesiguiente++;
            return ultimoretorno.item;
        }

        public boolean hasPrevious() {
            return indicesiguiente > 0;
        }

        public E previous() {
            checkForComodification();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            ultimoretorno = siguiente = (siguiente == null) ? ultimo : siguiente.anterior;
            indicesiguiente--;
            return ultimoretorno.item;
        }

        public int nextIndex() {
            return indicesiguiente;
        }

        public int previousIndex() {
            return indicesiguiente - 1;
        }

        public void remove() {
            checkForComodification();
            if (ultimoretorno == null) {
                throw new IllegalStateException();
            }
            Nodo<E> lastNext = ultimoretorno.siguiente;
            Desvincular(ultimoretorno);
            if (siguiente == ultimoretorno) {
                siguiente = lastNext;
            } 
            else {
                indicesiguiente--;
            }
            ultimoretorno = null;
            sumafinal++;
        }

        public void set(E e) {
            if (ultimoretorno == null) {
                throw new IllegalStateException();
            }
            checkForComodification();
            ultimoretorno.item = e;
        }

        public void add(E e) {
            checkForComodification();
            ultimoretorno = null;
            if (siguiente == null) {
                enlazarlista(e);
            } 
            else {
                linkBefore(e, siguiente);
            }
            indicesiguiente++;
            sumafinal++;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            while (modCount == sumafinal && indicesiguiente < Tamano) {
                action.accept(siguiente.item);
                ultimoretorno = siguiente;
                siguiente = siguiente.siguiente;
                indicesiguiente++;
            }
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != sumafinal) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private static class Nodo<E> {

        E item;
        Nodo<E> siguiente;
        Nodo<E> anterior;

        Nodo(Nodo<E> prev, E element, Nodo<E> next) {
            this.item = element;
            this.siguiente = next;
            this.anterior = prev;
        }
    }

    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    private class DescendingIterator implements Iterator<E> {

        private final ListaIterador itr = new ListaIterador(size());

        public boolean hasNext() {
            return itr.hasPrevious();
        }

        public E next() {
            return itr.previous();
        }

        public void remove() {
            itr.remove();
        }
    }

    @SuppressWarnings("unchecked")
    private ListaEnlazada<E> superClone() {
        try {
            return (ListaEnlazada<E>) super.clone();
        } 
        catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    public Object[] toArray() {
        Object[] result = new Object[Tamano];
        int i = 0;
        for (Nodo<E> x = inicio; x != null; x = x.siguiente) {
            result[i++] = x.item;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < Tamano) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), Tamano);
        }
        int i = 0;
        Object[] result = a;
        for (Nodo<E> x = inicio; x != null; x = x.siguiente) {
            result[i++] = x.item;
        }
        if (a.length > Tamano) {
            a[Tamano] = null;
        }
        return a;
    }

    private void escribirObjeto(java.io.ObjectOutputStream s) throws java.io.IOException {
        s.defaultWriteObject();
        s.writeInt(Tamano);
        for (Nodo<E> x = inicio; x != null; x = x.siguiente) {
            s.writeObject(x.item);
        }
    }

    @SuppressWarnings("unchecked")
    private void leerObjeto(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size = s.readInt();
        for (int i = 0; i < size; i++) {
            enlazarlista((E) s.readObject());
        }
    }
}
