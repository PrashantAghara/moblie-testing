package com.mobile.util;

import com.mobile.dto.MobileDTO;
import com.mobile.model.Mobile;
import com.mobile.service.BookingService;
import com.mobile.service.MobileService;
import com.mobile.service.ReturnService;
import com.mobile.service.UserService;

import java.util.List;
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
            System.out.println("1. View available phones");
            System.out.println("2. View Phone by name");
            System.out.println("3. Book a phone");
            System.out.println("4. Return a phone");
            System.out.println("5. Exit");
            System.out.println("===============================");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Mobile> mobiles = mobileService.getAvailableMobiles();
                    printerUtil.printAvailableMobiles(mobiles);
                    break;
                case 2:
                    System.out.print("Enter phone name : ");
                    String phoneName = scanner.next();
                    MobileDTO mobileDTO = mobileService.getMobileName(bookingService, phoneName);
                    printerUtil.printMobileDetails(mobileDTO);
                    break;
                case 3:
                    System.out.println("Are you new User (Y/N) : ");
                    String newUser = scanner.next();
                    String userName;
                    if (newUser.equals("Y")) {
                        System.out.print("Enter Username : ");
                        userName = scanner.next();
                        System.out.print("Enter your name : ");
                        String name = scanner.next();
                        System.out.print("Enter phone : ");
                        String phone = scanner.next();
                        System.out.print("Enter address : ");
                        String address = scanner.next();
                        userService.createUser(userName, name, phone, address);
                        System.out.println("Created user with username : " + userName);
                    } else if (newUser.equals("N")) {
                        System.out.print("Enter user name : ");
                        userName = scanner.next();
                    } else {
                        System.out.println("Invalid choice");
                        return;
                    }
                    System.out.print("Enter phone name : ");
                    String mobile = scanner.next();
                    System.out.print("Enter number of days for phone to be returned : ");
                    int returnDays = scanner.nextInt();
                    bookingService.createBooking(mobileService, userName, mobile, returnDays);
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
