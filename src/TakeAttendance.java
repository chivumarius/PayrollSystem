import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Class for taking attendance
public class TakeAttendence extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7; // Labels for displaying instructions
    JTextField t1,t2,t3,t4,t5,t6,t7; // Text fields for user input
    JButton b1,b2; // Buttons for submitting or canceling attendance
    Choice c2,fh,sh; // Choice dropdowns for selecting attendance status

    // Constructor to set up the attendance taking interface
    TakeAttendence(){
        // Set layout for the frame
        setLayout(new GridLayout(4,2,50,50));

        // Create choice dropdown for selecting employee ID
        c2 = new Choice();
        try{
            // Retrieve employee IDs from the database and add them to the dropdown
            DBConnection c = new DBConnection();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                c2.add(rs.getString("id"));
            }
        } catch(Exception e) {
            throw new RuntimeException(e); // Handle exceptions
        }
        // Add label and choice dropdown for selecting employee ID
        add(new JLabel("Select Emp No"));
        add(c2);

        // Add labels and choice dropdowns for selecting attendance status (first and second half)
        l1 = new JLabel("First Half");
        fh = new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
        add(l1);
        add(fh);

        l2 = new JLabel("Second Half");
        sh = new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
        add(l2);
        add(sh);

        // Create buttons for submitting or canceling attendance
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        // Add buttons to the frame
        add(b1);
        add(b2);

        // Add action listeners to the buttons
        b1.addActionListener(this);
        b2.addActionListener(this);

        // Set background color of the frame
        getContentPane().setBackground(Color.WHITE);
        // Set frame visibility, size, and location
        setVisible(true);
        setSize(400,450);
        setLocation(600,200);
    }

    // Method to handle button click events
    public void actionPerformed(ActionEvent ae){
        // Get selected attendance status for first and second half
        String f = fh.getSelectedItem();
        String s = sh.getSelectedItem();
        // Get current date and time
        String dt = new java.util.Date().toString();
        // Get selected employee ID
        String id=c2.getSelectedItem();
        // Create SQL query to insert attendance record into the database
        String qry = "insert into attendence values("+ id +",'"+dt+"','"+f+"','"+s+"')";
        try{
            // Execute SQL query to insert attendance record
            DBConnection c1 = new DBConnection();
            c1.s.executeUpdate(qry);
            // Show confirmation message
            JOptionPane.showMessageDialog(null,"Attendance confirmed");
            // Close the attendance taking interface
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace(); // Handle exceptions
        }
    }

    // Main method to create and display the attendance taking interface
    public static void main(String[] s){
        new TakeAttendence();
    }
}