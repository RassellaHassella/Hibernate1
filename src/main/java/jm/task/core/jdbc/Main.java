package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Rassel", "Hassel", (byte) 29);
        userService.saveUser("Oleg", "Olegov",  (byte) 34);
        userService.saveUser("Roman", "Plushkin", (byte) 99);
        userService.saveUser("Igor", "Krutoy",  (byte) 56);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();


    }
}
