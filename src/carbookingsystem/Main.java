package carbookingsystem;

import carbookingsystem.booking.Booking;
import carbookingsystem.booking.BookingService;
import carbookingsystem.car.Car;
import carbookingsystem.exceptions.InvalidNumberException;
import carbookingsystem.user.User;
import carbookingsystem.user.UserService;


import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        BookingService bookingService = new BookingService();

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            try {
                displayMenu();
                System.out.print("Select action:");
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 7) {
                    throw new InvalidNumberException("Invalid choice! Please enter a valid Integer between 1 and 7");
                }
                switch (choice) {
                    case 1 -> bookCar(userService, bookingService, scanner);
                    case 2 -> displayAllUserBookedCars(userService, bookingService, scanner);
                    case 3 -> displayAllBookings(bookingService);
                    case 4 -> displayAvailableCars(bookingService, false);
                    case 5 -> displayAvailableCars(bookingService, true);
                    case 6 -> displayAllUsers(userService);
                    case 7 -> {
                        isRunning = false;
                        System.out.printf("Exiting...%n");
                    }
                    default -> throw new IllegalArgumentException("Invalid action: " + choice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a valid integer");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void bookCar(UserService userService, BookingService bookingService, Scanner scanner) {
        if (!displayAvailableCars(bookingService, false)) {
            return;
        }

        System.out.println("Select car reg number:");
        String regNumber = scanner.nextLine();

        if (!displayAllUsers(userService)) {
            return;
        }

        System.out.println("Select User ID:");
        String userId = scanner.nextLine();

        try {
            UUID userUUID = UUID.fromString(userId);
            User user = userService.getUserById(userUUID);
            if (user == null) {
                System.out.println("No user found with id " + userId);
            } else {
                UUID bookingId = bookingService.bookCar(user, regNumber);
                String completionMessage = """
                        Successfully booked car with reg number %s for user %s
                        Booking ref: %s
                        """.formatted(regNumber, userId, bookingId);
                System.out.println(completionMessage);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid User ID format: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayAllUserBookedCars(UserService userService, BookingService bookingService, Scanner scanner) {

        if (!displayAllUsers(userService)) {
            return;
        }

        System.out.println("Select user Id:");
        String userId = scanner.nextLine();

        User user = userService.getUserById(UUID.fromString(userId));
        if (user == null) {
            System.out.println("No user found with id " + userId);
            return;
        }

        List<Car> userBookedCars = bookingService.getUserBookedCars(user.getId());

        if (userBookedCars.isEmpty()) {
            System.out.println("User" + user + " has no booked cars");
            return;
        }
        for (Car userBookedcar : userBookedCars) {
            System.out.println(userBookedcar);
        }
    }

    private static void displayAllBookings(BookingService bookingService) {
        List<Booking> bookings = bookingService.getBookings();
        if (bookings.isEmpty()) {
            System.out.println("No bookings found in the system");
            return;
        }
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    private static boolean displayAvailableCars(BookingService bookingService, boolean isElectric) {
        List<Car> availableCars = isElectric ? bookingService.getAvailableElectricCars() : bookingService.getAvailableCars();
        if (availableCars.isEmpty()) {
            System.out.println("There are no available cars");
            return false;
        }
        for (Car car : availableCars) {
            System.out.println(car);
        }
        return true;
    }

    private static boolean displayAllUsers(UserService userService) {
        List<User> allUsers = userService.getAllUsers();
        if (allUsers.isEmpty()) {
            System.out.println("No users found in the system");
            return false;
        }
        for (User user : allUsers) {
            System.out.println(user);
        }
        return true;
    }

    private static void displayMenu() {
        System.out.println("""
                \n
                1 - Book Car
                2 - View All User Booked Cars
                3 - View All Bookings
                4 - View Available Cars
                5 - View Available Electric Cars
                6 - View all users
                7 - Exit
                """);
    }
}