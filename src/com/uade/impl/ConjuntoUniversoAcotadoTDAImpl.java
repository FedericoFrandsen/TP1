package com.uade.impl;
import  org.uade.api.ConjuntoTDA;

import java.util.Random;


//c) Universo acotado. Considerar por ejemplo el Universo de los números enteros entre 0 y N


//InicializarConjunto: la operación asigna un valor inicial al arreglo y a la variable cantidad. La creación del arreglo también es O(1) ya que el tamaño del arreglo es constante (N).
//Costo: O(1)

// Agregar: recorre el arreglo para comprobar si el elemento ya existe, lo cual toma O(n).
//Costo:O(n)

//Elegir:es una operación de tiempo constante
//Costo:O(1)

//Sacar:Se recorre el arreglo para encontrar el elemento a eliminar, luego, reemplazarlo con el último elemento es una operación de tiempo constante O(1), pero el recorrido inicial para encontrar el elemento es O(n).
//Costo:O(n)

//Pertenece: en el peor caso, se recorre el arreglo entero para comprobar si el elemento está presente o no.
//Costo:O(n)

//ConjuntoVacio: solo compara la variable cantidad con 0, lo cual es una operación  constante.
//Costo:O(1)

public class ConjuntoUniversoAcotadoTDAImpl implements ConjuntoTDA {
    private int[] elementos;
    private int cantidad;
    public int TamanioMaximo;
    private Random rand;

    public ConjuntoUniversoAcotadoTDAImpl(int N) {
        this.TamanioMaximo = N;
        inicializarConjunto();
    }

    @Override
    public void inicializarConjunto() {
        elementos = new int[TamanioMaximo+1];
        cantidad = 0;
    }

    @Override
    public void agregar(int x) {
        if ( x>=0 &&cantidad < TamanioMaximo && !pertenece(x)) {
            elementos[cantidad] = x;
            cantidad++;
        }
    }

    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(cantidad);
            return elementos[numeroAleatorio]; // Elegir un elemento aleatorio
        }
        throw new RuntimeException("El conjunto está vacío.");
    }

    @Override
    public void sacar(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                elementos[i] = elementos[cantidad - 1]; // Reemplazar con el último elemento
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
        return cantidad==0;
    }
}
