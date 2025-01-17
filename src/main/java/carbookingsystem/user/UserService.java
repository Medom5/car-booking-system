package carbookingsystem.user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final List<User> allUsers;

    public UserService(UserDao userDao) {
        this.allUsers = userDao.getAllUsers(); // replaced  userDao with list to keep java faker random result and not  override users on each call
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public User getUserById(UUID id) {
        return allUsers.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
