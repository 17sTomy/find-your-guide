package vistas.turista;

import controladores.GuiaController;
import controladores.TuristaController;
import controladores.ViajeController;

import vistas.logueo.SeleccionRol;
import vistas.turista.BuscarGuiasView;
import vistas.turista.HistorialViajesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TuristaLandingPage {
    public JFrame frame;

    public TuristaLandingPage(TuristaController turistaController, GuiaController guiaController, ViajeController viajeController) {

        // Crear el frame principal
        frame = new JFrame("FindYourGuide - Landing Page (Turista)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear el panel superior con el nombre del usuario y el título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(39, 174, 96));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("FindYourGuide - Turista", JLabel.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));

        JLabel userNameLabel = new JLabel("Gracias por elegirnos", JLabel.RIGHT);
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userNameLabel.setForeground(Color.WHITE);
        userNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 20));

        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(userNameLabel, BorderLayout.EAST);

        // Crear el panel central con el mensaje de bienvenida
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(236, 240, 241));
        JLabel welcomeLabel = new JLabel("Bienvenido a FindYourGuide");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        welcomeLabel.setForeground(new Color(39, 174, 96));
        centerPanel.add(welcomeLabel);

        // Crear el panel de navegación con botones estilizados
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(255, 255, 255));
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton homeButton = createNavButton("Inicio");
        JButton buscarGuiasButton = createNavButton("Buscar Guías");
        JButton historialViajesButton = createNavButton("Historial de Viajes");
        JButton perfilButton = createNavButton("Perfil");
        JButton logoutButton = createNavButton("Cerrar Sesión");

        navPanel.add(homeButton);
        navPanel.add(buscarGuiasButton);
        navPanel.add(historialViajesButton);
        navPanel.add(perfilButton);
        navPanel.add(logoutButton);

        // Añadir paneles al frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(navPanel, BorderLayout.SOUTH);

        // Hacer visible el frame
        frame.setVisible(true);

        // Añadir listeners a los botones (acciones a realizar)
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Página de inicio");
            }
        });

        buscarGuiasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new BuscarGuiasView(turistaController, guiaController, viajeController, frame).setVisible(true);
            }
        });

        historialViajesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new HistorialViajesView(turistaController, guiaController, viajeController, frame).setVisible(true);
            }

        });

        perfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Página de perfil");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new SeleccionRol(turistaController, guiaController, viajeController);

            }
        });
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(39, 174, 96));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }
}
