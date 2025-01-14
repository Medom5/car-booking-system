package carbookingsystem.user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao =  userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
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
