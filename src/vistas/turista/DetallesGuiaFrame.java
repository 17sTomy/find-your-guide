package vistas.turista;

import javax.swing.*;
import java.awt.*;

public class DetallesGuiaFrame extends JFrame {
    public DetallesGuiaFrame(BuscarGuiasPage.Guia guia) {
        setTitle("Detalles del Guía");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel detailsPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        detailsPanel.add(new JLabel("Nombre:"));
        detailsPanel.add(new JLabel(guia.getNombreCompleto()));

        detailsPanel.add(new JLabel("Ciudad:"));
        detailsPanel.add(new JLabel(guia.getCiudad()));

        detailsPanel.add(new JLabel("Idiomas:"));
        detailsPanel.add(new JLabel(guia.getIdiomas()));

        detailsPanel.add(new JLabel("Servicios:"));
        detailsPanel.add(new JLabel(guia.getServicios()));

        detailsPanel.add(new JLabel("Puntuación:"));
        detailsPanel.add(new JLabel(String.valueOf(guia.getPuntuacion())));

        add(detailsPanel, BorderLayout.CENTER);

        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(e -> dispose());
        add(cerrarButton, BorderLayout.SOUTH);
    }
}


