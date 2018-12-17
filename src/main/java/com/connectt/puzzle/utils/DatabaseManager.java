package com.connectt.puzzle.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection Manager for SQLite database.
 */
public class DatabaseManager {
    private static Connection connection = null;

    /**
     * Connect to the database
     *
     * @return the Connection object
     */
    public static Connection connect() {
        String url = "jdbc:sqlite:" + DatabaseManager.class.getClassLoader().getResource("puzzle.db");

        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    /**
     * Disconnect from the database
     */
    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
