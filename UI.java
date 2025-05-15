import javax.swing.*;
import java.awt.*;

public class UI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Budgeting app");
        frame.setSize(1080, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton button = new JButton("Click Me!");

        button.setFont(new Font("Arial", Font.BOLD, 28)); // Font style and size
        button.setBackground(Color.BLUE);                            // Background color
        button.setForeground(Color.WHITE);                           // Text color
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border
        button.setPreferredSize(new Dimension(150, 50));
        button.setFocusPainted(false);        // Removes focus border around text
        button.setBounds(500, 360, 300, 50);

        JLabel label = new JLabel("Hello, this is some text!");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(Color.BLACK);
        label.setBounds(50, 500, 300, 50);

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Button was clicked!");
        });

        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
    }
}
