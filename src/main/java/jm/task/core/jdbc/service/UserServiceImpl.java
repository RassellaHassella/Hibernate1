import jm.task.core.jdbc.*;
import jm.task.core.jdbc.model.User;
import java.util.List;
import jm.task.core.jdbc.*;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.*;
public class UserServiceImpl implements UserService {

    public void createUsersTable() {
        createUsersTable();
    }

    public void dropUsersTable() {
        dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
       saveUser(name, lastName, age);
        System.out.println("Пользователь с именем " + name + " добавлен!");

    }

    public void removeUserById(long id) {
         removeUserById(id);
    }

    public List<User> getAllUsers() {
        return getAllUsers();
    }

    public void cleanUsersTable() {
        cleanUsersTable();
    }
}
