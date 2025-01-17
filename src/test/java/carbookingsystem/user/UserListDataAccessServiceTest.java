package carbookingsystem.user;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserListDataAccessServiceTest {

    @Test
    void testGetAllUsersFromList() {
        UserDao userDao = new UserListDataAccessService();

        List<User> users = userDao.getAllUsers();

        assertNotNull(users);
        assertEquals(2, users.size()); // Two users in the static list
    }
}
