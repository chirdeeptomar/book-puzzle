package com.connectt.puzzle.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Base class for query execution
 */
abstract class Query {

    private final Connection _connection;

    Query(Connection connection) {
        _connection = connection;
    }

    ResultSet execute(String query) {
        ResultSet rs = null;

        try {
            Statement statement = _connection.createStatement();
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return rs;
    }
}
