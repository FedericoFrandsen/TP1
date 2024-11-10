package com.uade.impl;
import com.uade.api.ConjuntoTDA;

import java.util.Random;
//InicializarConjunto: Solo se asigna un arreglo de tamaño inicial y se establece `cantidad` en 0.
//Coste: O(1)

//Agregar (agregar): Primero verifica si el elemento ya está en el conjunto (operación O(n)). Si el elemento no existe y el arreglo está lleno, se llama a `expandirArreglo` (operación O(n)); en caso contrario, simplemente agrega el elemento al final (O(1)).
//Coste promedio: O(n)
//Coste peor caso: O(n)

//Expandir arreglo (expandirArreglo): Duplica el tamaño del arreglo y copia todos los elementos del arreglo original al nuevo.
//Coste: O(n)

//Elegir (elegir): Selecciona un índice aleatorio y accede al elemento en el arreglo. Seleccionar el índice es O(1), pero contar elementos (en este caso, `cantidad`) es ya conocido.
//Coste: O(1)

//Sacar (sacar): En el peor caso, se recorre el arreglo para encontrar el elemento a eliminar y luego reorganiza el último elemento en la posición del eliminado.
//Coste: O(n)

//Pertenecer (pertenece): Recorre tdo el arreglo para verificar si el elemento ya está en el conjunto.
//Coste: O(n)

//Conjunto vacío (conjuntoVacio): Solo se verifica si `cantidad` es 0.
//Coste: O(1)

public class ConjuntoSinLimiteTDAImpl implements ConjuntoTDA {
    private int[] elementos;
    private int cantidad;
    private final int TAMANIO_INICIAL = 10;

    @Override
    public void inicializarConjunto() {
        elementos = new int[TAMANIO_INICIAL];
        cantidad = 0;
    }

    @Override
    public void agregar(int x) {
        if (!pertenece(x)) {
            if (cantidad == elementos.length) {
                expandirArreglo();
            }
            elementos[cantidad] = x;
            cantidad++;
        }
    }

    private void expandirArreglo() {
        int nuevoTamanio = elementos.length * 2;
        int[] nuevoArreglo = new int[nuevoTamanio];
        for (int i = 0; i < elementos.length; i++) {
            nuevoArreglo[i] = elementos[i];
        }
        elementos = nuevoArreglo;
    }

    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(cantidad);
            return elementos[numeroAleatorio];
        }
        throw new RuntimeException("El conjunto está vacío.");
    }

    @Override
    public void sacar(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                elementos[i] = elementos[cantidad - 1];
                cantidad--;
                break;
            }
        }
    }

    @Override
    public boolean pertenece(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }
}
