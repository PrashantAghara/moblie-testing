package com.mobile.util;

import com.mobile.dto.MobileDTO;
import com.mobile.model.Mobile;

import java.util.List;

public class PrinterUtil {
    public void printMobileDetails(MobileDTO mobileDTO) {
        if (mobileDTO == null) {
            return;
        }
        System.out.println("--- Mobile details are ---");
        System.out.println("Name : " + mobileDTO.getName());
        System.out.println("Available : " + mobileDTO.getAvailable());
        System.out.println("Details : " + mobileDTO.getDetail());
        System.out.println("Quantity : " + mobileDTO.getQuantity());
        if (mobileDTO.getBookings() != null) {
            System.out.println("--- Bookings ---");
            mobileDTO.getBookings().forEach(bookingDetailDTO -> {
                System.out.println("-----");
                System.out.println("Booked by : " + bookingDetailDTO.getUserName());
                System.out.println("Booking date : " + bookingDetailDTO.getBookingDate());
                System.out.println("Return date : " + bookingDetailDTO.getReturnDate());
                System.out.println("-----");
            });
        }
    }

    public void printAvailableMobiles(List<Mobile> mobiles) {
        System.out.println("=== Available Mobiles ===");
        if (mobiles.isEmpty()) {
            return;
        }
        mobiles.forEach(mobile -> {
            System.out.println("-*-*-*-");
            System.out.println("Mobile Name : " + mobile.getName());
            System.out.println("Mobile Details : " + mobile.getDetail());
            System.out.println("-*-*-*-");
        });
    }
}
