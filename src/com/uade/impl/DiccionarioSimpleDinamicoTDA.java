package com.uade.impl;
import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioSimpleTDA;

// InicializarDiccionario: Se inicializa la lista dinámica y el conjunto de claves.
// Coste: O(1)

// Agregar:
// 1.  si la clave ya existe en el conjunto de claves usando `pertenece`, lo cual es O(n).
// 2. Si la clave existe, recorre la lista para encontrar el nodo y actualizar su valor, lo cual es O(n).
// 3. Si la clave no existe, crea un nuevo nodo y lo agrega al inicio de la lista, lo cual es O(1).
// 4. Agrega la clave al conjunto de claves usando `agregar`, lo cual es O(n).
// Coste: O(n)

// Eliminar:
// 1. Verifica si la clave existe en el conjunto de claves usando `pertenece`, lo cual es O(n).
// 2. Si la clave existe, recorre la lista para encontrar el nodo y eliminarlo, actualizando los enlaces, lo cual es O(n).
// 3. Elimina la clave del conjunto de claves usando `sacar`, lo cual es O(n).
// Coste: O(n)

// Recuperar:
// Recorre la lista para encontrar la clave y devolver su valor, lo que requiere O(n) en el peor caso.
// Coste: O(n)

// Claves:
// Devuelve una referencia al conjunto de claves ya almacenado.
// Coste: O(1)


public class DiccionarioSimpleDinamicoTDA implements DiccionarioSimpleTDA {

    private class Nodo {
        int clave;
        int valor;
        Nodo siguiente;
    }
    private Nodo inicio;
    private ConjuntoTDA conjuntoClaves;

    @Override
    public void InicializarDiccionario() {
        inicio = null;
        conjuntoClaves = new ConjuntoConLimiteTDAImpl();
        conjuntoClaves.inicializarConjunto();
    }

    @Override
    public void Agregar(int clave, int valor) {
        if(conjuntoClaves.pertenece(clave)) {
            Nodo actual = inicio;
            while(actual!=null) {
                if(actual.clave == clave) {
                    actual.valor = valor;
                    return;
                }
                actual = actual.siguiente;
            }
        }else {// Si la clave no existe, la agregamos
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.clave = clave;
            nuevoNodo.valor = valor;
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
            conjuntoClaves.agregar(clave);
        }
    }


    @Override
    public void Eliminar(int clave) {
        if (conjuntoClaves.pertenece(clave)) {
            Nodo actual = inicio;
            Nodo anterior = null;
            while (actual != null) {
                if (actual.clave == clave) {
                    if (anterior == null) {
                        inicio = actual.siguiente;
                    } else {
                        anterior.siguiente = actual.siguiente;
                    }
                    conjuntoClaves.sacar(clave); // Quitar la clave del conjunto
                    return;
                }
                anterior = actual;
                actual = actual.siguiente;
            }
        }
    }

    @Override
    public int Recuperar(int clave) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.clave == clave) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        throw new RuntimeException("La clave no existe.");

    }

    @Override
    public ConjuntoTDA Claves() {
        return conjuntoClaves;
    }
}
