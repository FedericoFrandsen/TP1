package com.uade.impl;
import com.uade.api.ColaTDA;

// Insertar un elemento en la cola es una operacion de acceso simple O(1)
// Para desacolar, todos los elementos deben moverse una posición hacia la izquierda, lo que implica recorrer el arreglo
// y por ende el costo es O(n), donde n es el numero de elementos de la cola
//  Primero es una operacion constante, por lo que el costo es O(1)
// ColaVacia compara la longitud de la cola con cero, por lo que es constante y su costo es O(1)


public class ColaTDAImpl implements ColaTDA {

    private int longitud;
    private int[] elementos;

    @Override
    public void inicializarCola() {
    longitud = 0;
    }

    @Override
    public void acolar(int x) {
        if (longitud < elementos.length) {
            elementos[longitud] = x;
            longitud++;
        }
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            for (int i = 0; i < longitud - 1; i++) {
                elementos[i] = elementos[i + 1];
            }
            longitud--;
        }
    }


    @Override
    public int primero() {
        return elementos[0];
    }


    @Override
    public boolean colaVacia() {
        return longitud==0;
    }

}
