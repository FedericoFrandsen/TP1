package com.uade.impl;

import com.uade.api.ColaTDA;

//Acolar: Se crea un nuevo nodo y se ajusta el puntero del último nodo. Como no es necesario recorrer la lista para añadir, es una operación constante.
//Costo: O(1)
//Desacolar: El puntero del frente de la cola se ajusta para apuntar al siguiente nodo. No hay necesidad de recorrer toda la lista.
//Costo: O(1)
//Primero:Acceder al valor del nodo al que apunta el frente es una operación de tiempo constante.
//Costo: O(1)
//ColaVacia:Se chequea si el puntero de frente es nulo. Esto es una operación de tiempo constante.
//Costo: O(1)

public class ColaTDADinamicaImpl implements ColaTDA {
    private class Nodo {
        int valor;
        Nodo siguiente;
    }

    private Nodo frente;  // Apunta al frente de la cola (primer elemento)
    private Nodo finalCola; // Apunta al final de la cola (último elemento)


    @Override
    public void inicializarCola() {
        frente = null;
        finalCola = null;
    }

    @Override
    public void acolar(int x) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = x;
        nuevoNodo.siguiente = null; // El nuevo nodo será el último, por lo que no tiene siguiente

        if (finalCola != null) {
            finalCola.siguiente = nuevoNodo; // El último nodo actual ahora apunta al nuevo nodo
        }
        finalCola = nuevoNodo; // El nuevo nodo es ahora el último en la cola

        // Si la cola estaba vacía, el frente también debe apuntar al nuevo nodo
        if (frente == null) {
            frente = nuevoNodo;
        }
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            frente = frente.siguiente; // El frente ahora apunta al siguiente nodo

            // Si el frente llega a ser null, significa que la cola está vacía
            if (frente == null) {
                finalCola = null;
            }
        }
    }

    @Override
    public int primero() {
        if (!colaVacia()) {
        return frente.valor;
    }
        throw new RuntimeException("La cola está vacía.");
}
    @Override
    public boolean colaVacia() {
        return frente == null; // Si el frente es null, no hay elementos en la cola
    }
}
