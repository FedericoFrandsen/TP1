package com.uade.app;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDADinamicaImpl;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

import java.util.Scanner;

public class exe {
    public static void main(String[] args) {
        exe ex = new exe();
        ex.execute();
        ex.execute2();
    }
    private void execute() {
        PilaTDA pila1 = new PilaTDAImpl();
        PilaTDA pila2 = new PilaTDAImpl();

        pila1.inicializarPila();
        pila2.inicializarPila();

        OperacionPila op = new OperacionPila();
        Scanner sc = new Scanner(System.in);
        op.llenarPila(pila1, sc , "pilaOrigen");
        sc.close();

        prueba1(pila1,pila2, sc ,op);
        prueba2(pila2,pila1, sc ,op);
        prueba3(pila1, sc , op);
        prueba4(pila1, sc , op);
        prueba5(pila1, sc , op);
        prueba6(pila1, sc , op);

    }
    private void execute2(){
        PilaTDA pila1Dinamica = new PilaTDADinamicaImpl();
        PilaTDA pila2Dinamica = new PilaTDADinamicaImpl();
        pila1Dinamica.inicializarPila();
        pila2Dinamica.inicializarPila();
        OperacionPila op = new OperacionPila();
        Scanner sc = new Scanner(System.in);
        op.llenarPila(pila1Dinamica, sc , "pilaOrigenDinamica");
        sc.close();

        prueba1(pila1Dinamica,pila2Dinamica,sc ,op);
        prueba2(pila2Dinamica,pila1Dinamica,sc ,op);
        prueba3(pila1Dinamica, sc , op);
        prueba4(pila1Dinamica, sc , op);
        prueba5(pila1Dinamica, sc , op);
        prueba6(pila1Dinamica, sc , op);

    }

    private void prueba1(PilaTDA pila1,PilaTDA pila2, Scanner sc, OperacionPila op) {
        op.pasarPila(pila1, pila2);
        System.out.println("Pila origen:");
        op.mostrarPila(pila1);
        System.out.println("Pila destino:");
        op.mostrarPila(pila2);
    }
    private void prueba2(PilaTDA pila1,PilaTDA pila2, Scanner sc, OperacionPila op){
      op.copiarPila(pila2,pila1); // copio la 2 en la 1, ya que en este mometento la 1 esta vacia por la prueba 1
        System.out.println("Pila origen:");
        op.mostrarPila(pila2);
        System.out.println("Pila destino:");
        op.mostrarPila(pila1);

    }
    private void prueba3(PilaTDA pila1, Scanner sc, OperacionPila op){
        System.out.println("Pila original:");
        op.invertirPila(pila1);
        System.out.println("Pila invertida:");
        op.invertirPila(pila1);
    }
    private void  prueba4(PilaTDA pila1, Scanner sc, OperacionPila op){
        op.contarElementos(pila1);
        //System.out.println("La cantidad de elementos de la pila es: "  +  no se como llamar al contador que devuelve la operacion contar elementos);
    }
    private void prueba5(PilaTDA pila1, Scanner sc, OperacionPila op){
        op.sumarElementos(pila1);
        System.out.println("La suma de los elemetos de la pila es:"); //mismo problema que la prueba4
    }
    private void prueba6(PilaTDA pila1, Scanner sc, OperacionPila op){
        op.promedioElementos(pila1);
        System.out.println("La media de los elementos de la pila es:");//mismo problema que la prueba4
    }
}
