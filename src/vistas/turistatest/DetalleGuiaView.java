package vistas.turistatest;

import controladores.GuiaController;
import modelos.clases.Reseña;
import modelos.dtos.GuiaDTO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DetalleGuiaView extends JFrame {
    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JLabel paisLabel;
    private JLabel ciudadLabel;
    private JLabel idiomasLabel;
    private JLabel serviciosLabel;
    private JLabel puntuacionLabel;
    private JLabel credencialLabel;
    private JTextArea reseñasTextArea;

    public DetalleGuiaView(GuiaDTO guia) {
        setTitle("Detalle del Guía");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelDetalle = new JPanel();
        panelDetalle.setLayout(new BoxLayout(panelDetalle, BoxLayout.Y_AXIS));

        nombreLabel = new JLabel("Nombre: " + guia.getNombre());
        apellidoLabel = new JLabel("Apellido: " + guia.getApellido());
        paisLabel = new JLabel("País: " + guia.getPais());
        ciudadLabel = new JLabel("Ciudad: " + guia.getCiudad());
        idiomasLabel = new JLabel("Idiomas: " + guia.getIdiomas());
        serviciosLabel = new JLabel("Servicios: " + guia.getServicios());
        puntuacionLabel = new JLabel("Puntuación: " + guia.getPuntuacion());
        credencialLabel = new JLabel("Credencial: " + guia.getCredencial());

        reseñasTextArea = new JTextArea();
        reseñasTextArea.setEditable(false);
        reseñasTextArea.setText(obtenerReseñas(guia.getEmail()));

        panelDetalle.add(nombreLabel);
        panelDetalle.add(apellidoLabel);
        panelDetalle.add(paisLabel);
        panelDetalle.add(ciudadLabel);
        panelDetalle.add(idiomasLabel);
        panelDetalle.add(serviciosLabel);
        panelDetalle.add(puntuacionLabel);
        panelDetalle.add(credencialLabel);
        panelDetalle.add(new JLabel("Reseñas:"));
        panelDetalle.add(new JScrollPane(reseñasTextArea));

        add(panelDetalle);
    }

    private String obtenerReseñas(String emailGuia) {
        GuiaController guiaController = new GuiaController();
        List<Reseña> reseñas = guiaController.getReseñas(emailGuia);
        StringBuilder reseñasTexto = new StringBuilder();

        for (Reseña reseña : reseñas) {
            reseñasTexto.append(reseña.toString()).append("\n\n");
        }

        return reseñasTexto.toString();
    }
}