package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guia_landingpage {
    private static JFrame frame;
    private static guia_configuracion configuracionPage;

    public static void main(String[] args) {
        // Crear la página de configuración
        configuracionPage = new guia_configuracion();

        // Crear el frame principal
        frame = new JFrame("Guía - Landing Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear el panel superior con el nombre del usuario y el título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("Guía", JLabel.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));

        JLabel userNameLabel = new JLabel("Usuario: Juan Pérez", JLabel.RIGHT);
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userNameLabel.setForeground(Color.WHITE);
        userNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 20));

        topPanel.add(titleLabel, BorderLayout.WEST);
        topPanel.add(userNameLabel, BorderLayout.EAST);

        // Crear el panel central con el mensaje de bienvenida
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(230, 230, 250));
        JLabel welcomeLabel = new JLabel("Bienvenido a la Guía");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        welcomeLabel.setForeground(new Color(0, 102, 204));
        centerPanel.add(welcomeLabel);

        // Crear el panel de navegación con botones estilizados
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(255, 255, 255));
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton homeButton = createNavButton("Inicio");
        JButton profileButton = createNavButton("Perfil");
        JButton settingsButton = createNavButton("Configuración");
        JButton logoutButton = createNavButton("Cerrar Sesión");

        navPanel.add(homeButton);
        navPanel.add(profileButton);
        navPanel.add(settingsButton);
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
                // Acción para el botón de inicio
                JOptionPane.showMessageDialog(frame, "Página de inicio");
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para el botón de perfil
                JOptionPane.showMessageDialog(frame, "Página de perfil");
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navegar a la página de configuración
                frame.setVisible(false);
                configuracionPage.frame.setVisible(true);
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para el botón de cerrar sesión
                JOptionPane.showMessageDialog(frame, "Cerrar sesión");
            }
        });
    }

    private static JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }
}

