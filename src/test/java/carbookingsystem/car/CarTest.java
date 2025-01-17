package carbookingsystem.car;



import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class CarTest {

    @Test
    void testCarConstructorAndGetter() {
        String regNumber = "1234";
        BigDecimal rentalPrice = new BigDecimal("88.0");
        Brand brand = Brand.TESLA;
        boolean isElectronic = true;

        Car car = new Car(regNumber, rentalPrice, brand, isElectronic);

        assertEquals(regNumber, car.getRegNumber());
        assertEquals(rentalPrice, car.getRentalPricePerDay());
        assertEquals(brand, car.getBrand());
        assertTrue(isElectronic);
    }

    @Test
    void testCarSetter() {
        Car car = new Car("1234", new BigDecimal("88.0"), Brand.TESLA, true);

        car.setRegNumber("5678");
        car.setRentalPricePerDay(new BigDecimal("100.0"));
        car.setBrand(Brand.BMW);
        car.setIsElectric(false);

        assertEquals("5678", car.getRegNumber());
        assertEquals(new BigDecimal("100.0"), car.getRentalPricePerDay());
        assertEquals(Brand.BMW, car.getBrand());
        assertFalse(car.getIsElectric());
    }

    @Test
    void testEqualsAndHashCode() {
        Car car = new Car("1234", new BigDecimal("88.0"), Brand.TESLA, true);
        Car car2 = new Car("1234", new BigDecimal("88.0"), Brand.TESLA, true);
        Car car3 = new Car("5678", new BigDecimal("66.0"), Brand.HONDA, false);

        assertEquals(car, car2);
        assertNotEquals(car, car3);
        assertEquals(car.hashCode(), car2.hashCode());
        assertNotEquals(car.hashCode(), car3.hashCode());
    }

    @Test
    void testToString() {
        Car car = new Car("1234", new BigDecimal("88.0"), Brand.TESLA, true);

        String toString = car.toString();

        assertTrue(toString.contains(car.getRegNumber()));
        assertTrue(toString.contains(car.getRentalPricePerDay().toString()));
        assertTrue(toString.contains(car.getBrand().toString()));
    }
}
