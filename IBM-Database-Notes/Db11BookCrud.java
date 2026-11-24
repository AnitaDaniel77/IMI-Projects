// Full CRUD on the Books table with JDBC: create, read, paginate, update and delete
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db11BookCrud {

    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            createWithStatement(conn);
            createWithPrepared(conn, "Advanced Java", "Author X", 499.99, "Programming", Date.valueOf("2024-03-01"), 1);
            createWithProcedure(conn, "Spring Boot in Practice", "Author Y", 560.00, "Programming", Date.valueOf("2025-01-15"), 2);

            readAll(conn);
            readByGenre(conn, "Programming");
            readPage(conn, 1, 2); // page 1, 2 books per page
            readPage(conn, 2, 2); // page 2

            updatePrice(conn, "Advanced Java", 399.99);
            deleteByGenre(conn, "Fiction");

            readAll(conn);

        } catch (SQLException e) {
            System.out.println("Could not connect: " + e.getMessage());
        }
    }

    // CREATE with a plain Statement: fixed values only, never use with user input
    static void createWithStatement(Connection conn) {
        String sql = "INSERT INTO Books (Title, Author, Price, Genre, PublicationDate, PublisherID) "
                + "VALUES ('Old Novel', 'Author Z', 150.00, 'Fiction', '2010-06-01', 1)";
        try (Statement stmt = conn.createStatement()) {
            System.out.println("Statement insert: " + stmt.executeUpdate(sql) + " row");
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // CREATE with a PreparedStatement: safe and reusable
    static void createWithPrepared(Connection conn, String title, String author, double price,
                                   String genre, Date published, int publisherId) {
        if (title == null || title.isBlank() || price < 0) {
            System.out.println("Not saved: title is required and price can't be negative");
            return; // validate before touching the database
        }
        String sql = "INSERT INTO Books (Title, Author, Price, Genre, PublicationDate, PublisherID) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.setString(4, genre);
            ps.setDate(5, published);
            ps.setInt(6, publisherId);
            System.out.println("Prepared insert: " + ps.executeUpdate() + " row");
        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // CREATE through the AddBook stored procedure
    static void createWithProcedure(Connection conn, String title, String author, double price,
                                    String genre, Date published, int publisherId) {
        try (CallableStatement cs = conn.prepareCall("{CALL AddBook(?, ?, ?, ?, ?, ?)}")) {
            cs.setString(1, title);
            cs.setString(2, author);
            cs.setDouble(3, price);
            cs.setString(4, genre);
            cs.setDate(5, published);
            cs.setInt(6, publisherId);
            System.out.println("Procedure insert: " + cs.executeUpdate() + " row");
        } catch (SQLException e) {
            System.out.println("Procedure insert failed: " + e.getMessage());
        }
    }

    // READ everything (fixed query, so Statement is fine here)
    static void readAll(Connection conn) {
        System.out.println("All books:");
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT BookID, Title, Author, Price FROM Books")) {
            while (rs.next()) {
                System.out.println("  " + rs.getInt("BookID") + " | " + rs.getString("Title")
                        + " | " + rs.getString("Author") + " | R" + rs.getDouble("Price"));
            }
        } catch (SQLException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }

    // READ one genre
    static void readByGenre(Connection conn, String genre) {
        System.out.println(genre + " books:");
        try (PreparedStatement ps = conn.prepareStatement("SELECT Title, Price FROM Books WHERE Genre = ?")) {
            ps.setString(1, genre);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println("  " + rs.getString("Title") + " R" + rs.getDouble("Price"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }

    // READ one page at a time, most expensive first
    static void readPage(Connection conn, int page, int pageSize) {
        int offset = (page - 1) * pageSize; // how many rows to skip
        System.out.println("Page " + page + ":");
        String sql = "SELECT Title, Price FROM Books ORDER BY Price DESC LIMIT ? OFFSET ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println("  " + rs.getString("Title") + " R" + rs.getDouble("Price"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Page read failed: " + e.getMessage());
        }
    }

    // UPDATE a price by title
    static void updatePrice(Connection conn, String title, double newPrice) {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE Books SET Price = ? WHERE Title = ?")) {
            ps.setDouble(1, newPrice);
            ps.setString(2, title);
            int rows = ps.executeUpdate();
            System.out.println(rows == 0 ? "No book called " + title : "Updated " + rows + " row");
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    // DELETE every book in a genre
    static void deleteByGenre(Connection conn, String genre) {
        try (PreparedStatement ps = conn.prepareStatement("DELETE FROM Books WHERE Genre = ?")) {
            ps.setString(1, genre);
            System.out.println("Deleted " + ps.executeUpdate() + " " + genre + " book(s)");
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}