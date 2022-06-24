package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Util {

    private static Connection connection = null;
    private static Util instance = null;

    private static final String DB_DRV = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/kata";
    private static final String DB_USER = "root";

    public Connection getConnection() {
        try {
            Class.forName(DB_DRV);
            connection = DriverManager.getConnection(DB_URL,
                    DB_USER,
                    "123456");
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }

    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }

}