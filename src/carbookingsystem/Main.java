package carbookingsystem;
import carbookingsystem.car.Brand;
import carbookingsystem.car.Car;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(2,false, new BigDecimal(3), Brand.BMW);
        System.out.println(car);
    }
}