package com.uade.impl;
import org.uade.api.ColaPrioridadTDA;

public class ColaPrioridadTDAImpl implements ColaPrioridadTDA {
   private class Elemento {
         int valor;
         int prioridad;
    }

   private Elemento[] elementos;
   private int indice;

    @Override
    public void inicializarCola() {
    indice = 0;
    }

    @Override
    public void acolarPrioridad(int valor, int prioridad) {

       Elemento nuevoElemento = new Elemento();
       nuevoElemento.valor = valor;
       nuevoElemento.prioridad = prioridad;
       int j = indice-1;

       while (j>=0 && elementos[j].prioridad < prioridad) {
            elementos[j+1] = elementos[j];
            j--;
       }
       elementos[j+1] = nuevoElemento;
       indice++;
        }
//elementos[0] = {valor: 10, prioridad: 1}
//elementos[1] = {valor: 20, prioridad: 2}
//elementos[2] = {valor: 30, prioridad: 3}

    //indice =3
    //si ingreso un elemento (25, 2):     j=2     PrioridadElemento2  = 3  >  prionuevo= 2   entonces  elemeneto3 = elemento2 y j--
    //                                    j=1     PrioridadElemento1  = 2  =  prionuevo=2    entonces corta el ciclo y elemenento 2 =nuevoElemento e indice=4
    //Quedan asi:
    //elementos[0] = {valor: 10, prioridad: 1}
    //elementos[1] = {valor: 20, prioridad: 2}
    //elementos[2] = {valor: 25, prioridad: 2}
    //elementos[3] = {valor: 30, prioridad:3 }


    @Override
    public void desacolar() {
        if (!colaVacia()) {
            indice--; // Simplemente reducir el tamaño, ya que el primero es el de mayor prioridad
        }
    }

    @Override
    public int primero() {
        if (!colaVacia()) {
            return elementos[0].valor; // El primero siempre es el de mayor prioridad
        }
        throw new RuntimeException("La cola está vacía.");
    }

    @Override
    public boolean colaVacia() {
        return indice == 0;
    }

    @Override
    public int prioridad() {
        if (!colaVacia()) {
            return elementos[0].prioridad; // Retornar la prioridad del elemento en el frente
        }
        throw new RuntimeException("La cola está vacía.");
    }
}
