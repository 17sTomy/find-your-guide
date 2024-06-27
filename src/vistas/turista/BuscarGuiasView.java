package vistas.turista;

import controladores.GuiaController;
import controladores.TuristaController;
import controladores.ViajeController;
import enums.Ciudad;
import enums.Pais;
import modelos.dtos.GuiaDTO;
import vistas.guia.GestionarViajesView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarGuiasView extends JFrame {
    private TuristaController turistaController;
    private GuiaController guiaController;
    private ViajeController viajeController;

    private JTextField nombreField;
    private JTextField apellidoField;
    private JComboBox<Pais> paisComboBox;
    private JComboBox<Ciudad> ciudadComboBox;
    private JTextField idiomasField;
    private JTextField serviciosField;
    private JTextField puntuacionField;
    private JButton buscarButton;
    private JButton contratarButton;
    private JButton volverButton;
    private JTable resultadosTable;

    public BuscarGuiasView(TuristaController turistaController, GuiaController guiaController, ViajeController viajeController, JFrame previousFrame) {
        this.turistaController = turistaController;
        this.guiaController = guiaController;
        this.viajeController = viajeController;

        setTitle("Buscar Guías");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel de criterios de búsqueda
        JPanel panelBusqueda = new JPanel(new GridLayout(9, 2));
        panelBusqueda.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panelBusqueda.add(nombreField);

        panelBusqueda.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        panelBusqueda.add(apellidoField);

        panelBusqueda.add(new JLabel("País:"));
        paisComboBox = new JComboBox<>(Pais.values());
        paisComboBox.insertItemAt(null, 0); // Permitir selección nula
        paisComboBox.setSelectedIndex(0); // Seleccionar por defecto
        panelBusqueda.add(paisComboBox);

        panelBusqueda.add(new JLabel("Ciudad:"));
        ciudadComboBox = new JComboBox<>(Ciudad.values());
        ciudadComboBox.insertItemAt(null, 0); // Permitir selección nula
        ciudadComboBox.setSelectedIndex(0); // Seleccionar por defecto
        panelBusqueda.add(ciudadComboBox);

        panelBusqueda.add(new JLabel("Idiomas (separados por coma):"));
        idiomasField = new JTextField();
        panelBusqueda.add(idiomasField);

        panelBusqueda.add(new JLabel("Servicios (separados por coma):"));
        serviciosField = new JTextField();
        panelBusqueda.add(serviciosField);

        panelBusqueda.add(new JLabel("Puntuación mínima:"));
        puntuacionField = new JTextField();
        panelBusqueda.add(puntuacionField);

        buscarButton = new JButton("Buscar");
        panelBusqueda.add(buscarButton);
        panelBusqueda.add(new JLabel());

        add(panelBusqueda, BorderLayout.NORTH);

        // Agregar botón de Volver
        volverButton = new JButton("Volver");
        panelBusqueda.add(volverButton);

        // Tabla de resultados
        resultadosTable = new JTable(new DefaultTableModel(new Object[]{"Nombre", "Apellido", "Email", "País", "Ciudad", "Idiomas", "Servicios", "Puntuación"}, 0));
        add(new JScrollPane(resultadosTable), BorderLayout.CENTER);

        // Botón para contratar guía
        contratarButton = new JButton("Contratar");
        contratarButton.setEnabled(false); // Desactivar hasta que se seleccione un guía
        add(contratarButton, BorderLayout.SOUTH);

        // Evento del botón de búsqueda
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarGuias();
            }
        });

        // Evento del botón de contratar
        contratarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contratarGuia();
            }
        });

        // Evento del botón de volver
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // new GestionarViajesView(turistaController, guiaController, viajeController).setVisible(true);
                new HistorialViajesView(turistaController, guiaController, viajeController, previousFrame);
                dispose();

                previousFrame.setVisible(true);
                dispose();
            }
        });

        // Evento de selección de la tabla
        resultadosTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && resultadosTable.getSelectedRow() != -1) {
                contratarButton.setEnabled(true);
            } else {
                contratarButton.setEnabled(false);
            }
        });
    }

    private void buscarGuias() {
        String nombre = nombreField.getText().isEmpty() ? null : nombreField.getText();
        String apellido = apellidoField.getText().isEmpty() ? null : apellidoField.getText();
        String idioma = idiomasField.getText().isEmpty() ? null : idiomasField.getText();
        String servicio = serviciosField.getText().isEmpty() ? null : serviciosField.getText();
        Double puntuacion = puntuacionField.getText().isEmpty() ? null : Double.parseDouble(puntuacionField.getText());
        Pais pais = (Pais) paisComboBox.getSelectedItem();
        Ciudad ciudad = (Ciudad) ciudadComboBox.getSelectedItem();

        // Llamar al método del controlador para buscar guías
        List<GuiaDTO> resultados = turistaController.buscarGuias(nombre, apellido, idioma, servicio, puntuacion, pais, ciudad);

        // Verificar si se obtuvieron resultados
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron guías con los criterios de búsqueda proporcionados.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Se encontraron " + resultados.size() + " guías.");
        }

        // Actualizar la tabla de resultados
        DefaultTableModel model = (DefaultTableModel) resultadosTable.getModel();
        model.setRowCount(0); // Limpiar resultados anteriores

        for (GuiaDTO guia : resultados) {
            model.addRow(new Object[]{
                    guia.getNombre(),
                    guia.getApellido(),
                    guia.getEmail(),
                    guia.getPais().toString(),
                    guia.getCiudad().toString(),
                    guia.getIdiomas().toString(),
                    guia.getServicios().toString(),
                    guia.getPuntuacion()
            });
        }
    }

    private void contratarGuia() {
        int selectedRow = resultadosTable.getSelectedRow();
        if (selectedRow != -1) {
            String emailGuia = (String) resultadosTable.getValueAt(selectedRow, 2); // Suponiendo que el email está en la tercera columna
            System.out.println(emailGuia);
            Ciudad ciudad = Ciudad.valueOf((String) resultadosTable.getValueAt(selectedRow, 4)); // Suponiendo que la ciudad está en la cuarta columna
            Pais pais = Pais.valueOf((String) resultadosTable.getValueAt(selectedRow, 3)); // Suponiendo que el país está en la tercera columna
            System.out.println(pais);
            new ContratarGuiaView(turistaController, guiaController, viajeController, emailGuia, ciudad, pais).setVisible(true);
        }
    }

}
