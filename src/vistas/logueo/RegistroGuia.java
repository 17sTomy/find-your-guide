package vistas.logueo;

import controladores.GuiaController;
import controladores.TuristaController;
import enums.*;
import modelos.clases.Credencial;
import modelos.dtos.CredencialDTO;
import modelos.dtos.GuiaDTO;
import modelos.dtos.TuristaDTO;

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
    private JComboBox<Idioma> idiomaComboBox;
    private File selectedCredencialFile;


    public RegistroGuia() {
        this.guiaDTO = guiaDTO;
        this.modoRegistro = modoRegistro;
        guiaController = new GuiaController();

        // Crear el frame principal
        frame = new JFrame("Registro de Guía");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

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
                // Acción para volver atrás
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

        gbc.gridx = 0;
        gbc.gridy = 9;
        centerPanel.add(new JLabel("País:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        paisComboBox = new JComboBox<>(Pais.values());
        centerPanel.add(paisComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        centerPanel.add(new JLabel("Ciudad:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        ciudadComboBox = new JComboBox<>(Ciudad.values());
        centerPanel.add(ciudadComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        centerPanel.add(new JLabel("ID Credencial: "), gbc); // Etiqueta para el texto de la credencial

        gbc.gridx = 1;
        gbc.gridy = 11;
        JTextField credencialField = new JTextField(20);  // Campo de texto para la credencial
        centerPanel.add(credencialField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        centerPanel.add(new JLabel("Foto de Credencial (JPG):"), gbc); // Etiqueta para la foto de la credencial

        gbc.gridx = 1;
        gbc.gridy = 12;
        JButton uploadCredencialButton = new JButton("Cargar Credencial"); // Botón para cargar la foto de la credencial
        centerPanel.add(uploadCredencialButton, gbc);

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
        registerPanel.add(backButton);


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

        googleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nameField.getText();
                String apellido = surnameField.getText();
                String sexoStr = (String) genderComboBox.getSelectedItem();
                Sexo sexo;
                try {
                    sexo = Sexo.valueOf(sexoStr.toUpperCase());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, "Seleccione un sexo válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir de la acción si el valor del sexo no es válido
                }

                String dni = dniField.getText();
                String email = emailField.getText();
                String telefono = phoneField.getText();
                String fotoPerfil = (selectedImageFile != null) ? selectedImageFile.getAbsolutePath() : "";

                // Validaciones
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                if (selectedImageFile == null || !selectedImageFile.getName().endsWith(".jpg")) {
                    JOptionPane.showMessageDialog(frame, "Por favor, cargue una foto de perfil válida en formato JPG.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                TuristaController turistaController = new TuristaController();
                turistaController.registrarTurista(new TuristaDTO(nombre, apellido, dni, sexo, email, telefono, fotoPerfil, "GOOGLE", 0), "google", Auth.GOOGLE);
                JOptionPane.showMessageDialog(frame, "Registro con Google exitoso.");
            }
        });

        appleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nameField.getText();
                String apellido = surnameField.getText();
                String sexoStr = (String) genderComboBox.getSelectedItem();
                Sexo sexo;
                try {
                    sexo = Sexo.valueOf(sexoStr.toUpperCase());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, "Seleccione un sexo válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir de la acción si el valor del sexo no es válido
                }

                String dni = dniField.getText();
                String email = emailField.getText();
                String telefono = phoneField.getText();
                String fotoPerfil = (selectedImageFile != null) ? selectedImageFile.getAbsolutePath() : "";

                // Validaciones
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (selectedImageFile == null || !selectedImageFile.getName().endsWith(".jpg")) {
                    JOptionPane.showMessageDialog(frame, "Por favor, cargue una foto de perfil válida en formato JPG.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                TuristaController turistaController = new TuristaController();
                turistaController.registrarTurista(new TuristaDTO(nombre, apellido, dni, sexo, email, telefono, fotoPerfil, "APPLEID", 0), "apple", Auth.APPLEID);
                JOptionPane.showMessageDialog(frame, "Registro con Apple exitoso.");
            }
        });

        facebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nameField.getText();
                String apellido = surnameField.getText();
                String sexoStr = (String) genderComboBox.getSelectedItem();
                Sexo sexo;
                try {
                    sexo = Sexo.valueOf(sexoStr.toUpperCase());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, "Seleccione un sexo válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir de la acción si el valor del sexo no es válido
                }

                String dni = dniField.getText();
                String email = emailField.getText();
                String telefono = phoneField.getText();
                String fotoPerfil = (selectedImageFile != null) ? selectedImageFile.getAbsolutePath() : "";

                // Validaciones
                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (selectedImageFile == null || !selectedImageFile.getName().endsWith(".jpg")) {
                    JOptionPane.showMessageDialog(frame, "Por favor, cargue una foto de perfil válida en formato JPG.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                TuristaController turistaController = new TuristaController();
                turistaController.registrarTurista(new TuristaDTO(nombre, apellido, dni, sexo, email, telefono, fotoPerfil, "FACEBOOK", 0), "facebook", Auth.FACEBOOK);
                JOptionPane.showMessageDialog(frame, "Registro con Facebook exitoso.");
            }
        });

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

        uploadCredencialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedCredencialFile = fileChooser.getSelectedFile();
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
                String credencial = credencialField.getText(); // Obtener texto de la credencial
                String fotoCredencial = selectedCredencialFile != null ? selectedCredencialFile.getAbsolutePath() : null;


                Pais pais = (Pais) paisComboBox.getSelectedItem();
                Ciudad ciudad = (Ciudad) ciudadComboBox.getSelectedItem();
                //Credencial credencial = (Credencial) credencialComboBox.getSelectedItem(); TODO agregar para credencial dto

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
                guiaController.registrarGuia(new GuiaDTO(nombre, apellido, dni, sexo, email, telefono, fotoPerfil, "BASICO", null, pais,ciudad,new CredencialDTO(credencial,fotoCredencial),idiomas, null), password, Auth.BASICO);
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

    private JButton createThirdPartyButton(String provider) {
        JButton button = new JButton(provider);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(66, 133, 244));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        if (provider.equals("Apple")) {
            button.setBackground(new Color(0, 0, 0));
        } else if (provider.equals("Facebook")) {
            button.setBackground(new Color(59, 89, 152));
        }

        return button;
    }

    public static void main(String[] args) {
        new RegistroGuia();
    }
}
