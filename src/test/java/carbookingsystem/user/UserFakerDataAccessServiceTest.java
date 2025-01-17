package carbookingsystem.user;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserFakerDataAccessServiceTest {

    @Test
    public void userFakerDataAccessServiceTest() {

        UserDao userDao = new UserFakerDataAccessService();

        List <User> users = userDao.getAllUsers();

        assertNotNull(users);
        assertEquals(20 , users.size()); // Faker generates 20 users
    }
}
