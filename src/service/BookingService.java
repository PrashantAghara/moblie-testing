package service;

import dao.BookingDAO;
import exception.BookingNotFoundException;
import exception.MobileNotFoundException;
import exception.UserNotFoundException;
import model.Booking;
import model.Mobile;
import model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingService {
    private final BookingDAO bookingDAO;
    private final UserService userService;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
        this.userService = new UserService();
    }

    public List<Booking> getBookingByPhoneId(String phoneId) {
        return bookingDAO.getBookingByPhoneId(phoneId);
    }

    public void createBooking(MobileService mobileService, String userName, String phoneName, String returnDate) {
        try {
            User user = userService.getUserById(userName);
            Mobile mobile = mobileService.getMobile(phoneName);
            if (!mobile.getAvailable()) {
                System.out.println(phoneName + " is not available");
                return;
            }
            String bookingDate = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now());
            String id = userName + "_" + phoneName + "_" + bookingDate;
            Booking booking = new Booking(id, mobile.getId(), user.getId(), bookingDate, returnDate);
            bookingDAO.createBooking(booking);
            int quantity = mobile.getQuantity() - 1;
            if (quantity == 0) {
                mobile.setAvailable(false);
            }
            mobile.setQuantity(quantity);
            mobileService.setMobileInDB(mobile);
            System.out.println("Booking was successful with id : " + id);
        } catch (UserNotFoundException | MobileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public Booking getBookingById(String id) throws BookingNotFoundException {
        return bookingDAO.getBookingById(id);
    }

    public void removeBookingById(String id) {
        bookingDAO.removeBooking(id);
    }
}
