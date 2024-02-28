import java.awt.*;

// Class for displaying a splash screen
class Splash {

    // Main method to initialize and display the splash screen
    public static void main(String[] args) {
        // Create a new splash screen frame with a title
        SplashFrame f1 = new SplashFrame("Payroll System Free Licence Version 2.0");

        // Center the splash screen frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = (screenSize.width - f1.getWidth()) / 2;
        int yPos = (screenSize.height - f1.getHeight()) / 2;
        f1.setLocation(xPos, yPos);

        // Set the splash screen frame to be visible
        f1.setVisible(true); // Show

        // Animation loop to gradually increase the size of the splash screen
        int i;
        int x = 1;

        for(i = 2; i <= 600; i += 4, x += 1) {
            // Set size of the splash screen frame
            f1.setSize(i + x, i);

            // Pause to create animation effect
            try {
                Thread.sleep(10);
            } catch(Exception e) {
                // Throw a runtime exception if there's an interruption during sleep
                throw new RuntimeException(e);
            }
        }

        // Hide the splash screen frame
        f1.setVisible(false);

        // Show the login frame
        new Login().setVisible(true);
    }
}