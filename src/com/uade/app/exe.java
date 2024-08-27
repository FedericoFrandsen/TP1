package com.uade.app;

import com.uade.api.PilaTDA;
import com.uade.impl.PilaTDAImpl;
import com.uade.util.OperacionPila;

public class exe {
    public static void main(String[] args) {
        exe ex = new exe();
        ex.execute();
    }
    public void execute() {
        PilaTDA pila1 = new PilaTDAImpl();
        PilaTDA pila2 = new PilaTDAImpl();

        pila1.inicializarPila();
        pila2.inicializarPila();

        OperacionPila op = new OperacionPila();

    }

}
