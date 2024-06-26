package vistas.turistatest;

import controladores.TuristaController;
import controladores.ViajeController;
import modelos.dtos.GuiaDTO;
import modelos.clases.Servicio;
import enums.Ciudad;
import enums.Pais;
import modelos.dtos.TuristaDTO;
import modelos.dtos.ViajeDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ContratarGuiaView extends JFrame {
    private TuristaController turistaController;
    private ViajeController viajeController;
    private String emailGuia;
    private Ciudad ciudad;
    private Pais pais;
    private JTextField fechaInicioField;
    private JTextField fechaFinField;
    private JButton contratarButton;
    private JLabel resumenLabel;

    public ContratarGuiaView(TuristaController turistaController, String emailGuia, Ciudad ciudad, Pais pais) {
        this.turistaController = turistaController;
        this.viajeController = new ViajeController();
        this.emailGuia = emailGuia;
        this.ciudad = ciudad;
        this.pais = pais;

        setTitle("Contratar Guía");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelServicios = new JPanel();
        panelServicios.setLayout(new BoxLayout(panelServicios, BoxLayout.Y_AXIS));

        // Obtener servicios del guía
        GuiaDTO guia = turistaController.getGuiaByEmail(emailGuia);
        System.out.println(emailGuia);
        System.out.println(guia);
        List<Servicio> servicios = guia.getServicios();
        for (Servicio servicio : servicios) {
            panelServicios.add(new JLabel(servicio.getNombre() + " - " + servicio.getDescripcion() + " - $" + servicio.getPrecio()));
        }

        JPanel panelFechas = new JPanel(new GridLayout(3, 2));
        panelFechas.add(new JLabel("Fecha de Inicio (YYYY-MM-DD):"));
        fechaInicioField = new JTextField();
        panelFechas.add(fechaInicioField);

        panelFechas.add(new JLabel("Fecha de Fin (YYYY-MM-DD):"));
        fechaFinField = new JTextField();
        panelFechas.add(fechaFinField);

        contratarButton = new JButton("Contratar");
        contratarButton.setEnabled(false); // Desactivar hasta que se ingresen las fechas
        panelFechas.add(contratarButton);

        resumenLabel = new JLabel();
        panelFechas.add(resumenLabel);

        panel.add(panelServicios, BorderLayout.CENTER);
        panel.add(panelFechas, BorderLayout.SOUTH);

        add(panel);

        // Evento para habilitar el botón de contratar cuando se ingresen las fechas
        ActionListener fechaListener = e -> contratarButton.setEnabled(!fechaInicioField.getText().isEmpty() && !fechaFinField.getText().isEmpty());
        fechaInicioField.addActionListener(fechaListener);
        fechaFinField.addActionListener(fechaListener);

        // Evento del botón de contratar
        contratarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearViaje();
            }
        });
    }

    private void crearViaje() {
        //try {
            LocalDate fechaInicio = LocalDate.parse(fechaInicioField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate fechaFin = LocalDate.parse(fechaFinField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);

            String emailTurista = turistaController.getTuristaDTO().getEmail();

            ViajeDTO viajeDTO = new ViajeDTO(ciudad, pais, fechaInicio, fechaFin);
            viajeController.crearViaje(viajeDTO, emailTurista, emailGuia);
            //boolean disponible = viajeController.crearViaje(viajeDTO, emailTurista, emailGuia);
            //if (disponible) {
            //    resumenLabel.setText("Guía contratado exitosamente.");
            //} else {
            //    JOptionPane.showMessageDialog(this, "Las fechas no están disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
            //}
        //} catch (Exception ex) {
        //    JOptionPane.showMessageDialog(this, "Error al contratar el guía: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        //}
    }
}
