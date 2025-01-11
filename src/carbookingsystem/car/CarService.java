package carbookingsystem.car;

import java.util.List;

public class CarService {
    private CarDAO carDAO;

    public CarService() {
         carDAO = new CarDAO();
    }
    public List<Car> getAllCars() {
        return carDAO.getCars();
    }
}
