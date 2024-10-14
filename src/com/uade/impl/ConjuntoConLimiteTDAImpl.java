package com.uade.impl;
import org.uade.api.ConjuntoTDA;

import java.util.Random;

//Tamaño máximo acotado

public class ConjuntoConLimiteTDAImpl implements ConjuntoTDA {

    private int[] elementos;
    private int cantidad;
    private int TamanioMaximo = 100;
    private Random rand;


    @Override
    public void inicializarConjunto() {
        elementos = new int[TamanioMaximo];
        cantidad = 0;
    }

    @Override
    public void agregar(int x) {
        if (cantidad < TamanioMaximo && !pertenece(x)) {
            elementos[cantidad] = x;
            cantidad++;
        }
    }

    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(cantidad);
            return elementos[numeroAleatorio]; // Elegir un elemento aleatorio
        }
        throw new RuntimeException("El conjunto está vacío.");
    }

    @Override
    public void sacar(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                elementos[i] = elementos[cantidad - 1]; // Reemplazar con el último elemento
                cantidad--;
                break;
            }
        }
    }

    @Override
    public boolean pertenece(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad==0;
    }
}
