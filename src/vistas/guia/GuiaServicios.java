package vistas.guia;

import controladores.GuiaController;
import controladores.TuristaController;
import controladores.ViajeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiaServicios extends JFrame {
    private TuristaController turistaController;
    private GuiaController guiaController;
    private ViajeController viajeController;

    private DefaultListModel<String> serviciosListModel;
    private JList<String> serviciosList;
    private JTextField nombreServicioField;
    private JTextField precioServicioField;
    private JButton eliminarServicioButton;

    public GuiaServicios(TuristaController turistaController, GuiaController guiaController, ViajeController viajeController) {

        this.turistaController = turistaController;
        this.guiaController = guiaController;
        this.viajeController = viajeController;

        setTitle("Servicios Ofrecidos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior con título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(41, 128, 185));
        topPanel.setPreferredSize(new Dimension(getWidth(), 60));

        JLabel titleLabel = new JLabel("Servicios Ofrecidos", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Panel central para la lista de servicios y el formulario de nuevos servicios
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(236, 240, 241));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Lista de servicios
        serviciosListModel = new DefaultListModel<>();
        serviciosList = new JList<>(serviciosListModel);
        JScrollPane serviciosScrollPane = new JScrollPane(serviciosList);
        serviciosScrollPane.setPreferredSize(new Dimension(300, 400));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        centerPanel.add(serviciosScrollPane, gbc);

        // Formulario de nuevo servicio
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(236, 240, 241));

        JLabel nombreServicioLabel = new JLabel("Nombre del Servicio:");
        nombreServicioLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(nombreServicioLabel, gbc);

        nombreServicioField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(nombreServicioField, gbc);

        JLabel precioServicioLabel = new JLabel("Precio del Servicio:");
        precioServicioLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(precioServicioLabel, gbc);

        precioServicioField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(precioServicioField, gbc);

        JButton agregarServicioButton = new JButton("Agregar Servicio");
        agregarServicioButton.setFont(new Font("Arial", Font.BOLD, 14));
        agregarServicioButton.setBackground(new Color(41, 128, 185));
        agregarServicioButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(agregarServicioButton, gbc);

        // Botón para eliminar servicio
        eliminarServicioButton = new JButton("Eliminar Servicio");
        eliminarServicioButton.setFont(new Font("Arial", Font.BOLD, 14));
        eliminarServicioButton.setBackground(new Color(255, 69, 0));
        eliminarServicioButton.setForeground(Color.WHITE);
        eliminarServicioButton.setEnabled(false); // Inicialmente deshabilitado
        gbc.gridy = 3;
        formPanel.add(eliminarServicioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        centerPanel.add(formPanel, gbc);

        // Botón de volver al inicio
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton volverButton = new JButton("Volver al Inicio");
        volverButton.setFont(new Font("Arial", Font.BOLD, 14));
        volverButton.setBackground(new Color(41, 128, 185));
        volverButton.setForeground(Color.WHITE);
        bottomPanel.add(volverButton);

        // Añadir paneles al frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Añadir listeners a los botones
        agregarServicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreServicio = nombreServicioField.getText();
                String precioServicio = precioServicioField.getText();

                if (!nombreServicio.isEmpty() && !precioServicio.isEmpty()) {
                    serviciosListModel.addElement(nombreServicio + " - $" + precioServicio);
                    nombreServicioField.setText("");
                    precioServicioField.setText("");
                } else {
                    JOptionPane.showMessageDialog(GuiaServicios.this, "Por favor, complete todos los campos.");
                }
            }
        });

        eliminarServicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = serviciosList.getSelectedIndex();
                if (selectedIndex != -1) {
                    serviciosListModel.remove(selectedIndex);
                }
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GuiaLandingPage(turistaController, guiaController, viajeController).frame.setVisible(true);
            }
        });

        serviciosList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                eliminarServicioButton.setEnabled(serviciosList.getSelectedIndex() != -1);
            }
        });
    }

}
