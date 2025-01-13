package carbookingsystem.user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private UserDao userDAO;

    public UserService(){
        userDAO = new UserDao();
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(UUID id) {
        for(User user : getAllUsers()){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}
