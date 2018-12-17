package com.connectt.puzzle;

import com.connectt.puzzle.utils.DatabaseManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabaseTest {

    private static Connection connection;

    @BeforeAll
    static void setup() {
        connection = DatabaseManager.connect();
    }

    @Test
    void can_connect_successfully() throws SQLException {
        String sql = "SELECT * FROM b0dy";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        assertEquals(1, rs.getInt("id"));
    }

    @AfterAll
    static void teardown() {
        DatabaseManager.disconnect();
    }
}
