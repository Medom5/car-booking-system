package carbookingsystem.user;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserFakerDataAccessService implements UserDao {
    private List<User> users; // Store users persistently

    public UserFakerDataAccessService() {
        Faker faker = new Faker();

        // prevent data getting override on each getAllUsers call
        this.users = IntStream.range(0, 20)
                .mapToObj(u -> new User(UUID.randomUUID(), faker.name().name()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }


}
