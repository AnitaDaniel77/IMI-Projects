// Running the bookstore SQL from Java with JDBC (needs a MySQL database and driver)
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db05BookstoreJdbc {

    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // DML: insert a book with placeholders
            PreparedStatement insert = conn.prepareStatement(
                "INSERT INTO Books (book_id, title, author, price) VALUES (?, ?, ?, ?)");
            insert.setInt(1, 3);
            insert.setString(2, "Spring in Action");
            insert.setString(3, "Craig Walls");
            insert.setBigDecimal(4, new java.math.BigDecimal("610.00"));
            insert.executeUpdate();

            // DML: update a price
            PreparedStatement update = conn.prepareStatement(
                "UPDATE Books SET price = ? WHERE book_id = ?");
            update.setBigDecimal(1, new java.math.BigDecimal("580.00"));
            update.setInt(2, 3);
            update.executeUpdate();

            // DQL: read every book
            ResultSet books = conn.prepareStatement("SELECT book_id, title, price FROM Books").executeQuery();
            while (books.next()) {
                System.out.println(books.getInt("book_id") + " | " + books.getString("title") + " | R" + books.getBigDecimal("price"));
            }

            // Procedure: call total_book_value()
            CallableStatement call = conn.prepareCall("{CALL total_book_value()}");
            ResultSet total = call.executeQuery();
            if (total.next()) {
                System.out.println("Total value: R" + total.getBigDecimal("total_value"));
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
