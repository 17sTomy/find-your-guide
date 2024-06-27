package vistas.guia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiaPerfil {
    public JFrame frame;

    // Campos de texto
    private JTextField nameField;
    private JTextField lastNameField;
    private JComboBox<String> sexField;
    private JTextField dniField;
    private JTextField emailField;
    private JTextField phoneField;
    private JComboBox<String> citiesComboBox;

    private JButton modifyButton;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton backButton;
    private JButton uploadPhotoButton;

    public GuiaPerfil() {
        // Crear el frame de perfil
        frame = new JFrame("FindYourGuide - Perfil");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear el panel superior con el título y el botón de inicio
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(41, 128, 185));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("Perfil del Guía", JLabel.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));

        topPanel.add(titleLabel, BorderLayout.WEST);

        // Crear el panel central con el formulario de perfil
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(236, 240, 241));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear campos de texto para los datos del perfil
        JLabel nameLabel = new JLabel("Nombre:");
        JLabel lastNameLabel = new JLabel("Apellido:");
        JLabel sexLabel = new JLabel("Sexo:");
        JLabel dniLabel = new JLabel("DNI:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneLabel = new JLabel("Número de Teléfono:");
        JLabel citiesLabel = new JLabel("Ciudades/Países de Servicio:");
        JLabel photoLabel = new JLabel("Foto de Perfil:");

        nameField = new JTextField(20);
        lastNameField = new JTextField(20);
        sexField = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"});
        dniField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);

        // Crear un JComboBox para las ciudades con capacidad de búsqueda
        String[] cities = {"Buenos Aires, Argentina", "Santiago, Chile", "Lima, Perú", "Bogotá, Colombia", "Madrid, España"};
        citiesComboBox = new JComboBox<>(cities);
        citiesComboBox.setEditable(true);
        citiesComboBox.setSelectedIndex(-1);  // Sin selección por defecto

        uploadPhotoButton = new JButton("Cargar Foto");
        uploadPhotoButton.setBackground(new Color(41, 128, 185));
        uploadPhotoButton.setForeground(Color.WHITE);
        uploadPhotoButton.setFont(new Font("Arial", Font.BOLD, 14));
        uploadPhotoButton.setFocusPainted(false);
        uploadPhotoButton.setEnabled(false);  // Inicialmente deshabilitado

        // Posicionar los componentes en el panel
        gbc.gridx = 0; gbc.gridy = 0; centerPanel.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; centerPanel.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; centerPanel.add(lastNameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; centerPanel.add(lastNameField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; centerPanel.add(sexLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; centerPanel.add(sexField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; centerPanel.add(dniLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; centerPanel.add(dniField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; centerPanel.add(emailLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; centerPanel.add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 5; centerPanel.add(phoneLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5; centerPanel.add(phoneField, gbc);
        gbc.gridx = 0; gbc.gridy = 6; centerPanel.add(citiesLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6; centerPanel.add(citiesComboBox, gbc);
        gbc.gridx = 0; gbc.gridy = 7; centerPanel.add(photoLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 7; centerPanel.add(uploadPhotoButton, gbc);

        // Crear panel inferior con botones
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(255, 255, 255));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        modifyButton = new JButton("Modificar");
        modifyButton.setFont(new Font("Arial", Font.BOLD, 14));
        modifyButton.setBackground(new Color(41, 128, 185));
        modifyButton.setForeground(Color.WHITE);
        modifyButton.setFocusPainted(false);
        modifyButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        saveButton = new JButton("Guardar Cambios");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.setBackground(new Color(46, 204, 113));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        saveButton.setVisible(false);  // Escondemos el botón inicialmente

        cancelButton = new JButton("Cancelar");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setBackground(new Color(231, 76, 60));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        cancelButton.setVisible(false);  // Escondemos el botón inicialmente

        backButton = new JButton("Volver");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(41, 128, 185));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        bottomPanel.add(modifyButton);
        bottomPanel.add(saveButton);
        bottomPanel.add(cancelButton);
        bottomPanel.add(backButton);

        // Añadir paneles al frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(centerPanel), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Listeners para los botones
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditable(true);
                modifyButton.setVisible(false);
                saveButton.setVisible(true);
                cancelButton.setVisible(true);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para guardar cambios
                saveProfile();
                setEditable(false);
                modifyButton.setVisible(true);
                saveButton.setVisible(false);
                cancelButton.setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cancelar
                setEditable(false);
                modifyButton.setVisible(true);
                saveButton.setVisible(false);
                cancelButton.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                //new GuiaLandingPage("Guía").main(null);
            }
        });

        uploadPhotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cargar la foto de perfil
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Procesar el archivo seleccionado
                    JOptionPane.showMessageDialog(frame, "Foto cargada exitosamente.");
                }
            }
        });

        // Inicializar los campos con datos actuales (mock)
        loadProfile();
        setEditable(false);
    }

    // Método para hacer los campos editables o no
    private void setEditable(boolean editable) {
        nameField.setEditable(editable);
        lastNameField.setEditable(editable);
        sexField.setEnabled(editable);
        dniField.setEditable(editable);
        emailField.setEditable(editable);
        phoneField.setEditable(editable);
        citiesComboBox.setEnabled(editable);
        uploadPhotoButton.setEnabled(editable);
    }

    // Mock: cargar datos de perfil
    private void loadProfile() {
        nameField.setText("Juan");
        lastNameField.setText("Pérez");
        sexField.setSelectedItem("Masculino");
        dniField.setText("12345678");
        emailField.setText("juan.perez@example.com");
        phoneField.setText("1234567890");
        citiesComboBox.setSelectedItem("Buenos Aires, Argentina");
    }

    // Mock: guardar datos de perfil
    private void saveProfile() {
        JOptionPane.showMessageDialog(frame, "Cambios guardados exitosamente.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuiaPerfil().frame.setVisible(true);
            }
        });
    }
}

