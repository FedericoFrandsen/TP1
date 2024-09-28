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
            //colaPrioridadAux.copiarCola(ColaPrioridad);  me falta hacer este metodo
            while (!colaPrioridadAux.colaVacia()) {
                colaPrioridadAux.desacolar();
                largo++;
            }
            return largo;
        }
       public boolean sonIguales(ColaPrioridadTDA colaPrioridad1, ColaPrioridadTDA colaPrioridad2){
            int largoCola1 = largoColaPrioridad(colaPrioridad1);
            int largoCola2 = largoColaPrioridad(colaPrioridad2);
           //colaPrioridadAux1.copiarCola(ColaPrioridad1)
           //colaPrioridadAux2.copiarCola(ColaPrioridad2)
            if (largoCola1 == largoCola2){
                while (!colaPrioridadAux1.colaVacia()  || !colaPrioridadAAUX2.colaVacia()) {
                    if (colaPrioridadAux1.primero() == colaPrioridadAux2.primero() || colaPrioridadAux1.prioridad() == colaPrioridadAux2.prioridad()) {
                        colaPrioridadAux1.desacolar();
                        colaPrioridadAux2.desacolar();
                    } else { return false;}
                }

            }else return false;
            return true;
        }
}
