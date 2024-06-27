package vistas.turista;

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
import java.util.Scanner;

public class HistorialViajesView extends JFrame {
    private TuristaController turistaController;
    private GuiaController guiaController;
    private ViajeController viajeController;
    private JPanel panelViajes; // Hacemos panelViajes una variable de instancia para que pueda ser actualizada
    private String emailTurista;

    public HistorialViajesView(TuristaController turistaController, GuiaController guiaController, ViajeController viajeController, JFrame previousFrame) {
        this.turistaController = turistaController;
        this.guiaController = guiaController;
        this.viajeController = viajeController;
        this.emailTurista = turistaController.getTuristaDTO().getEmail();

        setTitle("Historial de Viajes");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Inicializamos panelViajes aquí
        panelViajes = new JPanel();
        panelViajes.setLayout(new BoxLayout(panelViajes, BoxLayout.Y_AXIS));
        panelViajes.setBorder(BorderFactory.createTitledBorder("Viajes del Turista"));
        panelViajes.setBackground(Color.WHITE);

        // Llamamos a la función para renderizar los viajes
        renderizarViajes();

        JScrollPane scrollPane = new JScrollPane(panelViajes);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Botón de volver
        JButton volverButton = new JButton("Volver");
        volverButton.setFont(new Font("Arial", Font.BOLD, 14));
        volverButton.setBackground(new Color(39, 174, 96));
        volverButton.setForeground(Color.WHITE);
        volverButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousFrame.setVisible(true);
                dispose();
            }
        });

        JPanel volverPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        volverPanel.add(volverButton);
        panelPrincipal.add(volverPanel, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    // Función para obtener y renderizar los viajes del turista
    private void renderizarViajes() {
        panelViajes.removeAll(); // Limpiamos el panel antes de renderizar

        List<ViajeDTO> viajes = viajeController.getViajes(emailTurista);

        for (ViajeDTO viaje : viajes) {
            JPanel viajePanel = new JPanel(new BorderLayout());
            viajePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            viajePanel.setBackground(Color.WHITE);
            viajePanel.setPreferredSize(new Dimension(960, 150));
            viajePanel.setMaximumSize(new Dimension(960, 150));
            viajePanel.setMinimumSize(new Dimension(960, 150));

            String infoViaje = "<html>" +
                    "País: " + viaje.getPaisDestino() + "<br>Ciudad: " + viaje.getCiudadDestino() +
                    "<br>Fecha Inicio: " + viaje.getFechaInicio() + "<br>Fecha Fin: " + viaje.getFechaFin() +
                    "<br>Estado Reserva: " + viaje.getReserva().getEstado() +
                    "<br>Estado Viaje: " + viaje.getEstado() +
                    "<br>Factura paga: " + viaje.getFacturaPaga()
                    + "</html>";
            JLabel infoLabel = new JLabel(infoViaje);
            infoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            botonesPanel.setBackground(Color.WHITE);

            JButton cancelarButton = new JButton("Cancelar");
            JButton pagarButton = new JButton("Pagar");
            JButton calificarButton = new JButton("Calificar");

            // Lógica para habilitar/deshabilitar botones según el estado del viaje
            if (viaje.getEstado().equals(EstadoViaje.Cancelado.toString()) || viaje.getEstado().equals(EstadoViaje.Finalizado.toString())) {
                cancelarButton.setEnabled(false);
                pagarButton.setEnabled(false);
                calificarButton.setEnabled(false);
            } else {
                cancelarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viajeController.cancelarReserva(viaje.getIdViaje());
                        renderizarViajes(); // Actualiza los viajes después de cancelar
                    }
                });

                pagarButton.setEnabled(viaje.getEstado().equals("Finalizado") && !viaje.getFacturaPaga());
                //pagarButton.setEnabled(!viaje.getFacturaPaga());
                pagarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viajeController.pagarTotalFactura(viaje.getIdViaje());
                        renderizarViajes(); // Actualiza los viajes después de pagar
                    }
                });

                calificarButton.setEnabled(viaje.getFacturaPaga()); // Lógica para habilitar calificar
                calificarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Ingrese el email del guía: ");
                        String emailGuia = scanner.nextLine();
                        System.out.print("Ingrese la puntuación: ");
                        Double puntuacion = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese el comentario: ");
                        String comentario = scanner.nextLine();
                        System.out.println("Calificar viaje: " + viaje.getIdViaje());
                        turistaController.calificarGuia(emailGuia, turistaController.getTuristaDTO().getEmail(), puntuacion, comentario);
                    }
                });
            }

            botonesPanel.add(cancelarButton);
            botonesPanel.add(pagarButton);
            botonesPanel.add(calificarButton);

            viajePanel.add(infoLabel, BorderLayout.CENTER);
            viajePanel.add(botonesPanel, BorderLayout.SOUTH);
            panelViajes.add(viajePanel);
        }

        panelViajes.revalidate();
        panelViajes.repaint();
    }
}