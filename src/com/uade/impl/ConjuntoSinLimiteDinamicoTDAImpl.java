package com.uade.impl;

import com.uade.api.ConjuntoTDA;

import java.util.Random;

//b) Tamaño máximo no acotado


//InicializarConjunto: Solo se asigna null al puntero inicio.
//Coste: O(1)

//Agregar: Se debe verificar si el elemento ya existe en el conjunto (operación O(n)). Si no está, agregar el elemento en la cabeza de la lista es O(1).
//Coste: O(n)

//Elegir (elegir):Se debe contar los elementos (O(n)) y luego recorrer la lista hasta el índice aleatorio (también O(n)).
//Coste: O(n)

//Sacar (sacar): En el peor caso, se debe recorrer toda la lista para encontrar el valor a eliminar.
//Coste:O(n)

//Pertenecer (pertenece): Se debe recorrer toda la lista para verificar si el elemento está en el conjunto.
//Coste:O(n)

//Conjunto vacío (conjuntoVacio): Solo se verifica si inicio es null.
//Coste:O(1)




public class ConjuntoSinLimiteDinamicoTDAImpl implements ConjuntoTDA {
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
            inicio = nuevoNodo;
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

        if (inicio.valor == x) {
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
