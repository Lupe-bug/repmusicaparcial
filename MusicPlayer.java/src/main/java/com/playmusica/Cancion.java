/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.playmusica;

/**
 *
 * @author barah
 */

public class Cancion {
    private String nombre; // Almacena el nombre de la canción
    private String ruta;   // Almacena la ruta del archivo de audio de la canción

    // Constructor que acepta dos parámetros para inicializar las variables de instancia
    public Cancion(String nombre, String ruta) {
        this.nombre = nombre; // Asigna el nombre de la canción a la variable de instancia "nombre"
        this.ruta = ruta;     // Asigna la ruta del archivo de audio de la canción a la variable de instancia "ruta"
    }

    // Método de acceso para la variable de instancia "nombre"
    public String getNombre() {
        return nombre; // Devuelve el valor actual de la variable "nombre"
    }

    // Método de modificación para la variable de instancia "nombre"
    public void setNombre(String nombre) {
        this.nombre = nombre; // Asigna un nuevo valor a la variable "nombre"
    }

    // Método de acceso para la variable de instancia "ruta"
    public String getRuta() {
        return ruta; // Devuelve el valor actual de la variable "ruta"
    }

    // Método de modificación para la variable de instancia "ruta"
    public void setRuta(String ruta) {
        this.ruta = ruta; // Asigna un nuevo valor a la variable "ruta"
    }
}

