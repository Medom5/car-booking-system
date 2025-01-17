package carbookingsystem.car;

public enum Brand {

    TOYOTA("Toyota"),
    HONDA("Honda"),
    FORD("Ford"),
    CHEVROLET("Chevrolet"),
    BMW("BMW"),
    MERCEDES("Mercedes"),
    AUDI("Audi"),
    TESLA("Tesla"),
    VOLKSWAGEN("Volkswagen"),
    NISSAN("Nissan");

    private final String brand;

    Brand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}