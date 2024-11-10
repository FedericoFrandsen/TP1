package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import java.util.Random;
//InicializarConjunto: Solo asigna null al puntero inicio.
//Coste: O(1)

//Agregar : Comprueba si el elemento ya existe (O(n)) y cuenta los elementos actuales (O(n)) para respetar el tamaño máximo. Si es posible, agrega el nuevo nodo en el inicio (O(1)).
//Coste: O(n)

//Elegir : Cuenta los elementos (O(n)) y recorre la lista hasta el índice aleatorio seleccionado (O(n)).
//Coste: O(n)

//Sacar : En el peor caso, recorre toda la lista para encontrar y eliminar el nodo correspondiente.
//Coste: O(n)

//Pertenecer : Recorre la lista para comprobar si el elemento existe en el conjunto.
//Coste: O(n)

//Conjunto vacío : Comprueba si el puntero inicio es null.
//Coste: O(1)

public class ConjuntoUniversoAcotadoDinamicoTDAImpl implements ConjuntoTDA {
    private int tamanioMaximo;
    private Nodo inicio;

    private class Nodo {
        int valor;
        Nodo siguiente;
    }

    public ConjuntoUniversoAcotadoDinamicoTDAImpl(int N) {
        this.tamanioMaximo = N;
        inicializarConjunto();
    }

    @Override
    public void inicializarConjunto() {
        inicio = null;
    }

    @Override
    public void agregar(int x) {
        if (x >= 0 && contarElementos() < tamanioMaximo && !pertenece(x)) {
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.valor = x;
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        }
    }

    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            int cantidad = contarElementos();
            int indiceAleatorio = new Random().nextInt(cantidad);

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
        if (inicio == null) {
            return;
        }

        if (inicio.valor == x) {
            inicio = inicio.siguiente;
            return;
        }

        Nodo actual = inicio;
        while (actual.siguiente != null && actual.siguiente.valor != x) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
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
        return inicio == null;
    }

    private int contarElementos() {
        int contador = 0;
        Nodo actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
}
