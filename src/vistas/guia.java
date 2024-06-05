package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guia {
    public static void main(String[] args) {
        // Crear el frame principal
        JFrame frame = new JFrame("Mi Aplicación Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Crear panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Crear componentes
        JLabel label1 = new JLabel("Campo 1:");
        JTextField textField1 = new JTextField();
        JLabel label2 = new JLabel("Campo 2:");
        JTextField textField2 = new JTextField();
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");

        // Añadir componentes al panel
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(button1);
        panel.add(button2);

        // Añadir panel al frame
        frame.add(panel, BorderLayout.CENTER);

        // Hacer visible el frame
        frame.setVisible(true);

        // Añadir listeners a los botones (acciones a realizar)
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para el botón 1
                JOptionPane.showMessageDialog(frame, "Botón 1 presionado");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para el botón 2
                JOptionPane.showMessageDialog(frame, "Botón 2 presionado");
            }
        });
    }
}

