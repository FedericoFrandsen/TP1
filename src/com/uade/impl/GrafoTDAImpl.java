package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;

// inicializarGrafo: Inicializa la matriz de adyacencia con un tamaño fijo y el conjunto de vértices.
// Coste espacial: O(n²) debido a la matriz de adyacencia, donde n es MAX_VERTICES.
// Coste temporal: O(n²) debido a la inicialización de la matriz.

// agregarVertice: Agrega un vértice al conjunto de vértices si no está presente.
// Coste espacial: O(1).
// Coste temporal: O(n), donde n es la cantidad de vértices en el conjunto, debido a la verificación en `pertenece`.

// eliminarVertice: Elimina un vértice del conjunto y todas las aristas asociadas en la matriz.
// Coste espacial: O(1).
// Coste temporal: O(n), donde n es MAX_VERTICES, por recorrer todas las aristas asociadas al vértice.

// vertices: Devuelve el conjunto de vértices activos en el grafo.
// Coste espacial: O(1).
// Coste temporal: O(1), ya que simplemente devuelve el conjunto.

// agregarArista: Agrega o actualiza una arista en la matriz de adyacencia.
// Coste espacial: O(1).
// Coste temporal: O(1), al acceder directamente a la matriz en la posición [v1][v2].

// eliminarArista: Elimina una arista asignando un valor especial (SIN_ARISTA) en la matriz.
// Coste espacial: O(1).
// Coste temporal: O(1), al acceder directamente a la matriz en la posición [v1][v2].

// ExisteArista: Comprueba si hay una arista entre dos vértices.
// Coste espacial: O(1).
// Coste temporal: O(1), al acceder directamente a la matriz y verificar su valor.

// pesoArista: Devuelve el peso de la arista entre dos vértices o lanza una excepción si no existe.
// Coste espacial: O(1).
// Coste temporal: O(1), al acceder directamente a la matriz en la posición [v1][v2].


public class GrafoTDAImpl implements GrafoTDA {

    private static final int MAX_VERTICES = 100; // Tamaño máximo de la matriz
    private static final int SIN_ARISTA = -1; // -1 = ausencia de arista
    private int[][] matrizAdyacencia;
    private ConjuntoTDA conjuntoVertices;

    @Override
    public void inicializarGrafo() {
        matrizAdyacencia = new int[MAX_VERTICES][MAX_VERTICES];
        conjuntoVertices = new ConjuntoConLimiteTDAImpl(); // Usa tu implementación
        conjuntoVertices.inicializarConjunto();

        //Inicializo todas las aristas como inexistentes
        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                matrizAdyacencia[i][j] = SIN_ARISTA;
            }
        }
    }

    @Override
    public void agregarVertice(int vertice) {
        if (!conjuntoVertices.pertenece(vertice)) {
            conjuntoVertices.agregar(vertice);
        }
    }

    @Override
    public void eliminarVertice(int vertice) {
        if (conjuntoVertices.pertenece(vertice)) {
            conjuntoVertices.sacar(vertice);

            // Eliminar las aristas asociadas al vértice
            for (int i = 0; i < MAX_VERTICES; i++) {
                matrizAdyacencia[vertice][i] = SIN_ARISTA; // Aristas salientes
                matrizAdyacencia[i][vertice] = SIN_ARISTA; // Aristas entrantes
            }
        }
    }

    @Override
    public ConjuntoTDA vertices() {
        return conjuntoVertices;
    }

    @Override
    public void agregarArista(int v1, int v2, int peso) {
        if (conjuntoVertices.pertenece(v1) && conjuntoVertices.pertenece(v2)) {
            matrizAdyacencia[v1][v2] = peso;
        }
    }

    @Override
    public void eliminarArista(int v1, int v2) {
        if (conjuntoVertices.pertenece(v1) && conjuntoVertices.pertenece(v2)) {
            matrizAdyacencia[v1][v2] = SIN_ARISTA;
        }
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        return conjuntoVertices.pertenece(v1) && conjuntoVertices.pertenece(v2) && matrizAdyacencia[v1][v2] != SIN_ARISTA;
    }

    @Override
    public int pesoArista(int v1, int v2) {
        if (conjuntoVertices.pertenece(v1) && conjuntoVertices.pertenece(v2) && matrizAdyacencia[v1][v2] != SIN_ARISTA) {
            return matrizAdyacencia[v1][v2];
        }
        throw new RuntimeException("No existe arista entre " + v1 + " y " + v2);
    }
    }

