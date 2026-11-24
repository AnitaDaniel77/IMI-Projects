// Connecting to MySQL two ways: one-off with DriverManager, and reused through a DBCP pool
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Db08JdbcAndPool {

    private static final String URL = "jdbc:mysql://localhost:3306/shop";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        connectOnce();
        connectWithPool();
    }

    // Opens a brand new connection, uses it, closes it
    static void connectOnce() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("DriverManager connected: " + !conn.isClosed());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    // Keeps a pool of open connections and lends them out
    static void connectWithPool() {
        BasicDataSource pool = new BasicDataSource();
        pool.setUrl(URL);
        pool.setUsername(USER);
        pool.setPassword(PASSWORD);
        pool.setInitialSize(5); // open 5 at startup
        pool.setMaxTotal(20);   // never more than 20 at once
        pool.setMaxIdle(10);    // keep at most 10 sitting unused

        try (Connection conn = pool.getConnection(); // borrow from the pool
             PreparedStatement stmt = conn.prepareStatement("SELECT name, price FROM products WHERE price < ?")) {

            stmt.setBigDecimal(1, new java.math.BigDecimal("500.00"));
            ResultSet rows = stmt.executeQuery();
            while (rows.next()) {
                System.out.println(rows.getString("name") + " R" + rows.getBigDecimal("price"));
            }

        } catch (SQLException e) {
            System.out.println("Pool query failed: " + e.getMessage());
        } // close() here hands the connection back to the pool, it doesn't really close it

        try {
            pool.close(); // shut the whole pool down when the app stops
        } catch (SQLException e) {
            System.out.println("Could not close pool: " + e.getMessage());
        }
    }
}