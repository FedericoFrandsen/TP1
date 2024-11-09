package com.uade.util;

import com.uade.api.ColaTDA;
import com.uade.api.ConjuntoTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.impl.ConjuntoConLimiteTDAImpl;
import com.uade.impl.PilaTDAImpl;
// interseccionConjunto: intersección de dos conjuntos, copiando y restaurando los conjuntos originales.
// Coste: O(n * m), donde n es el número de elementos en conjunto1 y m en conjunto2.

// unionConjunto: Une dos conjuntos, copiando y restaurando los conjuntos originales.
// Coste: O(n + m), donde n y m son las cantidades de elementos en conjunto1 y conjunto2 respectivamente.

// diferenciaConjunto: Calcula la diferencia de dos conjuntos, restaurando el conjunto original.
// Coste: O(n * m), donde n es el número de elementos en conjunto1 y m en conjunto2.

// diferenciaSimetrica: Calcula la diferencia simétrica de dos conjuntos, restaurando los conjuntos originales.
// Coste: O(n * m), donde n es el número de elementos en conjunto1 y m en conjunto2.

// copiarConjunto: Copia todos los elementos de conjunto1 en conjunto2 y luego restaura conjunto1.
// Coste: O(n), donde n es el número de elementos en conjunto1.

// diferenciaSimetrica2: Calcula la diferencia simétrica utilizando la diferencia y la unión de conjuntos.
// Coste: O(n * m), donde n y m son las cantidades de elementos en conjunto1 y conjunto2 respectivamente.

// sonIguales: Compara dos conjuntos calculando la intersección y contando los elementos.
// Coste: O(n * m), donde n y m son las cantidades de elementos en conjunto1 y conjunto2 respectivamente.

// contarElementos: Cuenta los elementos en un conjunto, restaurándolo después.
// Coste: O(n), donde n es el número de elementos en el conjunto.

// interPilaCola: Calcula la intersección de los elementos de una pila y una cola.
// Coste: O(n * m), donde n es el número de elementos en la pila y m en la cola.

// mismosElementos: Verifica si una pila y una cola contienen los mismos elementos, usando conjuntos auxiliares.
// Coste: O(n * m), donde n es el número de elementos en la pila y m en la cola.


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
    public ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2){

        ConjuntoTDA difSimetrica = new ConjuntoConLimiteTDAImpl();
        difSimetrica.inicializarConjunto();
        ConjuntoTDA aux = new ConjuntoConLimiteTDAImpl();
        aux.inicializarConjunto();
        ConjuntoTDA aux2 = new ConjuntoConLimiteTDAImpl();
        aux2.inicializarConjunto();
        copiarConjunto(conjunto1,aux);
        copiarConjunto(conjunto2,aux2);

        while (!conjunto1.conjuntoVacio()){
            int elemento = conjunto1.elegir();
            conjunto1.sacar(elemento);
            if (!conjunto2.pertenece(elemento)){
                difSimetrica.agregar(elemento);
            }
        }
        while (!conjunto2.conjuntoVacio()){
            int elemento = conjunto2.elegir();
            conjunto2.sacar(elemento);
            if(!conjunto1.pertenece(elemento)){
                difSimetrica.agregar(elemento);
            }
        }
        copiarConjunto(aux,conjunto1);
        copiarConjunto(aux2, conjunto2);
        return difSimetrica;
    }
    public void copiarConjunto(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
        ConjuntoTDA aux = new ConjuntoConLimiteTDAImpl();
        aux.inicializarConjunto();

        while (!conjunto1.conjuntoVacio()){
            int elemento = conjunto1.elegir();
            conjunto1.sacar(elemento);
            conjunto2.agregar(elemento);
            aux.agregar(elemento);
        }
        while (!aux.conjuntoVacio()){
            int elemento = aux.elegir();
            conjunto1.agregar(elemento);
            aux.sacar(elemento);
        }
    }

    public ConjuntoTDA diferenciaSimetrica2(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2){
        ConjuntoTDA aDifB = diferenciaConjunto(conjunto1,conjunto2);
        ConjuntoTDA bDifA = diferenciaConjunto(conjunto1,conjunto2);
        ConjuntoTDA dif = unionConjunto(aDifB,bDifA);
        return dif;
}

    public boolean sonIguales(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2){

        ConjuntoTDA inter = interseccionConjunto(conjunto1,conjunto2);
        int cantidadElementos1 = contarElementos(conjunto1);
        int cantidadElementosInter = contarElementos(inter);

        if (cantidadElementos1 == cantidadElementosInter){
            return true;
        } else {return false;

            }
    }

    public int contarElementos(ConjuntoTDA conjunto){
        int c=0;

        while (!conjunto.conjuntoVacio()){
            int elemento = conjunto.elegir();
            conjunto.sacar(elemento);
            c++;
        }
        return c;
    }

    public ConjuntoTDA interPilaCola(PilaTDA p, ColaTDA c){
        ConjuntoTDA inter = new ConjuntoConLimiteTDAImpl();
        inter.inicializarConjunto();
        ConjuntoTDA elementosPila = new ConjuntoConLimiteTDAImpl();
        ConjuntoTDA elementosCola = new ConjuntoConLimiteTDAImpl();
        elementosPila.inicializarConjunto();
        elementosCola.inicializarConjunto();
        OperacionPila opPila = new OperacionPila();
        OperacionCola opCola = new OperacionCola();
        PilaTDA pAux = new PilaTDAImpl();
        ColaTDA cAux = new ColaTDAImpl();
        p.inicializarPila();
        c.inicializarCola();

        opPila.copiarPila(p,pAux);
        opCola.copiarCola(c,cAux);

        while (!pAux.pilaVacia()){
            elementosPila.agregar(pAux.tope());
            pAux.desapilar();
        }
        while (!cAux.colaVacia()){
            elementosCola.agregar(cAux.primero());
            cAux.desacolar();
        }
        while (!elementosPila.conjuntoVacio()){
            int valor = elementosPila.elegir();
            elementosPila.sacar(valor);

            if (elementosCola.pertenece(valor)){
                inter.agregar(valor);
            }
        }
        return inter;
    }
    public boolean mismosElementos (PilaTDA p, ColaTDA c){
        PilaTDA pAux = new PilaTDAImpl();
        ColaTDA cAux = new ColaTDAImpl();
        p.inicializarPila();
        c.inicializarCola();

        OperacionPila opPila = new OperacionPila();
        OperacionCola opCola = new OperacionCola();
        opPila.copiarPila(p,pAux);
        opCola.copiarCola(c,cAux);

        ConjuntoTDA elementosPila = new ConjuntoConLimiteTDAImpl();
        ConjuntoTDA elementosCola = new ConjuntoConLimiteTDAImpl();
        elementosPila.inicializarConjunto();
        elementosCola.inicializarConjunto();

        while (!pAux.pilaVacia()){
            elementosPila.agregar(pAux.tope());
            pAux.desapilar();
        }
        while (!cAux.colaVacia()){
            elementosCola.agregar(cAux.primero());
            cAux.desacolar();
        }
        while (!elementosPila.conjuntoVacio()){
            int valor = elementosPila.elegir();
            elementosPila.sacar(valor);

            if (!elementosCola.pertenece(valor)){
                return false;
            }
        }
        return true;
    }

}