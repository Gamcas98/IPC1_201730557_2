/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.backend.objects;

/**
 *
 * @author joses
 */
public class Mantenimiento {

    private int numero;
    private boolean estado;
    private Avion avion;

    public Mantenimiento(int numero, boolean estado, Avion avion) {
        this.estado = estado;
        this.avion = avion;
        this.numero=numero;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Avion getAvion() {
        return avion;
    }

    	public int getNumero() {
		return numero;
	}
    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getDisponible() {
        if (getEstado()) {
            return "Disponible";
        } else {
            return "Ocupado";
        }
    }

}
