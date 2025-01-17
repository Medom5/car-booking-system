package carbookingsystem.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CarServiceTest {

    @Mock
    private CarDao carDao;

    private CarService carService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        carService = new CarService(carDao);
    }

    @Test
    void testGetAllCars() {
        List<Car> mockCars = List.of(
                new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true),
                new Car("4543", new BigDecimal("66.00"), Brand.HONDA, false)
        );
        when(carDao.getAllCars()).thenReturn(mockCars);

        List<Car> cars = carService.getAllCars();

        assertEquals(2, cars.size());
        verify(carDao).getAllCars();
    }

    @Test
    void testGetCar() {

        Car mokCar = new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true);
        when(carDao.getAllCars()).thenReturn(List.of(mokCar));

        Car car = carService.getCar("1234");

        assertNotNull(car);
        assertEquals("1234", car.getRegNumber());
        verify(carDao).getAllCars();
    }

    @Test
    void testGetAllElectricityCars() {

        List<Car> mockCars = List.of(
                new Car("1234", new BigDecimal("88.00"), Brand.TESLA, true),
                new Car("4543", new BigDecimal("66.00"), Brand.HONDA, false)
        );
        when(carDao.getAllCars()).thenReturn(mockCars);

        List<Car> electricCars = carService.getAllElectricCars();

        assertEquals(1, electricCars.size());
        verify(carDao).getAllCars();
    }
}
