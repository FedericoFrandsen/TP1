package com.uade.impl;

import com.uade.api.ColaTDA;

// Acolar: Insertar un elemento en la cola es una operación de acceso simple.
// Coste: O(1)

// Desacolar: desacolar solo implica mover el índice de inicio una posición hacia adelante sin desplazar elementos.
// Coste: O(1)

// Primero: Es una operación constante, ya que simplemente se accede al elemento en la posición de inicio de la cola.
// Coste: O(1)

// ColaVacia: Comprueba si el índice de inicio es igual al índice de fin, lo que es una operación constante.
// Coste: O(1)

public class ColaTDAImplDos implements ColaTDA {
    private int[] elementos;
    private int indice;
    private int fondo;  //  próximo espacio libre para el siguiente elemento
    private int MAX = 100;

    @Override
    public void inicializarCola() {
        elementos = new int[100];
        indice = 0;
        fondo = 0;
    }

    @Override
    public void acolar(int x) {
        if ((fondo + 1) % MAX != indice) { // Si la cola no está llena
            elementos[fondo] = x;
            fondo = (fondo + 1) % MAX;
        }
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            indice = (indice + 1) % MAX;
        }
    }

    @Override
    public int primero() {
        if (!colaVacia()) {
            return elementos[indice];
        }
        throw new RuntimeException("La cola está vacía.");
    }

    @Override
    public boolean colaVacia() {
        return indice == fondo;
    }
}
