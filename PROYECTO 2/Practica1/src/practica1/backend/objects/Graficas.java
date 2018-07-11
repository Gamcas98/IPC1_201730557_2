/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.backend.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author joses
 */
public class Graficas extends JFrame {

    private ImageIcon icon;
    private JScrollPane panel;

    public Graficas(ImageIcon nuevo, String titulo) {
        super("Graficas");
        add(getTitulo(titulo));
        nuevo.getImage().flush();
        panel = new JScrollPane(new JLabel(nuevo));
        panel.setBounds(20, 100, 700, 600);
        panel.repaint();
        add(panel);
        init();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void setIcon(ImageIcon nuevo) {
        this.icon = nuevo;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void init() {
        setLayout(null);
        setResizable(false);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JLabel getTitulo(String title) {
        JLabel titulo = new JLabel(title);
        titulo.setBounds(220, 10, 200, 70);
        titulo.setOpaque(true);
        titulo.setFont(new Font("Italic", 1, 18));
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setVisible(true);
        return titulo;
    }

}
