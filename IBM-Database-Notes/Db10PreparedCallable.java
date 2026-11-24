// PreparedStatement for safe inserts, updates and selects; CallableStatement for stored procedures
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Db10PreparedCallable {

    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            int newId = insertBook(conn, "New Book", "Author X", 25.99);
            updatePrice(conn, newId, 30.99);
            findByAuthor(conn, "Author X");
            callGetBooksByAuthor(conn, "Author X");
            callAveragePrice(conn, "Author X");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // INSERT with placeholders and get back the new primary key
    static int insertBook(Connection conn, String title, String author, double price) throws SQLException {
        String sql = "INSERT INTO Books (Title, Author, Price) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            int rows = ps.executeUpdate(); // number of rows added
            System.out.println("Inserted " + rows + " row");

            ResultSet keys = ps.getGeneratedKeys(); // the id MySQL just created
            if (keys.next()) {
                int id = keys.getInt(1);
                System.out.println("New book id: " + id);
                return id;
            }
            return -1;
        }
    }

    // UPDATE one book's price
    static void updatePrice(Connection conn, int bookId, double newPrice) throws SQLException {
        String sql = "UPDATE Books SET Price = ? WHERE BookID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, bookId);
            System.out.println("Updated " + ps.executeUpdate() + " row");
        }
    }

    // SELECT with a parameter, safe even if the input is nasty
    static void findByAuthor(Connection conn, String author) throws SQLException {
        String sql = "SELECT BookID, Title, Price FROM Books WHERE Author = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, author);
            ResultSet rs = ps.executeQuery();
            System.out.println("Books by " + author + ":");
            while (rs.next()) {
                System.out.println("  " + rs.getInt("BookID") + " " + rs.getString("Title") + " R" + rs.getDouble("Price"));
            }
        }
    }

    // Stored procedure with one IN parameter that returns rows
    static void callGetBooksByAuthor(Connection conn, String author) throws SQLException {
        try (CallableStatement cs = conn.prepareCall("{CALL GetBooksByAuthor(?)}")) {
            cs.setString(1, author);
            ResultSet rs = cs.executeQuery();
            System.out.println("Procedure result for " + author + ":");
            while (rs.next()) {
                System.out.println("  " + rs.getString("Title"));
            }
        }
    }

    // Stored procedure with an IN and an OUT parameter
    static void callAveragePrice(Connection conn, String author) throws SQLException {
        try (CallableStatement cs = conn.prepareCall("{CALL GetAveragePrice(?, ?)}")) {
            cs.setString(1, author);                     // IN: who to check
            cs.registerOutParameter(2, Types.DOUBLE);    // OUT: tell JDBC what type comes back
            cs.execute();
            System.out.println("Average price for " + author + ": R" + cs.getDouble(2));
        }
    }
}