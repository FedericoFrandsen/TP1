package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioMultipleTDA;
// inicializarDiccionario: Se inicializan los arreglos de claves y valores, y se establece cantidad en 0.
// Coste: O(1)

// agregar: Se busca si la clave ya existe en el diccionario (operación O(n) en el peor caso).
// Si no existe, se agrega una nueva clave en la posición `cantidad` (O(1)).
// Si existe, se agrega el valor en el conjunto asociado a esa clave, con costo O(m) siendo m la cantidad de elementos en el conjunto.
// Coste: O(n) en el peor caso si la clave no existe o O(n + m) si existe

// eliminar: Se busca la clave en el arreglo (O(n)). Si se encuentra, se elimina reemplazándola con la última clave, y se decrece `cantidad` (O(1)).
// Coste: O(n)

// eliminarValor: Se busca la clave en el arreglo (O(n)). Si se encuentra, se elimina el valor en el conjunto asociado a la clave (O(m)).
// Coste: O(n + m)

// recuperar: Se busca la clave en el arreglo (O(n)). Si se encuentra, se retorna el conjunto asociado (O(1)).
// Coste: O(n)

// claves: Retorna un conjunto de claves con O(n) porque debe recorrer todas las claves almacenadas.
// Coste: O(n)


public class DiccionarioMultipleTDAImpl implements DiccionarioMultipleTDA {


    private int[] claves;
    private ConjuntoTDA[] valores;
    private int cantidad;

    @Override
    public void inicializarDiccionario() {
        claves = new int[100];
        valores = new ConjuntoTDA[100];
        cantidad = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        int pos = posicionClave(clave);

        if (pos == -1) {
            claves[cantidad] = clave;
            valores[cantidad] = new ConjuntoConLimiteTDAImpl();
            valores[cantidad].inicializarConjunto();
            valores[cantidad].agregar(valor);
            cantidad++;
        } else {
            valores[pos].agregar(valor);
        }
    }

    @Override
    public void eliminar(int clave) {
        int pos = posicionClave(clave);
        if (pos != -1) {
            claves[pos] = claves[cantidad - 1];
            valores[pos] = valores[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public void eliminarValor(int clave, int valor) {
        int pos = posicionClave(clave);
        if (pos != -1) {
            valores[pos].sacar(valor);
            if (valores[pos].conjuntoVacio()) {
                eliminar(clave);
            }
        }
    }

    @Override
    public ConjuntoTDA recuperar(int clave) {
        int pos = posicionClave(clave);
        if (pos != -1) {
            return valores[pos];
        }
        return null;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conjuntoClaves = new ConjuntoConLimiteTDAImpl();
        conjuntoClaves.inicializarConjunto();
        for (int i = 0; i < cantidad; i++) {
            conjuntoClaves.agregar(claves[i]);
        }
        return conjuntoClaves;
    }

    private int posicionClave(int clave) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                return i;
            }
        }
        return -1;
    }
}