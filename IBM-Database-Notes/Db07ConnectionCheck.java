// Connects to a database and prints what it is, like the info panel in DBeaver or Workbench
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db07ConnectionCheck {

    public static void main(String[] args) {
        // Change these to match your database
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String user = "root";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData info = conn.getMetaData(); // facts about the database

            System.out.println("Connected to: " + info.getDatabaseProductName());
            System.out.println("Version: " + info.getDatabaseProductVersion());
            System.out.println("Driver: " + info.getDriverName());

            // List the tables, like the sidebar in a GUI tool
            System.out.println("Tables:");
            ResultSet tables = info.getTables(conn.getCatalog(), null, "%", new String[] {"TABLE"});
            while (tables.next()) {
                System.out.println("  - " + tables.getString("TABLE_NAME"));
            }

        } catch (SQLException e) {
            System.out.println("Could not connect: " + e.getMessage());
        }
    }
}