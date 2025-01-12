package carbookingsystem.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingDAO {
    private static final List<Booking> bookings;

    static {
        bookings = new ArrayList<>();
    }

    public void book(Booking booking) {
        bookings.add(booking);
    }

    public Booking getBooking(UUID bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                return booking;
            }
        }
        return null;
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    public void cancelBooking(Booking booking) {
        booking.setCancelled(true);
    }
}
