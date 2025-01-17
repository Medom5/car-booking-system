package carbookingsystem.booking;

import carbookingsystem.car.Brand;
import carbookingsystem.car.Car;
import carbookingsystem.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class BookingDaoTest {

    private BookingDao bookingDao;

    @BeforeEach
    void setup() {
        bookingDao = new BookingDao();
    }

    @Test
    void testBookAndGetBooking() {
        Car car = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
        User user = new User(UUID.randomUUID(), "John");
        UUID bookingId = UUID.randomUUID();
        Booking booking = new Booking(bookingId, car, user, LocalDateTime.now());

        bookingDao.book(booking);

        Booking retrievedBooking = bookingDao.getBooking(bookingId);

        assertNotNull(retrievedBooking);
        assertEquals(bookingId, retrievedBooking.getBookingId());
    }

    @Test
    void testCancelBooking() {
        Car car = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
        User user = new User(UUID.randomUUID(), "John");
        UUID bookingId = UUID.randomUUID();
        Booking booking = new Booking(bookingId, car, user, LocalDateTime.now());

        bookingDao.book(booking);

        bookingDao.cancelBooking(booking);

        Booking retrievedBooking = bookingDao.getBooking(bookingId);

        assertTrue(retrievedBooking.isCancelled());
    }
}
