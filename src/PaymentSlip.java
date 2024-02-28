import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class PaymentSlip extends JFrame implements ActionListener {

    private Choice c1;
    private JTextArea t1;
    private JButton b1;

    public PaymentSlip() {
        // Set frame size and location
        setSize(800, 550);
        setLocationRelativeTo(null); // Set frame to open in the center of the screen

        // Initialize components
        c1 = new Choice();
        try {
            DBConnection dbConnection = new DBConnection();
            ResultSet rs = dbConnection.getStatement().executeQuery("SELECT * FROM salary");
            while (rs.next()) {
                c1.add(rs.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Failed to retrieve employee IDs");
        }

        setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.add(new JLabel("Select Id"));
        p1.add(c1);
        add(p1, BorderLayout.NORTH);

        t1 = new JTextArea(30, 80);
        JScrollPane jsp = new JScrollPane(t1);

        Font f1 = new Font("arial", Font.BOLD, 20);
        t1.setFont(f1);

        b1 = new JButton("Generate Pay Slip");
        add(b1, BorderLayout.SOUTH);
        add(jsp, BorderLayout.CENTER);

        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            DBConnection dbConnection = new DBConnection();

            ResultSet rs = dbConnection.getStatement().executeQuery("SELECT * FROM employee WHERE id=" + c1.getSelectedItem());
            rs.next();
            String name = rs.getString("name");
            rs.close();

            rs = dbConnection.getStatement().executeQuery("SELECT * FROM salary WHERE id=" + c1.getSelectedItem());

            // Get current month using Calendar class
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH);

            // Set text for payment slip
            t1.setText(" ----------------   PAYMENT SLIP FOR THE MONTH OF " + month + " ,2019  ------------------------");
            t1.append("\n");

            if (rs.next()) {
                double houseRentAllowance = Double.parseDouble(rs.getString("house_rent_allowance"));
                double dearnessAllowance = Double.parseDouble(rs.getString("dearness_allowance"));
                double medicalAllowance = Double.parseDouble(rs.getString("medical_allowance"));
                double providentFund = Double.parseDouble(rs.getString("provident_fund"));
                double basicSalary = Double.parseDouble(rs.getString("basic_salary"));
                double gross = houseRentAllowance + dearnessAllowance + medicalAllowance + providentFund + basicSalary;
                double net = gross - providentFund;

                t1.append("\n     Employee ID:                      " + rs.getString("id"));
                t1.append("\n     Employee Name:                " + name);
                t1.append("\n----------------------------------------------------------------");
                t1.append("\n         House Rent Allowance:  " + String.format("%.2f", houseRentAllowance));
                t1.append("\n         Dearness Allowance:      " + String.format("%.2f", dearnessAllowance));
                t1.append("\n         Medical Allowance:         " + String.format("%.2f", medicalAllowance));
                t1.append("\n         Provident Fund:              " + String.format("%.2f", providentFund));
                t1.append("\n         Basic Salary:                   " + String.format("%.2f", basicSalary));
                t1.append("\n-----------------------------------------------------------------");
                t1.append("\n     Gross Salary:                      " + String.format("%.2f", gross));
                t1.append("\n     Net Salary:                           " + String.format("%.2f", net));
                t1.append("\n     Tax 2.1% of gross:               " + String.format("%.2f", (gross * 2.1 / 100)));
                t1.append("\n -----------------------------------------------------------------");
                t1.append("\n\n\n   (  Signature  )      ");
            }
        } catch (SQLException | NumberFormatException ee) {
            ee.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PaymentSlip paymentSlip = new PaymentSlip();
            paymentSlip.setVisible(true);
            paymentSlip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}