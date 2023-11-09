package jm.task.core.jdbc.dao;

import com.mysql.jdbc.Statement;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    Connection connection = getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Statement statement = null;
        String sql = "CREATE TABLE User (Id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                "name TINYTEXT, lastName TINYTEXT, age TINYINT)";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Таблица создана!");
        } catch (SQLException e) {
            System.out.println("Соединение с БД не установлено!");
        }

    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
