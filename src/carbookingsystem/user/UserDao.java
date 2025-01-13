package carbookingsystem.user;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

class UserDao {
    private static final List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"), "Jake"));
        users.add(new User(UUID.randomUUID(), "Maria"));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

}
