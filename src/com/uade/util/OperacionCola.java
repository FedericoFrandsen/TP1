package com.uade.util;

import com.uade.api.ColaTDA;
import com.uade.api.PilaTDA;
import com.uade.impl.ColaTDAImpl;
import com.uade.impl.PilaTDAImpl;

import java.util.Scanner;

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
    public void invertirColaRecu(ColaTDA colaOrigen){

        if (!colaOrigen.colaVacia()) {
            int frente = colaOrigen.primero();
            colaOrigen.desacolar();
            invertirColaRecu(colaOrigen);
            colaOrigen.acolar(frente);
        }
    }

    public void copiarCola(ColaTDA colaOrigen, ColaTDA colaDestino){
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();

        while (!colaOrigen.colaVacia()){
            aux.acolar(colaOrigen.primero());
            colaOrigen.desacolar();
        }
        while (!aux.colaVacia()){
            colaDestino.acolar(aux.primero());
            colaOrigen.acolar(aux.primero());
            aux.desacolar();

        }
    }
    public void contiene(ColaTDA colaOrigen, ColaTDA colaDestino){
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();
        invertirColaRecu(colaOrigen);
        int ultimo = colaOrigen.primero();
        invertirCola(colaOrigen);
        copiarCola(colaDestino, aux);
        int contador = 0;
        while (!colaDestino.colaVacia()){
            if (ultimo == colaDestino.primero()){
                System.out.println("El ultimo de C1 esta contenido en C2 y es:" + colaDestino.primero());
                colaDestino.desacolar();
                contador++;
            } else { colaDestino.desacolar(); }
        }
        if (contador==0){
            System.out.println("el ultimo elemento de C1 no esta contenido en c2");
        }
        copiarCola(aux,colaDestino);
    }

    public boolean esCapicua(ColaTDA colaOrigen){
        PilaTDA pila = new PilaTDAImpl();
        pila.inicializarPila();
        ColaTDA aux = new ColaTDAImpl();
        aux.inicializarCola();
        copiarCola(colaOrigen,aux);
        while (!aux.colaVacia() && !pila.pilaVacia()){
            if (aux.primero() != pila.tope()){
                return false;
            }
            aux.desacolar();
            pila.desapilar();
        }
        return true;

    }

    public boolean esInversa(ColaTDA colaOrigen, ColaTDA colaDestino){
        ColaTDA auxOrigen = new ColaTDAImpl();
        ColaTDA auxDestino = new ColaTDAImpl();
        auxOrigen.inicializarCola();
        auxDestino.inicializarCola();
        copiarCola(colaOrigen, auxOrigen);
        copiarCola(colaDestino,auxDestino);
        invertirColaRecu(auxOrigen);
        while (!auxOrigen.colaVacia()){
            if (auxOrigen.primero() != auxDestino.primero()){
                return false;
            }
            auxDestino.desacolar();
            auxOrigen.desacolar();
         }
        return true;
    }

    public void llenarCola(ColaTDA cola, Scanner sc) {

        System.out.println("ingresar cantidad de elementos:");
        int elemento= sc.nextInt();

        for (int i = 0; i < elemento; i++) {
            System.out.println("ingresar elemento:");
            int valor = sc.nextInt();
            cola.acolar(valor);
        }

    }
    public void mostrarCola(ColaTDA cola) {
        ColaTDA aux= new ColaTDAImpl();
        aux.inicializarCola();

        while(!cola.colaVacia()) {
            System.out.println(cola.primero());
            aux.acolar(cola.primero());
            cola.desacolar();
        }
        while(!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }
    }
}