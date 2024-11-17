package com.uade.app;

import com.uade.api.GrafoTDA;
import com.uade.impl.GrafoTDAImpl;
import com.uade.util.OperacionesGrafo;

public class pruebaAristasSalientes {

    public static void main(String[] args) {

        GrafoTDA grafo = new GrafoTDAImpl();
    grafo.inicializarGrafo();
    grafo.agregarVertice(0);
    grafo.agregarVertice(1);
    grafo.agregarVertice(2);
    grafo.agregarArista(0, 1, 10);
    grafo.agregarArista(0, 2, 5);

    OperacionesGrafo operaciones = new OperacionesGrafo();
System.out.println("Mayor peso saliente de 0: " + operaciones.mayorCostoAristasSalientes(grafo, 0)); // Imprime 10

}

}