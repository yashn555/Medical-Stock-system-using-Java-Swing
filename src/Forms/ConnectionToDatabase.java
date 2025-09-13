package Forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionToDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost/medical";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 
    
    // Method to establish database connection
    public static Connection connectToDb() {
        Connection conn = null;
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
