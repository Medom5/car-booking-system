package carbookingsystem.user;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserFakerDataAccessService implements UserDao{

    public UserFakerDataAccessService() {

    }


    @Override
    public List<User> getAllUsers() {
        Faker faker = new Faker();

        return IntStream.range(0,20)
                .mapToObj(u -> new User(UUID.randomUUID(), faker.name().name()))
                .collect(Collectors.toList());
    }
}
