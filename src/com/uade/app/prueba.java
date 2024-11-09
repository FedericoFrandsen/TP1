package com.uade.app;

import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioMultipleTDA;
import com.uade.impl.DiccionarioMultipleTDAImpl;
import com.uade.util.OperacionesDiccionario;

public class prueba {
    public static void main(String[] args) {
        prueba ex = new prueba();
        ex.execute2();
    }
    public void execute2(){

        DiccionarioMultipleTDA diccionario = new DiccionarioMultipleTDAImpl();
        diccionario.inicializarDiccionario();

        diccionario.agregar(2,1);
        diccionario.agregar(3,9);
        diccionario.agregar(4,7);
        diccionario.agregar(2,4);


        ConjuntoTDA claves = diccionario.claves();

        mostrarclaves(claves);
        System.out.println("clavees originales");
        mostrarclaves(diccionario.claves());

        OperacionesDiccionario op = new OperacionesDiccionario();
        DiccionarioMultipleTDA diccionario2 = new DiccionarioMultipleTDAImpl();
        diccionario2.inicializarDiccionario();

        diccionario2.agregar(5,3);
        op.agregarDiccionario(diccionario, diccionario2);
        System.out.println("diccionario2:");
        mostrarclaves(diccionario2.claves());

    }
    private void mostrarclaves(ConjuntoTDA claves) {
        while(!claves.conjuntoVacio()){
            int valor =claves.elegir();
            claves.sacar(valor);
            System.out.println(valor);
        }
    }
}
