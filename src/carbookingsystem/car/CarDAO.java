package carbookingsystem.car;

import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private final List<Car> cars;

    public CarDAO() {
        cars = new ArrayList<Car>();
    }
    public List<Car> getCars() {
        return cars;
    }
    public void addCar(Car car) {
        cars.add(car);
    }

}
