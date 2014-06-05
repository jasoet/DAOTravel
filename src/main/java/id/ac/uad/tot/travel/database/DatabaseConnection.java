/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.uad.tot.travel.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jasoet
 */
public class DatabaseConnection {

    private static DatabaseConnection dbConnection=null;

    public static DatabaseConnection getInstance() throws SQLException {
        if (dbConnection == null) {
            dbConnection = new DatabaseConnection();
        }else if(dbConnection.getConnection().isClosed()){
            dbConnection = new DatabaseConnection();
        }
        
        return dbConnection;
    }

    private final Connection connection;

    private DatabaseConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Load class Failed : " + ex.getMessage());
        }

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel", "root", "");
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() throws SQLException {
        connection.close();
    }

}
