/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.playmusica;

import music.listadobleenlazada.ListaDoble;
import music.listadobleenlazada.Nodo;

/**
 *
 * @author barah
 
 */
public class Cola<T> {
    // Atributos de la cola
    private Nodo<T> frente;  // Nodo que apunta al frente de la cola
    private Nodo<T> fin;  // Nodo que apunta al final de la cola
    private int tam;  // Tamaño actual de la cola

    // Constructor que crea una cola vacía
    public Cola() {
        this.frente = null;  // Inicializa el frente a nulo
        this.fin = null;  // Inicializa el fin a nulo
        this.tam = 0;  // Inicializa el tamaño a cero
    }

    // Constructor que crea una cola a partir de una lista doble enlazada de elementos
    public Cola(ListaDoble<T> listaCanciones) {
        Nodo<T> nodo = listaCanciones.getInicio();  // Obtiene el primer nodo de la lista
        while (nodo != null) {  // Recorre todos los nodos de la lista
            agregar(nodo.getElemento());  // Agrega el elemento del nodo a la cola
            nodo = nodo.getSiguiente();  // Avanza al siguiente nodo de la lista
        }
    }

    // Método que devuelve si la cola está vacía
    public boolean estaVacia() {
        return this.frente == null;  // Si el frente es nulo, la cola está vacía
    }

    // Método que agrega un elemento al final de la cola
    public void agregar(T elemento) {
        Nodo<T> nodo = new Nodo<>(elemento);  // Crea un nuevo nodo con el elemento
        if (estaVacia()) {  // Si la cola está vacía
            this.frente = nodo;  // El frente y el fin apuntan al nuevo nodo
            this.fin = nodo;
        } else {  // Si la cola no está vacía
            this.fin.setSiguiente(nodo);  // El último nodo apunta al nuevo nodo
            this.fin = nodo;  // El nuevo nodo se convierte en el último
        }
        this.tam++;  // Incrementa el tamaño de la cola
    }

    // Método que quita y devuelve el elemento del frente de la cola
    public T quitar() {
        if (estaVacia()) {  // Si la cola está vacía
            return null;  // Retorna nulo
        }
        T elemento = this.frente.getElemento();  // Obtiene el elemento del frente
        this.frente = this.frente.getSiguiente();  // El frente apunta al siguiente nodo
        this.tam--;  // Decrementa el tamaño de la cola
        return elemento;  // Retorna el elemento quitado
    }

    // Método que devuelve el tamaño actual de la cola
    public int getTam() {
        return this.tam;
    }

    // Método que devuelve el elemento del frente de la cola sin quitarlo
    public T getElementoFrente() {
        if (estaVacia()) {  // Si la cola está vacía
            return null;  // Retorna nulo
        }
        return this.frente.getElemento();  // Retorna el elemento del frente
    }

    // Método que devuelve el elemento del final de la cola sin quitarlo
    public T getElementoFinal() {
    // Check if the queue is empty
    if (estaVacia()) {
        return null;
    }
    // Return the element at the end of the queue
    return this.fin.getElemento();
}

public void vaciar() {
    // Set both the front and end pointers to null, effectively emptying the queue
    this.frente = null;
    this.fin = null;
    // Reset the size counter to 0
    this.tam = 0;
}

public void mostrar() {
    // Start at the front of the queue
    Nodo<T> aux = this.frente;
    // Loop through all elements until we reach the end (null)
    while (aux != null) {
        // Print out the string representation of the current element
        System.out.println(aux.getElemento().toString());
        // Move to the next element in the queue
        aux = aux.getSiguiente();
    }
}

public void cambiarSiguiente() {
    // If there's only one or zero elements in the queue, return without doing anything
    if (getTam() <= 1) {
        return;
    }
    // Remove the first element in the queue and add it to the end
    T elemento = quitar();
    agregar(elemento);
}

public void cambiarAnterior() {
    // If there's only one or zero elements in the queue, return without doing anything
    if (getTam() <= 1) {
        return;
    }
    // Remove the last element in the queue and add it to the front
    T elemento = this.fin.getElemento();
    Nodo<T> nodoAnterior = this.frente;
    // Loop through all elements until we reach the second-to-last element
    while (nodoAnterior.getSiguiente() != this.fin) {
        nodoAnterior = nodoAnterior.getSiguiente();
    }
    // Set the next pointer of the second-to-last element to null, effectively removing the last element
    nodoAnterior.setSiguiente(null);
    // Set the new end of the queue to be the second-to-last element
    this.fin = nodoAnterior;
    // Add the removed element to the front of the queue
    agregar(elemento);
}

public void reproducirAleatorio() {
    // If there's only one or zero elements in the queue, return without doing anything
    if (getTam() <= 1) {
        return;
    }
    // Create an array to hold all the elements in the queue
    T[] elementos = (T[]) new Object[getTam()];
    // Start at the front of the queue
    Nodo<T> aux = this.frente;
    // Loop through all elements, adding them to the array
    for (int i = 0; i < getTam(); i++) {
        elementos[i] = aux.getElemento();
        aux = aux.getSiguiente();
    }
    // Shuffle the array using the Fisher-Yates algorithm
    int n = getTam();
    for (int i = 0; i < getTam(); i++) {
        int r = i + (int) (Math.random() * (n - i));
        T temp = elementos[r];
        elementos[r] = elementos[i];
        elementos[i] = temp;
    }
    // Empty the queue
    vaciar();
    // Add the elements back to the queue in their shuffled order
    for (int i = 0; i < getTam(); i++) {
        agregar(elementos[i]);
    }
}
}



