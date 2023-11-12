package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//        UserServiceImpl userService = new UserServiceImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Rassel", "Hassel", (byte) 29);
        userDaoJDBC.saveUser("Oleg", "Olegov",  (byte) 34);
        userDaoJDBC.saveUser("Roman", "Plushkin", (byte) 99);
        userDaoJDBC.saveUser("Igor", "Krutoy",  (byte) 56);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();


    }
}
