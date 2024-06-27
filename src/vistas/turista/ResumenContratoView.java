package vistas.turista;

import controladores.TuristaController;
import controladores.ViajeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ResumenContratoView extends JFrame {
    private TuristaController turistaController;
    private ViajeController viajeController;
    private int idViaje;
    private String emailGuia;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private JLabel informacionFacturaLabel;
    private JLabel fechaInicioLabel;
    private JLabel fechaFinLabel;
    private JButton confirmarButton;
    private JButton cancelarButton;

    public ResumenContratoView(TuristaController turistaController, ViajeController viajeController, int idViaje, String emailGuia, LocalDate fechaInicio, LocalDate fechaFin) {
        this.turistaController = turistaController;
        this.viajeController = viajeController;
        this.idViaje = idViaje;
        this.emailGuia = emailGuia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

        setTitle("Resumen de Contrato");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(Color.WHITE);

        // Panel de Fechas
        JPanel panelFechas = new JPanel(new GridLayout(2, 1, 0, 10));
        panelFechas.setBackground(Color.WHITE);
        panelFechas.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 1), "Fechas Seleccionadas", 0, 0, new Font("Arial", Font.BOLD, 14), Color.GRAY));

        fechaInicioLabel = new JLabel("Fecha de Inicio: " + fechaInicio.toString());
        fechaInicioLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        fechaFinLabel = new JLabel("Fecha de Fin: " + fechaFin.toString());
        fechaFinLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        panelFechas.add(fechaInicioLabel);
        panelFechas.add(fechaFinLabel);

        panelPrincipal.add(panelFechas, BorderLayout.NORTH);

        // Panel de Información de Factura
        JPanel panelFactura = new JPanel();
        panelFactura.setLayout(new BoxLayout(panelFactura, BoxLayout.Y_AXIS));
        panelFactura.setBackground(Color.WHITE);
        panelFactura.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 1), "Información de la Factura", 0, 0, new Font("Arial", Font.BOLD, 14), Color.GRAY));

        String informacionFactura = viajeController.getInformacionFactura(idViaje);
        informacionFacturaLabel = new JLabel("<html>" + informacionFactura.replaceAll("\n", "<br>") + "</html>");
        informacionFacturaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        informacionFacturaLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelFactura.add(informacionFacturaLabel);

        panelPrincipal.add(panelFactura, BorderLayout.CENTER);

        // Panel de Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panelBotones.setBackground(Color.WHITE);
        confirmarButton = new JButton("Confirmar Contrato");
        confirmarButton.setFont(new Font("Arial", Font.BOLD, 14));
        confirmarButton.setBackground(new Color(34, 139, 34));
        confirmarButton.setForeground(Color.WHITE);
        confirmarButton.setEnabled(verificarDisponibilidadGuia());
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para confirmar el contrato
                dispose();
            }
        });

        cancelarButton = new JButton("Cancelar");
        cancelarButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelarButton.setBackground(new Color(220, 20, 60));
        cancelarButton.setForeground(Color.WHITE);
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viajeController.eliminarViaje(idViaje);
                dispose();
            }
        });

        panelBotones.add(confirmarButton);
        panelBotones.add(cancelarButton);

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        add(panelPrincipal);

        // Eliminar el viaje si se cierra la ventana sin confirmar
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                viajeController.eliminarViaje(idViaje);
            }
        });
    }

    private boolean verificarDisponibilidadGuia() {
        return turistaController.verificarDisponibilidadGuia(emailGuia, fechaInicio, fechaFin);
    }
}

