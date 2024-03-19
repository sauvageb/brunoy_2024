package com.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Final sur une classe empeche l'heritage
public final class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:8889/jdbc_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Instance UNIQUE
    private static Connection S_INSTANCE;

    // Empeche l'instanciation de cette classe Singleton
    private ConnectionManager() {
    }

    public static Connection getInstance() {
        if (S_INSTANCE == null) {
            try {
                loadDriver();
                S_INSTANCE = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.err.println("Error connection");
            }
        }
        return S_INSTANCE;
    }

    private static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            if (S_INSTANCE != null && !S_INSTANCE.isClosed()) {
                S_INSTANCE.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection");
        }
    }

}
