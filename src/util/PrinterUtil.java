package util;

import dto.MobileDTO;

public class PrinterUtil {
    public void printMobileDetails(MobileDTO mobileDTO) {
        if (mobileDTO == null) {
            return;
        }
        System.out.println("--- Mobile details are ---");
        System.out.println("Name : " + mobileDTO.getName());
        System.out.println("Available : " + mobileDTO.getAvailable());
        System.out.println("Details : " + mobileDTO.getDetail());
        if (mobileDTO.getBookings() != null) {
            System.out.println("-- Bookings --");
            mobileDTO.getBookings().forEach(bookingDetailDTO -> {
                System.out.println("Booked by : " + bookingDetailDTO.getUserName());
                System.out.println("Booking date : " + bookingDetailDTO.getBookingDate());
                System.out.println("Return date : " + bookingDetailDTO.getReturnDate());
            });
        }
    }
}
