package com.uade.impl;
import com.uade.api.PilaTDA;

//Apilar:La inserción de un elemento en el tope es constante.
//coste O(1)
//Desapilar: Eliminar el elemento en el tope es simplemente ajustar un puntero.
//coste O(1)
//Tope: Acceder al tope es constante.
//coste O(1)
//PilaVacia:Verificar si el tope es 0 es una operación constante.
//coste O(1)

public class PilaTDAImpl implements PilaTDA {

    private  int[] elementos;
    private int tope = 0;

    @Override
    public void inicializarPila() {
        elementos = new int[100];
        tope=0;
    }

    @Override
    public void apilar(int x) {
        if (tope < elementos.length - 1) {
            tope++;
            elementos[tope] = x;
        }
    }

    @Override
    public void desapilar() {
        if (!pilaVacia()) {
            tope--;
        }
    }

    @Override
    public int tope() {
        if (!pilaVacia()) {
        return elementos[tope];
    }
        throw new RuntimeException("La pila está vacía.");
    }

    @Override
    public boolean pilaVacia() {
        return tope == 0;
    }
}

