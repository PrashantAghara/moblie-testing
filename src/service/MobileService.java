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
    private final UserService userService;

    public MobileService() {
        this.mobileDAO = new MobileDAO();
        this.userService = new UserService();
    }

    public MobileDTO getMobileName(BookingService bookingService, String name) {
        try {
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
        } catch (MobileNotFoundException mobileNotFoundException) {
            System.out.println(mobileNotFoundException.getMessage());
            return null;
        }
    }

    public Mobile getMobile(String name) throws MobileNotFoundException {
        return mobileDAO.getMobileByName(name);
    }

    public void setMobileInDB(Mobile mobile) {
        mobileDAO.setMobileInDB(mobile);
    }
}
