package database;

import model.Booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingDB {
    private static final Map<String, Booking> bookingDB = new HashMap<>();

    public List<Booking> getBookingByPhoneId(String phoneId) {
        System.out.println(bookingDB);
        return bookingDB.values()
                .stream()
                .filter(booking -> booking.getMobileId().equals(phoneId))
                .toList();
    }

    public void createBooking(Booking booking) {
        bookingDB.put(booking.getId(), booking);
        System.out.println("Booking added with Id : " + booking.getId());
        System.out.println(bookingDB);
    }

    public Booking getBookingById(String id) {
        return bookingDB.get(id);
    }

    public void deleteBooking(String id) {
        bookingDB.remove(id);
    }
}
