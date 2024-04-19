package service;

import dao.MobileDAO;
import dto.BookingDetailDTO;
import dto.MobileDTO;
import exception.MobileNotFoundException;
import model.Booking;
import model.Mobile;
import model.User;

import java.util.List;

public class MobileService {
    private final MobileDAO mobileDAO;
    private final BookingService bookingService;
    private final UserService userService;

    public MobileService() {
        this.mobileDAO = new MobileDAO();
        this.bookingService = new BookingService();
        this.userService = new UserService();
    }

    public MobileDTO getMobileName(String name) throws MobileNotFoundException {
        Mobile mobile = mobileDAO.getMobileByName(name);
        MobileDTO mobileDTO = new MobileDTO(mobile.getId(), mobile.getName(), mobile.getDetail(),
                mobile.getAvailable(), mobile.getQuantity());
        List<Booking> bookingDetailList = bookingService.getBookingByPhoneId(mobile.getId());
        if (!bookingDetailList.isEmpty()) {
            List<BookingDetailDTO> bookings = bookingDetailList.stream()
                    .map(booking -> {
                        User user = userService.getUserById(booking.getUserId());
                        return new BookingDetailDTO(user.getName(), booking.getBookingDate(), booking.getReturnDate());
                    }).toList();
            mobileDTO.setBookings(bookings);
        }
        return mobileDTO;
    }
}
