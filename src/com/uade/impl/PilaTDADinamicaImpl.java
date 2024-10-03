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

public class PilaTDADinamicaImpl implements PilaTDA {

    private class Nodo {
        int valor;
        Nodo siguiente;
    }

    private Nodo tope;

    @Override
    public void inicializarPila() {
        tope = null;
    }

    @Override
    public void apilar(int x) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = x;
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    @Override
    public void desapilar() {
        if (!pilaVacia()) {
            tope = tope.siguiente;
        }
    }

    @Override
    public int tope() {
        if (!pilaVacia()) {
            return tope.valor;
        }
        throw new RuntimeException("La pila está vacía.");
    }

    @Override
    public boolean pilaVacia() {
        return tope == null;
    }
}
