package com.uade.util;

import com.uade.api.ConjuntoTDA;
import com.uade.api.GrafoTDA;
import com.uade.impl.ConjuntoConLimiteTDAImpl;

// adyacentesDobles: Devuelve el conjunto de vértices adyacentes dobles de un vértice dado.
// Coste espacial: O(1), ya que no se almacenan estructuras adicionales más allá del conjunto resultado.
// Coste temporal: O(n²), donde n es MAX_VERTICES, debido a los dos bucles anidados que recorren vértices.


// mayorCostoAristasSalientes: Encuentra el mayor peso entre las aristas salientes de un vértice.
// Coste espacial: O(1), no se utilizan estructuras adicionales.
// Coste temporal: O(n), donde n es MAX_VERTICES, al recorrer los posibles destinos para encontrar el mayor peso.


// predecesores: Devuelve el conjunto de vértices que tienen aristas entrantes hacia un vértice dado.
// Coste espacial: O(1), además del conjunto resultado.
// Coste temporal: O(n), donde n es MAX_VERTICES, al recorrer todos los vértices para buscar aristas entrantes.


// verticesAislados: Devuelve el conjunto de vértices aislados en el grafo (sin aristas entrantes ni salientes).
// Coste espacial: O(1), además del conjunto resultado.
// Coste temporal: O(n²), donde n es MAX_VERTICES, debido a las verificaciones de conectividad para cada vértice con todos los demás.


// verticesPuente: Devuelve el conjunto de vértices puente entre dos vértices dados.
// Coste espacial: O(1), además del conjunto resultado.
// Coste temporal: O(n), donde n es MAX_VERTICES, al recorrer los vértices intermedios para verificar las aristas.


// gradoVertice: Calcula el grado de un vértice como la diferencia entre el número de aristas salientes y entrantes.
// Coste espacial: O(1), no se utilizan estructuras adicionales.
// Coste temporal: O(n), donde n es MAX_VERTICES, al recorrer todos los vértices para contar aristas entrantes y salientes.


public class OperacionesGrafo {


    //4) Dado un Grafo G y un vértice v, calcular el conjunto de vértices AdyacentesDobles de v.
    //Se define que un vértice w es adyacente doble de un vértice v, si existe otro vértice x y hay
    //una arista que comienza en v y termina en x y otra que comienza en x y termina en w.


    public ConjuntoTDA adyancentesDobles(GrafoTDA grafo, int v){
        ConjuntoTDA resultado = new ConjuntoConLimiteTDAImpl();
        resultado.inicializarConjunto();

        if (!grafo.vertices().pertenece(v)) {
            throw new RuntimeException("El vértice no existe.");
        }
        for (int x = 0; x < 100; x++) { // 100 es MAX_VERTICES
            if (grafo.ExisteArista(v, x)) { // Hay una arista de v a x
                for (int w = 0; w < 100; w++) {
                    if (grafo.ExisteArista(x, w)) { // Hay una arista de x a w
                        resultado.agregar(w); // Agregamos w como adyacente doble de v
                    }
                }
            }
        }

        return resultado;
    }

    //5) Dado un vértice v de un grafo, calcular el mayor de los costos de las aristas salientes.

    public int mayorCostoAristasSalientes(GrafoTDA grafo, int v) {
        if (!grafo.vertices().pertenece(v)) {
            throw new RuntimeException("El vértice no existe.");
        }

        int maxPeso = -1; // -1 = no hay aristas.

        for (int i = 0; i < 100; i++) { // Iteramos sobre los posibles destinos.
            if (grafo.ExisteArista(v, i)) {
                int peso = grafo.pesoArista(v, i);
                if (maxPeso == -1 || peso > maxPeso) { // Actualizamos el máximo si es necesario.
                    maxPeso = peso;
                }
            }
        }

        if (maxPeso == -1) {
            throw new RuntimeException("El vértice no tiene aristas salientes.");
        }

        return maxPeso;
    }

    //6) Dado un Grafo G y un vértice v, escribir un metodo que permita obtener el conjunto de los
    //Predecesores del vértice v en G.
    //Se define que un vértice o es predecesor de otro vértice d, si hay una arista que comienza
    //en o y termina en d.

    public ConjuntoTDA predecesores(GrafoTDA grafo, int v) {
        ConjuntoTDA resultado = new ConjuntoConLimiteTDAImpl();
        resultado.inicializarConjunto();

        if (!grafo.vertices().pertenece(v)) {
            throw new RuntimeException("El vértice no tiene aristas salientes.");
        }

        for (int o = 0; o < 100; o++) {
            if (grafo.ExisteArista(o, v)) { // Hay una arista de o a v
                resultado.agregar(o);
            }
        }
        return resultado;
    }

    //7) Dado un Grafo G escribir un metodo que permita obtener el conjunto de los vértices aislados en G.
    public ConjuntoTDA verticesAislados(GrafoTDA grafo) {
    ConjuntoTDA resultado = new ConjuntoConLimiteTDAImpl();
        resultado.inicializarConjunto();

        ConjuntoTDA vertices = grafo.vertices();
        int verticeActual;

        while (!vertices.conjuntoVacio()) {
            verticeActual = vertices.elegir();
            vertices.sacar(verticeActual);

            boolean aislado = true;

            for (int i = 0; i < 100; i++) {
                if (grafo.ExisteArista(verticeActual, i) || grafo.ExisteArista(i, verticeActual)) {
                aislado = false;
                break;
                 }
             }

             if (aislado) {
            resultado.agregar(verticeActual);
            }
        }

        return resultado;
    }
    // 8. Obtener el conjunto de vértices puente entre dos vértices
    public ConjuntoTDA verticesPuente(GrafoTDA grafo, int v1, int v2) {
        ConjuntoTDA resultado = new ConjuntoConLimiteTDAImpl();
        resultado.inicializarConjunto();

        if (!grafo.vertices().pertenece(v1) || !grafo.vertices().pertenece(v2)) {
            throw new RuntimeException("Uno de los vertices no existe");
        }

        for (int p = 0; p < 100; p++) {
            if (grafo.ExisteArista(v1, p) && grafo.ExisteArista(p, v2)) {
                resultado.agregar(p);
            }
        }

        return resultado;
    }

    // 9. Calcular el grado de un vértice
    public int gradoVertice(GrafoTDA grafo, int v) {
        if (!grafo.vertices().pertenece(v)) {
            throw new RuntimeException("El vértice no existe.");
        }

        int salientes = 0;
        int entrantes = 0;

        for (int i = 0; i < 100; i++) {
            if (grafo.ExisteArista(v, i)) {
                salientes++;
            }
            if (grafo.ExisteArista(i, v)) {
                entrantes++;
            }
        }

        return salientes - entrantes;
    }
}
