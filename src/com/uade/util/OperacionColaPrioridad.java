package com.uade.util;
import com.uade.impl.ColaPrioridadTDAImpl;
import com.uade.api.ColaPrioridadTDA;
import com.uade.api.ColaPrioridadTDA;

public class OperacionColaPrioridad {
        //si quisiera que no se borren las colas originales tendria que hacer unos arreglos agregando colas aux y trabajando sobre ellas.
        public ColaPrioridadTDA intercalarColasPrioridad(ColaPrioridadTDA colaPrioridad1, ColaPrioridadTDA colaPrioridad2) {
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

        public int largoColaPrioridad(ColaPrioridadTDA colaPrioridad) {
            int largo = 0;
            ColaPrioridadTDA colaPrioridadAux = new ColaPrioridadTDAImpl();
            colaPrioridadAux.inicializarCola();
            copiarCola(colaPrioridad, colaPrioridadAux);
            while (!colaPrioridadAux.colaVacia()) {
                colaPrioridadAux.desacolar();
                largo++;
            }
            return largo;
        }
       public boolean sonIguales(ColaPrioridadTDA colaPrioridad1, ColaPrioridadTDA colaPrioridad2){
            int largoCola1 = largoColaPrioridad(colaPrioridad1);
            int largoCola2 = largoColaPrioridad(colaPrioridad2);

            ColaPrioridadTDA colaPrioridadAux1 = new ColaPrioridadTDAImpl();
            ColaPrioridadTDA colaPrioridadAux2 = new ColaPrioridadTDAImpl();

           colaPrioridadAux1.inicializarCola();
           colaPrioridadAux2.inicializarCola();

           copiarCola(colaPrioridad1,colaPrioridadAux1);
           copiarCola(colaPrioridad2, colaPrioridadAux2);

           if (largoCola1 == largoCola2){
                while (!colaPrioridadAux1.colaVacia()  || !colaPrioridadAux2.colaVacia()) {
                    if (colaPrioridadAux1.primero() == colaPrioridadAux2.primero() || colaPrioridadAux1.prioridad() == colaPrioridadAux2.prioridad()) {
                        colaPrioridadAux1.desacolar();
                        colaPrioridadAux2.desacolar();
                    } else { return false;}
                }

            }else {return false;}
            return true;
        }

        public void copiarCola(ColaPrioridadTDA colaOrigen, ColaPrioridadTDA colaDestino ) {
            ColaPrioridadTDA colaAux = new ColaPrioridadTDAImpl();
            colaAux.inicializarCola();

            while (!colaOrigen.colaVacia()) {
                colaAux.acolarPrioridad(colaOrigen.primero(), colaOrigen.primero());
                colaDestino.acolarPrioridad(colaOrigen.primero(), colaOrigen.primero());
                colaOrigen.desacolar();
            }
            while (!colaAux.colaVacia()) {
                colaOrigen.acolarPrioridad(colaAux.primero(), colaAux.prioridad());
                colaAux.desacolar();
            }

        }


}
