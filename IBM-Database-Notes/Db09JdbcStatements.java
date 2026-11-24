// JDBC Statement examples: select, filter, sort, limit, group, join, nulls and error handling
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db09JdbcStatements {

    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            setUp(stmt);

            // SELECT everything
            System.out.println("All books:");
            ResultSet all = stmt.executeQuery("SELECT * FROM Books");
            while (all.next()) {
                System.out.println("  " + all.getInt("BookID") + " " + all.getString("Title")
                        + " by " + all.getString("Author") + " R" + all.getDouble("Price"));
            }

            // WHERE with a placeholder (safer than gluing the name into the SQL)
            System.out.println("By Author X:");
            PreparedStatement byAuthor = conn.prepareStatement("SELECT Title FROM Books WHERE Author = ?");
            byAuthor.setString(1, "Author X");
            ResultSet filtered = byAuthor.executeQuery();
            while (filtered.next()) {
                System.out.println("  " + filtered.getString("Title"));
            }

            // ORDER BY two columns, then LIMIT for a top list
            System.out.println("Top 3 most expensive:");
            ResultSet top = stmt.executeQuery(
                "SELECT Title, Price FROM Books WHERE Price IS NOT NULL ORDER BY Price DESC, Title ASC LIMIT 3");
            while (top.next()) {
                System.out.println("  " + top.getString("Title") + " R" + top.getDouble("Price"));
            }

            // GROUP BY with COUNT
            System.out.println("Books per author:");
            ResultSet counts = stmt.executeQuery("SELECT Author, COUNT(*) AS Total FROM Books GROUP BY Author");
            while (counts.next()) {
                System.out.println("  " + counts.getString("Author") + ": " + counts.getInt("Total"));
            }

            // INNER JOIN with Publishers
            System.out.println("Books and publishers:");
            ResultSet joined = stmt.executeQuery(
                "SELECT b.Title, p.Name FROM Books b INNER JOIN Publishers p ON b.PublisherID = p.PublisherID");
            while (joined.next()) {
                System.out.println("  " + joined.getString("Title") + " - " + joined.getString("Name"));
            }

            // IS NULL: books with no price yet
            System.out.println("Books missing a price:");
            ResultSet noPrice = stmt.executeQuery("SELECT Title, Price FROM Books WHERE Price IS NULL");
            while (noPrice.next()) {
                noPrice.getDouble("Price"); // gives 0.0 for NULL
                if (noPrice.wasNull()) {    // so check if it was really NULL
                    System.out.println("  " + noPrice.getString("Title") + " (no price)");
                }
            }

        } catch (SQLException e) {
            // Friendly message plus the codes that help you look the error up
            System.out.println("Database error: " + e.getMessage());
            System.out.println("SQL state: " + e.getSQLState() + ", error code: " + e.getErrorCode());
        }
    }

    // Builds the two practice tables with some rows
    static void setUp(Statement stmt) throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS Books");
        stmt.executeUpdate("DROP TABLE IF EXISTS Publishers");
        stmt.executeUpdate("CREATE TABLE Publishers (PublisherID INT PRIMARY KEY, Name VARCHAR(50))");
        stmt.executeUpdate("CREATE TABLE Books (BookID INT PRIMARY KEY, Title VARCHAR(100), "
                + "Author VARCHAR(50), Price DOUBLE, PublisherID INT)");
        stmt.executeUpdate("INSERT INTO Publishers VALUES (1, 'Penguin'), (2, 'Pearson')");
        stmt.executeUpdate("INSERT INTO Books VALUES "
                + "(1, 'Java Basics', 'Author X', 350, 1), "
                + "(2, 'Spring Deep Dive', 'Author X', 520, 2), "
                + "(3, 'SQL Made Simple', 'Author Y', 520, 1), "
                + "(4, 'Clean Code', 'Author Z', 450, 2), "
                + "(5, 'Draft Book', 'Author Y', NULL, 1)");
    }
}