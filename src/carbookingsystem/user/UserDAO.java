package carbookingsystem.user;
import java.util.ArrayList;
import java.util.List;

class UserDAO {
    private final List<User> users;

    public UserDAO() {
        users = new ArrayList<>();
    }

   public void addUser(User user) {
        users.add(user);
   }

    public List<User> getAllUsers() {
        return users;
    }


}
