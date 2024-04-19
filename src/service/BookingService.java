package service;

import dao.BookingDAO;
import database.BookingDB;
import model.Booking;
import model.User;

import java.util.List;

public class BookingService {
    private final BookingDAO bookingDAO;
    private final MobileService mobileService;
    private final UserService userService;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
        this.mobileService = new MobileService();
        this.userService = new UserService();
    }

    public List<Booking> getBookingByPhoneId(String phoneId) {
        return bookingDAO.getBookingByPhoneId(phoneId);
    }

    public void createBooking(String userName, String phoneName, String bookingDate, String returnDate) {

    }
}
