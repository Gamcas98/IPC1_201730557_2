/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.backend.estructuras;

import javax.swing.JTextArea;
import practica1.backend.objects.Pasajero;

/**
 *
 * @author joses
 */
public class ColaPasajeros {

    public Nodo inicio;
    public Nodo fin;
    private int size;

    public ColaPasajeros() {
        inicio = null;
        fin = null;
        size = 0;
    }

    public void setPasajero(int numero, int maletas, int documentos) {
        Pasajero pasajero = new Pasajero(numero, maletas, documentos);
        insertar(pasajero);
    }

    public int getMaletas() {
        if (sizeCola() != 0) {
            Pasajero pasajero = (Pasajero) getElemento(sizeCola() - 1);
            return pasajero.getMaletas();
        }
        return 0;
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

    public Nodo getInicioNodo() {
        return inicio;
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

    public int sizeCola() {
        return size;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int getSize() {
        return size;
    }

    public void recorrerPasajeros(JTextArea consola) {
        for (int i = sizeCola() - 1; i >= 0; i--) {
            Pasajero p = (Pasajero) getElemento(i);
            consola.append("\nPASAJERO: " + p.getNumero() + "\n");
            consola.append("	MALETAS: " + p.getMaletas() + "\n 	DOCUMENTOS: " + p.getDocumentos() + "\n");
        }
    }

}
