package com.uade.util;

//4) A partir del TDA Cola definido, escribir distintos métodos que permitan
//a) Pasar una Cola a otra
//b) Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
//c) Invertir el contenido de una Cola (NO pueden usarse Pilas auxiliares)
//d) Determinar si el final de la Cola C1 coincide o no con la Cola C2.
//e) Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
//que el primer elemento es igual al último, el segundo igual al penúltimo, etc.
//f) Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán
//inversas, si tienen los mismos elementos pero en orden inverso

import com.uade.api.ColaTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;

public class OperacionCola {
    public void pasarCola(ColaTDA colaOrigen, ColaTDA colaDestino){
        while (!colaOrigen.colaVacia()){
            colaDestino.acolar(colaOrigen.primero());
            colaOrigen.desacolar();
        }
    }
    public void invertirCola(ColaTDA colaOrigen){
        PilaTDA aux = new PilaTDAImpl();
        aux.inicializarPila();

        while (!colaOrigen.colaVacia()){
        aux.apilar(colaOrigen.primero());
        colaOrigen.desacolar();
    }
        while (!aux.pilaVacia()){
        colaOrigen.acolar(aux.tope());
        aux.desapilar();
        }
    }
    
}
