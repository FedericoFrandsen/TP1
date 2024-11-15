package com.uade.impl;

import com.uade.api.ABBTDA;

public class ABBTDAImpl implements ABBTDA {
    private NodoABB nodoRaiz;

    private class NodoABB {
        int valor;
        NodoABB hijoIzq;
        NodoABB hijoDer;
    }



    @Override
    public void inicializarArbol() {
        nodoRaiz = null;
    }

    @Override
    public int raiz() { // Permite obtener el valor de un nodo
        if (nodoRaiz != null) {
            return nodoRaiz.valor;
        }
        throw new RuntimeException("El arbol esta vacio");
    }

    @Override
    public ABBTDA hijoIzq() { // Permite obtener el subárbol izquierdo

        ABBTDAImpl subArbolIzq = new ABBTDAImpl();

       if (nodoRaiz != null && nodoRaiz.hijoIzq != null) {
           subArbolIzq.nodoRaiz = nodoRaiz.hijoIzq;
       }
        return subArbolIzq;
    }

    @Override
    public ABBTDA hijoDer() {  //Permite obtener el subárbol derecho
        ABBTDAImpl subArbolDer = new ABBTDAImpl();

        if (nodoRaiz != null && nodoRaiz.hijoDer != null) {
            subArbolDer.nodoRaiz = nodoRaiz.hijoDer;
        }
        return subArbolDer;
    }

    @Override
    public void agregar(int x) { // Permite añadir un elemento solo comprobando si ya existe.
        nodoRaiz = agregarRecursivo(nodoRaiz, x);
    }
    private NodoABB agregarRecursivo(NodoABB nodo, int x) {
        if (nodo == null) {
            NodoABB nodoNuevo = new NodoABB();
            nodoNuevo.valor = x;
            nodoNuevo.hijoIzq = null;
            nodoNuevo.hijoDer = null;
            return nodoNuevo;
        }
        if (x<nodo.valor) {
            nodo.hijoIzq = agregarRecursivo(nodo.hijoIzq, x);
        } else if (x>nodo.valor) {
            nodo.hijoDer = agregarRecursivo(nodo.hijoDer, x);
        }
        return nodo;
    }

    @Override
    public void eliminar(int x) {
        nodoRaiz = eliminarRecursivo(nodoRaiz, x);
    }
    private NodoABB eliminarRecursivo(NodoABB nodo, int x) {
        if (nodo == null) {
            return null;
        }
        if (x<nodo.valor) {
            nodo.hijoIzq = eliminarRecursivo(nodo.hijoIzq, x);
        } else if (x>nodo.valor) {
            nodo.hijoDer = eliminarRecursivo(nodo.hijoDer, x);
        } else {
            if (nodo.hijoIzq == null) {
                return nodo.hijoDer ;
            }
            if (nodo.hijoDer == null) {
                return nodo.hijoIzq;
            }
            nodo.valor = encontrarMinimo(nodo.hijoDer);
            nodo.hijoDer = eliminarRecursivo(nodo.hijoDer, nodo.valor);
        }
        return nodo;
    }
    private int encontrarMinimo(NodoABB nodo) {
        while (nodo.hijoIzq != null) {
            nodo = nodo.hijoIzq;
        }
        return nodo.valor;
    }

    @Override
    public boolean arbolVacio() {
        if (nodoRaiz == null) {
            return true;
        } else {
            return false;
        }
    }
}
