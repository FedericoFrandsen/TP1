package com.uade.impl;

import com.uade.api.PilaTDA;

//Apilar:debido al desplazamiento de elementos al agregar un nuevo valor en la primera posición del arreglo.
//coste O(n)
//Desapilar: Eliminar el elemento en el tope es simplemente ajustar un puntero.
//coste O(1)
//Tope: Acceder al tope es constante.
//coste O(1)
//PilaVacia:Verificar si el tope es 0 es una operación constante.
//coste O(1)


public class PilaTDAImplDos implements PilaTDA {

    private int[] elementos;
    private int cantidad;

    @Override
    public void inicializarPila() {
        elementos = new int[100];
        cantidad = 0;
    }

    @Override
    public void apilar(int x) {
        if (cantidad < elementos.length) {
            // Desplazo todos los elementos una posición a la derecha
            for (int i = cantidad; i > 0; i--) {
                elementos[i] = elementos[i - 1];
            }
            elementos[0] = x; // Agrego el nuevo elemento en la primera posición
            cantidad++;
        }
    }

    @Override
    public void desapilar() {
        if (!pilaVacia()) {
            cantidad--;
        }
    }

    @Override
    public int tope() {
        if (!pilaVacia()) {
            return elementos[0];
        }
        throw new RuntimeException("La pila está vacía.");
    }

    @Override
    public boolean pilaVacia() {
        return cantidad == 0;
    }
}
