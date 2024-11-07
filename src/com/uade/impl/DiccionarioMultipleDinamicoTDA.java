package com.uade.impl;
import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioMultipleTDA;

// InicializarDiccionario: Asigna null al inicio de la lista dinámica.
// Coste: O(1)

// Agregar:
// 1. Recorre la lista para encontrar la clave, lo cual es O(n) en el peor caso.
// 2. Si la clave no está, crea un nuevo nodo y lo agrega al inicio o en la posición correspondiente, lo cual es O(1).
// 3. Si la clave está, agrega el valor al conjunto asociado, lo cual es O(n) en el peor caso (por la implementación del conjunto).
// Coste: O(n)

// Eliminar:
// 1. Recorre la lista para encontrar la clave a eliminar, lo cual es O(n).
// 2. Si encuentra la clave, actualiza el enlace del nodo anterior, lo cual es O(1).
// Coste: O(n)

// EliminarValor:
// 1. Busca la clave en la lista, lo cual es O(n).
// 2. Si encuentra la clave, elimina el valor del conjunto asociado, lo cual es O(n).
// 3. Si el conjunto queda vacío, elimina la clave de la lista, lo cual es O(n).
// Coste: O(n)

// Recuperar: Recorre la lista para encontrar la clave solicitada y devolver el conjunto de valores asociado, lo cual es O(n).
// Coste: O(n)

// Claves: Recorre toda la lista y agrega cada clave al conjunto a devolver.
// Coste: O(n)


public class DiccionarioMultipleDinamicoTDA implements DiccionarioMultipleTDA {

    private class NodoClave {
        int clave;
        ConjuntoTDA valores;
        NodoClave siguiente;
    }

    private NodoClave inicio;

    @Override
    public void inicializarDiccionario() {
        inicio = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        NodoClave actual = inicio;
        NodoClave anterior = null;

        while (actual != null && actual.clave != clave) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            NodoClave nuevoNodo = new NodoClave();
            nuevoNodo.clave = clave;
            nuevoNodo.valores = new ConjuntoConLimiteTDAImpl();
            nuevoNodo.valores.inicializarConjunto();
            nuevoNodo.valores.agregar(valor);

            if (anterior == null) {
                inicio = nuevoNodo;
            } else {
                anterior.siguiente = nuevoNodo;
            }
        } else {
            actual.valores.agregar(valor);
        }
    }

    @Override
    public void eliminar(int clave) {
        NodoClave actual = inicio;
        NodoClave anterior = null;

        while (actual != null && actual.clave != clave) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            if (anterior == null) {
                inicio = actual.siguiente;
            } else {
                anterior.siguiente = actual.siguiente;
            }
        }
    }

    @Override
    public void eliminarValor(int clave, int valor) {
        NodoClave actual = inicio;

        while (actual != null && actual.clave != clave) {
            actual = actual.siguiente;
        }

        if (actual != null) {
            actual.valores.sacar(valor);
            if (actual.valores.conjuntoVacio()) {
                eliminar(clave);
            }
        }
    }

    @Override
    public ConjuntoTDA recuperar(int clave) {
        NodoClave actual = inicio;

        while (actual != null) {
            if (actual.clave == clave) {
                return actual.valores;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conjuntoClaves = new ConjuntoConLimiteTDAImpl();
        conjuntoClaves.inicializarConjunto();
        NodoClave actual = inicio;

        while (actual != null) {
            conjuntoClaves.agregar(actual.clave);
            actual = actual.siguiente;
        }
        return conjuntoClaves;
    }
}

