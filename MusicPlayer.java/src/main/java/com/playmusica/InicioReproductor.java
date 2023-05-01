/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.playmusica;

/**
 *
 * @author barah
 */

import java.io.File;
import java.util.Scanner;

import music.listadobleenlazada.ListaDoble;
import music.listadobleenlazada.Nodo;

public class InicioReproductor {

   public static void main(String[] args) {
    // Crea un objeto File para el directorio que contiene las canciones
    File folder = new File("C:\\Users\\barah\\Music\\musicapar");
    
    // Crea una lista doble enlazada con las canciones del directorio
    ListaDoble listaCanciones = listFilesForFolder(folder);
    
    // Crea una cola de reproducción con la lista de canciones
    Cola colaCanciones = new Cola(listaCanciones);

    // Define una variable booleana para determinar si continuar o no en el bucle
    boolean continuar = true;
    
    // Crea un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);

    // Ejecuta el bucle mientras continuar sea verdadero
    while (continuar) {
        // Muestra el menú
        menu();
        
        // Lee la opción seleccionada por el usuario
        int opcion = scanner.nextInt();

        // Ejecuta una acción dependiendo de la opción seleccionada
        switch (opcion) {
            case 1:
                playMusica(colaCanciones);
                break;
            case 2:
                cambiarCancion(colaCanciones, true);
                break;
            case 3:
                cambiarCancion(colaCanciones, false);
                break;
            case 4:
                modoAleatorio(colaCanciones);
                break;
            case 5:
                volverReproducir(colaCanciones);
                break;
            case 6:
                continuar = false;
                break;
            default:
                System.out.println("Opción no válida");
        }
    }
}

// Función que muestra el menú de opciones
public static void menu() {
    System.out.println("\n==== Reproductor de Música ====");
    System.out.println("1. Reproducir música");
    System.out.println("2. Cambiar a la siguiente canción");
    System.out.println("3. Cambiar a la canción anterior");
    System.out.println("4. Modo aleatorio");
    System.out.println("5. Volver a reproducir");
    System.out.println("6. Salir");
    System.out.print("Elija una opción: ");
}

// Función que crea una lista doble enlazada con las canciones del directorio especificado
public static ListaDoble listFilesForFolder(final File folder) {
    ListaDoble listaCanciones = new ListaDoble();
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isFile()) {
            String nombreArchivo = fileEntry.getName();
            if (nombreArchivo.endsWith(".mp3") || nombreArchivo.endsWith(".wav")) {
                listaCanciones.insertarAlFinal(nombreArchivo);
            }
        }
    }
    return listaCanciones;
}

// Función que reproduce la canción en la parte frontal de la cola de canciones
public static void playMusica(Cola colaCanciones) {
    if (!colaCanciones.esVacia()) {
        Cancion cancionActual = colaCanciones.quitar();
        System.out.println("Reproduciendo canción: " + cancionActual.getNombre());
    } else {
        System.out.println("No hay canciones para reproducir.");
    }
}

// Función que cambia la canción actual en la cola de reproducción
public static void cambiarCancion(Cola colaCanciones, boolean siguiente) {
    // Verificar si la cola de canciones no está vacía
    if (!colaCanciones.esVacia()) {
        // Obtener la canción actual en la parte frontal de la cola
        Nodo cancionActual = colaCanciones.verFrente();

        if (siguiente) {
            // Si se especificó cambiar a la siguiente canción, quitar la canción actual de la cola
            colaCanciones.quitar();
            // Insertar la canción actual al final de la cola, para que se reproduzca después de la siguiente canción
            colaCanciones.insertarAlFinal(cancionActual.getNombre());
            // Imprimir un mensaje indicando la canción actual que se está reproduciendo
            System.out.println("Cambiando a la siguiente canción: " + colaCanciones.verFrente().getNombre());
        } else {
            // Si se especificó cambiar a la canción anterior, quitar la canción actual de la cola
            // y colocarla al frente de la cola, para que se reproduzca antes de la canción anterior
            colaCanciones.insertarAlFrente(colaCanciones.quitar());
            // Imprimir un mensaje indicando la canción actual que se está reproduciendo
            System.out.println("Cambiando a la canción anterior: " + colaCanciones.verFrente().getNombre());
        }
    }
}

// Esta función privada aún no está implementada
private static void modoAleatorio(Cola colaCanciones) {
    throw new UnsupportedOperationException("Not supported yet."); 
}

// Esta función privada aún no está implementada
private static void volverReproducir(Cola colaCanciones) {
    throw new UnsupportedOperationException("Not supported yet."); 
}
}
