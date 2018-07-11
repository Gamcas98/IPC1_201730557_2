/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.backend.estructuras;

import javax.swing.JTextArea;

/**
 *
 * @author joses
 */
public class ListaMaletas {

    public Nodo inicio;
    public Nodo fin;
    private int size;

    public ListaMaletas() {
        inicio = null;
        fin = null;
        size = 0;
    }

    public void setMaleta(int numero) {
        ingresar(numero);
    }

    public void eliminarMaleta(int cantidad) {
        while (cantidad != 0) {
            eliminar(1);
            cantidad--;
        }
    }

    public Nodo getInicioNodo() {
        return inicio;
    }

    public void ingresar(Object objeto) {
        Nodo nuevo = new Nodo(objeto);

        if (inicio == null) {
            inicio = nuevo;
            inicio.siguiente = inicio;
            nuevo.anterior = fin;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            nuevo.siguiente = inicio;
            nuevo.anterior = fin;
            fin = nuevo;
            inicio.anterior = fin;
        }
    }

    public void eliminar(int maleta) {
        if (inicio != null) {
            if (maleta > 0) {
                int cont = 1;
                Nodo aux = inicio;
                while ((aux.getSiguiente() != inicio) && (cont < maleta)) {
                    cont++;
                    aux = aux.getSiguiente();
                }
                if (cont == 1) {
                    if (aux.getSiguiente() == inicio) {
                        inicio = null;
                    } else {
                        Nodo ant = aux.getAnterior();
                        ant.setSiguiente(aux.getSiguiente());
                        aux = aux.getSiguiente();
                        aux.setAnterior(ant);
                        inicio = aux;
                    }
                } else {
                    Nodo ant = aux.getAnterior();
                    aux.setAnterior(null);
                    ant.setSiguiente(aux.getSiguiente());
                    aux = aux.getSiguiente();
                    aux.setAnterior(ant);
                }
            }
        }
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int getSize() {
        return size;
    }

    public void recorrerMaletas(JTextArea consola) {
        Nodo aux = inicio;
        if (inicio != null) {
            do {
                consola.append("\nMALETA: " + aux.getObjeto());
                aux = aux.siguiente;
            } while (aux != inicio);
        }
    }

}
