package carbookingsystem.booking;

import carbookingsystem.car.Brand;
import carbookingsystem.car.Car;
import carbookingsystem.user.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    @Test
    void testBookingConstructorAndGetter() {
        Car car = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
        User user = new User(UUID.randomUUID(), "Peter");
        UUID uuid = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        Booking booking = new Booking(uuid, car, user, now);

        assertEquals(uuid, booking.getBookingId());
        assertEquals(car, booking.getCar());
        assertEquals(user, booking.getUser());
        assertEquals(now, booking.getBookingTime());
    }

    @Test
    void testBookingSetter() {

        Booking booking = new Booking(UUID.randomUUID(), new Car("5678", new BigDecimal("83.00"), Brand.HONDA, false), new User(UUID.randomUUID(), "Roland"), LocalDateTime.now());

        UUID uuid = UUID.randomUUID();
        Car car = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
        LocalDateTime now = LocalDateTime.now();
        User user = new User(UUID.randomUUID(), "Peter");

        booking.setBookingId(uuid);
        booking.setCar(car);
        booking.setUser(user);
        booking.setBookingTime(now);

        assertEquals(uuid, booking.getBookingId());
        assertEquals(car, booking.getCar());
        assertEquals(user, booking.getUser());
        assertEquals(now, booking.getBookingTime());
        assertFalse(booking.isCancelled());
    }

    @Test
    void testBookingEqualsAndHashCode() {
        UUID userId = UUID.randomUUID();
        Car car = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
        User user = new User(userId, "Peter");
        UUID uuid = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        Booking booking = new Booking(uuid, car, user, now);

        Car car2 = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
        User user2 = new User(userId, "Peter");
        Booking booking2 = new Booking(uuid, car2, user2, now);

        assertEquals(booking, booking2);
        assertEquals(booking.hashCode(), booking2.hashCode());
    }

    @Test
    void testBookingToString() {
            Car car = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
            User user = new User(UUID.randomUUID(), "Peter");
            UUID uuid = UUID.randomUUID();
            LocalDateTime now = LocalDateTime.now();

            Booking booking = new Booking(uuid, car, user, now);

            String expectedToString = "Booking{" +
                    "id=" + uuid +
                    ", car=" + car +
                    ", user=" + user +
                    ", bookingTime=" + now +
                    ", isCancelled=false}";

            assertEquals(expectedToString, booking.toString());
    }
}
