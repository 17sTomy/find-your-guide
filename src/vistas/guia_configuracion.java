//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class guia_configuracion {
    public static JFrame frame;

    public guia_configuracion() {
        frame = new JFrame("Configuración");
        frame.setDefaultCloseOperation(3);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 102, 204));
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));
        JLabel titleLabel = new JLabel("Configuración", 2);
        titleLabel.setFont(new Font("Arial", 1, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));
        topPanel.add(titleLabel, "West");
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(230, 230, 250));
        JLabel messageLabel = new JLabel("Página de configuración");
        messageLabel.setFont(new Font("Arial", 1, 18));
        messageLabel.setForeground(new Color(0, 102, 204));
        centerPanel.add(messageLabel);
        frame.add(topPanel, "North");
        frame.add(centerPanel, "Center");
        frame.setVisible(false);
    }
}
