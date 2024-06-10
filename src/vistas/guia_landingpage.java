//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class guia_landingpage {
    private JFrame frame;
    private guia_configuracion configuracionPage = new guia_configuracion();

    public guia_landingpage(String role) {
        this.frame = new JFrame(role.equals("Guía") ? "Guía - Landing Page" : "Turista - Landing Page");
        this.frame.setDefaultCloseOperation(3);
        this.frame.setSize(800, 600);
        this.frame.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setPreferredSize(new Dimension(this.frame.getWidth(), 60));
        JLabel titleLabel = new JLabel(role, 2);
        titleLabel.setFont(new Font("Arial", 1, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));
        JLabel userNameLabel = new JLabel("Usuario: Juan Pérez", 4);
        userNameLabel.setFont(new Font("Arial", 0, 16));
        userNameLabel.setForeground(Color.WHITE);
        userNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 20));
        topPanel.add(titleLabel, "West");
        topPanel.add(userNameLabel, "East");
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(230, 230, 250));
        JLabel welcomeLabel = new JLabel("Bienvenido a Find Your Guide");
        welcomeLabel.setFont(new Font("Arial", 1, 32));
        welcomeLabel.setForeground(new Color(0, 102, 204));
        centerPanel.add(welcomeLabel);
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(255, 255, 255));
        navPanel.setLayout(new FlowLayout(1, 20, 20));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton homeButton = this.createNavButton("Inicio");
        JButton profileButton = this.createNavButton("Perfil");
        JButton settingsButton = this.createNavButton("Configuración");
        JButton logoutButton = this.createNavButton("Cerrar Sesión");
        navPanel.add(homeButton);
        navPanel.add(profileButton);
        navPanel.add(settingsButton);
        navPanel.add(logoutButton);
        this.frame.add(topPanel, "North");
        this.frame.add(centerPanel, "Center");
        this.frame.add(navPanel, "South");
        this.frame.setVisible(true);
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(guia_landingpage.this.frame, "Página de inicio");
            }
        });
        profileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(guia_landingpage.this.frame, "Página de perfil");
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guia_landingpage.this.frame.dispose();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(guia_landingpage.this.frame, "Cerrar sesión");
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guia_configuracion.frame.setVisible(true);
            }
        });
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", 1, 14));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }
}
