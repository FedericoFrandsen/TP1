package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioSimpleTDA;

// InicializarDiccionario: Se asigna un arreglo vacío para las claves y valores, y se inicializa el conjunto de claves.
// Coste: O(1)

// Agregar:
// 1. Verifica si la clave ya existe en el conjunto de claves, lo cual es O(n).
// 2. Si la clave no está, agrega la nueva clave y el valor al final de los arreglos, lo que es O(1).
// 3. Si la clave ya existe, se reemplaza el valor correspondiente, lo que implica una búsqueda O(n).
// Coste: O(n)

// Eliminar:
// 1. Busca la clave en el arreglo, lo que implica una búsqueda lineal O(n).
// 2. Si se encuentra, reemplaza el elemento con el último elemento del arreglo y ajusta el tamaño. Esto es O(1).
// 3. Elimina la clave del conjunto de claves, lo que es O(n) debido a la implementación del conjunto.
// Coste: O(n)

// Recuperar: Se realiza una búsqueda de la clave en el arreglo, lo que requiere O(n) ya que se trata de una búsqueda lineal.
// Coste: O(n)

// Claves: Devuelve una referencia al conjunto de claves ya almacenado.
// Coste: O(1)


public class DiccionarioSimpleTDAImpl implements DiccionarioSimpleTDA {
    private int[] valores;
    private int[] claves;
    private int cantidad;
    private final int TAMANIO_MAXIMO = 100;
    private ConjuntoTDA conjuntoClaves;


    @Override
    public void InicializarDiccionario() {
        valores = new int[TAMANIO_MAXIMO];
        claves = new int[TAMANIO_MAXIMO];
        cantidad = 0;
        conjuntoClaves = new ConjuntoConLimiteTDAImpl();
        conjuntoClaves.inicializarConjunto();
    }

    @Override
    public void Agregar(int clave, int valor) {//no acepta duplicados
        if (!conjuntoClaves.pertenece(clave)) {
            if (cantidad < TAMANIO_MAXIMO) {
                claves[cantidad] = clave;
                valores[cantidad] = valor;
                conjuntoClaves.agregar(clave);
                cantidad++;
            }
        } else {
            // Si la clave ya existe, actualiza el valor asociado
            for (int i = 0; i < cantidad; i++) {
                if (claves[i] == clave) {
                    valores[i] = valor;
                    break;
                }
            }
        }
    }


    @Override
    public void Eliminar(int clave) {
//elimina elemento indicando la clave
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                claves[i] = claves[cantidad - 1]; // Reemplazar con el último elemento
                valores[i] = valores[cantidad - 1];
                conjuntoClaves.sacar(clave);
                cantidad--;
                break;
            }
        }
    }

    @Override
    public int Recuperar(int clave) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                return valores[i];
            }
        }
        throw new RuntimeException("La clave no existe.");
    }

    @Override
    public ConjuntoTDA Claves() {
        return conjuntoClaves;
    }
}

