import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.MessageFormat;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;

public class StudentsRecord extends JFrame implements ActionListener {
    // Database credentials
    private static final String BASE_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "students_record";
    private static final String DB_URL = BASE_URL + DB_NAME;
    private static final String DB_USER = "adx";
    private static final String DB_PASSWORD = "adx";

    private Connection con;

    // Swing components
    private JTextField regn_no, name, email, phone, search_by_regn_no;
    private JButton create, printb, update, delete, search, reset, exit;
    private JTable tab_data = new JTable();
    private JScrollPane table_Panel;

    // Constructor
    public StudentsRecord() {
        super("Student Records Dashboard");
        connectToDatabase();
        initializeGUI();
        loadTable("SELECT * FROM student_info");
    }

    private void loadTable(String query) {
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            tab_data.setModel(DbUtils.resultSetToTableModel(rs));
            table_Panel.setViewportView(tab_data);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Error loading data: " + e.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                DB_URL, 
                DB_USER, 
                DB_PASSWORD
            );
            System.out.println("Connection Successful!");
        } 
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, 
                "MySQL JDBC Driver not found: " + e.getMessage(), 
                "Driver Error", JOptionPane.ERROR_MESSAGE);
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Database con failed: " + e.getMessage(), 
                "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initializeGUI() {
        // Set frame properties
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels and text fields
        JLabel regn_no_label = new JLabel("Registration Number:");
        regn_no_label.setBounds(50, 50, 150, 35);
        add(regn_no_label);

        regn_no = new JTextField();
        regn_no.setBounds(200, 50, 300, 35);
        add(regn_no);

        JLabel name_label = new JLabel("Full Name:");
        name_label.setBounds(50, 100, 150, 35);
        add(name_label);

        name = new JTextField();
        name.setBounds(200, 100, 300, 35);
        add(name);

        JLabel email_label = new JLabel("Email:");
        email_label.setBounds(50, 150, 150, 35);
        add(email_label);

        email = new JTextField();
        email.setBounds(200, 150, 300, 35);
        add(email);

        JLabel phone_label = new JLabel("Phone Number:");
        phone_label.setBounds(50, 200, 150, 35);
        add(phone_label);

        phone = new JTextField();
        phone.setBounds(200, 200, 300, 35);
        add(phone);

        JLabel search_label = new JLabel("Search by Registration Number:");
        search_label.setBounds(50, 300, 250, 35);
        add(search_label);

        search_by_regn_no = new JTextField();
        search_by_regn_no.setBounds(250, 300, 250, 35);
        add(search_by_regn_no);

        // Create and position buttons
        create = new JButton("Add New");
        create.setBounds(550, 50, 100, 35);
        create.addActionListener(this);
        add(create);

        search = new JButton("Search");
        search.setBounds(550, 300, 100, 35);
        search.addActionListener(this);
        add(search);

        update = new JButton("Update");
        update.setBounds(550, 100, 100, 35);
        update.addActionListener(this);
        add(update);

        delete = new JButton("Delete");
        delete.setBounds(550, 150, 100, 35);
        delete.addActionListener(this);
        add(delete);

        reset = new JButton("Reset");
        reset.setBounds(550, 200, 100, 35);
        reset.addActionListener(this);
        add(reset);

        printb = new JButton("Print");
        printb.setBounds(550, 250, 100, 35);
        printb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hmsg = "Printing in Progress";
                String fmsg = "Page-{0, number, integer}";
                MessageFormat headr = new MessageFormat(hmsg);
                MessageFormat footr = new MessageFormat(fmsg);
                try {
                    tab_data.print(JTable.PrintMode.NORMAL, headr, footr);
                }
                catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(printb);

        exit = new JButton("Exit");
        exit.setBounds(670, 300, 80, 35);
        exit.addActionListener(this);
        add(exit);

        // Initialize and set bounds for table and scroll pane
        table_Panel = new JScrollPane(tab_data);
        table_Panel.setBounds(50, 380, 700, 200);
        tab_data.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel rec;
                rec = (DefaultTableModel) tab_data.getModel();
                int selectedRow = tab_data.getSelectedRow();
                String s_regn, s_name, s_email, s_phone;
                s_regn = rec.getValueAt(selectedRow,0).toString();
                s_name = rec.getValueAt(selectedRow,1).toString();
                s_email = rec.getValueAt(selectedRow,2).toString();
                s_phone = rec.getValueAt(selectedRow,3).toString();
                regn_no.setText(s_regn);
                name.setText(s_name);
                email.setText(s_email);
                phone.setText(s_phone);
            }
        });
        add(table_Panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } 
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }
        else if (e.getSource() == create) {
            addStudent();
        }
        else if (e.getSource() == update) {
            updateStudent();
        }
        else if (e.getSource() == delete) {
            deleteStudent();
        }
        else if (e.getSource() == reset) {
            resetFields();
        }
        else if(e.getSource() == search) {
            searchStudent();
        }
    }

    private void resetFields() {
        regn_no.setText("");
        name.setText("");
        email.setText("");
        phone.setText("");
        search_by_regn_no.setText("");
        loadTable("SELECT * FROM student_info");
    }

    private void addStudent() {
        try {
            String insertQuery = 
            "INSERT INTO student_info (regn_no, name, email, phone) VALUES (?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);
            pstmt.setString(1, regn_no.getText());
            pstmt.setString(2, name.getText());
            pstmt.setString(3, email.getText());
            pstmt.setString(4, phone.getText());

            int rowsAffected = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, 
                rowsAffected + " student record added successfully!");
                
            loadTable("SELECT * FROM student_info");
            resetFields();
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error adding student: " + ex.getMessage(), 
                "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateStudent() {
        try {
            String updateQuery = 
            "UPDATE student_info SET name = ?, email = ?, phone = ? WHERE regn_no = ?";
            PreparedStatement pstmt = con.prepareStatement(updateQuery);
            pstmt.setString(1, name.getText());
            pstmt.setString(2, email.getText());
            pstmt.setString(3, phone.getText());
            pstmt.setString(4, regn_no.getText());

            int rowsAffected = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, 
                rowsAffected + " student record updated successfully!");

            loadTable("SELECT * FROM student_info");
            resetFields();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error updating student: " + ex.getMessage(), 
                "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteStudent() {
        try {
            String deleteQuery = "DELETE FROM student_info WHERE regn_no = ?";
            PreparedStatement pstmt = con.prepareStatement(deleteQuery);
            pstmt.setString(1, regn_no.getText());

            int rowsAffected = pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, 
                rowsAffected + " student record deleted successfully!");

            loadTable("SELECT * FROM student_info");
            resetFields();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error deleting student: " + ex.getMessage(), 
                "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchStudent() {
        try {
            String searchQuery = "SELECT * FROM student_info WHERE regn_no = ?";
            PreparedStatement pstmt = con.prepareStatement(searchQuery);
            pstmt.setString(1, search_by_regn_no.getText());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String stud_regn = rs.getString("regn_no");
                loadTable("SELECT * FROM student_info WHERE regn_no = " + stud_regn);
                regn_no.setText(stud_regn);
                name.setText(rs.getString("name"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
                JOptionPane.showMessageDialog(this, "Record found!");
            }
            else {
                JOptionPane.showMessageDialog(this, 
                    "No record found with the given Registration Number.");
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error searching student: " + ex.getMessage(), 
                "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentsRecord());
    }
}
