import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateSalary extends JFrame implements ActionListener, ItemListener {

    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    Choice c2;

    UpdateSalary() {

        setLayout(null);
        c2 = new Choice();
        try {
            // Connect to the database and fetch employee IDs
            DBConnection c = new DBConnection();
            ResultSet rs = c.getStatement().executeQuery("select * from salary");
            while (rs.next()) {
                c2.add(rs.getString("id"));
            }

        } catch (Exception e) {
            // Handle any exceptions that might occur during database connection or query execution
            throw new RuntimeException(e);
        }

        // Label and Choice for selecting employee ID
        JLabel emp = new JLabel("Select EmpNo");
        emp.setBounds(20, 20, 100, 20);
        add(emp);

        c2.setBounds(120, 20, 200, 20);
        add(c2);

        // "House Rent Allowance" → Labels and TextFields for displaying and updating salary components
        l1 = new JLabel("House Rent Allowance");
        t1 = new JTextField(15);

        l1.setBounds(20, 60, 100, 20);
        t1.setBounds(120, 60, 200, 20);
        add(l1);
        add(t1);


        // "Dearness Allowance"
        l2 = new JLabel("Dearness Allowance");
        t2 = new JTextField(15);

        l2.setBounds(20, 100, 100, 20);
        t2.setBounds(120, 100, 200, 20);
        add(l2);
        add(t2);


        // "Medical Allowance"
        l3 = new JLabel("Medical Allowance");
        t3 = new JTextField(15);

        l3.setBounds(20, 140, 100, 20);
        t3.setBounds(120, 140, 200, 20);
        add(l3);
        add(t3);


        // "Provident Fund"
        l4 = new JLabel("Provident Fund");
        t4 = new JTextField(15);

        l4.setBounds(20, 180, 100, 20);
        t4.setBounds(120, 180, 200, 20);
        add(l4);
        add(t4);


        // "Basic Salary"
        l5 = new JLabel("Basic Salary");
        t5 = new JTextField(15);

        l5.setBounds(20, 220, 100, 20);
        t5.setBounds(120, 220, 200, 20);
        add(l5);
        add(t5);

        // Buttons for updating and deleting salary information
        b1 = new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Delete");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b1.setBounds(40, 280, 100, 20);
        b2.setBounds(200, 280, 100, 20);
        add(b1);
        add(b2);

        // Add action listeners for buttons and item listener for choice
        b1.addActionListener(this);
        b2.addActionListener(this);
        c2.addItemListener(this);

        // Set background color, visibility, size, and location of the frame
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setSize(400, 450);
        setLocation(600, 200);
        // Set Frame to Open in the Center of the Screen at Runtime
        setLocationRelativeTo(null);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            // Get the values from the text fields
            String house_rent_allowance = t1.getText();
            String dearness_allowance = t2.getText();
            String medical_allowance = t3.getText();
            String provident_fund = t4.getText();
            String basic_salary = t5.getText();
            String id = c2.getSelectedItem(); // Get the selected ID

            // Construct the update query with placeholders
            String qry = "update salary set house_rent_allowance=?, dearness_allowance=?, " +
                    "medical_allowance=?, provident_fund=?, basic_salary=? where id=?";

            try {
                // Create a PreparedStatement
                DBConnection c1 = new DBConnection();
                PreparedStatement pstmt = c1.getConnection().prepareStatement(qry);

                // Set values for placeholders
                pstmt.setString(1, house_rent_allowance);
                pstmt.setString(2, dearness_allowance);
                pstmt.setString(3, medical_allowance);
                pstmt.setString(4, provident_fund);
                pstmt.setString(5, basic_salary);
                pstmt.setString(6, id); // Set the ID

                // Execute the update query
                pstmt.executeUpdate();

                // Show success message and hide the frame
                JOptionPane.showMessageDialog(null, "Salary Updated");
            } catch (SQLException e) {
                // Handle any SQL exceptions
                e.printStackTrace();
            }
        }

        if (ae.getSource() == b2) {
            try {
                // Create a PreparedStatement for deleting
                DBConnection c1 = new DBConnection();
                PreparedStatement pstmt = c1.getConnection().prepareStatement("delete from salary where id = ?");

                // Set the value for the placeholder
                pstmt.setString(1, c2.getSelectedItem());

                // Execute delete query
                pstmt.executeUpdate();

                // Show success message and hide the frame
                JOptionPane.showMessageDialog(null, "Salary Deleted");
                this.setVisible(false);
            } catch (SQLException ee) {
                // Handle any SQL exceptions
                ee.printStackTrace();
            }
        }
    }




    // Overriding the itemStateChanged method
    @Override
    public void itemStateChanged(ItemEvent ie) {
        try {
            DBConnection c1 = new DBConnection();
            ResultSet rs = c1.getStatement().executeQuery("select * from salary where id=" + c2.getSelectedItem());
            if (rs.next()) {
                t1.setText(rs.getString("house_rent_allowance"));
                t2.setText(rs.getString("dearness_allowance"));
                t3.setText(rs.getString("medical_allowance"));
                t4.setText(rs.getString("provident_fund"));
                t5.setText(rs.getString("basic_salary"));

            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create an instance of the UpdateSalary class to display the GUI
        new UpdateSalary();
    }
}

