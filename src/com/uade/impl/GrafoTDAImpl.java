package com.uade.impl;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;

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

