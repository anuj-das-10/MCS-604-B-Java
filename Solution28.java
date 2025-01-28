import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Solution28 extends JFrame {

    public Solution28() {
        setTitle("Pragati ka - Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        String[] header = {"Registration No", "Name", "Email", "Phone"};
        Object[][] data = {
            {"S101", "Anuj Das", "anuj@example.com", "9123456789"},
            {"S102", "Pragati", "deypragati@gmail.com", "9876543210"},
            {"S103", "Charlie Brown", "charl@example.com", "9988776655"},
            {"S104", "David White", "david@example.com", "9871234560"},
            {"S105", "Ella Green", "ella@example.com", "9234567890"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, header);
        JTable studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Use SwingUtilities to create and show the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(() -> {
            Solution28 frame = new Solution28();
            frame.setVisible(true);
        });
    }
}
