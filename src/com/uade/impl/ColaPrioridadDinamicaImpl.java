package com.uade.impl;
import com.uade.api.ColaPrioridadTDA;

//AcolarPrioridad: O(n) – En el peor de los casos, necesitarás recorrer toda la lista enlazada para encontrar la posición correcta del nuevo nodo.
//Desacolar: O(1) – Desacolar implica eliminar el primer nodo, lo que toma tiempo constante.
//Primero: O(1) – Acceder al valor del primer nodo es constante.
//ColaVacia: O(1) – Verificar si el primer nodo es null es una operación constante.
//Prioridad: O(1) – Retornar la prioridad del primer nodo es constante.


public class ColaPrioridadDinamicaImpl implements ColaPrioridadTDA {

    private class Nodo {
        int valor;
        int prioridad;
        Nodo siguiente;
    }
    private Nodo primero;

    @Override
    public void inicializarCola() {
        primero=null;
    }

    @Override
    public void acolarPrioridad(int valor, int prioridad) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = valor;
        nuevoNodo.prioridad = prioridad;

        // Insertar el nuevo nodo en la posición correcta
        if (primero == null || primero.prioridad > prioridad) {
            nuevoNodo.siguiente = primero;
            primero = nuevoNodo;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null && actual.siguiente.prioridad <= prioridad) {
                actual = actual.siguiente;
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
        }
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            primero = primero.siguiente; // Eliminar el primer nodo
        }
    }

    @Override
    public int primero() {
        if (!colaVacia()) {
            return primero.valor;
        }
        throw new RuntimeException("La cola está vacía.");

    }

    @Override
    public boolean colaVacia() {
        return primero == null;
    }

    @Override
    public int prioridad() {
        if (!colaVacia()) {
            return primero.prioridad;
        }
        throw new RuntimeException("La cola está vacía.");

    }
}
