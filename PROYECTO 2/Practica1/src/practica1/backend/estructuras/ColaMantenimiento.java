/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.backend.estructuras;

import javax.swing.JTextArea;
import practica1.backend.objects.Avion;

/**
 *
 * @author joses
 */
public class ColaMantenimiento {

    public Nodo inicio;
    public Nodo fin;
    private int size;

    public ColaMantenimiento() {
        inicio = null;
        fin = null;
        size = 0;
    }

    public void setAvion(Avion avion) {
        insertar(avion);
    }

    public Nodo getInicioNodo() {
        return inicio;
    }

    public void pasarMantenimiento(ListaMantenimiento listMantenimiento) {
        if (inicioCola() == null) {
            return;
        }
        listMantenimiento.addAviones((Avion) inicioCola());
        if (listMantenimiento.getEstado()) {
            quitar();
        }
    }

    public void insertar(Object objeto) {

        if (estaVacia()) {
            inicio = new Nodo(objeto);
            fin = inicio;
        } else {
            fin = fin.siguiente = new Nodo(objeto);
        }
        size++;
    }

    public Object quitar() {
        if (estaVacia()) {
            return null;
        }
        Object aux = inicio.getObjeto();
        inicio = inicio.siguiente;
        size--;
        return aux;
    }

    public Object inicioCola() {
        if (inicio == null) {
            return null;
        }
        return inicio.getObjeto();

    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public Object getElemento(int indice) {
        indice = size - indice - 1;
        int cont = 0;
        Nodo temp = inicio;

        while (cont < indice) {
            temp = temp.getSiguiente();
            cont++;
        }
        return temp.getObjeto();
    }

    public int sizeCola() {
        return size;
    }

    public void recorrerEstaciones(JTextArea consola) {
        for (int i = sizeCola() - 1; i >= 0; i--) {
            Avion avion = (Avion) getElemento(i);
            consola.append("	AVION: " + avion.getNumero() + "\n	TIPO: "
                    + avion.getTipo() + "\n 	PASAJEROS: "
                    + avion.getPasajeros() + "\n 	TURNOS DESABORDAJE: "
                    + avion.getTurnosDesabordaje() + "\n 	TURNOS MANTENIMIENTO "
                    + avion.getTurnosMantenimiento() + "\n");
        }
    }
}
