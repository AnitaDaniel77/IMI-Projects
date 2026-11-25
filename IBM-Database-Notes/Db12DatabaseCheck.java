// Runs once at startup: confirms MySQL is reachable and lists its databases and tables
package com.example.bookstore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Db12DatabaseCheck implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Db12DatabaseCheck.class);

    private final DataSource dataSource; // built by Spring from application.properties

    public Db12DatabaseCheck(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            // Safe to log: product name and URL, never the password
            log.info("Connected to {} at {}", conn.getMetaData().getDatabaseProductName(), conn.getMetaData().getURL());

            ResultSet databases = stmt.executeQuery("SHOW DATABASES");
            while (databases.next()) {
                log.info("Database: {}", databases.getString(1));
            }

            ResultSet tables = stmt.executeQuery("SHOW TABLES");
            while (tables.next()) {
                log.info("Table: {}", tables.getString(1));
            }

        } catch (SQLException e) {
            log.error("Database check failed: {}", e.getMessage());
        }
    }
}