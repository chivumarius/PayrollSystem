import javax.swing.*;
import java.awt.*;

// Class representing the splash screen frame
class SplashFrame extends JFrame {
    // Constructor to initialize the splash screen frame
    SplashFrame(String s) {
        super(s);

        // Load and scale the image for the splash screen
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll_system.jpg"));
        Image i1 = c1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);

        // Add the image to a label and add the label to the frame
        JLabel m1 = new JLabel(i2);
        add(m1);

        // Set frame properties
        setSize(730, 550);

        // Center the splash screen frame on the screen
        setLocationRelativeTo(null);	// Center the frame on the screen

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}