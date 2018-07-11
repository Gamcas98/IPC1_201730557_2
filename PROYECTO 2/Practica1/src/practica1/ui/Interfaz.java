/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.ui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import practica1.backend.estructuras.ColaMantenimiento;
import practica1.backend.estructuras.ColaPasajeros;
import practica1.backend.estructuras.ListaAviones;
import practica1.backend.estructuras.ListaMaletas;
import practica1.backend.estructuras.ListaMantenimiento;
import practica1.backend.objects.Graficador;
import practica1.backend.objects.Graficas;

public class Interfaz extends javax.swing.JFrame {

    private ListaAviones listAvion;
    private ColaPasajeros colaPasajero;
    private ListaMaletas listMaletas;
    private ColaMantenimiento colaMantenimiento;
    private ListaMantenimiento ListMantenimiento;
    private int cantAviones, turnos = 0, numero = 1, contador, cantEstaciones;
    private int pasajeros, desabordaje, mantenimiento, maletas, documentos;
    private String tipo, ruta;
    private boolean iniciado = false;
    private int contadorMaletas, numeroMaleta = 1;

    public Interfaz() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        CantAviones = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        consola = new javax.swing.JTextArea();
        CantEstaciones = new javax.swing.JTextField();
        turno = new javax.swing.JButton();
        iniciar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAvion = new javax.swing.JButton();
        btnEquipaje = new javax.swing.JButton();
        btnMant = new javax.swing.JButton();
        btnDesabordaje = new javax.swing.JButton();
        btnAll = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("List Airport");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(0, 51, 51));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Eras Demi ITC", 1, 18)); // NOI18N
        jLabel2.setText("No. Aviones:");

        consola.setBackground(new java.awt.Color(0, 0, 0));
        consola.setColumns(20);
        consola.setFont(new java.awt.Font("Courier New", 2, 12)); // NOI18N
        consola.setForeground(new java.awt.Color(0, 204, 51));
        consola.setRows(5);
        consola.setEditable(false);
        jScrollPane1.setViewportView(consola);

        turno.setFont(new java.awt.Font("Palatino Linotype", 2, 18)); // NOI18N
        turno.setText("Siguiente Turno");
        turno.setEnabled(false);
        turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnoActionPerformed(evt);
            }
        });

        iniciar.setFont(new java.awt.Font("Palatino Linotype", 2, 18)); // NOI18N
        iniciar.setText("Iniciar");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Eras Demi ITC", 1, 18)); // NOI18N
        jLabel4.setText("No. Estaciones:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Generar Graficas de Simulacion");

        btnAvion.setText("Aviones");
        btnAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvionActionPerformed(evt);
            }
        });

        btnEquipaje.setText("Equipaje");
        btnEquipaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipajeActionPerformed(evt);
            }
        });

        btnMant.setText("Mantenimiento");
        btnMant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantActionPerformed(evt);
            }
        });

        btnDesabordaje.setText("Desabordaje");
        btnDesabordaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesabordajeActionPerformed(evt);
            }
        });

        btnAll.setText("Todas las Graficas");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        jButton6.setText("Escritorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAvion)
                            .addComponent(btnMant))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDesabordaje)
                                .addGap(52, 52, 52)
                                .addComponent(btnEquipaje)
                                .addGap(42, 42, 42))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAll)
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(CantAviones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(CantEstaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(iniciar)
                                        .addGap(69, 69, 69)
                                        .addComponent(turno))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(CantAviones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(CantEstaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(turno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvion)
                    .addComponent(btnDesabordaje)
                    .addComponent(btnEquipaje))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMant)
                    .addComponent(jButton6)
                    .addComponent(btnAll)))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnoActionPerformed

        if (!iniciado) {
            addAviones();
            turnos++;
            imprimir();
            iniciado = true;
            graficar();
            return;
        }
        listAvion.bajaTurno();
        ListMantenimiento.bajarTurno();

        int aux = 5;
        while (aux != 0) {
            listAvion.eliminaAvion(colaMantenimiento);
            ListMantenimiento.terminaMantenimiento();
            colaMantenimiento.pasarMantenimiento(ListMantenimiento);
            aux--;
        }

        sacarPasajeros();
        addAviones();
        turnos++;
        imprimir();
        graficar();

    }//GEN-LAST:event_turnoActionPerformed

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed

        if (CantAviones.getText().isEmpty() || CantEstaciones.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique los campos", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            turnos = 0;
            numero = 1;
            contador = 0;
            numeroMaleta = 1;
            listAvion = new ListaAviones();
            colaPasajero = new ColaPasajeros();
            listMaletas = new ListaMaletas();
            ListMantenimiento = new ListaMantenimiento();
            colaMantenimiento = new ColaMantenimiento();
            try {
                cantAviones = Integer.parseInt(CantAviones.getText());
                cantEstaciones = Integer.parseInt(CantEstaciones.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Verifique los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            addEstaciones();
            iniciar.setEnabled(false);
            turno.setEnabled(true);
            imprimir();
        }
    }//GEN-LAST:event_iniciarActionPerformed

    private void btnAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvionActionPerformed
        ruta = "listaDobl.png";
        ImageIcon icono = new ImageIcon(ruta);
        icono.getImage().flush();
        String titulo = "Aviones";
        Graficas frame = new Graficas(icono, titulo);
    }//GEN-LAST:event_btnAvionActionPerformed

    private void btnDesabordajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesabordajeActionPerformed
        ruta = "colaPasajero.png";
        ImageIcon icono = new ImageIcon(ruta);
        icono.getImage().flush();
        String titulo = "Desabordaje";
        Graficas frame = new Graficas(icono, titulo);
    }//GEN-LAST:event_btnDesabordajeActionPerformed

    private void btnEquipajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipajeActionPerformed
        ruta = "listaEquipaje.png";
        ImageIcon icono = new ImageIcon(ruta);
        icono.getImage().flush();
        String titulo = "Equipaje";
        Graficas frame = new Graficas(icono, titulo);
    }//GEN-LAST:event_btnEquipajeActionPerformed

    private void btnMantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantActionPerformed
        ruta = "listaMantenimiento.png";
        ImageIcon icono = new ImageIcon(ruta);
        icono.getImage().flush();
        String titulo = "Mantenimiento";
        Graficas frame = new Graficas(icono, titulo);
    }//GEN-LAST:event_btnMantActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        ruta = "sistema.png";
        ImageIcon icono = new ImageIcon(ruta);
        icono.getImage().flush();
        String titulo = "Sistema Completo";
        Graficas frame = new Graficas(icono, titulo);
    }//GEN-LAST:event_btnAllActionPerformed

    //metodos para el funcionamiento de la ui
    public void obtenerAviones() {

        int tipoAvion = (int) (Math.random() * 3 + 1);
        switch (tipoAvion) {
            case 1:
                tipo = "Pequeno";
                desabordaje = 1;
                pasajeros = (int) ((Math.random() * 6) + 5);
                mantenimiento = (int) ((Math.random() * 2) + 1);
                break;
            case 2:
                tipo = "Mediano";
                desabordaje = 2;
                pasajeros = (int) ((Math.random() * 11) + 15);
                mantenimiento = (int) ((Math.random() * 3) + 2);
                break;
            case 3:
                tipo = "Grande";
                desabordaje = 3;
                pasajeros = (int) ((Math.random() * 11) + 30);
                mantenimiento = (int) ((Math.random() * 4) + 3);
                break;
            default:
                break;
        }
    }

    public void addAviones() {
        if (cantAviones > 0) {
            obtenerAviones();
            listAvion.setAvion(numero, tipo, pasajeros, desabordaje, mantenimiento);
            numero++;
            cantAviones--;
            addPasajeros();
            addMaletas();
        }
    }

    public void addEstaciones() {
        while (cantEstaciones != 0) {
            ListMantenimiento.iniciarLista(cantEstaciones);
            cantEstaciones--;
        }
    }

    public void sacarPasajeros() {
        int pasajeros = 5;
        while (pasajeros != 0) {
            listMaletas.eliminarMaleta(colaPasajero.getMaletas());
            colaPasajero.quitar();
            pasajeros--;
        }
    }

    public void addPasajeros() {
        contador += pasajeros;
        for (int i = (contador - pasajeros + 1); i < (contador + 1); i++) {
            equipajePasajeros();
            colaPasajero.setPasajero(i, maletas, documentos);
            contadorMaletas += maletas;
        }
    }

    public void addMaletas() {
        while (contadorMaletas != 0) {
            listMaletas.setMaleta(numeroMaleta);
            numeroMaleta++;
            contadorMaletas--;
        }
    }

    public void equipajePasajeros() {
        maletas = (int) (Math.random() * 4 + 1);
        documentos = (int) (Math.random() * 10 + 1);
    }

    public void imprimir() {
        consola.append("\n____________TURNO " + turnos + "___________\n");
        consola.append("\n ----------- AVIONES -----------\n");
        listAvion.recorrerAviones(consola);

        consola.append("\n ----------- PASAJEROS -----------\n");
        colaPasajero.recorrerPasajeros(consola);

        consola.append("\n ---------MALETAS---------\n");
        listMaletas.recorrerMaletas(consola);

        consola.append("\n ---------ESTACIONES---------\n");
        ListMantenimiento.recorrerMantenimiento(consola);

        consola.append("\n ---------COLA---------\n");
        colaMantenimiento.recorrerEstaciones(consola);

        consola.append("\n____________FIN TURNO " + turnos + "__________\n");
    }

    public void graficar() {

        Graficador graficador = new Graficador();

        graficador.crearDot(listAvion.getPrimero(), "listaDoble.dot");
        graficador.generarImagen("listaDoble.dot", "listaDobl.png");

        graficador.crearDesabordaje(colaPasajero.getInicioNodo(), "colaPasajero.dot");
        graficador.generarImagen("colaPasajero.dot", "colaPasajero.png");

        graficador.crearDotMantenimiento(ListMantenimiento.getInicioNodo(), "listaMantenimiento.dot",
                colaMantenimiento.getInicioNodo());
        graficador.generarImagen("listaMantenimiento.dot", "listaMantenimiento.png");

        graficador.crearDotListaMaleta(listMaletas.getInicioNodo(),
                listMaletas.getInicioNodo(), "colaMaleta");
        graficador.generarImagen("colaMaleta.dot", "listaEquipaje.png");

        graficador.crearDotCompleto(listAvion.getPrimero(),
                colaPasajero.getInicioNodo(),
                listMaletas.getInicioNodo(),
                ListMantenimiento.getInicioNodo(),
                colaMantenimiento.getInicioNodo(),
                "sistema.dot");
        graficador.generarImagen("sistema.dot", "sistema.png");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CantAviones;
    private javax.swing.JTextField CantEstaciones;
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnAvion;
    private javax.swing.JButton btnDesabordaje;
    private javax.swing.JButton btnEquipaje;
    private javax.swing.JButton btnMant;
    public javax.swing.JTextArea consola;
    private javax.swing.JButton iniciar;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton turno;
    // End of variables declaration//GEN-END:variables
}
