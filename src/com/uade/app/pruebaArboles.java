package com.uade.app;

import com.uade.api.ABBTDA;
import com.uade.impl.ABBTDAImpl;
import com.uade.util.OperacionesABB;

public class pruebaArboles {
    public static void main(String[] args) {
            // Crear el árbol y las operaciones
            ABBTDA arbol = new ABBTDAImpl();
            OperacionesABB operaciones = new OperacionesABB();

            // Inicializar el árbol
            arbol.inicializarArbol();

            // Agregar elementos al árbol
            arbol.agregar(10);
            arbol.agregar(5);
            arbol.agregar(15);
            arbol.agregar(3);
            arbol.agregar(7);
            arbol.agregar(20);
            arbol.agregar(17);
            arbol.agregar(39); // Para hacerlo más interesante
            arbol.agregar(40);

            // Calcular la altura
            int altura = operaciones.calcularAltura(arbol);

            // Mostrar el resultado
            System.out.println("La altura del árbol es: " + altura);
        }
    }


