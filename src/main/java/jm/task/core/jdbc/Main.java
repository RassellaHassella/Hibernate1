
import jm.task.core.jdbc.*;
public class Main {
    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();
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
