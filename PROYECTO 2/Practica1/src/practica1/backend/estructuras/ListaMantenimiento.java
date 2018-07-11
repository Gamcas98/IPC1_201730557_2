/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.backend.estructuras;

import javax.swing.JTextArea;
import practica1.backend.objects.Avion;
import practica1.backend.objects.Mantenimiento;

/**
 *
 * @author joses
 */
public class ListaMantenimiento {

    public Nodo inicio;
    public Nodo fin;
    public int size;
    private boolean estado;

    public ListaMantenimiento() {

        inicio = null;
        fin = null;
        size = 0;

    }

    public void addAviones(Avion avion) {
        if (inicio != null) {
            Nodo aux = inicio;
            while (aux != null) {
                estado = false;
                Mantenimiento m = (Mantenimiento) aux.getObjeto();
                if (m.getEstado()) {
                    m.setEstado(false);
                    m.setAvion(avion);
                    estado = true;
                    aux = aux.siguiente;
                    return;
                } else {
                    estado = false;
                    aux = aux.siguiente;
                }
            }
        }
    }

    public Nodo getInicioNodo() {
        return inicio;
    }

    public void iniciarLista(int numero) {
        Mantenimiento nuevo = new Mantenimiento(numero, true, null);
        insertarInicio(nuevo);
    }

    public void bajarTurno() {
        if (inicio != null) {
            Nodo aux = inicio;
            while (aux != null) {
                Mantenimiento m = (Mantenimiento) aux.getObjeto();
                if (m.getAvion() != null) {
                    m.getAvion().setTurnosMantenimiento(m.getAvion().getTurnosMantenimiento() - 1);
                }
                aux = aux.siguiente;
            }
        }
    }

    public void terminaMantenimiento() {
        if (inicio != null) {
            Nodo aux = inicio;
            while (aux != null) {
                Mantenimiento m = (Mantenimiento) aux.getObjeto();
                if (m.getAvion() != null) {
                    if (m.getAvion().getTurnosMantenimiento() <= 0) {
                        m.setAvion(null);
                        m.setEstado(true);
                    }
                }
                aux = aux.siguiente;
            }
        }
    }

    public void insertarInicio(Object objeto) {
        Nodo nodo = new Nodo(objeto, inicio);
        inicio = nodo;
        if (fin == null) {
            fin = inicio;
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

    public boolean estaVacio() {
        compruebaMantenimiento();
        return estaVacio;
    }
    boolean estaVacio = false;

    public void compruebaMantenimiento() {
        if (inicio != null) {
            Nodo aux = inicio;
            while (aux != null) {
                Mantenimiento m = (Mantenimiento) aux.getObjeto();
                if (m.getEstado()) {
                    estaVacio = true;
                }
                aux = aux.siguiente;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean getEstado() {
        return estado;
    }

    public void recorrerMantenimiento(JTextArea consola) {
        for (int i = 0; i < getSize(); i++) {
            Mantenimiento mantenimiento = (Mantenimiento) getElemento(i);
            if (mantenimiento.getAvion() == null) {
                consola.append("\nESTACION " + (i + 1));
                consola.append("\n	ESTADO: " + mantenimiento.getDisponible() + "\n");
            } else {
                consola.append("\nESTACION " + (i + 1));
                consola.append("\n	ESTADO: " + mantenimiento.getDisponible() + mantenimiento.getAvion());
            }
        }
    }

}
