package com.uade.util;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;

public class OperacionPila {

    //a) Pasar una Pila a otra (dejándola en orden inverso)
    //b) Copiar una Pila en otra (dejándola en el mismo orden que la original)
    //c) Invertir el contenido de una Pila.
    //d) Contar los elementos de una Pila
    //e) Sumar los elementos de una Pila
    //f) Calcular el promedio de los elementos de una Pila

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
}
