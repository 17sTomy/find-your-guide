package vistas.guia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiaLandingPage {
    public JFrame frame;
    private String role;

    public GuiaLandingPage(String role) {
        this.role = role;

        // Crear el frame principal
        frame = new JFrame("FindYourGuide - Landing Page (Guía)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear el panel superior con el nombre del usuario y el título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(41, 128, 185));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("FindYourGuide - Guía", JLabel.LEFT);
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
        centerPanel.setBackground(new Color(236, 240, 241));
        JLabel welcomeLabel = new JLabel("Bienvenido a FindYourGuide");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        welcomeLabel.setForeground(new Color(41, 128, 185));
        centerPanel.add(welcomeLabel);

        // Crear el panel de navegación con botones estilizados
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(255, 255, 255));
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton homeButton = createNavButton("Inicio");
        JButton profileButton = createNavButton("Perfil");
        JButton servicesButton = createNavButton("Servicios");
        JButton logoutButton = createNavButton("Cerrar Sesión");

        navPanel.add(homeButton);
        navPanel.add(profileButton);
        navPanel.add(servicesButton);
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

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GuiaPerfil().frame.setVisible(true);
            }
        });

        servicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Página de servicios");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Cerrar sesión");
            }
        });
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(41, 128, 185));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiaLandingPage("Guía");
            }
        });
    }
}
