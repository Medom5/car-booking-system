package carbookingsystem.user;
import java.util.ArrayList;
import java.util.List;

class UserDAO {
    private static  final List<User> users;

    static {
        users = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

}
