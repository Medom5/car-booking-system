package carbookingsystem.user;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserCsvDataAccessServiceTest {

    @Test
    void testGetAllUsersFromCsv() {

        UserDao userDao = new UserCsvDataAccessService("users.csv");

        List<User> users = userDao.getAllUsers();

        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
}
