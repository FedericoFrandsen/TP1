package com.uade.impl;
//AcolarPrioridad: Inserta el elemento al final de la cola sin ordenarlo.
//Costo: O(1)

//Desacolar: Busca el elemento con la mayor prioridad, luego lo reemplaza con el último elemento de la cola para mantener los elementos continuos.
//Costo: O(n).

//Primero: Recorre los elementos para encontrar el de mayor prioridad.
//Costo: O(n)

//ColaVacia: Comprueba si el índice es 0, lo cual es una operación constante.
//Costo: O(1)

//Prioridad:  busca el elemento de mayor prioridad recorriendo el arreglo.
//Costo: O(n)

import com.uade.api.ColaPrioridadTDA;

public class ColaPrioridadTDAImplDos implements ColaPrioridadTDA {
    private class Elemento {
        int valor;
        int prioridad;
    }

    private Elemento[] elementos;
    private int indice;

    @Override
    public void inicializarCola() {
        elementos = new Elemento[100];
        indice = 0;
    }

    @Override
    public void acolarPrioridad(int valor, int prioridad) {
        Elemento nuevoElemento = new Elemento();
        nuevoElemento.valor = valor;
        nuevoElemento.prioridad = prioridad;

        // Insertar el nuevo elemento sin ordenarlo
        if (indice < elementos.length) {
            elementos[indice] = nuevoElemento;
            indice++;
        } else {
            throw new RuntimeException("La cola está llena.");
        }
    }

    @Override
    public void desacolar() {
        if (!colaVacia()) {
            int j = 0;

            // Encontrar el elemento de mayor prioridad
            for (int i = 1; i < indice; i++) {
                if (elementos[i].prioridad > elementos[j].prioridad) {
                    j = i;
                }
            }

            // Reemplazar el elemento de mayor prioridad con el último
            elementos[j] = elementos[indice - 1];
            indice--;
        }
    }

    @Override
    public int primero() {
        if (!colaVacia()) {
            int maxIndex = 0;

            // Buscar el elemento con la mayor prioridad
            for (int i = 1; i < indice; i++) {
                if (elementos[i].prioridad > elementos[maxIndex].prioridad) {
                    maxIndex = i;
                }
            }
            return elementos[maxIndex].valor;
        }
        throw new RuntimeException("La cola está vacía.");
    }

    @Override
    public boolean colaVacia() {
        return indice == 0;
    }

    @Override
    public int prioridad() {
        if (!colaVacia()) {
            int j = 0;

            // Buscar la mayor prioridad actual
            for (int i = 1; i < indice; i++) {
                if (elementos[i].prioridad > elementos[j].prioridad) {
                    j = i;
                }
            }
            return elementos[j].prioridad;
        }
        throw new RuntimeException("La cola está vacía.");
    }
}
