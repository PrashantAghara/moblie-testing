package com.mobile.util;

import com.mobile.dto.MobileDTO;
import com.mobile.service.BookingService;
import com.mobile.service.MobileService;
import com.mobile.service.ReturnService;
import com.mobile.service.UserService;

import java.util.Scanner;

public class Driver {
    private final UserService userService;
    private final MobileService mobileService;
    private final BookingService bookingService;
    private final ReturnService returnService;
    private final PrinterUtil printerUtil;

    public Driver() {
        this.userService = new UserService();
        this.mobileService = new MobileService();
        this.bookingService = new BookingService();
        this.returnService = new ReturnService(bookingService, mobileService);
        this.printerUtil = new PrinterUtil();
    }

    public void drive() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        while (true) {
            System.out.println("=== MOBILE SOFTWARE TESTING ===");
            System.out.println("1. Add new User");
            System.out.println("2. View Phone by name");
            System.out.println("3. Book a phone");
            System.out.println("4. Return a phone");
            System.out.println("5. Exit");
            System.out.println("===============================");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Username : ");
                    String userId = scanner.next();
                    System.out.print("Enter your name : ");
                    String name = scanner.next();
                    System.out.print("Enter phone : ");
                    String phone = scanner.next();
                    System.out.print("Enter address : ");
                    String address = scanner.next();
                    userService.createUser(userId, name, phone, address);
                    System.out.println("Created user with username : " + userId);
                    break;
                case 2:
                    System.out.print("Enter phone name : ");
                    String phoneName = scanner.next();
                    MobileDTO mobileDTO = mobileService.getMobileName(bookingService, phoneName);
                    printerUtil.printMobileDetails(mobileDTO);
                    break;
                case 3:
                    System.out.print("Enter phone name : ");
                    String mobile = scanner.next();
                    System.out.print("Enter user name : ");
                    String userName = scanner.next();
                    System.out.print("Enter return date : ");
                    String returnDate = scanner.next();
                    bookingService.createBooking(mobileService, userName, mobile, returnDate);
                    break;
                case 4:
                    System.out.print("Enter Booking id : ");
                    String bookingId = scanner.next();
                    System.out.print("Enter phone name : ");
                    String bookedPhone = scanner.next();
                    returnService.returnPhone(bookedPhone, bookingId);
                    break;
                case 5:
                    System.out.println("Thanks for visiting application");
                    System.exit(200);
            }
        }
    }
}
