package vistas.turistatest;

import controladores.TuristaController;
import controladores.ViajeController;
import controladores.GuiaController;
import modelos.dtos.GuiaDTO;
import modelos.clases.Servicio;
import enums.Ciudad;
import enums.Pais;
import modelos.clases.Reseña;
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
    private GuiaController guiaController;
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
        this.guiaController = new GuiaController();
        this.emailGuia = emailGuia;
        this.ciudad = ciudad;
        this.pais = pais;

        setTitle("Contratar Guía");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Panel de Información
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Obtener información del guía
        GuiaDTO guia = turistaController.getGuiaByEmail(emailGuia);

        // Panel de credenciales
        JPanel panelCredencial = new JPanel(new BorderLayout());
        panelCredencial.setBorder(BorderFactory.createTitledBorder("Credenciales"));
        panelCredencial.setBackground(Color.WHITE);

        JLabel puntuacionLabel = new JLabel("Puntuación: " + guia.getPuntuacion());
        puntuacionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        puntuacionLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelCredencial.add(puntuacionLabel, BorderLayout.NORTH);

        JTextArea reseñasArea = new JTextArea(5, 30);
        reseñasArea.setEditable(false);
        reseñasArea.setLineWrap(true);
        reseñasArea.setWrapStyleWord(true);
        reseñasArea.setBorder(BorderFactory.createTitledBorder("Reseñas"));

        // Obtener reseñas del controlador
        List<Reseña> reseñas = guiaController.getReseñas(emailGuia);
        for (Reseña reseña : reseñas) {
            reseñasArea.append("• " + reseña.getComentario() + "\n");
        }

        JScrollPane reseñasScrollPane = new JScrollPane(reseñasArea);
        panelCredencial.add(reseñasScrollPane, BorderLayout.CENTER);

        panelInfo.add(panelCredencial);

        // Panel de servicios
        JPanel panelServicios = new JPanel();
        panelServicios.setBorder(BorderFactory.createTitledBorder("Servicios"));
        panelServicios.setLayout(new BoxLayout(panelServicios, BoxLayout.Y_AXIS));
        panelServicios.setBackground(Color.WHITE);

        List<Servicio> servicios = guia.getServicios();
        for (Servicio servicio : servicios) {
            JLabel servicioLabel = new JLabel(servicio.getNombre() + " - " + servicio.getDescripcion() + " - $" + servicio.getPrecio());
            servicioLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            panelServicios.add(servicioLabel);
        }

        panelInfo.add(panelServicios);

        // Panel de fechas y resumen
        JPanel panelFechas = new JPanel(new GridLayout(3, 2, 10, 10));
        panelFechas.setBorder(BorderFactory.createTitledBorder("Seleccionar Fechas"));
        panelFechas.setBackground(Color.WHITE);

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

        panelPrincipal.add(panelInfo, BorderLayout.CENTER);
        panelPrincipal.add(panelFechas, BorderLayout.SOUTH);

        add(panelPrincipal);

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
        try {
            LocalDate fechaInicio = LocalDate.parse(fechaInicioField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate fechaFin = LocalDate.parse(fechaFinField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);

            String emailTurista = turistaController.getTuristaDTO().getEmail();

            ViajeDTO viajeDTO = new ViajeDTO(ciudad, pais, fechaInicio, fechaFin);
            viajeController.crearViaje(viajeDTO, emailTurista, emailGuia);
            resumenLabel.setText("Guía contratado exitosamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al contratar el guía: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
