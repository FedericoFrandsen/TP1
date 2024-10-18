package com.uade.impl;
import org.uade.api.ConjuntoTDA;

import java.util.Random;


//b) Tamaño máximo no acotado


public class ConjuntoSinLimiteTDAImpl implements ConjuntoTDA {
    private Random rand;

    private class NodoConjunto {
        int valor;
        NodoConjunto siguiente;
    }
    private NodoConjunto inicio;

    @Override
    public void inicializarConjunto() {
        inicio = null;
    }

    @Override
    public void agregar(int x) {
        if (!pertenece(x)) {
            NodoConjunto nuevoNodo = new NodoConjunto();
            nuevoNodo.valor = x;
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo; // Agregar el nuevo nodo al inicio de la lista
        }
    }

    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            Random rand = new Random();
            int cantidad = contarElementos();
            int numeroAleatorio = rand.nextInt(cantidad);

            NodoConjunto actual = inicio;
            for (int i = 0; i < numeroAleatorio; i++) {
                actual = actual.siguiente;
            }
            return actual.valor;
        }
        throw new RuntimeException("El conjunto está vacío.");
    }

    @Override
    public void sacar(int x) {
        if (inicio == null){
            return;
        }

        if (inicio.valor == x) { // Si el valor está en el primer nodo
            inicio = inicio.siguiente;
            return;
        }
        NodoConjunto actual = inicio;
        while (actual.siguiente != null && actual.siguiente.valor != x) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    @Override
    public boolean pertenece(int x) {
        NodoConjunto actual = inicio;
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

    //metodo auxiliar
    private int contarElementos() {
        NodoConjunto actual = inicio;
        int contador = 0;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
}
