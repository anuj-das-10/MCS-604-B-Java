import java.sql.*;

class JDBC_CLI {
    private Connection con;
    // Database Credentials
    private static final String BASE = "jdbc:mysql://localhost:3306/";
    private static final String DB = "students_record";
    private static final String DB_URL = BASE + DB;
    private static final String DB_USER = "adx";
    private static final String DB_PASS = "adx";

    JDBC_CLI() {
        connect();
    }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Successfully connected to database!");
            viewStudents();
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
        }
        catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    private void printTable(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        System.out.println("RETRIEVED INFORMATION FROM TABLE:: " + metaData.getTableName(1) + "\n");

        // Print the header row
        for (int i = 1; i <= columnCount; i++) {
            if(i == 1) {
                System.out.printf("%-10s", metaData.getColumnName(i));
            }
            else {
                System.out.printf("%-30s", metaData.getColumnName(i));
            }
        }
        System.out.println();
        System.out.println("=".repeat(columnCount * 20));

        // Print the data rows
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                if(i == 1) {
                    System.out.printf("%-10s", rs.getString(i));
                }
                else {
                    System.out.printf("%-30s", rs.getString(i));
                }
            }
            System.out.println();
        }
    }

    private void viewStudents() {
        try {
            String query = "SELECT * FROM student_info";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            printTable(rs);
        }
        catch (SQLException e) {
            System.out.println("Unable to retrieve details: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        JDBC_CLI admin = new JDBC_CLI();
    }
}
