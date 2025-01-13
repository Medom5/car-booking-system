package carbookingsystem.user;

import java.util.List;
import java.util.UUID;

public class UserService {
    private UserDaoImpl userDAOImpl;

    public UserService(){
        userDAOImpl = new UserDaoImpl();
    }

    public List<User> getAllUsers() {
        return userDAOImpl.getAllUsers();
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
