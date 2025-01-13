package carbookingsystem.user;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {

    private static final List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(UUID.randomUUID(), "Jake"));
        users.add(new User(UUID.randomUUID(), "Maria"));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

}
