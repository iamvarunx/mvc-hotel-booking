package Model;

import java.sql.Date;

public class Payment {
    private static int paymentID;
    private int userID;
    private String paymentMode;
    private Date paymentDate;
    private int amount;

    public Payment(int paymentid, int userID, String paymentMode, Date paymentDate, int amount) {
        paymentID = paymentid;
        this.userID = userID;
        this.paymentMode = paymentMode;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public Payment() {
        // TODO Auto-generated constructor stub
    }

    public static int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentid) {
        paymentID = paymentid;
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
