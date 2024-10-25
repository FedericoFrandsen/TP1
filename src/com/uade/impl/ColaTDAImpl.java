package com.uade.impl;
import com.uade.api.ColaTDA;

// Acolar: Insertar un elemento en la cola es una operación de acceso simple.
// Coste: O(1)

// Desacolar: Todos los elementos deben moverse una posición hacia la izquierda, lo que implica recorrer el arreglo.
// Coste: O(n), donde n es el número de elementos en la cola.

// Primero: Es una operación constante, ya que simplemente se accede al primer elemento.
// Coste: O(1)

// ColaVacia: Compara el índice de la cola con cero, lo que es una operación constante.
// Coste: O(1)



public class ColaTDAImpl implements ColaTDA {


    private int indice;
    private int[] elementos;

    @Override
    public void inicializarCola() {
    indice = 0;
    }

    @Override
    public void acolar(int x) {
        if (indice < elementos.length) {
            elementos[indice] = x;
            indice++;
        }
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            for (int i = 0; i < indice - 1; i++) {
                elementos[i] = elementos[i + 1];
            }
            indice--;
        }
    }


    @Override
    public int primero() {
        return elementos[0];
    }


    @Override
    public boolean colaVacia() {
        return indice ==0;
    }

}
