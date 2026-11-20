// Preview of plain JDBC: connect, insert a row and read it back
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db01CourseIntro {

    // H2 in-memory database for practice, swap for MySQL later
    private static final String URL = "jdbc:h2:mem:bank";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, "sa", "")) {

            // Create a simple table
            conn.createStatement().execute(
                "CREATE TABLE client (id INT PRIMARY KEY, name VARCHAR(50))");

            // Create: insert one client using placeholders
            PreparedStatement insert = conn.prepareStatement(
                "INSERT INTO client (id, name) VALUES (?, ?)");
            insert.setInt(1, 1);
            insert.setString(2, "Anita");
            insert.executeUpdate();

            // Read: fetch all clients
            ResultSet rows = conn.prepareStatement("SELECT id, name FROM client").executeQuery();
            while (rows.next()) {
                System.out.println(rows.getInt("id") + " - " + rows.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}