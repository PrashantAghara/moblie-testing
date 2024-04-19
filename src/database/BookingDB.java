package database;

import model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingDB {
    private static final Map<String, Booking> bookingDB = new HashMap<>();

    public Booking getBookingById(String id) {
        return bookingDB.get(id);
    }

    public void createBooking(Booking booking) {
        bookingDB.put(booking.getId(), booking);
        System.out.println("Booking added with Id : " + booking.getId());
    }
}
