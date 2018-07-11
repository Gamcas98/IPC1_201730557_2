/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.backend.estructuras;

/**
 *
 * @author joses
 */
public class Nodo {

    public Nodo siguiente;
    public Nodo anterior;
    private Object objeto;

    //constructor para lista doble
    public Nodo(Object objeto, Nodo anterior, Nodo siguiente) {
        this.siguiente = siguiente;
        this.objeto = objeto;
        this.anterior = anterior;
    }

    //constructor para cola simple
    public Nodo(Object objeto) {	
        this.objeto = objeto;
        setSiguiente(null);
    }

    //constructor para lista simple
    public Nodo(Object objeto, Nodo siguiente) { 
        this.siguiente = siguiente;
        this.objeto = objeto;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

}
