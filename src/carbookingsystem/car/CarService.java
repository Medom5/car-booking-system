package carbookingsystem.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final CarDao carDAO;

    public CarService(CarDao carDAO) {
        this.carDAO = carDAO;
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    public Car getCar(String regNumber) {
        for (Car car : getAllCars()) {
            if (car.getRegNumber().equals(regNumber)) {
                return car;
            }}
            return getAllCars().stream()
                    .filter(car -> car.getRegNumber().equals(regNumber))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Car with regNumber " + regNumber + " not found"));


    }

    public List<Car> getAllElectricCars() {
        return getAllCars().stream()
                .filter(Car::getIsElectric)
                .collect(Collectors.toList());
    }
}
