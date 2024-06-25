//package vistas.turistatest;
//import controladores.TuristaController;
//import enums.Auth;
//import enums.Ciudad;
//import enums.Pais;
//import modelos.clases.Guia;
//import modelos.dtos.GuiaDTO;
//import modelos.dtos.TuristaDTO;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.time.LocalDate;
//
//public class ContratarGuiaView extends JFrame {
//    private JTextField destinoField;
//    private JTextField paisField;
//    private JTextField fechaInicioField;
//    private JTextField fechaFinField;
//    private JButton contratarButton;
//    private JLabel resumenLabel;
//
//    private GuiaDTO guia;
//    private TuristaDTO turista;
//
//    public ContratarGuiaView(GuiaDTO guia, TuristaDTO turista) {
//        this.guia = guia;
//        this.turista = turista;
//
//        setTitle("Contratar Guía");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        JPanel panelContratar = new JPanel(new GridLayout(6, 2));
//
//        panelContratar.add(new JLabel("Destino:"));
//        destinoField = new JTextField();
//        panelContratar.add(destinoField);
//
//        panelContratar.add(new JLabel("País:"));
//        paisField = new JTextField();
//        panelContratar.add(paisField);
//
//        panelContratar.add(new JLabel("Fecha de Inicio (YYYY-MM-DD):"));
//        fechaInicioField = new JTextField();
//        panelContratar.add(fechaInicioField);
//
//        panelContratar.add(new JLabel("Fecha de Fin (YYYY-MM-DD):"));
//        fechaFinField = new JTextField();
//        panelContratar.add(fechaFinField);
//
//        contratarButton = new JButton("Contratar");
//        panelContratar.add(contratarButton);
//
//        resumenLabel = new JLabel();
//        panelContratar.add(resumenLabel);
//
//        add(panelContratar, BorderLayout.CENTER);
//
//        contratarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                contratarGuia();
//            }
//        });
//    }
//
//    private void contratarGuia() {
//        try {
//            Ciudad destino = Ciudad.valueOf(destinoField.getText().toUpperCase());
//            Pais pais = Pais.valueOf(paisField.getText().toUpperCase());
//            LocalDate fechaInicio = LocalDate.parse(fechaInicioField.getText());
//            LocalDate fechaFin = LocalDate.parse(fechaFinField.getText());
//
//            TuristaController turistaController = new TuristaController();
//            turistaController.loginTurista(turista.getEmail(), turista.getPassword(), Auth.valueOf(turista.getAuth()));
//            Guia guiaObj = new Guia(
//                    guia.getNombre(),
//                    guia.getApellido(),
//                    guia.getSexo(),
//                    guia.getDni(),
//                    guia.getEmail(),
//                    "password", // Usar una contraseña dummy
//                    guia.getNumTelefono(),
//                    guia.getFotoPerfil(),
//                    null, // Autenticación no es necesaria aquí
//                    guia.getServicios(),
//                    guia.getPais(),
//                    guia.getCiudad(),
//                    guia.getCredencial(),
//                    guia.getIdiomas()
//            );
//            turistaController.contratarGuia(destino, pais, fechaInicio, fechaFin, guiaObj);
//
//            resumenLabel.setText("Guía contratado exitosamente.");
//        } catch (Exception ex) {
//            resumenLabel.setText("Error al contratar el guía: " + ex.getMessage());
//        }
//    }
//}
