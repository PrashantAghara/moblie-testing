package model;

import java.util.Date;

public class Booking {
    private String id;
    private String mobileId;
    private String userId;
    private Date bookingDate;
    private Date returnDate;

    public Booking(String id, String mobileId, String userId, Date bookingDate, Date returnDate) {
        this.id = id;
        this.mobileId = mobileId;
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.returnDate = returnDate;
    }

    public String getId() {
        return id;
    }

    public String getMobileId() {
        return mobileId;
    }

    public String getUserId() {
        return userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
