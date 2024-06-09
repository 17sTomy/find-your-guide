package vistas;

import javax.swing.*;
import java.awt.*;

public class guia_configuracion {
    public JFrame frame;

    public guia_configuracion() {
        // Crear el frame principal
        frame = new JFrame("Configuración");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear el panel superior con el título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("Configuración", JLabel.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));

        topPanel.add(titleLabel, BorderLayout.WEST);

        // Crear el panel central
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(230, 230, 250));
        JLabel messageLabel = new JLabel("Página de configuración");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        messageLabel.setForeground(new Color(0, 102, 204));
        centerPanel.add(messageLabel);

        // Añadir paneles al frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Hacer visible el frame
        frame.setVisible(false); // Se hará visible cuando se llame desde Guia
    }
}
