package com.uade.api;

public interface PilaTDA {

    //Inicializar estructura
    void inicializarPila();

    //agregar elemento
    void apilar(int x);

    //quitar y obtener el primer elemento
    void desapilar();

    // me permite saber cual es el ultimo elemento ingresado
    int tope();

    //indica si la pila tiene elementos o no
    boolean pilaVacia();
}

