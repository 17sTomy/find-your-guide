package vistas.turista;

import javax.swing.*;
import java.awt.*;

public class DetallesGuiaFrame extends JFrame {
    private BuscarGuiasPage.Guia guia;

    public DetallesGuiaFrame(BuscarGuiasPage.Guia guia) {
        this.guia = guia;

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

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton contratarButton = new JButton("Contratar");
        JButton cerrarButton = new JButton("Cerrar");

        buttonPanel.add(contratarButton);
        buttonPanel.add(cerrarButton);

        add(buttonPanel, BorderLayout.SOUTH);

        cerrarButton.addActionListener(e -> dispose());

        contratarButton.addActionListener(e -> {
            // Implementar la lógica de contratación
            JOptionPane.showMessageDialog(this, "Contratación de guía realizada con éxito.");
            dispose();
        });
    }
}

