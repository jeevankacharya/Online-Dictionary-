package io.javabrains.onlinedictonary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        // Database name to access
        String dbName = "onlinedictionary";
        String dbUsername = "root";
        String dbPassword = "root";

        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
    }
}
