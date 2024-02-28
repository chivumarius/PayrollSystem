import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Salary extends JFrame implements ActionListener {
    JLabel empLabel, hraLabel, daLabel, maLabel, pfLabel, bsLabel;
    JTextField hraField, daField, maField, pfField, bsField;
    JButton submitButton, cancelButton;
    Choice empChoice;
    DBConnection dbConnection;

    public Salary() {
        super("Set Salary");

        // Create panel for organizing components
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Initialize Choice component to select employee ID
        empChoice = new Choice();
        try {
            dbConnection = new DBConnection();
            ResultSet rs = dbConnection.getStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                empChoice.add(rs.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: Unable to fetch employee IDs", "Error", JOptionPane.ERROR_MESSAGE);
        }
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Select Emp No"), gbc);
        gbc.gridx = 1;
        panel.add(empChoice, gbc);

        // House Rent Allowance field
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("House Rent Allowance"), gbc);
        gbc.gridx = 1;
        hraField = new JTextField(15);
        panel.add(hraField, gbc);

        // Dearness Allowance field
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Dearness Allowance"), gbc);
        gbc.gridx = 1;
        daField = new JTextField(15);
        panel.add(daField, gbc);

        // Medical Allowance field
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Medical Allowance"), gbc);
        gbc.gridx = 1;
        maField = new JTextField(15);
        panel.add(maField, gbc);

        // Provident Fund field
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Provident Fund"), gbc);
        gbc.gridx = 1;
        pfField = new JTextField(15);
        panel.add(pfField, gbc);

        // Basic Salary field
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Basic Salary"), gbc);
        gbc.gridx = 1;
        bsField = new JTextField(15);
        panel.add(bsField, gbc);

        // Create panel for buttons and set layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        buttonPanel.add(submitButton);

        // Cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        buttonPanel.add(cancelButton);

        // Add action listeners to buttons
        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Add panels to the frame
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Set window size, location, and visibility
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Action performed when buttons are clicked
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            try {
                String id = empChoice.getSelectedItem();
                String house_rent_allowance = hraField.getText();
                String dearness_allowance = daField.getText();
                String medical_allowance = maField.getText();
                String provident_fund = pfField.getText();
                String basic_salary = bsField.getText();

                // Format the ID to always have 4 digits by padding with leading zeros, if necessary
                id = String.format("%04d", Integer.parseInt(id));

                // Query to insert the salary
                String query = "INSERT INTO salary VALUES ('" + id + "', '" + house_rent_allowance + "', '" + dearness_allowance + "', '" + medical_allowance + "', '" + provident_fund + "', '" + basic_salary + "')";

                dbConnection.getStatement().executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Salary updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: Unable to update salary", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == cancelButton) {
            // Redirect to the initial MainScreen frame without creating a new one
            for (Window window : Window.getWindows()) {
                if (window instanceof MainScreen) {
                    window.setVisible(true);
                    break;
                }
            }
            dispose();
        }
    }

    // Main method to create an instance of Salary class
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Salary::new);
    }
}