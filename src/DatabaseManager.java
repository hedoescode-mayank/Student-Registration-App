import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// Stage 2: The Controller/Service
// Yeh class saara database ka kaam karegi.
public class DatabaseManager {

    // Database file ka naam. Yeh project ke root folder mein banegi.
    private static final String DB_URL = "jdbc:sqlite:students.db";

    private Connection conn = null;

    // Constructor: Jab bhi DatabaseManager banega, yeh connection try karega.
    public DatabaseManager() {
        try {
            // Establish connection
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Database connection established.");

            // Connection banne ke baad, table create karo (agar pehle se nahi hai)
            createStudentsTable();

        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    // Method to create the 'students' table
    private void createStudentsTable() {
        // SQL query to create a table
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT NOT NULL,"
                + " student_id TEXT NOT NULL UNIQUE," // UNIQUE taaki duplicate ID na ho
                + " email TEXT,"
                + " phone TEXT"
                + ");";

        try (Statement stmt = conn.createStatement()) {
            // Execute the query
            stmt.execute(sql);
            System.out.println("Table 'students' is ready.");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    // Method to add a new student to the database
    public boolean addStudent(Student student) {
        // SQL query to insert data. '?' placeholders hain.
        String sql = "INSERT INTO students(name, student_id, email, phone) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // '?' placeholders ki values set karna
            pstmt.setString(1, student.getFullName());
            pstmt.setString(2, student.getStudentId());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getPhone());

            // Execute the query
            pstmt.executeUpdate();
            System.out.println("New student added successfully.");
            return true; // Success

        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
            // Check for duplicate student ID
            if (e.getMessage().contains("UNIQUE constraint failed: students.student_id")) {
                return false; // Return false for duplicate ID
            }
            return false; // Return false for other errors
        }
    }
}

