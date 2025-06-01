package OOP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Main2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Full Screen GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setUndecorated(true); // Removes title bar for full-screen mode

            // Create a close button
            JButton closeButton = new JButton("X");
            closeButton.setFont(new Font("Arial", Font.BOLD, 16));
            closeButton.setBackground(Color.RED);
            closeButton.setForeground(Color.WHITE);
            closeButton.setFocusPainted(false);
            closeButton.addActionListener((ActionEvent e) -> System.exit(0));

            // Create a panel and set layout
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panel.setOpaque(false);
            panel.add(closeButton);

            // Add the panel to the frame
            frame.add(panel, BorderLayout.NORTH);

            // Set full screen mode
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = env.getDefaultScreenDevice();
            device.setFullScreenWindow(frame);

            frame.setVisible(true);
        });
    }
}