package carbookingsystem.car;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private CarDao carDAO;

    public CarService() {
         carDAO = new CarDao();
    }
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    public Car getCar(String regNumber) {
        for(Car car : getAllCars()) {
            if(car.getRegNumber().equals(regNumber)) {
                return car;
            }
        }
        throw new IllegalStateException("Car with regNumber " + regNumber + " not found");
    }

    public List<Car> getAllElectricCars() {
        List<Car> electricCars = new ArrayList<Car>();
        for(Car car : getAllCars()) {
            if(car.getIsElectric())
                electricCars.add(car);
        }
        return electricCars;
    }
}
