package com.uade.app;

import com.uade.impl.ABBTDAImpl;
import com.uade.util.OperacionesABB;

public class PruebaRecorridosABB {
    public static void main(String[] args) {
        ABBTDAImpl arbol = new ABBTDAImpl();
        arbol.inicializarArbol();

        int[] elementos = {10, 5, 15, 3, 7, 12, 20, 6, 8};
        for (int elemento : elementos) {
            arbol.agregar(elemento);
        }

        OperacionesABB operaciones = new OperacionesABB();

        // Mostrar los elementos en InOrder
        System.out.print("Recorrido InOrder: ");
        operaciones.mostrarInOrder(arbol);
        System.out.println();

        // Mostrar los elementos en PreOrder
        System.out.print("Recorrido PreOrder: ");
        operaciones.mostrarPreOrder(arbol);
        System.out.println();

        // Mostrar los elementos en PostOrder
        System.out.print("Recorrido PostOrder: ");
        operaciones.mostrarPostOrder(arbol);
        System.out.println();
    }
}

