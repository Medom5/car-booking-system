package carbookingsystem.booking;

import carbookingsystem.car.Car;
import carbookingsystem.user.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private Car car;
    private User user;
    private LocalDateTime bookingTime;
    private boolean isCancelled;

    public Booking(UUID bookingId, Car car, User user, LocalDateTime bookingTime, boolean isCancelled) {
        this.bookingId = bookingId;
        this.car = car;
        this.user = user;
        this.bookingTime = bookingTime;
        this.isCancelled = isCancelled;
    }

    public Booking(UUID bookingId, Car car, User user, LocalDateTime bookingTime) {
        this(bookingId, car, user, bookingTime, false);
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + bookingId +
                ", car=" + car +
                ", user=" + user +
                ", bookingTime=" + bookingTime +
                ", isCancelled=" + isCancelled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return isCancelled() == booking.isCancelled() && Objects.equals(getBookingId(), booking.getBookingId()) && Objects.equals(getCar(), booking.getCar()) && Objects.equals(getUser(), booking.getUser()) && Objects.equals(getBookingTime(), booking.getBookingTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingId(), getCar(), getUser(), getBookingTime(), isCancelled());
    }
}
