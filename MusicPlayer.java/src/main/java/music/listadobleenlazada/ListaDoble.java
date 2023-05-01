/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author barah
 * 
 */

package music.listadobleenlazada;

public class ListaDoble<T> {

    // Atributos
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tam;

    // Constructor
    public ListaDoble() {
        this.primero = null;
        this.ultimo = null;
        this.tam = 0;
    }

    // Métodos

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return this.primero == null;
    }

    // Agrega un elemento al inicio de la lista
    public void agregarInicio(T dato) {
        Nodo<T> nodo = new Nodo<>(dato);
        if (this.estaVacia()) {
            this.primero = nodo;
            this.ultimo = nodo;
        } else {
            nodo.setSiguiente(this.primero);
            this.primero.setAnterior(nodo);
            this.primero = nodo;
        }
        this.tam++;
    }

    // Agrega un elemento al final de la lista
    public void agregarFinal(T dato) {
        Nodo<T> nodo = new Nodo<>(dato);
        if (this.estaVacia()) {
            this.primero = nodo;
            this.ultimo = nodo;
        } else {
            nodo.setAnterior(this.ultimo);
            this.ultimo.setSiguiente(nodo);
            this.ultimo = nodo;
        }
        this.tam++;
    }

    // Elimina el primer elemento de la lista
    public T eliminarInicio() {
        if (this.estaVacia()) {
            return null;
        }
        T dato = this.primero.getDato();
        this.primero = this.primero.getSiguiente();
        if (this.primero != null) {
            this.primero.setAnterior(null);
        } else {
            this.ultimo = null;
        }
        this.tam--;
        return dato;
    }

    // Elimina el último elemento de la lista
    public T eliminarFinal() {
        if (this.estaVacia()) {
            return null;
        }
        T dato = this.ultimo.getDato();
        this.ultimo = this.ultimo.getAnterior();
        if (this.ultimo != null) {
            this.ultimo.setSiguiente(null);
        } else {
            this.primero = null;
        }
        this.tam--;
        return dato;
    }

    // Devuelve el tamaño de la lista
    public int getTam() {
        return this.tam;
    }

    // Vacía la lista
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
        this.tam = 0;
    }

    // Devuelve el primer nodo de la lista
    public Nodo<T> getInicio() {
        return this.primero;
    }

    // Imprime los elementos de la lista
    public void mostrar() {
        Nodo<T> aux = this.primero;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }
}


