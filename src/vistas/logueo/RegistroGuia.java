package vistas.logueo;

import enums.Ciudad;
import enums.Idioma;
import enums.Pais;
import vistas.logueo.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RegistroGuia {
    private JFrame frame;
    private File selectedImageFile; // Variable para almacenar la foto de perfil seleccionada
    private JTextField nameField;
    private JTextField surnameField;
    private JComboBox<String> genderComboBox;
    private JTextField dniField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField phoneField;
    private JComboBox<Pais> paisComboBox;
    private JComboBox<Ciudad> ciudadComboBox;
    private JComboBox<String> credencialComboBox;
    private JTextArea serviciosTextArea;
    private JComboBox<Idioma> idiomasComboBox;

    public RegistroGuia() {
        // Crear el frame principal
        frame = new JFrame("Registro de Guía");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700); // Aumentar el tamaño para acomodar los nuevos elementos
        frame.setLayout(new BorderLayout());

        // Crear el panel superior con el título
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
        backButton.setBorder(BorderFactory.createEmptyBorder(11, 54, 12, 54));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para volver atrás
                frame.dispose(); // Cierra la ventana actual de registro
                new Login(null); // Abre la ventana de login (asumiendo que no hay usuario registrado para pasar)
            }
        });

        topPanel.add(backButton, BorderLayout.WEST);

        // Crear el panel central con los campos de texto
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(230, 230, 250));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir los componentes con restricciones específicas
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.gridwidth = 1;
        centerPanel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        nameField = new JTextField(20);
        centerPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(new JLabel("Apellido:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        surnameField = new JTextField(20);
        centerPanel.add(surnameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(new JLabel("Sexo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        genderComboBox = new JComboBox<>(new String[]{"Masculino", "Femenino"});
        centerPanel.add(genderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(new JLabel("DNI:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        dniField = new JTextField(20);
        centerPanel.add(dniField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        centerPanel.add(new JLabel("Correo Electrónico:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        emailField = new JTextField(20);
        centerPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        centerPanel.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        passwordField = new JPasswordField(20);
        centerPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        centerPanel.add(new JLabel("Confirmar Contraseña:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        confirmPasswordField = new JPasswordField(20);
        centerPanel.add(confirmPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        centerPanel.add(new JLabel("Teléfono:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        phoneField = new JTextField(20);
        centerPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        centerPanel.add(new JLabel("País:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        paisComboBox = new JComboBox<>(Pais.values()); // Utilizando el enum Pais
        centerPanel.add(paisComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        centerPanel.add(new JLabel("Ciudad:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        ciudadComboBox = new JComboBox<>(Ciudad.values()); // Utilizando el enum Ciudad
        centerPanel.add(ciudadComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        centerPanel.add(new JLabel("Credencial:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        credencialComboBox = new JComboBox<>(new String[]{"Tipo A", "Tipo B", "Tipo C"});
        centerPanel.add(credencialComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        centerPanel.add(new JLabel("Servicios:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        serviciosTextArea = new JTextArea(4, 20);
        JScrollPane serviciosScrollPane = new JScrollPane(serviciosTextArea);
        centerPanel.add(serviciosScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 12;
        centerPanel.add(new JLabel("Idiomas:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 12;
        idiomasComboBox = new JComboBox<>(Idioma.values());
        centerPanel.add(idiomasComboBox, gbc);

        // Crear el panel inferior con el botón de registro y botones de terceros
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
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarGuia();
            }
        });

        googleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para registrar con Google
                JOptionPane.showMessageDialog(frame, "Registro con Google aún no implementado", "Registro con Google", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        appleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para registrar con Apple
                JOptionPane.showMessageDialog(frame, "Registro con Apple aún no implementado", "Registro con Apple", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        facebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para registrar con Facebook
                JOptionPane.showMessageDialog(frame, "Registro con Facebook aún no implementado", "Registro con Facebook", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    // Método para crear botones de navegación personalizados
    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(11, 54, 12, 54));
        return button;
    }

    // Método para crear botones de terceros personalizados
    private JButton createThirdPartyButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(59, 89, 152));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 40));
        return button;
    }

    // Método para registrar al guía
    private void registrarGuia() {
        // Obtener los valores de los campos
        String nombre = nameField.getText();
        String apellido = surnameField.getText();
        String sexo = (String) genderComboBox.getSelectedItem();
        String dni = dniField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        String telefono = phoneField.getText();
        Pais pais = (Pais) paisComboBox.getSelectedItem();
        Ciudad ciudad = (Ciudad) ciudadComboBox.getSelectedItem();
        String credencial = (String) credencialComboBox.getSelectedItem();
        String servicios = serviciosTextArea.getText();
        Idioma idioma = (Idioma) idiomasComboBox.getSelectedItem();

        // Mostrar mensaje de registro exitoso
        JOptionPane.showMessageDialog(frame,
                "Registro exitoso!\nNombre: " + nombre + " " + apellido +
                        "\nSexo: " + sexo +
                        "\nDNI: " + dni +
                        "\nEmail: " + email +
                        "\nTeléfono: " + telefono +
                        "\nPaís: " + pais +
                        "\nCiudad: " + ciudad +
                        "\nCredencial: " + credencial +
                        "\nServicios: " + servicios +
                        "\nIdioma: " + idioma,
                "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

        limpiarCampos();
    }

    // Método para limpiar los campos del formulario después del registro
    private void limpiarCampos() {
        nameField.setText("");
        surnameField.setText("");
        genderComboBox.setSelectedIndex(0);
        dniField.setText("");
        emailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        phoneField.setText("");
        paisComboBox.setSelectedIndex(0);
        ciudadComboBox.setSelectedIndex(0);
        credencialComboBox.setSelectedIndex(0);
        serviciosTextArea.setText("");
        idiomasComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegistroGuia();
            }
        });
    }
}
