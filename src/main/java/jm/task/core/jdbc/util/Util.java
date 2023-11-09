package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final DB_DRIVER = "";
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rootroot";

    public static  Connection getConnection() {
        Connection connection = null;
        try {
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД Установлено!");
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e | ClassNotFoundException e){
            e.printStackTrace();
        }
//
//    }
//    public static void main(String[] args) {
//        Connection connection;
//
//        try{
//            Driver driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            if(!connection.isClosed()){
//                System.out.println("Соединение с БД Установлено!");
//            }
//            connection.close();
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
        return connection;
    }
}
