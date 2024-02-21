package Dao;

import java.sql.*;
import Connections.dbCon;
import Model.Payment;

public class PaymentDao {
    public void insert_payment(int user_id, String mode, String pay_date, int amount) {

        try {
            dbCon db = new dbCon();
            Connection conn = db.connect();
            PreparedStatement pay_insert = conn.prepareStatement(
                    "Insert into payment_table(user_id,payment_mode,payment_date,Amount) values(?,?,?,?)");
            pay_insert.setInt(1, user_id);
            pay_insert.setString(2, mode);
            pay_insert.setString(3, pay_date);
            pay_insert.setInt(4, amount);
            pay_insert.executeUpdate();

            // select pay_id
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT payment_id FROM payment_table WHERE user_id='" + user_id
                    + "' AND payment_date='" + pay_date + "';");
            rs.next();
            int pay_id = rs.getInt(1);

            Payment p = new Payment();
            p.setAmount(amount);
            p.setPaymentDate(null);
            p.setPaymentID(pay_id);
            p.setPaymentMode(mode);
            p.setUserID(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
