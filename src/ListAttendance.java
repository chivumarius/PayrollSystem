import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ListAttendance extends JFrame implements ActionListener, WindowListener {

    private JTable j1;
    private JButton b1;
    private String[] headers = {"Emp id", "Date Time", "First Half", "Second Half"};
    private DefaultTableModel tableModel;

    public ListAttendance() {
        super("View Employees Attendance");
        setSize(800, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(this);

        tableModel = new DefaultTableModel(headers, 0);
        j1 = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(j1);
        add(scrollPane, BorderLayout.CENTER);

        b1 = new JButton("Print");
        add(b1, BorderLayout.SOUTH);
        b1.addActionListener(this);

        populateTable();

        setVisible(true);
    }

    private void populateTable() {
        try {
            DBConnection dbConnection = new DBConnection();
            Statement statement = dbConnection.getStatement();

            PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement("SELECT * FROM attendance", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String dateTime = resultSet.getString("date_tm");
                String firstHalf = resultSet.getString("f_half");
                String secondHalf = resultSet.getString("s_half");
                tableModel.addRow(new String[]{id, dateTime, firstHalf, secondHalf});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Failed to retrieve attendance data");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            j1.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        dispose(); // Inchide fereastra
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListAttendance());
    }
}