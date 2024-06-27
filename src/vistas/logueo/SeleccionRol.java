package vistas.logueo;

import controladores.GuiaController;
import controladores.TuristaController;
import controladores.ViajeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionRol {
    private JFrame frame;

    public SeleccionRol(TuristaController turistaController, GuiaController guiaController, ViajeController viajeController) {
        // Crear el frame principal
        frame = new JFrame("Seleccionar Rol");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al salir
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Crear el panel superior con el título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("Seleccione su Rol", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Crear el panel central con los botones
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(230, 230, 250));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JButton turistaButton = createRoleButton("Turista");
        JButton guiaButton = createRoleButton("Guía");

        centerPanel.add(turistaButton);
        centerPanel.add(guiaButton);

        // Añadir paneles al frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Hacer visible el frame
        frame.setVisible(true);

        // Añadir listeners a los botones (acciones a realizar)
        turistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de inicio de sesión como Turista
                frame.dispose(); // Cerrar la ventana actual
                new Login("Turista", turistaController, guiaController, viajeController); // Abrir la ventana de login
            }
        });

        guiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de inicio de sesión como Guía
                frame.dispose(); // Cerrar la ventana actual
                new Login("Guía", turistaController, guiaController, viajeController); // Abrir la ventana de login
            }
        });
    }

    private JButton createRoleButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
        return button;
    }

}
