package com.uade.util;

import com.uade.api.ConjuntoTDA;
import com.uade.api.DiccionarioMultipleTDA;
import com.uade.api.DiccionarioSimpleTDA;
import com.uade.impl.DiccionarioMultipleDinamicoTDA;

public class OperacionesDiccionario {

    public DiccionarioMultipleTDA combinar(DiccionarioMultipleTDA d1, DiccionarioMultipleTDA d2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleDinamicoTDA();
        resultado.inicializarDiccionario();

        agregarDiccionario(d1, resultado);
        agregarDiccionario(d2, resultado);

        return resultado;
    }
    public void agregarDiccionario(DiccionarioMultipleTDA d1, DiccionarioMultipleTDA d2) {
        ConjuntoTDA claves = d1.claves();

        while (!claves.conjuntoVacio()){
            int clave =  claves.elegir();
            claves.sacar(clave);

            ConjuntoTDA valores = d1.recuperar(clave);

            while(!valores.conjuntoVacio()){
                int valor = valores.elegir();
                valores.sacar(valor);
                d2.agregar(clave,valor);
            }
        }
    }

    public DiccionarioMultipleTDA interseccionDevalores(DiccionarioMultipleTDA d1, DiccionarioMultipleTDA d2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleDinamicoTDA();
        resultado.inicializarDiccionario();
        ConjuntoTDA clavesD1 = d1.claves();

        while (!clavesD1.conjuntoVacio()){
            int clave = clavesD1.elegir();
            clavesD1.sacar(clave);

            if (d2.recuperar(clave)!=null){
                ConjuntoTDA valores2 = d2.recuperar(clave);
                ConjuntoTDA valores1 = d1.recuperar(clave);
                OperacionesConjuntos op = new OperacionesConjuntos();

                ConjuntoTDA valoresComunes = op.interseccionConjunto(valores1, valores2);

                if (!valoresComunes.conjuntoVacio()){
                    int valor = valoresComunes.elegir();
                    valores2.sacar(valor);
                    resultado.agregar(clave,valor);
                }
            }
        }

        return resultado;
    }

    public DiccionarioMultipleTDA interseccionClaves(DiccionarioMultipleTDA d1, DiccionarioMultipleTDA d2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleDinamicoTDA();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesd1 = d1.claves();
        ConjuntoTDA clavesd2 = d2.claves();

        OperacionesConjuntos op = new OperacionesConjuntos();
        ConjuntoTDA clavesComunes = op.interseccionConjunto(clavesd1, clavesd2);

        while (!clavesComunes.conjuntoVacio()){
            int clave = clavesComunes.elegir();
            clavesComunes.sacar(clave);
            ConjuntoTDA valoresD1 = d1.recuperar(clave);
            ConjuntoTDA valoresD2 = d2.recuperar(clave);

            while (!valoresD1.conjuntoVacio()) {
                int valor = valoresD1.elegir();
                resultado.agregar(clave, valor);
                valoresD1.sacar(valor);
            }
            while (!valoresD2.conjuntoVacio()) {
                int valor = valoresD2.elegir();
                resultado.agregar(clave, valor);
                valoresD2.sacar(valor);
            }
        }
       return resultado;
    }
    public DiccionarioMultipleTDA interseccionClavesYElementosComunes(DiccionarioMultipleTDA d1, DiccionarioMultipleTDA d2) {
        DiccionarioMultipleTDA resultado = new DiccionarioMultipleDinamicoTDA();
        resultado.inicializarDiccionario();

        ConjuntoTDA clavesd1 = d1.claves();
        ConjuntoTDA clavesd2 = d2.claves();

        OperacionesConjuntos op = new OperacionesConjuntos();
        ConjuntoTDA clavesComunes = op.interseccionConjunto(clavesd1, clavesd2);

        while (!clavesComunes.conjuntoVacio()) {
            int clave = clavesComunes.elegir();
            clavesComunes.sacar(clave);

            ConjuntoTDA valoresD1 = d1.recuperar(clave);
            ConjuntoTDA valoresD2 = d2.recuperar(clave);


            ConjuntoTDA valoresComunes = op.interseccionConjunto(valoresD1, valoresD2);


            while (!valoresComunes.conjuntoVacio()) {
                int valor = valoresComunes.elegir();
                valoresComunes.sacar(valor);
                resultado.agregar(clave, valor);
            }
        }

        return resultado;
    }

    public DiccionarioMultipleTDA generarDiccionarioSinonimos(DiccionarioSimpleTDA d) {
        DiccionarioMultipleTDA ds = new DiccionarioMultipleDinamicoTDA();
        ds.inicializarDiccionario();

        ConjuntoTDA palabras = d.Claves();

        while (!palabras.conjuntoVacio()) {
            int palabra = palabras.elegir();
            palabras.sacar(palabra);

            int significado = d.Recuperar(palabra);

            ds.agregar(significado, palabra);
        }

        return ds;
    }

}

