package carbookingsystem;
import carbookingsystem.car.Brand;
import carbookingsystem.exceptions.InvalidNumberException;


import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("1 ⃣ - Book Car\n" +
                    "2 ⃣ - View All User Booked Cars\n" +
                    "3 ⃣ - View All Bookings\n" +
                    "4 ⃣ - View Available Cars\n" +
                    "5 ⃣ - View Available Electric Cars\n" +
                    "6 ⃣ - View all users\n" +
                    "7 ⃣ - Exit");

            try {
                int choice = scanner.nextInt();
                if (choice < 1 || choice > 7) {
                    throw new InvalidNumberException("Invalid choice! Please enter a valid Integer between 1 and 7");
                }
                switch (choice) {
                    case 1 -> {

                    }
                    case 2 -> {}
                    case 3 -> {}
                    case 4 -> {}
                    case 5 -> {}
                    case 6 -> {}
                    case 7 -> {
                        isRunning = false;
                        System.out.printf("Exiting...%n");
                    }
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a valid integer");
            }
            catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}