package carbookingsystem.car;
import java.math.BigDecimal;
import java.util.Objects;

public class Car {
    private int regNumber;
    private BigDecimal rentalPricePerDay;
    private Brand brand;
    private boolean  isElectric;


    public Car(int regNumber, Boolean isElectric, BigDecimal rentalPricePerDay, Brand brand) {
        this.regNumber = regNumber;
        this.isElectric = isElectric;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
    }

    public Boolean getIsElectric() {
        return isElectric;
    }

    public void setIsElectric(Boolean isElectric) {
        this.isElectric = isElectric;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Car{" +
                "regNumber=" + regNumber +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }

    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return getRegNumber() == car.getRegNumber() && java.util.Objects.equals(getRentalPricePerDay(), car.getRentalPricePerDay()) && java.util.Objects.equals(getBrand(), car.getBrand()) && java.util.Objects.equals(getIsElectric(), car.getIsElectric());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getRegNumber(), getRentalPricePerDay(), getBrand(), getIsElectric());
    }
}