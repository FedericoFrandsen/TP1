package com.uade.util;

import com.uade.api.ConjuntoTDA;
import com.uade.impl.ConjuntoConLimiteTDAImpl;

public class OperacionesConjuntos {

    public ConjuntoTDA  interseccionConjunto(ConjuntoTDA conjunto1,ConjuntoTDA conjunto2 ) {
    ConjuntoTDA aux = new ConjuntoConLimiteTDAImpl();
    ConjuntoTDA aux2 = new ConjuntoConLimiteTDAImpl();
    ConjuntoTDA inter = new ConjuntoConLimiteTDAImpl();
    aux.inicializarConjunto();
    aux2.inicializarConjunto();
    inter.inicializarConjunto();

    while (!conjunto1.conjuntoVacio()){
        int elemento = conjunto1.elegir();
        aux.agregar(elemento);
        aux2.agregar(elemento);
        conjunto1.sacar(elemento);
    }
    while (!aux2.conjuntoVacio()){
        int elemento = aux2.elegir();
        if(conjunto1.pertenece(elemento)){
            inter.agregar(elemento);
        }
        aux2.sacar(elemento);
    }
    while (!aux.conjuntoVacio()){
        int elemento = aux.elegir();
        conjunto1.agregar(elemento);
        aux.sacar(elemento);
    }
    return inter;
    }


    public ConjuntoTDA unionConjunto(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2){
        ConjuntoTDA aux = new ConjuntoConLimiteTDAImpl();
        ConjuntoTDA aux2 = new ConjuntoConLimiteTDAImpl();
        ConjuntoTDA aux3 = new ConjuntoConLimiteTDAImpl();
        ConjuntoTDA aux4 = new ConjuntoConLimiteTDAImpl();
        ConjuntoTDA union = new ConjuntoConLimiteTDAImpl();
        aux.inicializarConjunto();
        aux2.inicializarConjunto();
        aux3.inicializarConjunto();
        aux4.inicializarConjunto();
        union.inicializarConjunto();

        while (!conjunto1.conjuntoVacio()){
            int elemento = conjunto1.elegir();
            aux.agregar(elemento);
            aux2.agregar(elemento);
            conjunto1.sacar(elemento);
        }
        while (!conjunto2.conjuntoVacio()){
            int elemento = conjunto2.elegir();
            aux3.agregar(elemento);
            aux3.agregar(elemento);
            conjunto2.sacar(elemento);
        }
        while (!aux.conjuntoVacio()||aux3.conjuntoVacio()){
            int elemento = aux.elegir();
            int elemento2 = aux3.elegir();

            union.agregar(elemento);
            union.agregar(elemento2);
            aux.sacar(elemento);
            aux3.agregar(elemento2);
        }

        while (!aux2.conjuntoVacio()){
            int elemento = aux2.elegir();
            conjunto1.agregar(elemento);
            aux2.sacar(elemento);
        }
        while (!aux4.conjuntoVacio()){
            int elemento = aux4.elegir();
            conjunto2.agregar(elemento);
            aux4.sacar(elemento);
    }
        return union;
    }


    public ConjuntoTDA diferenciaConjunto(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2){
        ConjuntoTDA aux = new ConjuntoConLimiteTDAImpl();
        ConjuntoTDA aux2 = new ConjuntoConLimiteTDAImpl();
        ConjuntoTDA dife = new ConjuntoConLimiteTDAImpl();
        aux.inicializarConjunto();
        aux2.inicializarConjunto();
        dife.inicializarConjunto();

        while (!conjunto1.conjuntoVacio()){
            int elemento = conjunto1.elegir();
            aux.agregar(elemento);
            aux2.agregar(elemento);
            conjunto1.sacar(elemento);
        }
        while (aux2.conjuntoVacio()){
            int elemento = aux2.elegir();
            if (!conjunto1.pertenece(elemento)){
                dife.agregar(elemento);
            }
            aux2.sacar(elemento);
        }
        while (!aux.conjuntoVacio()){
            int elemento = aux.elegir();
            conjunto1.agregar(elemento);
            aux.sacar(elemento);
        }


    return dife;
    }
}
