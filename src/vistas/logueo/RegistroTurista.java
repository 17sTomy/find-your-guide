package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroTurista {
    private JFrame frame;

    public RegistroTurista() {
        // Crear el frame principal
        frame = new JFrame("Registrarse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al salir
        frame.setSize(400, 450); // Aumentar el tamaño para acomodar los nuevos elementos
        frame.setLayout(new BorderLayout());

        // Crear el panel superior con el título
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));

        JLabel titleLabel = new JLabel("Registro de Usuario", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Crear el panel central con los campos de texto
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(230, 230, 250));
        centerPanel.setLayout(new GridLayout(4, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel emailLabel = new JLabel("Correo Electrónico:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JPasswordField passwordField = new JPasswordField();

        JLabel confirmPasswordLabel = new JLabel("Confirmar Contraseña:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        JPasswordField confirmPasswordField = new JPasswordField();

        centerPanel.add(emailLabel);
        centerPanel.add(emailField);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordField);
        centerPanel.add(confirmPasswordLabel);
        centerPanel.add(confirmPasswordField);

        // Crear el panel inferior con el botón de registro y el mensaje de terceros
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(255, 255, 255));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        // Panel para el botón de registrarse
        JPanel registerPanel = new JPanel();
        registerPanel.setBackground(new Color(255, 255, 255));
        registerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton registerButton = createNavButton("Registrarse");

        registerPanel.add(registerButton);

        // Panel para el mensaje y botones de terceros
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
                // Validar que las contraseñas coincidan
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Acción para el botón de registrarse (puedes agregar lógica adicional aquí)
                    JOptionPane.showMessageDialog(frame, "Registro exitoso.");
                }
            }
        });

        googleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías implementar la lógica para el registro con Google
                JOptionPane.showMessageDialog(frame, "Registro con Google exitoso.");
            }
        });

        appleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías implementar la lógica para el registro con Apple
                JOptionPane.showMessageDialog(frame, "Registro con Apple exitoso.");
            }
        });

        facebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí deberías implementar la lógica para el registro con Facebook
                JOptionPane.showMessageDialog(frame, "Registro con Facebook exitoso.");
            }
        });
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
        button.setBackground(new Color(66, 133, 244)); // Azul de Google por defecto
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        if (provider.equals("Apple")) {
            button.setBackground(new Color(0, 0, 0)); // Negro de Apple por defecto
        } else if (provider.equals("Facebook")) {
            button.setBackground(new Color(59, 89, 152)); // Azul de Facebook por defecto
        }

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistroTurista::new);
    }
}
