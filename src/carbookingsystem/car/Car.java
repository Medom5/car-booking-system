package carbookingsystem.car;

import java.math.BigDecimal;
import java.util.Objects;

 public class Car {
    private String regNumber;
    private BigDecimal rentalPricePerDay;
    private Brand brand;
    private boolean  isElectric;


    public Car(String regNumber, BigDecimal rentalPricePerDay, Brand brand, Boolean isElectric) {
        this.regNumber = regNumber;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    public Boolean getIsElectric() {
        return isElectric;
    }

    public void setIsElectric(Boolean isElectric) {
        this.isElectric = isElectric;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
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

    @Override
    public java.lang.String toString() {
        return "Car{" +
                "regNumber=" + regNumber +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return getRegNumber() == car.getRegNumber() && java.util.Objects.equals(getRentalPricePerDay(), car.getRentalPricePerDay()) && java.util.Objects.equals(getBrand(), car.getBrand()) && java.util.Objects.equals(getIsElectric(), car.getIsElectric());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRegNumber(), getRentalPricePerDay(), getBrand(), getIsElectric());
    }
}