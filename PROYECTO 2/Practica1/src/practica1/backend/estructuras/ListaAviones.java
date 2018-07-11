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
public class ListaAviones {

    public Nodo inicio;
    public Nodo fin;
    private int size;

    public ListaAviones() {

        inicio = null;
        fin = null;
        size = 0;

    }

    public void setAvion(int numero, String tipo, int pasajeros, int turnosDesabordaje,
            int turnosMantenimiento) {

        Avion nuevo = new Avion(numero, tipo, pasajeros, turnosDesabordaje, turnosMantenimiento);
        insertarInicio(nuevo);
    }

    public Avion getAvion(int index) {
        Avion avion = (Avion) getElemento(index);
        return avion;
    }

    public void bajaTurno() {
        for (int i = 0; i < getSize(); i++) {
            Avion avion = (Avion) getElemento(i);
            avion.setTurnosDesabordaje(avion.getTurnosDesabordaje() - 1);
        }
    }

    public void eliminaAvion(ColaMantenimiento colaMantenimiento) {
        for (int i = 0; i < getSize(); i++) {
            Avion avion = (Avion) getElemento(i);
            if (avion.getTurnosDesabordaje() <= 0) {
                eliminarElemento(i);
                colaMantenimiento.setAvion(avion);
            }
        }
    }

    public void insertarInicio(Object objeto) {
        if (inicio == null) {
            inicio = new Nodo(objeto, null, null);
            fin = inicio;
        } else {
            Nodo nuevo = new Nodo(objeto, null, inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
        size++;
    }

    public void insertarFin(Object objeto) {

        if (inicio == null) {
            inicio = new Nodo(objeto, null, null);
            fin = inicio;
        } else {
            Nodo nuevo = new Nodo(objeto, fin, null);
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        size++;
    }

    public Object getElemento(int indice) {

        indice = size - indice - 1;
        int cont = 0;
        Nodo aux = inicio;

        while (cont < indice) {
            aux = aux.getSiguiente();
            cont++;
        }
        return aux.getObjeto();
    }

    public void eliminarElemento(int indice) {
        indice = size - indice - 1;
        if (indice == 0) {
            inicio = inicio.getSiguiente();
        } else {
            int cont = 0;
            Nodo aux = inicio;
            while (cont < indice - 1) {
                aux = aux.getSiguiente();
                cont++;
            }
            aux.setSiguiente(aux.getSiguiente());
        }
        size--;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int getSize() {
        return size;
    }

    public Nodo getPrimero() {
        return inicio;
    }

    public void recorrerAviones(JTextArea consola) {
        for (int i = 0; i < getSize(); i++) {

            Avion avion = (Avion) getElemento(i);
            consola.append("\nAVION: " + avion.getNumero() + "\n");

            consola.append("	TIPO: "
                    + avion.getTipo()
                    + "\n 	PASAJEROS: "
                    + avion.getPasajeros()
                    + "\n 	TURNOS DESABORDAJE: "
                    + avion.getTurnosDesabordaje() + "\n 	TURNOS MANTENIMIENTO "
                    + avion.getTurnosMantenimiento() + "\n");
        }
    }
}
