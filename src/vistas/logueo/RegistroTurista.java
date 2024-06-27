package vistas.logueo;

import controladores.GuiaController;
import controladores.TuristaController;
import controladores.ViajeController;
import enums.Auth;
import enums.Sexo;
import modelos.dtos.TuristaDTO;
import vistas.logueo.SeleccionRol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RegistroTurista {
    private JFrame frame;
    private File selectedImageFile;
    private TuristaController turistaController;
    private JComboBox<String> genderComboBox;

    public RegistroTurista(TuristaController turistaController, GuiaController guiaController, ViajeController viajeController) {
        this.turistaController = turistaController;

        // Crear el frame principal
        frame = new JFrame("Registro de Turista");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        // Panel superior con título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("Registro de Turista", JLabel.CENTER);
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
                new SeleccionRol(turistaController, guiaController, viajeController);
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

        // Añadir campos y pre-poblar si hay datos
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        centerPanel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        JTextField nameField = new JTextField(20);
        centerPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(new JLabel("Apellido:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField surnameField = new JTextField(20);
        centerPanel.add(surnameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(new JLabel("Sexo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        genderComboBox = new JComboBox<>(new String[]{"MASCULINO", "FEMENINO"});
        centerPanel.add(genderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(new JLabel("DNI:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        JTextField dniField = new JTextField(20);
        centerPanel.add(dniField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        centerPanel.add(new JLabel("Correo Electrónico:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        JTextField emailField = new JTextField(20);
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
        centerPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        centerPanel.add(new JLabel("Foto de Perfil (JPG):"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        JButton uploadProfilePictureButton = new JButton("Cargar Foto");
        centerPanel.add(uploadProfilePictureButton, gbc);

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
                    return;
                }

                String dni = dniField.getText();
                String email = emailField.getText();
                passwordField.setText("google");
                confirmPasswordField.setText("google");
                String password = new String(passwordField.getPassword());
                String telefono = phoneField.getText();
                String fotoPerfil = (selectedImageFile != null) ? selectedImageFile.getAbsolutePath() : "";

                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (selectedImageFile == null || !selectedImageFile.getName().endsWith(".jpg")) {
                    JOptionPane.showMessageDialog(frame, "Por favor, cargue una foto de perfil válida en formato JPG.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                turistaController.registrarTurista(new TuristaDTO(nombre, apellido, dni, sexo, email, telefono, fotoPerfil, "GOOGLE", 0), password, Auth.GOOGLE);
                JOptionPane.showMessageDialog(frame, "Registro con Google exitoso.");
                frame.dispose();
                new SeleccionRol(turistaController, guiaController, viajeController);
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
                    return;
                }

                String dni = dniField.getText();
                String email = emailField.getText();
                passwordField.setText("apple");
                confirmPasswordField.setText("apple");
                String password = new String(passwordField.getPassword());
                String telefono = phoneField.getText();
                String fotoPerfil = (selectedImageFile != null) ? selectedImageFile.getAbsolutePath() : "";

                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (selectedImageFile == null || !selectedImageFile.getName().endsWith(".jpg")) {
                    JOptionPane.showMessageDialog(frame, "Por favor, cargue una foto de perfil válida en formato JPG.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                turistaController.registrarTurista(new TuristaDTO(nombre, apellido, dni, sexo, email, telefono, fotoPerfil, "APPLEID", 0), password, Auth.APPLEID);
                JOptionPane.showMessageDialog(frame, "Registro con Apple exitoso.");
                frame.dispose();
                new SeleccionRol(turistaController, guiaController, viajeController);
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
                    return;
                }

                String dni = dniField.getText();
                String email = emailField.getText();
                passwordField.setText("facebook");
                confirmPasswordField.setText("facebook");
                String password = new String(passwordField.getPassword());
                String telefono = phoneField.getText();
                String fotoPerfil = (selectedImageFile != null) ? selectedImageFile.getAbsolutePath() : "";

                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (selectedImageFile == null || !selectedImageFile.getName().endsWith(".jpg")) {
                    JOptionPane.showMessageDialog(frame, "Por favor, cargue una foto de perfil válida en formato JPG.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                turistaController.registrarTurista(new TuristaDTO(nombre, apellido, dni, sexo, email, telefono, fotoPerfil, "FACEBOOK", 0), password, Auth.FACEBOOK);
                JOptionPane.showMessageDialog(frame, "Registro con Facebook exitoso.");
                frame.dispose();
                new SeleccionRol(turistaController, guiaController, viajeController);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(googleButton);
        buttonPanel.add(appleButton);
        buttonPanel.add(facebookButton);

        thirdPartyPanel.add(buttonPanel);

        // Añadir paneles al bottomPanel
        bottomPanel.add(registerPanel);
        bottomPanel.add(thirdPartyPanel);

        // Añadir paneles al frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Hacer visible el frame
        frame.setVisible(true);

        // Añadir listeners a los botones (acciones a realizar)
        uploadProfilePictureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        return f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg");
                    }

                    @Override
                    public String getDescription() {
                        return "Archivos JPG (*.jpg)";
                    }
                });
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedImageFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(frame, "Foto de perfil cargada: " + selectedImageFile.getName());
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capturar los datos del formulario
                String nombre = nameField.getText();
                String apellido = surnameField.getText();
                String sexoStr = (String) genderComboBox.getSelectedItem();
                Sexo sexo;
                try {
                    sexo = Sexo.valueOf(sexoStr.toUpperCase());
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, "Seleccione un sexo válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String dni = dniField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String telefono = phoneField.getText();
                String fotoPerfil = (selectedImageFile != null) ? selectedImageFile.getAbsolutePath() : "";

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

                turistaController.registrarTurista(new TuristaDTO(nombre, apellido, dni, sexo, email, telefono, fotoPerfil, "BASICO", 0), password, Auth.BASICO);
                JOptionPane.showMessageDialog(frame, "Registro exitoso.");
                frame.dispose();
                new SeleccionRol(turistaController, guiaController, viajeController);
            }
        });
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(150, 40));
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

}
