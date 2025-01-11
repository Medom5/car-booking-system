package carbookingsystem;
import carbookingsystem.car.Brand;
import carbookingsystem.car.Car;
import carbookingsystem.user.User;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        User user = new User(UUID.randomUUID(), "asdf");
        System.out.println(user);
    }
}