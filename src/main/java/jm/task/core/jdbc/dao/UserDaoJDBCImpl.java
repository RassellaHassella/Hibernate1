package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    Connection connection = getConnection();


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE User (Id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                "name TINYTEXT, lastName TINYTEXT, age TINYINT)";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Таблица создана!");
        } catch (SQLException e) {
            System.out.println("Создание таблицы неуспешно!");
        }
    }


    public void dropUsersTable() {
        String sql = "DROP TABLE User";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Таблица удалена!");
        } catch (SQLException e) {
            System.out.println("Удаление таблицы неуспешно!");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO User (name, lastName, age) VALUES (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.execute(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("Пользователь с именем " + name + " добавлен!");
        } catch (SQLException e) {
            System.out.println("Создание пользователя неуспешно!");
        }

    }

    public void removeUserById(long id) {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM User WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Пользователь удален!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Удаление пользователя неуспешно!");
        }
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT ID, name, lastName, age from User";
        Statement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("Id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Получение всех пользователей неуспешно!");
        }
        return userList;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE User";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Таблица User полностью очищена!");
        } catch (SQLException e) {
            System.out.println("Очистка таблицы неуспешно!");
        }
    }
}
