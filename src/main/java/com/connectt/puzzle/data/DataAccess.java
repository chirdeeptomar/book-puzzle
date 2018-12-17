package com.connectt.puzzle.data;

import com.connectt.puzzle.models.Body;
import com.connectt.puzzle.models.Crypt;
import com.connectt.puzzle.utils.DatabaseManager;

import java.io.Closeable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Manages Data Access for SQLite
 */
public class DataAccess extends Query implements Closeable {

    public DataAccess() {
        super(DatabaseManager.connect());
    }

    public Stream<Body> getBody() {
        String query = "SELECT * FROM b0dy;";
        List<Body> bodyList = new ArrayList<>();

        try (ResultSet rs = execute(query)) {
            while (rs.next()) {
                bodyList.add(new Body(rs.getInt("Id"), rs.getString("data")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bodyList.stream();
    }

    public Stream<Crypt> getCrypt() {
        String query = "SELECT * FROM crypt;";
        List<Crypt> cryptList = new ArrayList<>();

        try (ResultSet rs = execute(query)) {
            while (rs.next()) {
                cryptList.add(new Crypt(rs.getInt("Start"), rs.getInt("length"), rs.getInt("rotate")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cryptList.stream();
    }

    @Override
    public void close() {
        DatabaseManager.disconnect();
    }
}
