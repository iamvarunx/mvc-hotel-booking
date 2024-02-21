package Model;

import java.time.LocalDate;

public class Booking{
    private int bookingID;
    private int hotelID;
    private int roomID;
    private String City;
    private int noOfRooms;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int paymentID;
    private String status;
    private int noofDays;
    public int getNoofDays() {
        return noofDays;
    }
    public void setNoofDays(int noofDays) {
        this.noofDays = noofDays;
    }
    public int getBookingID() {
        return bookingID;
    }
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }
    public int getHotelID() {
        return hotelID;
    }
    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }
    public int getRoomID() {
        return roomID;
    }
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    public int getNoOfRooms() {
        return noOfRooms;
    }
    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
    public LocalDate getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
    public LocalDate getCheckOut() {
        return checkOut;
    }
    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
    public int getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
    

}
