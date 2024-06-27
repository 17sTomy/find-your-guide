package vistas.logueo;

import controladores.GuiaController;
import enums.*;
import modelos.clases.Credencial;
import modelos.dtos.GuiaDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RegistroGuia {
    private JFrame frame;
    private File selectedImageFile;
    private GuiaController guiaController;
    private GuiaDTO guiaDTO;
    private Auth modoRegistro;

    private JComboBox<Pais> paisComboBox;
    private JComboBox<Ciudad> ciudadComboBox;
    private JComboBox<Credencial> credencialComboBox;
    private JTextArea serviciosTextArea;
    private JComboBox<Idioma> idiomaComboBox;

    public RegistroGuia() {
        this.guiaDTO = guiaDTO;
        this.modoRegistro = modoRegistro;
        guiaController = new GuiaController();

        // Crear el frame principal
        frame = new JFrame("Registro de Guía");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setLayout(new BorderLayout());

        // Panel superior con título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("Registro de Guía", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Botón de retroceso
        JButton backButton = new JButton("Atrás");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(0, 102, 204));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(12, 54, 12, 54));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login("Guia");
            }
        });

        topPanel.add(backButton, BorderLayout.WEST);

        // Panel central con campos de texto
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(230, 230, 250));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos de formulario
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        centerPanel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JTextField nameField = new JTextField(20);
        if (guiaDTO != null) nameField.setText(guiaDTO.getNombre());
        centerPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(new JLabel("Apellido:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField surnameField = new JTextField(20);
        if (guiaDTO != null) surnameField.setText(guiaDTO.getApellido());
        centerPanel.add(surnameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(new JLabel("Sexo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"MASCULINO", "FEMENINO"});
        centerPanel.add(genderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(new JLabel("DNI:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JTextField dniField = new JTextField(20);
        if (guiaDTO != null) dniField.setText(guiaDTO.getDni());
        centerPanel.add(dniField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        centerPanel.add(new JLabel("Correo Electrónico:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JTextField emailField = new JTextField(20);
        if (guiaDTO != null) emailField.setText(guiaDTO.getEmail());
        centerPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        centerPanel.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        JPasswordField passwordField = new JPasswordField(20);
        centerPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        centerPanel.add(new JLabel("Confirmar Contraseña:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        JPasswordField confirmPasswordField = new JPasswordField(20);
        centerPanel.add(confirmPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        centerPanel.add(new JLabel("Teléfono:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        JTextField phoneField = new JTextField(20);
        if (guiaDTO != null) phoneField.setText(guiaDTO.getNumTelefono());
        centerPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        centerPanel.add(new JLabel("Foto de Perfil (JPG):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        JButton uploadProfilePictureButton = new JButton("Cargar Foto");
        centerPanel.add(uploadProfilePictureButton, gbc);

        // Campos adicionales
        gbc.gridx = 0;
        gbc.gridy = 9;
        centerPanel.add(new JLabel("Servicios (separados por comas):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        serviciosTextArea = new JTextArea(4, 20);
        serviciosTextArea.setLineWrap(true);
        centerPanel.add(new JScrollPane(serviciosTextArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        centerPanel.add(new JLabel("País:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        paisComboBox = new JComboBox<>(Pais.values());
        centerPanel.add(paisComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        centerPanel.add(new JLabel("Ciudad:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        ciudadComboBox = new JComboBox<>(Ciudad.values());
        centerPanel.add(ciudadComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        centerPanel.add(new JLabel("Credencial:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 12;
        JComboBox<Integer> credencialComboBox = new JComboBox<>(new Integer[]{1, 2, 3});
        centerPanel.add(credencialComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        centerPanel.add(new JLabel("Idioma:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 13;
        idiomaComboBox = new JComboBox<>(Idioma.values());
        centerPanel.add(idiomaComboBox, gbc);

        // Panel inferior con botón de registro
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(255, 255, 255));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        // Botón de registro
        JPanel registerPanel = new JPanel();
        registerPanel.setBackground(new Color(255, 255, 255));
        registerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton registerButton = createNavButton("Registrarse");
        registerPanel.add(registerButton);

        // Panel de terceros
        JPanel thirdPartyPanel = new JPanel();
        thirdPartyPanel.setBackground(new Color(255, 255, 255));
        thirdPartyPanel.setLayout(new BoxLayout(thirdPartyPanel, BoxLayout.Y_AXIS));

        JLabel thirdPartyLabel = new JLabel("También puede registrarse con:");
        thirdPartyLabel.setFont(new Font("Arial", Font.BOLD, 14));
        thirdPartyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thirdPartyPanel.add(thirdPartyLabel);

        // Añadir botones de terceros
        JButton googleButton = createThirdPartyButton("Google");
        JButton appleButton = createThirdPartyButton("Apple");
        JButton facebookButton = createThirdPartyButton("Facebook");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(255, 255, 255));
        buttonPanel.add(googleButton);
        buttonPanel.add(appleButton);
        buttonPanel.add(facebookButton);

        thirdPartyPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        thirdPartyPanel.add(buttonPanel);

        // Añadir componentes al panel inferior
        bottomPanel.add(registerPanel);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(thirdPartyPanel);

        // Añadir paneles al frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(centerPanel), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Mostrar el frame
        frame.setVisible(true);

        // Acción del botón para cargar foto de perfil
        uploadProfilePictureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedImageFile = fileChooser.getSelectedFile();
                }
            }
        });

        // Acción del botón para registrarse
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener valores de los campos
                String nombre = nameField.getText();
                String apellido = surnameField.getText();
                Sexo sexo = Sexo.valueOf((String) genderComboBox.getSelectedItem());
                String dni = dniField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String telefono = phoneField.getText();
                String fotoPerfil = selectedImageFile != null ? selectedImageFile.getAbsolutePath() : null;

                Pais pais = (Pais) paisComboBox.getSelectedItem();
                Ciudad ciudad = (Ciudad) ciudadComboBox.getSelectedItem();
                //Credencial credencial = (Credencial) credencialComboBox.getSelectedItem(); TODO agregar para credencial dto

                String serviciosStr = serviciosTextArea.getText();
                List<String> servicios = List.of(serviciosStr.split(",")).stream().map(String::trim).toList();
                Idioma idioma = (Idioma) idiomaComboBox.getSelectedItem();
                List<Idioma> idiomas = new ArrayList<>();
                idiomas.add(idioma);

                // Validaciones
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || email.isEmpty() || password.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (selectedImageFile == null || !selectedImageFile.getName().endsWith(".jpg")) {
                    JOptionPane.showMessageDialog(frame, "Por favor, cargue una foto de perfil válida en formato JPG.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                GuiaController guiaController = new GuiaController();
                guiaController.registrarGuia(new GuiaDTO(nombre, apellido, dni, sexo, email, telefono, fotoPerfil, "BASICO", null, pais,ciudad,null,idiomas,null), password, Auth.BASICO);
                JOptionPane.showMessageDialog(frame, "Registro exitoso.");

            }
        });
    }

    // Método auxiliar para crear botones de navegación
    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 54, 12, 54));
        return button;
    }

    // Método auxiliar para crear botones de terceros
    private JButton createThirdPartyButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(0, 102, 204));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2, true));
        return button;
    }

    public static void main(String[] args) {
        new RegistroGuia();
    }
}
