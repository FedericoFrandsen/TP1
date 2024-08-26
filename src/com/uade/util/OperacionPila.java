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

    public void pasarPila(PilaTDA pila1,PilaTDA pila2 ){
            while (!pila1.pilaVacia()){
                pila2.apilar(pila1.tope());
                pila1.desapilar();
            }
    }
    public void copiarPila(PilaTDA pila1,PilaTDA pila2 ){
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!pila1.pilaVacia()){
            aux.apilar(pila1.tope());
            pila1.desapilar();
        }
        while (!aux.pilaVacia()){
            pila2.apilar(aux.tope());
            pila1.apilar(aux.tope());
            aux.desapilar();

        }
    }
    public void invertirPila(PilaTDA pila1){
        PilaTDA aux = new PilaTDAImpl();
        PilaTDA aux2 = new PilaTDAImpl();
        aux.inicializarPila();
        aux2.inicializarPila();

        while (!pila1.pilaVacia()){
            aux.apilar(pila1.tope());
            pila1.desapilar();
        }
        while (!aux.pilaVacia()){
            aux2.apilar(aux.tope());
            aux.desapilar();
        }
        while (!aux2.pilaVacia()){
            pila1.apilar(aux2.tope());
            aux2.desapilar();
        }
    }
    public int contarElementos(PilaTDA pila1){
        int contador = 0;
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!pila1.pilaVacia()){
            aux.apilar(pila1.tope());
            pila1.desapilar();
            contador++;
        }
        while (!aux.pilaVacia()){
            pila1.apilar(aux.tope());
            aux.desapilar();
        }
        return contador;
    }
    public int sumarElementos(PilaTDA pila1){
       int suma = 0;
       while (!pila1.pilaVacia()){
           suma = suma + pila1.tope();  // ¿¿ Es lo mismo si uso cantidad += pila1.tope(); ??
           pila1.desapilar();
       }
       return suma;
    }
    public int promedioElementos(int suma, int contador){
        int promedio = 0;
        promedio = suma / contador;
        return promedio;
    }
}
