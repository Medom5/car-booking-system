package carbookingsystem.booking;

import carbookingsystem.car.Brand;
import carbookingsystem.car.Car;
import carbookingsystem.car.CarService;
import carbookingsystem.user.User;
import carbookingsystem.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @Mock
    private BookingDao bookingDao;

    @Mock
    private CarService carService;

    @Mock
    private UserService userService;

    private BookingService bookingService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        bookingService = new BookingService(bookingDao, carService, userService);
    }

    @Test
    void testBookCarSuccefully() {

        User user = new User(UUID.randomUUID(), "Judi");
        Car car = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
        List<Car> carList = List.of(car);

        when(carService.getAllCars()).thenReturn(carList);
        when(userService.getUserById(user.getId())).thenReturn(user);

        UUID bookingId = bookingService.bookCar(user,car.getRegNumber());

        assertNotNull(bookingId);
        verify(bookingDao).book(any(Booking.class));
    }

    @Test
    void testBookCarFail() {
        User user = new User(UUID.randomUUID(), "Judi");
        when(carService.getAllCars()).thenReturn(List.of());

        assertThrows(IllegalStateException.class, () -> bookingService.bookCar(user, "1234"));
    }

    @Test
    void testGetUserBookedCars() {
        User user = new User(UUID.randomUUID(), "Judi");
        Car car = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);

        when(bookingService.getAvailableCars()).thenReturn(List.of(car));

        UUID bookingId = bookingService.bookCar(user,car.getRegNumber());
        Booking booking = new Booking(bookingId, car, user, LocalDateTime.now());
        List<Booking> bookingList = List.of(booking);

        when(userService.getUserById(user.getId())).thenReturn(user);
        when(bookingDao.getAllBookings()).thenReturn(bookingList);


        List<Car> userBookedCars = bookingService.getUserBookedCars(user.getId());

        assertNotNull(userBookedCars);
        assertEquals(1, userBookedCars.size());
        assertEquals(car, userBookedCars.get(0));
    }

    @Test
    void testCancelBooking() {
        User user = new User(UUID.randomUUID(), "Judi");
        Car car = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
        UUID bookingId = UUID.randomUUID();
        Booking booking = new Booking(bookingId, car, user, LocalDateTime.now());

        when(bookingDao.getBooking(bookingId)).thenReturn(booking);

        doAnswer(invocation -> {
            Booking b = invocation.getArgument(0);
            b.setCancelled(true);
            return null;
        }).when(bookingDao).cancelBooking(any(Booking.class));

        bookingService.cancelBooking(bookingId);

        verify(bookingDao).cancelBooking(booking);
        assertTrue(booking.isCancelled());
    }

    @Test
    void testCancelBookingFail() {

        UUID bookingId = UUID.randomUUID();

        when(bookingDao.getBooking(bookingId)).thenReturn(null);

        assertThrows(IllegalStateException.class, () -> bookingService.cancelBooking(bookingId));
    }
}
