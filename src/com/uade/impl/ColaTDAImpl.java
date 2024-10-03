package com.uade.impl;
import com.uade.api.ColaTDA;

// Insertar un elemento en la cola es una operacion de acceso simple O(1)
// Para desacolar, todos los elementos deben moverse una posición hacia la izquierda, lo que implica recorrer el arreglo
// y por ende el costo es O(n), donde n es el numero de elementos de la cola
//  Primero es una operacion constante, por lo que el costo es O(1)
// ColaVacia compara la indiced de la cola con cero, por lo que es constante y su costo es O(1)


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
