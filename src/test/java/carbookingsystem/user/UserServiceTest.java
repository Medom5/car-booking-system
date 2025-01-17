package carbookingsystem.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserDao userDao;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userDao);
    }

    @Test
    void testGetAllUsers() {
        List<User>  mockUsers = List.of(
                new User(UUID.randomUUID(), "Jake"),
                new User(UUID.randomUUID(), "Mike")
        );
        when(userDao.getAllUsers()).thenReturn(mockUsers);

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
        verify(userDao).getAllUsers();
    }

    @Test
    void testGetUserById() {

        User user = new User(UUID.randomUUID(), "Jake");

        List<User> mockUsers = List.of(user);
        when(userDao.getAllUsers()).thenReturn(mockUsers);

        assertEquals(userService.getUserById(user.getId()), user);
        verify(userDao).getAllUsers();
    }

    @Test
    void testGetUserByIdNotFound() {

        List<User> mockUsers = List.of(new User(UUID.randomUUID(), "Jake"));
        when(userDao.getAllUsers()).thenReturn(mockUsers);

        User user = userService.getUserById(UUID.randomUUID());

        assertNull(user);
    }

}
