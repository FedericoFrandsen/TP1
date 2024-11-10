package com.uade.impl;

import com.uade.api.ConjuntoTDA;

import java.util.Random;

// inicializarConjunto: Establece los valores iniciales de inicio y cantidad.
// Coste: O(1)

// agregar: Recorre la lista completa para verificar si el elemento ya existe.
// Si el elemento no está y no se ha alcanzado el límite, lo agrega al inicio.
// Coste: O(n)

// elegir: Recorre la lista hasta el índice aleatorio seleccionado.
// En el peor caso, recorre toda la lista.
// Coste: O(n)

// sacar: Recorre la lista para encontrar el elemento especificado y eliminarlo.
// En el peor caso, debe recorrer toda la lista.
// Coste: O(n)

// pertenece: Recorre la lista para verificar si el elemento está presente.
// En el peor caso, debe recorrer toda la lista.
// Coste: O(n)

// conjuntoVacio: Verifica si la cantidad de elementos es 0, operación constante.
// Coste: O(1)


public class ConjuntoConLimiteDinamicoTDAImpl implements ConjuntoTDA {
    private Nodo inicio;
    private int cantidad;
    private int TamanioMaximo = 100;
    private Random rand;

    private class Nodo {
        int valor;
        Nodo siguiente;
    }

    @Override
    public void inicializarConjunto() {
        inicio = null;
        cantidad = 0;
    }

    @Override
    public void agregar(int x) {
        if (cantidad < TamanioMaximo && !pertenece(x)) {
            Nodo nuevo = new Nodo();
            nuevo.valor = x;
            nuevo.siguiente = inicio;
            inicio = nuevo;
            cantidad++;
        }
    }

    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            Random rand = new Random();
            int indiceAleatorio = rand.nextInt(cantidad);
            Nodo actual = inicio;
            for (int i = 0; i < indiceAleatorio; i++) {
                actual = actual.siguiente;
            }
            return actual.valor;
        }
        throw new RuntimeException("El conjunto está vacío.");
    }

    @Override
    public void sacar(int x) {
        Nodo actual = inicio;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.valor == x) {
                if (anterior == null) {
                    inicio = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                cantidad--;
                break;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    @Override
    public boolean pertenece(int x) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.valor == x) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }
}
