/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music.listadobleenlazada;

import com.playmusica.Cancion;

/**
 *
 * @author barah
 */

public class Nodo<T> {
    private T dato;            // Dato del nodo
    Nodo<T> siguiente;        // Referencia al siguiente nodo
    Nodo<T> anterior;         // Referencia al nodo anterior
    String valor;             // Valor del nodo (no utilizado en el código actual)
    
    public Nodo(T dato) {     // Constructor del nodo que recibe el dato
        this.dato = dato;     // Inicializa el dato del nodo
        this.siguiente = null;// Inicializa la referencia al siguiente nodo en null
        this.anterior = null; // Inicializa la referencia al nodo anterior en null
    }

    public T getDato() {      // Método que devuelve el dato del nodo
        return dato;
    }

    public void setDato(T dato) {  // Método que establece el dato del nodo
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {   // Método que devuelve la referencia al siguiente nodo
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {  // Método que establece la referencia al siguiente nodo
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {   // Método que devuelve la referencia al nodo anterior
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {   // Método que establece la referencia al nodo anterior
        this.anterior = anterior;
    }   

    public String getNombre() {   // Método que devuelve el nombre del nodo (no utilizado en el código actual)
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public Cancion getCancion() {   // Método que devuelve la canción del nodo (no utilizado en el código actual)
        throw new UnsupportedOperationException("Not supported yet.");
    }
}


