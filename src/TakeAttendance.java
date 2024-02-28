import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TakeAttendance extends JFrame implements ActionListener {
    JLabel l1, l2;
    Choice c2, fh, sh;
    JButton b1, b2;

    public TakeAttendance() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        c2 = new Choice();
        try {
            DBConnection dbConnection = new DBConnection();
            ResultSet rs = dbConnection.getStatement().executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                // Format the ID to have 4 digits with leading zeros
                String formattedID = String.format("%04d", rs.getInt("id"));
                c2.add(formattedID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Failed to retrieve employee IDs");
        }
        addComponent(new JLabel("Select Emp No"), gbc, 0, 0, 1);
        addComponent(c2, gbc, 1, 0, 1);

        l1 = new JLabel("First Half");
        fh = new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
        addComponent(l1, gbc, 0, 1, 1);
        addComponent(fh, gbc, 1, 1, 1);

        l2 = new JLabel("Second Half");
        sh = new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
        addComponent(l2, gbc, 0, 2, 1);
        addComponent(sh, gbc, 1, 2, 1);

        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        addComponent(b1, gbc, 0, 3, 1);
        addComponent(b2, gbc, 1, 3, 1);

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        pack();
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComponent(Component component, GridBagConstraints gbc, int gridx, int gridy, int gridwidth) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = 1;
        add(component, gbc);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                String f = fh.getSelectedItem();
                String s = sh.getSelectedItem();
                String dt = new java.util.Date().toString();
                int id = Integer.parseInt(c2.getSelectedItem());
                String formattedID = String.format("%04d", id); // Format the ID to have 4 digits with leading zeros
                String qry = "INSERT INTO attendance (id, date_tm, f_half, s_half) VALUES (?, ?, ?, ?)";

                try (DBConnection dbConnection = new DBConnection();
                     PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(qry)) {

                    preparedStatement.setString(1, formattedID);
                    preparedStatement.setString(2, dt);
                    preparedStatement.setString(3, f);
                    preparedStatement.setString(4, s);
                    preparedStatement.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Attendance confirmed");
                this.setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Failed to insert attendance data");
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TakeAttendance();
    }
}