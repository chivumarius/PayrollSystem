import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainScreen extends JFrame implements ActionListener {

    public MainScreen() {
        setSize(2000, 1100);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/payroll.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu m1 = new JMenu("Master");
        m1.setForeground(Color.BLACK);

        JMenuItem t1 = new JMenuItem("New Employee");
        JMenuItem t3 = new JMenuItem("Salary");
        JMenuItem t4 = new JMenuItem("List Employee");

        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("monospaced", Font.PLAIN, 12));
        t1.setMnemonic('N');
        t1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));

        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("monospaced", Font.PLAIN, 12));
        t3.setMnemonic('S');
        t3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/schedreport.png")));
        t3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

        t4.setForeground(Color.BLACK);
        t4.setFont(new Font("monospaced", Font.PLAIN, 12));
        t4.setMnemonic('L');
        t4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/newinvoice.png")));
        t4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));

        m1.add(t1);
        m1.add(t3);
        m1.add(t4);
        mb.add(m1);

        t1.addActionListener(this);
        t3.addActionListener(this);
        t4.addActionListener(this);

        JMenu edit = new JMenu("Update");
        edit.setForeground(Color.BLACK);
        mb.add(edit);

        JMenuItem s1 = new JMenuItem("Update Salary");
        JMenuItem s2 = new JMenuItem("Update Employee");
        JMenuItem s3 = new JMenuItem("Take Attendance");

        s1.setForeground(Color.BLACK);
        s1.setFont(new Font("monospaced", Font.PLAIN, 12));
        s1.setMnemonic('U');
        s1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EditOpen.png")));
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));

        s2.setForeground(Color.BLACK);
        s2.setFont(new Font("monospaced", Font.PLAIN, 12));
        s2.setMnemonic('p');
        s2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        s2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));

        s3.setForeground(Color.BLACK);
        s3.setFont(new Font("monospaced", Font.PLAIN, 12));
        s3.setMnemonic('T');
        s3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/EXPENSE.PNG")));
        s3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));

        edit.add(s1);
        edit.add(s2);
        edit.add(s3);

        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);

        JMenu rep = new JMenu("Reports");
        rep.setForeground(Color.BLACK);
        mb.add(rep);

        JMenuItem p1 = new JMenuItem("Generate PaySlip");
        JMenuItem p2 = new JMenuItem("List Attendance");

        p1.setForeground(Color.BLACK);
        p1.setFont(new Font("monospaced", Font.PLAIN, 12));
        p1.setMnemonic('P');
        p1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));
        p1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));

        p2.setForeground(Color.BLACK);
        p2.setFont(new Font("monospaced", Font.PLAIN, 12));
        p2.setMnemonic('L');
        p2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/empreport.png")));
        p2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));

        rep.add(p1);
        rep.add(p2);

        p1.addActionListener(this);
        p2.addActionListener(this);

        JMenu util = new JMenu("Utilities");
        util.setForeground(Color.BLACK);
        mb.add(util);

        JMenuItem u1 = new JMenuItem("Notepad");
        JMenuItem u2 = new JMenuItem("Calculator");
        JMenuItem u3 = new JMenuItem("Web Browser");

        u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));
        u1.setForeground(Color.BLACK);
        u1.setFont(new Font("monospaced", Font.PLAIN, 12));
        u1.setMnemonic('O');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

        u2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")));
        u2.setForeground(Color.BLACK);
        u2.setFont(new Font("monospaced", Font.PLAIN, 12));
        u2.setMnemonic('C');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));




        u3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/explorer.jpg")));
        u3.setForeground(Color.BLACK);
        u3.setFont(new Font("monospaced", Font.PLAIN, 12));
        u3.setMnemonic('E');
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

        util.add(u1);
        util.add(u2);
        util.add(u3);

        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);

        JMenu m8 = new JMenu("Exit");
        m8.setForeground(Color.BLACK);
        mb.add(m8);

        JMenuItem m8i1 = new JMenuItem("Exit");
        m8.add(m8i1);
        m8i1.setForeground(Color.BLACK);
        m8i1.setFont(new Font("monospaced", Font.PLAIN, 14));
        m8i1.setMnemonic('X');
        m8i1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        m8i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        m8i1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        switch (msg) {
            case "New Employee":
                new NewEmployee().setVisible(true);
                break;
            case "List Employee":
                new ListEmployee().setVisible(true);
                break;
            case "Update Employee":
                new UpdateEmployee().setVisible(true);
                break;
            case "Salary":
                new Salary().setVisible(true);
                break;
            case "Update Salary":
                new UpdateSalary().setVisible(true);
                break;
            case "Notepad":
                try {
                    ProcessBuilder pb = new ProcessBuilder("notepad.exe");
                    pb.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Calculator":
                try {
                    ProcessBuilder pb = new ProcessBuilder("calc.exe");
                    pb.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Web Browser":
                try {
                    ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
                    pb.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Take Attendance":
                new TakeAttendance().setVisible(true);
                break;
            case "Exit":
                this.dispose(); // Close the current frame
                break;
            case "Generate PaySlip":
                new PaymentSlip().setVisible(true);
                break;
            case "List Attendance":
                new ListAttendance().setVisible(true);
                break;
        }
    }

    public static void main(String[] args) {
        new MainScreen().setVisible(true);
    }
}