import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployee extends JFrame implements ActionListener, ItemListener {
    JLabel empLabel, nameLabel, genderLabel, addressLabel, stateLabel, cityLabel, emailLabel, phoneLabel;
    JTextField nameField, addressField, stateField, cityField, emailField, phoneField;
    JButton updateButton, deleteButton;
    Choice genderChoice, employeeChoice;
    DBConnection dbConnection;


    UpdateEmployee() {
        super("Update Employee");

        setSize(400, 500);
        setLocation(600, 200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        empLabel = new JLabel("Select Employee ID");
        empLabel.setBounds(40, 40, 120, 20);
        add(empLabel);

        employeeChoice = new Choice();
        employeeChoice.setBounds(160, 40, 200, 20);
        try {
            dbConnection = new DBConnection();
            Statement statement = dbConnection.getStatement();
            ResultSet rs = statement.executeQuery("select * from employee");

            while (rs.next()) {
                employeeChoice.add(rs.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        add(employeeChoice);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(40, 80, 100, 20);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(160, 80, 200, 20);
        add(nameField);

        genderLabel = new JLabel("Gender: ");
        genderLabel.setBounds(40, 120, 100, 20);
        add(genderLabel);
        genderChoice = new Choice();
        genderChoice.add("Male");
        genderChoice.add("Female");
        genderChoice.setBounds(160, 120, 200, 20);
        add(genderChoice);

        addressLabel = new JLabel("Address: ");
        addressLabel.setBounds(40, 160, 100, 20);
        add(addressLabel);
        addressField = new JTextField();
        addressField.setBounds(160, 160, 200, 20);
        add(addressField);

        stateLabel = new JLabel("State: ");
        stateLabel.setBounds(40, 200, 100, 20);
        add(stateLabel);
        stateField = new JTextField();
        stateField.setBounds(160, 200, 200, 20);
        add(stateField);

        cityLabel = new JLabel("City: ");
        cityLabel.setBounds(40, 240, 100, 20);
        add(cityLabel);
        cityField = new JTextField();
        cityField.setBounds(160, 240, 200, 20);
        add(cityField);

        emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(40, 280, 100, 20);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(160, 280, 200, 20);
        add(emailField);

        phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(40, 320, 100, 20);
        add(phoneLabel);
        phoneField = new JTextField();
        phoneField.setBounds(160, 320, 200, 20);
        add(phoneField);

        updateButton = new JButton("Update");
        updateButton.setBounds(40, 400, 150, 30);
        add(updateButton);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(this);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(200, 400, 150, 30);
        add(deleteButton);
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(this);

        employeeChoice.addItemListener(this);

        // Set Frame to Open in the Center of the Screen at Runtime
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateButton) {
            try {
                String name = nameField.getText();
                String gender = genderChoice.getSelectedItem();
                String address = addressField.getText();
                String state = stateField.getText();
                String city = cityField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String query = "update employee set name='" + name + "', gender='" + gender + "', address='" + address + "', state='" + state + "', city='" + city + "', email='" + email + "', phone='" + phone + "' where id=" + employeeChoice.getSelectedItem();

                Statement statement = dbConnection.getStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Updated");
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        }

        if (ae.getSource() == deleteButton) {
            try {
                Statement statement = dbConnection.getStatement();
                statement.executeUpdate("delete from employee where id=" + employeeChoice.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Employee Deleted");
                dispose();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        try {
            Statement statement = dbConnection.getStatement();
            ResultSet rs = statement.executeQuery("select * from employee where id=" + employeeChoice.getSelectedItem());

            if (rs.next()) {
                nameField.setText(rs.getString("name"));
                genderChoice.select(rs.getString("gender"));
                addressField.setText(rs.getString("address"));
                stateField.setText(rs.getString("state"));
                cityField.setText(rs.getString("city"));
                emailField.setText(rs.getString("email"));
                phoneField.setText(rs.getString("phone"));
            }
        } catch (SQLException ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee();
    }
}