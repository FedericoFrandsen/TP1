package com.uade.util;

import com.uade.api.ABBTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoConLimiteTDAImpl;

// n es el número de nodos en el árbol.
// h es la altura del árbol.

// pertenece: Busca un elemento en el árbol comparándolo con la raíz y recursivamente en los subárboles.
// Coste: O(h)

// esHoja: Verifica si un nodo específico es una hoja mediante una búsqueda recursiva.
// Coste: O(h)

// profundidad: Calcula la distancia desde la raíz hasta un nodo específico utilizando una búsqueda recursiva.
// Coste: O(h)

// obtenerMenor: Encuentra el menor elemento recorriendo el subárbol izquierdo hasta el nodo más bajo.
// Coste: O(h)

// contarElementos: Recorre todos los nodos del árbol para contarlos.
// Coste: O(n)

// sumarElementos: Recorre todos los nodos del árbol y suma sus valores.
// Coste: O(n)

// contarHojas: Visita todos los nodos para identificar cuáles son hojas.
// Coste: O(n)

// calcularAltura: Recorre todos los nodos del árbol para calcular la altura de cada subárbol.
// Coste: O(n)

// mismaForma: Compara la estructura de dos árboles recursivamente.
// Coste: O(n), donde n es el número de nodos en el árbol más grande.

// sonIguales: Compara la estructura y los valores de dos árboles recursivamente.
// Coste: O(n)

// contarElementosEnNivel: Recorre los nodos para contar cuántos están en un nivel específico.
// Coste: O(n)

// mostrarInOrder: Recorre el árbol en orden (izquierda, raíz, derecha).
// Coste: O(n)

// mostrarPreOrder: Recorre el árbol en preorden (raíz, izquierda, derecha).
// Coste: O(n)

// mostrarPostOrder: Recorre el árbol en postorden (izquierda, derecha, raíz).
// Coste: O(n)

// obtenerMayoresQue: Recorre todos los nodos para agregar al conjunto aquellos mayores que un valor dado.
// Coste: O(n)

// obtenerAnterior: Encuentra el predecesor inmediato de un valor recorriendo el árbol iterativamente.
// Coste: O(h)




public class OperacionesABB {

    public boolean pertenece(ABBTDA arbol, int x){
        if (arbol.arbolVacio()) {
            return false;
        }
        if (arbol.raiz() == x) {
            return true;
        } else if (x < arbol.raiz()) {
            return pertenece(arbol.hijoIzq(), x);
        } else {
            return pertenece(arbol.hijoDer(), x);
        }
    }

    public boolean esHoja(ABBTDA arbol, int x){
        if (arbol.arbolVacio()) {
            return false;
        }
        if (arbol.raiz()==x) {
            if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
                return true;
            }
        }
        if (x < arbol.raiz()) {
            return esHoja(arbol.hijoIzq(), x);
        } else {
            return esHoja(arbol.hijoDer(), x);
        }
    }

    public int profundidad(ABBTDA arbol, int x){
        if (arbol.arbolVacio()) {
            throw new RuntimeException("El elemento no está en el árbol.");
        }
        if (arbol.raiz()==x) {
            return 0;
        } else if (x < arbol.raiz()) {
            return 1 + profundidad(arbol.hijoIzq(), x);
        } else {
            return 1 + profundidad(arbol.hijoDer(), x);}
    }

    public int obtenerMenor(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            throw new RuntimeException("El árbol está vacío.");
        }
        ABBTDA subArbolIzq = arbol.hijoIzq();
        if (subArbolIzq.arbolVacio()) {
            return arbol.raiz();
        } else {
            return obtenerMenor(subArbolIzq);
        }
    }

    public int contarElementos(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return 1 + contarElementos(arbol.hijoIzq()) + contarElementos(arbol.hijoDer());
    }

    public int sumarElementos(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return arbol.raiz() + sumarElementos(arbol.hijoIzq()) + sumarElementos(arbol.hijoDer());
    }

    public int contarHojas(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
            return 1;
        }
        return contarHojas(arbol.hijoIzq()) + contarHojas(arbol.hijoDer());
    }

    public int calcularAltura(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        int alturaIzquierda = calcularAltura(arbol.hijoIzq());
        int alturaDerecha = calcularAltura(arbol.hijoDer());

        // Comparar las alturas de los subárboles y devolver la mayor + 1
        if (alturaIzquierda > alturaDerecha) {
            return 1 + alturaIzquierda;
        } else {
            return 1 + alturaDerecha;
        }
    }

    public boolean mismaForma(ABBTDA arbol1, ABBTDA arbol2) {
        if (arbol1.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        }
        if (arbol1.arbolVacio() || arbol2.arbolVacio()) {
            return false;
        }
        return mismaForma(arbol1.hijoIzq(), arbol2.hijoIzq()) && mismaForma(arbol1.hijoDer(), arbol2.hijoDer());
    }


    public boolean sonIguales(ABBTDA arbol1, ABBTDA arbol2) {
        if (arbol1.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        }
        if (arbol1.arbolVacio() || arbol2.arbolVacio()) {
            return false;
        }
        return (arbol1.raiz() == arbol2.raiz()) &&
                sonIguales(arbol1.hijoIzq(), arbol2.hijoIzq()) &&
                sonIguales(arbol1.hijoDer(), arbol2.hijoDer());
    }


    public int contarElementosEnNivel(ABBTDA arbol, int nivel) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        if (nivel == 0) {
            return 1;
        }
        return contarElementosEnNivel(arbol.hijoIzq(),nivel - 1) + contarElementosEnNivel(arbol.hijoDer(), nivel - 1);
    }


    //    izq - raiz - der
    public void mostrarInOrder(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            mostrarInOrder(arbol.hijoIzq());
            System.out.print(arbol.raiz() + " ");
            mostrarInOrder(arbol.hijoDer());
        }
    }

    //    raiz - izq - der
    public void mostrarPreOrder(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            System.out.print(arbol.raiz() + " ");
            mostrarPreOrder(arbol.hijoIzq());
            mostrarPreOrder(arbol.hijoDer());
        }
    }

    //    izq - der - raiz
    public void mostrarPostOrder(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            mostrarPostOrder(arbol.hijoIzq());
            mostrarPostOrder(arbol.hijoDer());
            System.out.print(arbol.raiz() + " ");
        }
    }

    // m) Dado un valor k, armar un conjunto con todos los elementos del ABB que son mayores que k.
    public ConjuntoTDA obtenerMayoresQue(ABBTDA arbol, int k) {
        ConjuntoTDA conjunto = new ConjuntoConLimiteTDAImpl(); // Usa tu implementación de conjunto.
        conjunto.inicializarConjunto();
        agregarMayoresQue(arbol, k, conjunto);
        return conjunto;
    }

    private void agregarMayoresQue(ABBTDA arbol, int k, ConjuntoTDA conjunto) {
        if (!arbol.arbolVacio()) {
            if (arbol.raiz() > k) {
                conjunto.agregar(arbol.raiz());
            }
            agregarMayoresQue(arbol.hijoIzq(), k, conjunto);
            agregarMayoresQue(arbol.hijoDer(), k, conjunto);
        }
    }

    public int obtenerAnterior(ABBTDA arbol, int x) {
        if (arbol.arbolVacio()) {
            throw new RuntimeException("El árbol está vacío.");
        }

        ABBTDA actual = arbol;
        Integer anterior = null;

        while (!actual.arbolVacio()) {
            if (x > actual.raiz()) {
                anterior = actual.raiz(); // Posible predecesor
                actual = actual.hijoDer(); // Mover al subárbol derecho
            } else {
                actual = actual.hijoIzq(); // Mover al subárbol izquierdo
            }
        }

        if (anterior == null) {
            throw new RuntimeException("No existe un predecesor para el valor dado en el árbol.");
        }

        return anterior;
    }

}
