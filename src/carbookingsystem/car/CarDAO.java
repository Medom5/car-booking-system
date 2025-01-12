package carbookingsystem.car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private static final List<Car> cars;

    static {
        cars = new ArrayList<>();
        cars.add(new Car("1234",  new BigDecimal("88.00"), Brand.VOLKSWAGEN, false));
        cars.add(new Car("5678", new BigDecimal("60.00"), Brand.TESLA, true));
        cars.add(new Car("4567", new BigDecimal("90.00"), Brand.BMW, false));
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }
}
