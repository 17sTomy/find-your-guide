package vistas.turista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Collections;
import controladores.GuiaController;
import modelos.dtos.GuiaDTO;
import enums.Ciudad;
import enums.Pais;
import enums.Sexo;
import enums.Idioma;
import modelos.clases.Credencial;
import modelos.clases.Servicio;

public class BuscarGuiasPage extends JFrame {
    private JTextField ciudadField;
    private JTextField nombreField;
    private JTextField idiomasField;
    private JTextField serviciosField;
    private JTextField puntuacionField;
    private JButton buscarButton;
    private JTable guiasTable;
    private DefaultTableModel guiasTableModel;
    private JButton verDetallesButton;
    private JButton contratarButton;
    private JButton volverButton;

    private List<GuiaDTO> guias;
    private GuiaController guiaController;

    public BuscarGuiasPage() {
        guiaController = new GuiaController();

        setTitle("Buscar Guías");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de filtros
        JPanel filtrosPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        filtrosPanel.setBorder(BorderFactory.createTitledBorder("Filtros de Búsqueda"));

        filtrosPanel.add(new JLabel("País/Ciudad:"));
        ciudadField = new JTextField();
        filtrosPanel.add(ciudadField);

        filtrosPanel.add(new JLabel("Nombre/Apellido:"));
        nombreField = new JTextField();
        filtrosPanel.add(nombreField);

        filtrosPanel.add(new JLabel("Idiomas que habla:"));
        idiomasField = new JTextField();
        filtrosPanel.add(idiomasField);

        filtrosPanel.add(new JLabel("Tipo de servicios ofrecidos:"));
        serviciosField = new JTextField();
        filtrosPanel.add(serviciosField);

        filtrosPanel.add(new JLabel("Puntuación mínima:"));
        puntuacionField = new JTextField();
        filtrosPanel.add(puntuacionField);

        buscarButton = new JButton("Buscar");
        filtrosPanel.add(buscarButton);

        add(filtrosPanel, BorderLayout.NORTH);

        // Tabla de guías
        guiasTableModel = new DefaultTableModel(new String[]{"Nombre", "Apellido", "Ciudad", "Idiomas", "Servicios", "Puntuación"}, 0);
        guiasTable = new JTable(guiasTableModel);
        JScrollPane tableScrollPane = new JScrollPane(guiasTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        verDetallesButton = new JButton("Ver Detalles");
        contratarButton = new JButton("Contratar");
        volverButton = new JButton("Volver");
        botonesPanel.add(verDetallesButton);
        botonesPanel.add(contratarButton);
        botonesPanel.add(volverButton);
        add(botonesPanel, BorderLayout.SOUTH);

        // Añadir listeners a los botones
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarGuias();
            }
        });

        verDetallesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verDetallesGuia();
            }
        });

        contratarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contratarGuia();
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new TuristaLandingPage("Turista").frame.setVisible(true);
            }
        });

        // Mostrar todos los guías al iniciar
        buscarGuias();
    }

    private void buscarGuias() {
        String ciudad = ciudadField.getText().isEmpty() ? null : ciudadField.getText().toLowerCase().trim();
        String nombre = nombreField.getText().isEmpty() ? null : nombreField.getText().toLowerCase().trim();
        String idiomas = idiomasField.getText().isEmpty() ? null : idiomasField.getText().toLowerCase().trim();
        String servicios = serviciosField.getText().isEmpty() ? null : serviciosField.getText().toLowerCase().trim();
        Double puntuacionMin = puntuacionField.getText().isEmpty() ? null : Double.parseDouble(puntuacionField.getText().trim());

        // Crear el GuiaDTO con el constructor proporcionado
        GuiaDTO filtro = new GuiaDTO(
                nombre,                       // nombre
                null,                         // apellido
                null,                         // dni
                null,                         // sexo
                null,                         // email
                null,                         // numTelefono
                null,                         // fotoPerfil
                null,                         // auth
                servicios != null ? Collections.singletonList(new Servicio(servicios, null, null)) : null, // servicios
                null,                         // pais
                ciudad != null ? Ciudad.valueOf(ciudad.toUpperCase()) : null, // ciudad
                null,                         // credencial
                idiomas != null ? Collections.singletonList(Idioma.valueOf(idiomas.toUpperCase())) : null, // idiomas
                puntuacionMin                 // puntuacion
        );

        guias = guiaController.buscarGuias(filtro);

        if (guias.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron guías con los filtros especificados.");
        } else {
            mostrarGuias(guias);
        }
    }

    private void mostrarGuias(List<GuiaDTO> guias) {
        guiasTableModel.setRowCount(0);
        for (GuiaDTO guia : guias) {
            guiasTableModel.addRow(new Object[]{guia.getNombre(), guia.getApellido(), guia.getCiudad(), guia.getIdiomas(), guia.getServicios(), guia.getPuntuacion()});
        }
    }

    private void verDetallesGuia() {
        int selectedRow = guiasTable.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) guiasTableModel.getValueAt(selectedRow, 0);
            String apellido = (String) guiasTableModel.getValueAt(selectedRow, 1);
            GuiaDTO guiaSeleccionado = buscarGuiaPorNombreYApellido(nombre, apellido);
            if (guiaSeleccionado != null) {
                new DetallesGuiaFrame(guiaSeleccionado).setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un guía para ver los detalles.");
        }
    }

    private GuiaDTO buscarGuiaPorNombreYApellido(String nombre, String apellido) {
        for (GuiaDTO guia : guias) {
            if (guia.getNombre().equals(nombre) && guia.getApellido().equals(apellido)) {
                return guia;
            }
        }
        return null;
    }

    private void contratarGuia() {
        int selectedRow = guiasTable.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) guiasTableModel.getValueAt(selectedRow, 0);
            String apellido = (String) guiasTableModel.getValueAt(selectedRow, 1);
            GuiaDTO guiaSeleccionado = buscarGuiaPorNombreYApellido(nombre, apellido);
            if (guiaSeleccionado != null) {
                // Implementar la lógica de contratación
                JOptionPane.showMessageDialog(this, "Contratación de guía realizada con éxito.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un guía para contratar.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BuscarGuiasPage().setVisible(true);
            }
        });
    }
}
