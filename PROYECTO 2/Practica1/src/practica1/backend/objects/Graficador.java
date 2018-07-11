/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.backend.objects;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import practica1.backend.estructuras.Nodo;

/**
 *
 * @author joses
 */
public class Graficador {

    public void crearDot(Nodo primero, String nombre) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(nombre);
            pw = new PrintWriter(fw);
            pw.println("digraph listadoble {  node[shape=record];");
            pw.println(generarDotListaAvion(primero));
            pw.println("}");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {

            }
        }
    }

    public void crearDotCompleto(Nodo lAvion, Nodo lDesabordaje, Nodo Equipaje, Nodo Mantenimiento, Nodo cola, String nombre) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(nombre);
            pw = new PrintWriter(fw);
            pw.println("digraph sistemaCompleto { node[shape=record]; ");
            pw.println("subgraph listaAvion { " + generarDotListaAvion(lAvion) + "}");
            pw.println("subgraph desabordaje { " + generarDotDesabordaje(lDesabordaje) + "}");
            pw.println("subgraph mantenimiento { subgraph estacion {" + generarDotEstacion(Mantenimiento) + "rank = same" + rankEstacion(Mantenimiento) + "}" + "subgraph cola {" + generarDotColaAvion(cola) + "}" + mantEstacion(Mantenimiento, cola) + "}");
            pw.println("subgraph maletas { " + generarDotListaMaleta(Equipaje, Equipaje) + inicioFinMaleta(Equipaje) + "}");
            pw.println("}");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {

            }
        }
    }

    public void crearDesabordaje(Nodo primero, String nombre) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(nombre);
            pw = new PrintWriter(fw);
            pw.println("digraph listaPasajeros { node[shape=record]; ");
            pw.println(generarDotDesabordaje(primero));
            pw.println("}");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {

            }
        }
    }

    public void crearDotMantenimiento(Nodo primero, String nombre, Nodo cola) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(nombre);
            pw = new PrintWriter(fw);
            pw.println("digraph listaMantenimiento { node[shape=record]; ");
            pw.println("subgraph estacion{");
            pw.println(generarDotEstacion(primero));
            pw.println("rank = same" + rankEstacion(primero) + "}");
            pw.println("subgraph cola {" + generarDotColaAvion(cola) + "}");
            pw.println(mantEstacion(primero, cola) + "}");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {

            }
        }

    }

    public void crearDotListaMaleta(Nodo primero, Nodo ultimo, String nombre) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(nombre + ".dot");
            pw = new PrintWriter(fw);
            pw.println("digraph listacircular {");
            pw.println(generarDotListaMaleta(primero, ultimo));
            pw.println(inicioFinMaleta(primero));
            pw.println("}");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {

            }
        }
    }

    public String reemplazar(int posMemoria) {
        String cadena = String.valueOf(posMemoria);
        return cadena.replace("-", "_");
    }

    public String generarDotListaAvion(Nodo primero) {
        
        String cadena = "";
        if (primero == null) {
            return cadena;
        }
        Avion avion = (Avion) primero.getObjeto();
        
        cadena += "nodo" + reemplazar(primero.hashCode()) 
                + "[label=\"Avion: " + avion.getNumero() 
                + "&#92;nTamano: " + avion.getTipo() 
                + "&#92;nPasajeros: " + avion.getPasajeros() 
                + "&#92;nDesabordaje: " + avion.getTurnosDesabordaje()
                + "&#92;nMantenimiento: " + avion.getTurnosMantenimiento()
                + "\"];\n";
        
        if (primero.getSiguiente() != null) {
            cadena += "nodo" + reemplazar(primero.hashCode()) + "->" + "nodo" 
                    + reemplazar(primero.getSiguiente().hashCode()) + ";\n";
            
            cadena += "nodo" + reemplazar(primero.getSiguiente().hashCode()) + "->" + "nodo" 
                    + reemplazar(primero.getSiguiente().getAnterior().hashCode()) + ";\n";
            
            cadena += generarDotListaAvion(primero.getSiguiente());
        }

        return cadena;
    }

    public String generarDotDesabordaje(Nodo primero) {
        String cadena = "";
        if (primero == null) {
            return cadena;
        }
        Pasajero pasajero = (Pasajero) primero.getObjeto();
        cadena += "nodo" + reemplazar(primero.hashCode())
                + "[label=\" Pasajero: " + pasajero.getNumero()
                + " &#92;nMaletas: " + pasajero.getMaletas()
                + " &#92;nDocumentos: " + pasajero.getDocumentos() 
                + "\"];\n";
        
        if (primero.getSiguiente() != null) {
            cadena += "nodo" + reemplazar(primero.hashCode()) + "->" + "nodo" 
                    + reemplazar(primero.getSiguiente().hashCode()) + ";\n";
            
            cadena += generarDotDesabordaje(primero.getSiguiente());
        }
        return cadena;
    }

    public String generarColaPasajero(Nodo cola) {
        String cadena = "";
        if (cola == null) {
            return cadena;
        }
        Pasajero pasajero = (Pasajero) cola.getObjeto();
        if (pasajero != null) {
            cadena += "nodo" + reemplazar(cola.hashCode())
                    + "[label=\" Pasajero: " + pasajero.getNumero() 
                    + "\"];\n";
            
            if (cola.getSiguiente() != null) {
                cadena += "nodo" + reemplazar(cola.hashCode()) + "->" + "nodo" 
                        + reemplazar(cola.getSiguiente().hashCode()) + ";\n";
                
                cadena += generarColaPasajero(cola.getSiguiente());
            }
        }
        return cadena;
    }

    public String generarDotColaAvion(Nodo primero) {
        String cadena = "";
        if (primero == null) {
            return cadena;
        }
        Avion avion = (Avion) primero.getObjeto();
        cadena += "nodo" + reemplazar(primero.hashCode()) 
                + "[label=\"Avion: " + avion.getNumero() 
                + "&#92;nTamano: " + avion.getTipo() 
                + "&#92;nPasajeros: " + avion.getPasajeros() 
                + "&#92;nDesabordaje: " + avion.getTurnosDesabordaje() 
                + "&#92;nMantenimiento: " + avion.getTurnosMantenimiento() 
                + "\"];\n";
        
        if (primero.getSiguiente() != null) {
            cadena += "nodo" + reemplazar(primero.hashCode()) + "->" + "nodo"
                    + reemplazar(primero.getSiguiente().hashCode()) + ";\n";
            
            cadena += generarDotColaAvion(primero.getSiguiente());
        }
        return cadena;
    }

    public String generarDotEstacion(Nodo primero) {
        String cadena = "";
        
        Mantenimiento mantenimiento = (Mantenimiento) primero.getObjeto();
        if (mantenimiento.getAvion() == null) {
            cadena += "nodo" + reemplazar(primero.hashCode())
                    + "[label=\"Estacion: " + mantenimiento.getNumero() 
                    + "&#92;nEstado: " + mantenimiento.getDisponible() 
                    + "\"];\n";
            
        } else {
            Avion avion = mantenimiento.getAvion();
            cadena += "nodo" + reemplazar(primero.hashCode())
                    + "[label=\"Estacion: " + mantenimiento.getNumero() 
                    + "&#92;nEstado: " + mantenimiento.getDisponible()
                    + "&#92;nAvion: " + avion.getNumero() 
                    + "&#92;nTama�o: " + avion.getTipo() 
                    + "&#92;nPasajeros: " + avion.getPasajeros()
                    + "&#92;nDesabordaje: " + avion.getTurnosDesabordaje() 
                    + "&#92;nMantenimiento: " + avion.getTurnosMantenimiento() 
                    + "\"];\n";
        }
        if (primero.getSiguiente() != null) {
            cadena += "nodo" + reemplazar(primero.hashCode()) + "->" + "nodo" + reemplazar(primero.getSiguiente().hashCode()) + ";\n";
            cadena += generarDotEstacion(primero.getSiguiente());
        }

        return cadena;
    }

    public String rankEstacion(Nodo primero) {
        String cadena = "";
        if (primero.getSiguiente() != null) {
            cadena += " nodo" + reemplazar(primero.hashCode());
            cadena += rankEstacion(primero.getSiguiente());
        }
        return cadena;
    }


    public String mantEstacion(Nodo mantenimiento, Nodo cola) {
        String cadena = "";
        if (mantenimiento != null) {
            if (cola != null) {
                cadena += "nodo" + reemplazar(mantenimiento.hashCode()) + "->" + "nodo" + reemplazar(cola.hashCode()) + "\n";
                cadena += mantEstacion(mantenimiento.getSiguiente(), cola);
            }
        }
        return cadena;
    }

    public String generarDotListaMaleta(Nodo primero, Nodo ultimo) {
        String cadena = "";
        if (primero == null) {
            return cadena;
        }
        cadena += "nodo" + reemplazar(primero.hashCode()) 
                + "[label=\"" + primero.getObjeto() 
                + "\"];\n";
        
        if (primero.getSiguiente() != ultimo) {
            
            cadena += "nodo" + reemplazar(primero.hashCode()) + "->" 
                    + "nodo" + reemplazar(primero.getSiguiente().hashCode()) + ";\n";
            
            cadena += "nodo" + reemplazar(primero.getSiguiente().hashCode()) + "->" + "nodo" 
                    + reemplazar(primero.getSiguiente().getAnterior().hashCode()) + ";\n";
            
            cadena += generarDotListaMaleta(primero.getSiguiente(), ultimo);
        }

        return cadena;
    }

    public String inicioFinMaleta(Nodo primero) {
        String cadena = "";
        if (primero == null) {
            return cadena;
        }
        cadena += "nodo" + reemplazar(primero.hashCode()) + "->" + "nodo" + reemplazar(primero.anterior.hashCode()) + ";\n";
        cadena += "nodo" + reemplazar(primero.anterior.hashCode()) + "->" + "nodo" + reemplazar(primero.hashCode()) + ";\n";
        return cadena;
    }

    public void generarImagen(String direccionDot, String direccionImagen) {
        
        String doPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

        String cmd = doPath + " -Tjpg " + direccionDot + " -o " + direccionImagen;

        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
