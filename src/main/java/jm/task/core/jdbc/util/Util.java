package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Util {

    private static Connection connection = null;
    private static final String DB_DRV = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/kata";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "123456";

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRV);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            System.out.println("Connection close");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Close connection ERROR");
        }

    }


}