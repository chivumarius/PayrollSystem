import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

// Class for displaying the list of employees
public class ListEmployee extends JFrame implements ActionListener {

    private JTable table; // Table for displaying employee information
    private JButton printButton; // Button for printing the table
    private String[] columnHeaders = {"Emp id", "Name", "Gender", "Address", "State", "City", "Email id", "Phone"}; // Headers for the columns
    private String[][] data; // Matrix for storing employee information

    // Constructor to initialize and configure the frame
    public ListEmployee() {
        super("View Employees");

        setSize(1000, 400); // Set frame size
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Do nothing on close

        // Add window listener to handle close button action
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Redirect to the initial MainScreen frame without creating a new one
                for (Window window : Window.getWindows()) {
                    if (window instanceof MainScreen) {
                        window.setVisible(true);
                        break;
                    }
                }
                dispose();
            }
        });

        try (DBConnection dbConnection = new DBConnection();
             Statement statement = dbConnection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS count FROM employee")) {

            // Get the number of rows in the result set
            resultSet.next();
            int rowCount = resultSet.getInt("count");

            // Initialize the matrix with the appropriate dimensions
            data = new String[rowCount][8];

            // Query to get employee information
            ResultSet rs = statement.executeQuery("SELECT * FROM employee");
            int i = 0; // Row index variable
            while (rs.next()) {
                // Store employee information in the matrix
                data[i][0] = rs.getString("id");
                data[i][1] = rs.getString("name");
                data[i][2] = rs.getString("gender");
                data[i][3] = rs.getString("address");
                data[i][4] = rs.getString("state");
                data[i][5] = rs.getString("city");
                data[i][6] = rs.getString("email");
                data[i][7] = rs.getString("phone");
                i++; // Move to the next row
            }
            // Create the table with employee data and column headers
            table = new JTable(data, columnHeaders);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        } catch (Exception e) {
            e.printStackTrace(); // Handle other exceptions
        }

        printButton = new JButton("Print"); // Create the button for printing
        printButton.addActionListener(this); // Add action listener to the button

        JScrollPane scrollPane = new JScrollPane(table); // Create the scroll pane for the table
        add(scrollPane, BorderLayout.CENTER); // Add the scroll pane to the center of the frame
        add(printButton, BorderLayout.SOUTH); // Add the button to the bottom of the frame
    }

    // Method to handle button click events
    public void actionPerformed(ActionEvent ae) {
        try {
            table.print(); // Print the table
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions
        }
    }

    // Main method to create and display the frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListEmployee().setVisible(true)); // Create and display the frame
    }
}