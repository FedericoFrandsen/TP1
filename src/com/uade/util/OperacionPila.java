package com.uade.util;

import com.uade.api.ConjuntoTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ConjuntoConLimiteTDAImpl;
import com.uade.impl.PilaTDAImpl;
import java.util.Scanner;
// esCapicua: Verifica si una pila es capicúa, comparando la pila original con una versión invertida.
// Coste: O(n), donde n es el número de elementos en la pila.

// eliminarRepetidos: Elimina elementos consecutivos repetidos de una pila, usando una pila auxiliar.
// Coste: O(n), donde n es el número de elementos en la pila.

// repartirPila: Distribuye alternativamente los elementos de una pila original en dos pilas auxiliares.
// Coste: O(n), donde n es el número de elementos en la pila original.

// elementosRepetidos: Identifica los elementos consecutivos repetidos en una pila, almacenándolos en un conjunto.
// Coste: O(n), donde n es el número de elementos en la pila.


public class OperacionPila {

    public void pasarPila(PilaTDA pilaOrigen, PilaTDA pilaDestino){
            while (!pilaOrigen.pilaVacia()){
                pilaDestino.apilar(pilaOrigen.tope());
                pilaOrigen.desapilar();
            }
    }
    public void copiarPila(PilaTDA pilaOrigen, PilaTDA pilaDestino){
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!pilaOrigen.pilaVacia()){
            aux.apilar(pilaOrigen.tope());
            pilaOrigen.desapilar();
        }
        while (!aux.pilaVacia()){
            pilaDestino.apilar(aux.tope());
            pilaOrigen.apilar(aux.tope());
            aux.desapilar();

        }
    }
    public void invertirPila(PilaTDA pilaOrigen){
        PilaTDA aux = new PilaTDAImpl();
        PilaTDA aux2 = new PilaTDAImpl();
        aux.inicializarPila();
        aux2.inicializarPila();

        while (!pilaOrigen.pilaVacia()){
            aux.apilar(pilaOrigen.tope());
            pilaOrigen.desapilar();
        }
        while (!aux.pilaVacia()){
            aux2.apilar(aux.tope());
            aux.desapilar();
        }
        while (!aux2.pilaVacia()){
            pilaOrigen.apilar(aux2.tope());
            aux2.desapilar();
        }
    }
    public int contarElementos(PilaTDA pilaOrigen){
        int contador = 0;
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!pilaOrigen.pilaVacia()){
            aux.apilar(pilaOrigen.tope());
            pilaOrigen.desapilar();
            contador++;
        }
        while (!aux.pilaVacia()){
            pilaOrigen.apilar(aux.tope());
            aux.desapilar();
        }
        return contador;
    }
    public int sumarElementos(PilaTDA pilaOrigen){
       int suma = 0;
       while (!pilaOrigen.pilaVacia()){
           suma = suma + pilaOrigen.tope();  // ¿¿ Es lo mismo si uso cantidad += pila1.tope(); ??
           pilaOrigen.desapilar();
       }
       return suma;
    }
    public int promedioElementos(PilaTDA pilaOrigen){
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        copiarPila(pilaOrigen,aux);

        int suma = sumarElementos(aux);
        int contador = contarElementos(aux);

        int promedio = 0;
        if (contador > 0) {
            promedio = suma / contador;
        }
        else { System.out.println("No se puede calcular el promedio"); }
        return promedio;
    }
    public void  llenarPila(PilaTDA pila, Scanner scanner, String nombre) {
        System.out.println("Ingrese la cantidad de elmentos para la pila " + nombre + ":");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la pila " + nombre +  ":");
        for (int i = 0; i < n; i++) {
            int elemento = scanner.nextInt();
            pila.apilar(elemento);
        }

    }
    public void mostrarPila(PilaTDA pila) {
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        while (!pila.pilaVacia()){
            System.out.println(pila.tope());
            aux.apilar(pila.tope());
            pila.desapilar();
        }
        while (!aux.pilaVacia()){
            pila.apilar(aux.tope());
            aux.desapilar();
        }
    }
    public boolean esCapicua(PilaTDA pila){

        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        PilaTDA copiaPila = new PilaTDAImpl();
        copiaPila.inicializarPila();

        copiarPila(pila,copiaPila);
        copiarPila(pila,aux);
        invertirPila(copiaPila);

        while(!copiaPila.pilaVacia()){
            if (copiaPila.tope()!=aux.tope()){
                return false;
            } else {
                copiaPila.desapilar();
                aux.desapilar();
            }
        }
        return true;
    }

    public void eliminarRepetidos(PilaTDA pila){
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        invertirPila(pila);

        while (!pila.pilaVacia()){
            int valor= pila.tope();
            pila.desapilar();
            if (valor != pila.tope()){
                aux.apilar(valor);
            }
        }
        copiarPila(aux,pila);
    }



    public void repartirPila(PilaTDA pilaOriginal, PilaTDA m1, PilaTDA m2){
        boolean turno = true;
        while(!pilaOriginal.pilaVacia()) {
            if (turno) {
                m1.apilar(pilaOriginal.tope());
            }
            else {
                m2.apilar(pilaOriginal.tope());
            }
            pilaOriginal.desapilar();
            turno =!turno;
        }
    }

    public ConjuntoTDA elementosRepetidos(PilaTDA pila){
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();
        ConjuntoTDA repetidos = new ConjuntoConLimiteTDAImpl();
        repetidos.inicializarConjunto();
        copiarPila(pila,aux);


        while (!pila.pilaVacia()){
            int valor= pila.tope();
            pila.desapilar();
            if (valor == pila.tope()){
                repetidos.agregar(valor);
            }
        }
        copiarPila(aux,pila);
        return repetidos;
    }
}
