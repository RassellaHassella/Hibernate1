import jm.task.core.jdbc.model.User;
import java.util.List;
import jm.task.core.jdbc.*;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.*;


public interface UserService {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
