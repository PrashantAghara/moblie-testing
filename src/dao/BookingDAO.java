package dao;

import database.BookingDB;
import model.Booking;

import java.util.List;

public class BookingDAO {
    private final BookingDB bookingDB;

    public BookingDAO() {
        this.bookingDB = new BookingDB();
    }

    public List<Booking> getBookingByPhoneId(String phoneId) {
        return bookingDB.getBookingByPhoneId(phoneId);
    }

    public void createBooking(Booking booking) {
        bookingDB.createBooking(booking);
    }
}
