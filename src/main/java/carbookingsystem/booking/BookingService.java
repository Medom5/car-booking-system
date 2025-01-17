package carbookingsystem.booking;

import carbookingsystem.car.Car;
import carbookingsystem.car.CarService;
import carbookingsystem.user.User;
import carbookingsystem.user.UserService;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class BookingService {
    private final BookingDao bookingDAO;
    private final CarService carService;
    private final UserService userService;

    public BookingService(BookingDao bookingDAO, CarService carService, UserService userService) {
        this.bookingDAO = bookingDAO;
        this.carService = carService;
        this.userService = userService;
    }

    public UUID bookCar(User user, String regNumber) {
        List<Car> availableCars = getAvailableCars();

        if (availableCars.isEmpty()) {
            throw new IllegalStateException("No car available for renting");
        }

        // Ensuring that the car a user wants to book is still available at the time the booking is processed
        Car car = availableCars.stream()
                .filter(availableCar -> availableCar.getRegNumber().equals(regNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Doesn't exist or already booked. Car with regNumber " + regNumber));

        UUID bookingId = UUID.randomUUID();
        Booking booking = new Booking(bookingId, car, user, LocalDateTime.now());
        bookingDAO.book(booking);

        return bookingId;
    }

    public List<Car> getUserBookedCars(UUID userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new IllegalStateException("No user found with ID: " + userId);
        }

        List<Booking> bookings = bookingDAO.getAllBookings();

        return bookings.stream()
                .filter(booking -> booking.getUser().getId().equals(userId) && !booking.isCancelled())
                .map(Booking::getCar)
                .collect(Collectors.toList());
    }


    public List<Car> getAvailableCars() {
        return getCars(carService.getAllCars());
    }

    public List<Car> getAvailableElectricCars() {
        return getCars(carService.getAllElectricCars());
    }

    private List<Car> getCars(List<Car> cars) {
        if (cars.isEmpty()) {
            return new ArrayList<>();
        }

        List<Booking> carBookings = bookingDAO.getAllBookings();

        if (carBookings.isEmpty()) {
            return new ArrayList<>(cars);
        }


        return cars.stream()
                .filter(car -> carBookings.stream()
                        .noneMatch(booking -> booking.getCar().equals(car) && !booking.isCancelled()))
                .collect(Collectors.toList());
    }

    public List<Booking> getBookings() {
        return bookingDAO.getAllBookings();
    }

    public void cancelBooking(UUID bookingId) {
        Booking booking = bookingDAO.getBooking(bookingId);

        if (booking == null) {
            throw new IllegalStateException("No booking found with ID: " + bookingId);
        }
        bookingDAO.cancelBooking(booking);
    }
}
