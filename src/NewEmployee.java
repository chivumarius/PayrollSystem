import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class NewEmployee extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t3, t4, t5, t6, t7;
    JButton b1, b2;
    Choice c1;
    DBConnection dbConnection;

    NewEmployee() {
        super("New Employee");

        setSize(600, 650);
        setLocation(600, 200);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setLayout(new GridLayout(8, 2, 10, 40));
        p1.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        l1 = new JLabel("Name");
        t1 = new JTextField(15);
        p1.add(l1);
        p1.add(t1);

        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");

        l2 = new JLabel("Gender");
        p1.add(l2);
        p1.add(c1);
        l3 = new JLabel("Address");
        t3 = new JTextField(15);
        p1.add(l3);
        p1.add(t3);
        l4 = new JLabel("State");
        t4 = new JTextField(15);
        p1.add(l4);
        p1.add(t4);
        l5 = new JLabel("City");
        t5 = new JTextField(15);
        p1.add(l5);
        p1.add(t5);
        l6 = new JLabel("Email");
        t6 = new JTextField(15);
        p1.add(l6);
        p1.add(t6);
        l7 = new JLabel("Phone");
        t7 = new JTextField(15);
        p1.add(l7);
        p1.add(t7);

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);

        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        setLocationRelativeTo(null);

        try {
            dbConnection = new DBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                // Get the last ID from the table
                String lastIDQuery = "SELECT MAX(CAST(SUBSTRING(id, 2) AS UNSIGNED)) FROM employee";
                try (ResultSet rs = dbConnection.getStatement().executeQuery(lastIDQuery)) {
                    int lastID = 0;
                    if (rs.next()) {
                        lastID = rs.getInt(1);
                    }

                    // Increment the last ID to get the new ID
                    int newID = lastID + 1;
                    String newIDString = String.format("%04d", newID); // Format to have 4 digits, e.g., 0001, 0010, 0100

                    String name = t1.getText();
                    String gender = c1.getSelectedItem();
                    String address = t3.getText();
                    String state = t4.getText();
                    String city = t5.getText();
                    String email = t6.getText();
                    String phone = t7.getText();

                    String qry = "INSERT INTO employee (id, name, gender, address, state, city, email, phone) " +
                            "VALUES ('" + newIDString + "','" + name + "','" + gender + "','" + address + "','" + state + "','" + city + "','" + email + "','" + phone + "')";

                    Statement statement = dbConnection.getStatement();
                    statement.executeUpdate(qry);
                    JOptionPane.showMessageDialog(null, "Employee Created");

                    // Clear the text fields after successful insertion
                    t1.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            dispose(); // Close the current frame
            // Show the existing MainScreen frame instead of creating a new one
            for (Window window : Window.getWindows()) {
                if (window instanceof MainScreen) {
                    window.setVisible(true);
                }
            }
        }
    }

    public static void main(String[] args) {
        new NewEmployee().setVisible(true);
    }
}