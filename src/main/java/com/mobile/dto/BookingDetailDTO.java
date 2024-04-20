package com.mobile.dto;

public class BookingDetailDTO {
    private String userName;
    private String bookingDate;
    private String returnDate;

    public BookingDetailDTO(String userName, String bookingDate, String returnDate) {
        this.userName = userName;
        this.bookingDate = bookingDate;
        this.returnDate = returnDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
