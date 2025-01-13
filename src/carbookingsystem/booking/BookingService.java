package carbookingsystem.booking;

import carbookingsystem.car.Car;
import carbookingsystem.car.CarService;
import carbookingsystem.user.User;
import carbookingsystem.user.UserService;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class BookingService {
    private final BookingDao bookingDAO;
    private final CarService carService;
    private final UserService userService;

    public BookingService() {
        bookingDAO = new BookingDao();
        carService = new CarService();
        userService = new UserService();
    }

    public UUID bookCar(User user, String regNumber) {
        List<Car> availableCars = getAvailableCars();

        if (availableCars.isEmpty()) {
            throw new IllegalStateException("No car available for renting");
        }

        for (Car availableCar : availableCars) {
            // Ensuring that the car a user wants to book is still available at the time the booking is processed
            if (availableCar.getRegNumber().equals(regNumber)) {
                Car car = carService.getCar(regNumber);
                UUID bookingId = UUID.randomUUID();
                Booking booking = new Booking(bookingId, car, user, LocalDateTime.now());
                bookingDAO.book(booking);
                return bookingId;
            }
        }
        throw new IllegalStateException("Doesn't exist or already booked. Car with regNumber " + regNumber);
    }

    public List<Car> getUserBookedCars(UUID userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new IllegalStateException("No user found with ID: " + userId);
        }

        List<Booking> bookings = bookingDAO.getAllBookings();
        List<Car> userCars = new ArrayList<>();

        for (Booking booking : bookings) {
            // Only include the cars that are not cancelled
            if (booking.getUser().getId().equals(userId) && !booking.isCancelled()) {
                userCars.add(booking.getCar());
            }
        }
        return userCars;
    }


    public List<Car> getAvailableCars() {
        return getCars(carService.getAllCars());
    }

    public List<Car> getAvailableElectricCars() {
        return getCars(carService.getAllElectricCars());
    }

    public List<Car> getCars(List<Car> cars) {
        if (cars.isEmpty()) return new ArrayList<>();

        List<Booking> carBookings = bookingDAO.getAllBookings();

        if (carBookings.isEmpty()) {
            return new ArrayList<>(cars);
        }

        List<Car> availableCars = new ArrayList<>();

        for (Car car : cars) {
            boolean booked = false;
            for (Booking booking : carBookings) {
                if (booking.getCar().equals(car) && !booking.isCancelled()) {
                    booked = true;
                    break;
                }
            }
            if (!booked) {
                availableCars.add(car);
            }
        }
        return availableCars;
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
