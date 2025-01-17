package carbookingsystem.car;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarDaoTest {

    @Test
    void testGetAllCars() {

        CarDao carDao = new CarDao();

        List<Car> cars = carDao.getAllCars();

        assertNotNull(cars);
        assertEquals(3, cars.size()); // static list has 3 cars
        assertEquals("1234", cars.get(0).getRegNumber()); // first car verification
    }
}
