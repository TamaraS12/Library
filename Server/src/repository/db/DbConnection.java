/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Tamarica
 */
public class DbConnection {

    private List<Connection> connectionPool;
    private static DbConnection instance;

    private DbConnection() {
        connectionPool = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            try {
                String url = "jdbc:mysql://localhost:3306/library";
                String user = "root";
                String password = "root";

                Connection connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection to the database successfully established!");
                connection.setAutoCommit(false);
                connectionPool.add(connection);
            } catch (SQLException ex) {
                System.out.println("Error! Connection to the database was not successfully established!\n" + ex.getMessage());
                ex.printStackTrace();
            }

        }
    }

    public static DbConnection getInstance() {

        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public synchronized Connection pop() throws Exception {
        if (connectionPool.isEmpty()) {
            throw new Exception("No available connection!");
        }
        Connection connection = connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }

    public synchronized void push(Connection connection) {
        connectionPool.add(connection);
    }

}
