package Model;

import java.sql.Date;

public class Payment {
    private int paymentID;
    private int userID;
    private String paymentMode;
    private Date paymentDate;
    private int amount;
    
    public Payment(int paymentID, int userID, String paymentMode, Date paymentDate, int amount) {
        this.paymentID = paymentID;
        this.userID = userID;
        this.paymentMode = paymentMode;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }
    public int getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getPaymentMode() {
        return paymentMode;
    }
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
