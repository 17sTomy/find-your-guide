package vistas.guia;

import controladores.GuiaController;
import controladores.TuristaController;
import controladores.ViajeController;
import modelos.dtos.ViajeDTO;
import enums.EstadoViaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GestionarViajesView extends JFrame {
    private TuristaController turistaController;
    private GuiaController guiaController;
    private ViajeController viajeController;

    public GestionarViajesView(TuristaController turistaController, GuiaController guiaController, ViajeController viajeController) {
        this.turistaController = turistaController;
        this.guiaController = guiaController;
        this.viajeController = viajeController;

        setTitle("Gestionar Viajes");
        setSize(1000, 800); // Aumentamos el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel de lista de viajes
        JPanel panelViajes = new JPanel();
        panelViajes.setLayout(new BoxLayout(panelViajes, BoxLayout.Y_AXIS));
        panelViajes.setBorder(BorderFactory.createTitledBorder("Viajes del Guía"));
        panelViajes.setBackground(Color.WHITE);

        String emailGuia = guiaController.getEmailGuia();
        List<ViajeDTO> viajes = viajeController.getViajes(emailGuia);

        for (ViajeDTO viaje : viajes) {
            JPanel viajePanel = new JPanel(new BorderLayout());
            viajePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            viajePanel.setBackground(Color.WHITE);
            viajePanel.setPreferredSize(new Dimension(960, 150)); // Ajustamos el tamaño del panel
            viajePanel.setMaximumSize(new Dimension(960, 150));
            viajePanel.setMinimumSize(new Dimension(960, 150));

            String infoViaje = "<html>" +
                        "País: " + viaje.getPaisDestino() + "<br>Ciudad: " + viaje.getCiudadDestino() +
                        "<br>Fecha Inicio: " + viaje.getFechaInicio() + "<br>Fecha Fin: " + viaje.getFechaFin() +
                        "<br>Estado Reserva: " + viaje.getReserva().getEstado() +
                        "<br>Estado Viaje: " + viaje.getEstado()
                    + "</html>" ;
            JLabel infoLabel = new JLabel(infoViaje);
            infoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            botonesPanel.setBackground(Color.WHITE);

            JButton aceptarButton = new JButton("Aceptar");
            aceptarButton.setEnabled(viaje.getReserva().getEstado().equals("Pendiente"));
            aceptarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viajeController.aceptarReserva(viaje.getIdViaje());
                }
            });

            JButton cancelarButton = new JButton("Cancelar");
            cancelarButton.setEnabled(!viaje.getEstado().equals("Finalizado"));
            cancelarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viajeController.rechazarReserva(viaje.getIdViaje());
                }
            });

            JButton finalizarButton = new JButton("Finalizar Viaje");
            finalizarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viajeController.cambiarEstadoViaje(viaje.getIdViaje(), EstadoViaje.Finalizado);
                }
            });

            botonesPanel.add(aceptarButton);
            botonesPanel.add(cancelarButton);
            botonesPanel.add(finalizarButton);

            viajePanel.add(infoLabel, BorderLayout.CENTER);
            viajePanel.add(botonesPanel, BorderLayout.SOUTH);
            panelViajes.add(viajePanel);
        }

        JScrollPane scrollPane = new JScrollPane(panelViajes);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Botón de volver
        JButton volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Arial", Font.BOLD, 14));
        volverButton.setBackground(new Color(41, 128, 185));
        volverButton.setForeground(Color.WHITE);
        volverButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiaLandingPage(turistaController, guiaController, viajeController).frame.setVisible(true);
            }
        });

        JPanel volverPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        volverPanel.add(volverButton);
        panelPrincipal.add(volverPanel, BorderLayout.SOUTH);

        add(panelPrincipal);
    }
}
