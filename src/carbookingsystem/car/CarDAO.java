package carbookingsystem.car;

import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private static final List<Car> cars;

    static {
        cars = new ArrayList<>();
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
