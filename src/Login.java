import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    private JTextField t1;
    private JPasswordField t2;
    private JButton b1, b2;

    public Login() {
        super("Login");

        // Set the dimensions of the login panel
        setSize(600, 250);

        setLayout(null); // Set the layout to null for absolute positioning of components

        // JLabel for the image on the left
        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/defaultpic.png")));
        l.setBounds(20, 20, 150, 150); // Set the position and dimensions of the image
        add(l);

        // JLabel for "Username"
        JLabel l1 = new JLabel("Username");
        l1.setBounds(200, 50, 100, 30); // Set the position and dimensions of the label for "Username"
        add(l1);

        // JTextField for username
        t1 = new JTextField(10);
        t1.setBounds(300, 50, 150, 30); // Set the position and dimensions of the textfield for username
        add(t1);

        // JLabel for "Password"
        JLabel l2 = new JLabel("Password");
        l2.setBounds(200, 100, 100, 30); // Set the position and dimensions of the label for "Password"
        add(l2);

        // JPasswordField for password
        t2 = new JPasswordField(10);
        t2.setBounds(300, 100, 150, 30); // Set the position and dimensions of the textfield for password
        add(t2);

        // JButton for Submit
        b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon/login.png")));
        b1.setBounds(200, 160, 100, 30); // Set the position and dimensions of the Submit button
        b1.addActionListener(this);
        add(b1);

        // JButton for Cancel
        b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon/Cancel.png")));
        b2.setBounds(350, 160, 100, 30); // Set the position and dimensions of the Cancel button
        b2.addActionListener(this);
        add(b2);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                // Establish database connection
                DBConnection c1 = new DBConnection();
                String u = t1.getText();
                char[] passwordChars = t2.getPassword();
                String v = new String(passwordChars);
                String q = "select * from login where username='" + u + "' and password='" + v + "'";
                ResultSet rs = c1.getStatement().executeQuery(q);
                if (rs.next()) {
                    new MainScreen().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}