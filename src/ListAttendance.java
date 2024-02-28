import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

// Class for listing attendance records
public class ListAttendence extends JFrame implements ActionListener{

    JTable j1; // Table for displaying attendance records
    JButton b1; // Button for printing attendance records
    String[] h = {"Emp id","Date Time","First Half","Second Half"}; // Headers for the table
    String[][] d = new String[15][4]; // Data for the table
    int i=0,j=0; // Counters for navigating through data array

    // Constructor to set up the interface for viewing attendance records
    ListAttendence(){
        super("View Employees Attendance");
        setSize(800,300); // Set size of the frame
        setLocation(450,150); // Set location of the frame

        try{
            // Query the database to retrieve attendance records
            String q="select * from attendance";
            DBConnection c1=new DBConnection(); // Create a database connection
            ResultSet rs=c1.s.executeQuery(q); // Execute the query
            // Populate the data array with attendance records
            while(rs.next()){
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("date_tm");
                d[i][j++]=rs.getString("f_half");
                d[i][j++]=rs.getString("s_half");
                i++; // Increment row counter
                j=0; // Reset column counter
            }

            j1=new JTable(d,h); // Create the table with data and headers

        } catch(Exception e) {
            throw new RuntimeException(e); // Handle exceptions
        }

        // Create button for printing attendance records
        b1=new JButton("Print");
        // Add button to the bottom of the frame
        add(b1,"South");
        // Add a scroll pane for the table
        JScrollPane s1=new JScrollPane(j1);
        // Add the scroll pane to the frame
        add(s1);

        // Add action listener to the print button
        b1.addActionListener(this);

    }

    // Method to handle button click events
    public void actionPerformed(ActionEvent ae){
        try{
            // Print the table
            j1.print();
        } catch(Exception e) {
            throw new RuntimeException(e); // Handle exceptions
        }
    }

    // Main method to create and display the attendance listing interface
    public static void main(String[] args){
        new ListAttendence().setVisible(true);
    }
}