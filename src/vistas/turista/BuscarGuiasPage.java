package vistas.turista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    private List<Guia> guias;

    public BuscarGuiasPage() {
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
        guiasTableModel = new DefaultTableModel(new String[]{"Nombre", "Ciudad", "Idiomas", "Servicios", "Puntuación"}, 0);
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

        // Cargar datos de los guías desde un archivo
        guias = cargarGuiasDesdeArchivo("src/vistas/turista/guias.txt");

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
        mostrarGuias(guias);
    }

    private void buscarGuias() {
        String ciudad = ciudadField.getText().toLowerCase().trim();
        String nombre = nombreField.getText().toLowerCase().trim();
        String idiomas = idiomasField.getText().toLowerCase().trim();
        String servicios = serviciosField.getText().toLowerCase().trim();
        String puntuacionStr = puntuacionField.getText().trim();

        double puntuacionMin = puntuacionStr.isEmpty() ? 0 : Double.parseDouble(puntuacionStr);

        List<Guia> guiasFiltrados = new ArrayList<>();
        for (Guia guia : guias) {
            boolean coincideCiudad = ciudad.isEmpty() || guia.getCiudad().toLowerCase().contains(ciudad);
            boolean coincideNombre = nombre.isEmpty() || guia.getNombreCompleto().toLowerCase().contains(nombre);
            boolean coincideIdiomas = idiomas.isEmpty() || guia.getIdiomas().toLowerCase().contains(idiomas);
            boolean coincideServicios = servicios.isEmpty() || guia.getServicios().toLowerCase().contains(servicios);
            boolean coincidePuntuacion = guia.getPuntuacion() >= puntuacionMin;

            if (coincideCiudad && coincideNombre && coincideIdiomas && coincideServicios && coincidePuntuacion) {
                guiasFiltrados.add(guia);
            }
        }

        mostrarGuias(guiasFiltrados);
    }

    private void mostrarGuias(List<Guia> guias) {
        guiasTableModel.setRowCount(0);
        for (Guia guia : guias) {
            guiasTableModel.addRow(new Object[]{guia.getNombreCompleto(), guia.getCiudad(), guia.getIdiomas(), guia.getServicios(), guia.getPuntuacion()});
        }
    }

    private void verDetallesGuia() {
        int selectedRow = guiasTable.getSelectedRow();
        if (selectedRow != -1) {
            String nombreCompleto = (String) guiasTableModel.getValueAt(selectedRow, 0);
            Guia guiaSeleccionado = buscarGuiaPorNombre(nombreCompleto);
            if (guiaSeleccionado != null) {
                new DetallesGuiaFrame(guiaSeleccionado).setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un guía para ver los detalles.");
        }
    }

    private Guia buscarGuiaPorNombre(String nombreCompleto) {
        for (Guia guia : guias) {
            if (guia.getNombreCompleto().equals(nombreCompleto)) {
                return guia;
            }
        }
        return null;
    }

    private void contratarGuia() {
        int selectedRow = guiasTable.getSelectedRow();
        if (selectedRow != -1) {
            String nombreCompleto = (String) guiasTableModel.getValueAt(selectedRow, 0);
            Guia guiaSeleccionado = buscarGuiaPorNombre(nombreCompleto);
            if (guiaSeleccionado != null) {
                // Implementar la lógica de contratación
                JOptionPane.showMessageDialog(this, "Contratación de guía realizada con éxito.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un guía para contratar.");
        }
    }

    private List<Guia> cargarGuiasDesdeArchivo(String archivo) {
        List<Guia> guias = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 6) {
                    String nombre = datos[0];
                    String apellido = datos[1];
                    String ciudad = datos[2];
                    String idiomas = datos[3];
                    String servicios = datos[4];
                    double puntuacion = Double.parseDouble(datos[5]);
                    guias.add(new Guia(nombre, apellido, ciudad, idiomas, servicios, puntuacion));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guias;
    }

    class Guia {
        private String nombre;
        private String apellido;
        private String ciudad;
        private String idiomas;
        private String servicios;
        private double puntuacion;

        public Guia(String nombre, String apellido, String ciudad, String idiomas, String servicios, double puntuacion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.ciudad = ciudad;
            this.idiomas = idiomas;
            this.servicios = servicios;
            this.puntuacion = puntuacion;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public String getCiudad() {
            return ciudad;
        }

        public String getIdiomas() {
            return idiomas;
        }

        public String getServicios() {
            return servicios;
        }

        public double getPuntuacion() {
            return puntuacion;
        }

        public String getNombreCompleto() {
            return nombre + " " + apellido;
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
