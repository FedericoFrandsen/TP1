package com.uade.util;
import com.uade.impl.ColaPrioridadTDAImpl;
import org.uade.api.ColaPrioridadTDA;
import org.uade.api.ColaPrioridadTDA;

//5) Definir el TDA Cola con prioridades, listando las operaciones asociadas y establecer sus
//precondiciones.
//6) A partir del TDA Cola con prioridades definido, escribir un método que permita

//a) Combinar dos colas con prioridades CP1 y CP2, generando una nueva
//cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1
//son más prioritarios que los de la CP2.

//b) Determinar si dos Colas con prioridad son idénticas



public class OperacionColaPrioridad {

        private ColaPrioridadTDA intercalarColasPrioridad(ColaPrioridadTDA colaPrioridad1, ColaPrioridadTDA colaPrioridad2) {
            ColaPrioridadTDA colaPrioridad3 = new ColaPrioridadTDAImpl();
            colaPrioridad3.inicializarCola();

            while (!colaPrioridad1.colaVacia()  || !colaPrioridad2.colaVacia() ) {


                if (!colaPrioridad1.colaVacia()) {
                    if (colaPrioridad1.prioridad() >= colaPrioridad2.prioridad()){
                        colaPrioridad3.acolarPrioridad(colaPrioridad1.primero(), colaPrioridad1.prioridad());
                        colaPrioridad1.desacolar();

                    } else {
                        colaPrioridad3.acolarPrioridad(colaPrioridad2.primero(), colaPrioridad2.prioridad());
                        colaPrioridad2.desacolar();

                    }
                }
                if (colaPrioridad1.colaVacia()){
                        colaPrioridad3.acolarPrioridad(colaPrioridad2.primero(), colaPrioridad2.prioridad());
                    }

                }

                return colaPrioridad3;
        }
}
