package carbookingsystem.user;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    void testUserConstructorAndGetter() {
        UUID id = UUID.randomUUID();
        String userName = "Peter Pan";

        User user = new User(id, userName);

        assertEquals(id, user.getId());
        assertEquals(userName, user.getName());
    }

    @Test
    void testUserSetter() {
        User user = new User(UUID.randomUUID(), "Peter Pan");

        UUID id = UUID.randomUUID();
        String newName = "Peter Nap";
        user.setId(id);
        user.setName(newName);

        assertEquals(id, user.getId());
        assertEquals(newName, user.getName());

    }

    @Test
    void testEquals() {
        UUID id = UUID.randomUUID();
        String userName = "Peter Pan";

        User user = new User(id, userName);
        User user2 = new User(id, userName);

        assertEquals(user, user2);
        assertEquals(user.hashCode(), user2.hashCode());
    }
}
