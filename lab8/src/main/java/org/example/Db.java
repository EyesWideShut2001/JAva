package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class Db {

    private static final String URL = "jdbc:mysql://localhost:3306/lab8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void initialize() {
        try (
                Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                Db.class.getResourceAsStream("/data.sql")
                        )
                )
        ) {
            StringBuilder sqlBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line).append("\n");
            }

            String[] queries = sqlBuilder.toString().split(";");
            for (String query : queries) {
                if (!query.trim().isEmpty()) {
                    stmt.execute(query);
                }
            }

            System.out.println("Inițializarea bazei de date s-a realizat cu succes.");
        } catch (Exception e) {
            System.err.println("Eroare la inițializarea bazei de date:");
            e.printStackTrace();
        }
    }
}
