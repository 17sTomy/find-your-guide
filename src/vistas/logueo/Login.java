package vistas.logueo;

import controladores.GuiaController;
import controladores.TuristaController;
import controladores.ViajeController;
import enums.Auth;
import vistas.guia.GuiaLandingPage;
import vistas.turista.TuristaLandingPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JFrame frame;
    private String role;
    private TuristaController turistaController;
    private GuiaController guiaController;
    private ViajeController viajeController;
    private JTextField emailField;
    private JPasswordField passwordField;

    public Login(String role, TuristaController turistaController, GuiaController guiaController, ViajeController viajeController) {
        this.role = role;
        this.turistaController = turistaController;
        this.guiaController = guiaController;
        this.viajeController = viajeController;

        // Crear el frame principal
        frame = new JFrame("Iniciar Sesión - " + role);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al salir
        frame.setSize(400, 400); // Ajustar el tamaño de la ventana
        frame.setLayout(new BorderLayout());

        // Crear el panel superior con el título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("Iniciar Sesión como " + role, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Crear el panel central con los campos de texto
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(230, 230, 250));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        centerPanel.add(new JLabel("Correo Electrónico:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        emailField = new JTextField(20);
        centerPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        passwordField = new JPasswordField(20);
        centerPanel.add(passwordField, gbc);

        // Crear el panel inferior con los botones
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(255, 255, 255));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        // Panel de botones de inicio de sesión y registro
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(new Color(255, 255, 255));
        loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton loginButton = createNavButton("Iniciar Sesión");
        JButton registerButton = createNavButton("Registrarse");

        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        bottomPanel.add(loginPanel);

        // Panel de terceros
        JPanel thirdPartyPanel = new JPanel();
        thirdPartyPanel.setBackground(new Color(255, 255, 255));
        thirdPartyPanel.setLayout(new BoxLayout(thirdPartyPanel, BoxLayout.Y_AXIS));

        JLabel thirdPartyLabel = new JLabel("También puede loguearse con:");
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

        bottomPanel.add(thirdPartyPanel);

        // Añadir paneles al frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Hacer visible el frame
        frame.setVisible(true);

        // Añadir listeners a los botones (acciones a realizar)
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (role.equals("Guía")) {
                    if (guiaController.loginGuia(email, password, Auth.BASICO)) {
                        frame.dispose();
                        new GuiaLandingPage(turistaController, guiaController, viajeController).frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Credenciales incorrectas. Por favor, inténtelo de nuevo.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (role.equals("Turista")) {
                    if (turistaController.loginTurista(email, password, Auth.BASICO)) {
                        frame.dispose();
                        new TuristaLandingPage(turistaController, guiaController, viajeController).frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Credenciales incorrectas. Por favor, inténtelo de nuevo.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if (role.equals("Guía")) {
                    new RegistroGuia(guiaController, turistaController, viajeController);
                } else if (role.equals("Turista")) {
                    new RegistroTurista(turistaController, guiaController, viajeController);
                }
            }
        });

        // Añadir listeners para los botones de terceros
        googleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("google");
                autenticarConProveedor(Auth.GOOGLE, emailField.getText(), "google");
            }
        });

        appleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("apple");
                autenticarConProveedor(Auth.APPLEID, emailField.getText(), "apple");
            }
        });

        facebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("facebook");
                autenticarConProveedor(Auth.FACEBOOK, emailField.getText(), "facebook");
            }
        });

        // Centrar el frame en la pantalla
        frame.setLocationRelativeTo(null);
    }

    private void autenticarConProveedor(Auth authMethod, String email, String password) {
        if (role.equals("Guía")) {
            if (guiaController.loginGuia(email, password, authMethod)) {
                frame.dispose();
                new GuiaLandingPage(turistaController, guiaController, viajeController).frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frame, "Credenciales incorrectas. Por favor, inténtelo de nuevo.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            }
        } else if (role.equals("Turista")) {
            if (turistaController.loginTurista(email, password, authMethod)) {
                frame.dispose();
                new TuristaLandingPage(turistaController, guiaController, viajeController).frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(frame, "Credenciales incorrectas. Por favor, inténtelo de nuevo.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private JButton createNavButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
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
