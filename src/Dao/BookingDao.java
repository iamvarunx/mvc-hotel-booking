package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Connections.dbCon;
import Model.Booking;

public class BookingDao {
  public static LinkedHashMap<Integer, Integer> getNumberOfBookedRooms(int hID, Booking booking) {
    dbCon db = new dbCon();

    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(); // check_in date
    try {
      Connection conn = db.connect();
      String query = "SELECT Room_id, SUM(no_of_rooms) FROM booking_table \n" + //
                "WHERE ? BETWEEN check_in AND check_out OR ? BETWEEN check_in AND check_out AND \n" + //
                "status='active' AND Hotel_id= ? \n" + //
                "GROUP BY Room_id; \r\n";
      PreparedStatement ps1 = conn.prepareStatement(query);
      ps1.setString(1, booking.getCheckIn().toString());
      ps1.setString(2, booking.getCheckOut().toString());
      ps1.setInt(3, hID);
      ResultSet rs1 = ps1.executeQuery();
      while (rs1.next()) {
        map.put(rs1.getInt(1), map.getOrDefault(rs1.getInt(1), 0) + rs1.getInt(2));
      }
     

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return map;
  }

  public static void insert_booking(int hotel_id, int room_id, int no_room, String checkIn, String checkOut,
      int pay_id) {
    dbCon db = new dbCon();
    try {
      Connection conn = db.connect();
      PreparedStatement booking_insert = conn.prepareStatement(
          "Insert into booking_table(Hotel_id,Room_id,no_of_rooms,check_in,check_out,payment_id,status) values(?,?,?,?,?,?,?)");
      booking_insert.setInt(1, hotel_id);
      booking_insert.setInt(2, room_id);
      booking_insert.setInt(3, no_room);
      booking_insert.setString(4, checkIn);
      booking_insert.setString(5, checkOut);
      booking_insert.setInt(6, pay_id);
      booking_insert.setString(7, "active");
      booking_insert.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void cancelBooking(int bID) {
    dbCon db = new dbCon();
    try {
      Connection conn = db.connect();
      PreparedStatement ps = conn.prepareStatement(
          " UPDATE booking_table\n" + //
              "SET status='canceled'\n" + //
              "WHERE booking_id= ? ;");
      ps.setInt(1, bID);
      ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<List<String>> bookedDetails(String date, int userId) {

    List<List<String>> list = new ArrayList<>();
    dbCon db = new dbCon();
    try {
      Connection conn = db.connect();
      PreparedStatement ps = conn.prepareStatement(
          "Select booking_id,Hotel_address, Hotel_city, Room_type , check_in, check_out,no_of_rooms, payment_mode, payment_date, Amount \n"
              + //
              "from booking_table \n" + //
              "join payment_table using(payment_id) \n" + //
              "join room_types using (Room_id)\n" + //
              "join branch_details using (Hotel_id)\n" + //
              "where check_in >= ? and user_id = ?  and status ='active' ;");
      System.out.println(date);
      ps.setString(1, date);
      ps.setInt(2, userId);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        List<String> li = new ArrayList<>();
        li.add(String.valueOf(rs.getInt(1)));
        li.add(rs.getString(2));
        li.add(rs.getString(3));
        li.add(rs.getString(4));
        li.add(rs.getString(5));
        li.add(rs.getString(6));
        li.add(String.valueOf(rs.getInt(7)));
        li.add(rs.getString(8));
        li.add(rs.getString(9));
        li.add(String.valueOf(rs.getInt(10)));

        list.add(li);
      }
      return list;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public static List<List<String>> allBookedHistory(int userId) {

    List<List<String>> list = new ArrayList<>();
    dbCon db = new dbCon();
    try {
      Connection conn = db.connect();
      PreparedStatement ps = conn.prepareStatement(
          "Select Hotel_address, Hotel_city, Room_type , check_in, check_out,no_of_rooms, payment_mode, payment_date, Amount, status \n"
              + //
              "from booking_table \n" + //
              "join payment_table using(payment_id) \n" + //
              "join room_types using (Room_id)\n" + //
              "join branch_details using (Hotel_id)\n" + //
              "where  user_id = ?  ;");
      ps.setInt(1, userId);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        List<String> li = new ArrayList<>();
        li.add(rs.getString(1));
        li.add(rs.getString(2));
        li.add(rs.getString(3));
        li.add(rs.getString(4));
        li.add(rs.getString(5));
        li.add(String.valueOf(rs.getInt(6)));
        li.add(rs.getString(7));
        li.add(rs.getString(8));
        li.add(String.valueOf(rs.getInt(9)));
        li.add(rs.getString(10));
        list.add(li);
      }
      return list;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public static List<List<String>> viewToCanceldata(int userId) {

    List<List<String>> list = new ArrayList<>();
    dbCon db = new dbCon();
    try {
      Connection conn = db.connect();
      PreparedStatement ps = conn.prepareStatement(
          "Select booking_id,Hotel_address, Hotel_city, Room_type , check_in, check_out,no_of_rooms \n" + //
              "from booking_table \n" + //
              "join payment_table using(payment_id) \n" + //
              "join room_types using (Room_id)\n" + //
              "join branch_details using (Hotel_id)\n" + //
              "where  user_id = ? and status='active' ;");
      ps.setInt(1, userId);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        List<String> li = new ArrayList<>();
        li.add(String.valueOf(rs.getInt(1)));
        li.add(rs.getString(2));
        li.add(rs.getString(3));
        li.add(rs.getString(4));
        li.add(rs.getString(5));
        li.add(rs.getString(6));
        li.add(String.valueOf(rs.getInt(7)));
        list.add(li);
      }
      return list;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public static List<List<String>> display_all_bookingDetails(String date) {
    dbCon db = new dbCon();
    List<List<String>> list = new ArrayList<>();
    try {
      Connection conn = db.connect();
      String Query = "SELECT\n" + //
          "   ud.name,\n" + //
          "    ud.phone_no,\n" + //
          "    bd.Hotel_city,\n" + //
          "    rt.Room_type,\n" + //
          "    bt.no_of_rooms,\n" + //
          "    bt.check_in,\n" + //
          "    bt.check_out,\n" + //
          "    bt.status\n" + //
          "FROM\n" + //
          "    booking_table bt\n" + //
          "JOIN\n" + //
          "    branch_details bd ON bt.Hotel_id = bd.Hotel_id\n" + //
          "JOIN\n" + //
          "    hotel_rooms hr ON bt.Room_id = hr.Room_id\n" + //
          "JOIN\n" + //
          "    room_types rt ON hr.Room_id = rt.Room_id\n" + //
          "JOIN\n" + //
          "    payment_table pt ON bt.payment_id = pt.payment_id\n" + //
          "JOIN\n" + //
          "    user_details ud ON pt.user_id = ud.user_id\n" + //
          "WHERE bt.check_in = ? ;";
      PreparedStatement ps = conn.prepareStatement(Query);
      ps.setString(1, date);
      ResultSet rs = ps.executeQuery();
      while(rs.next())
      {
        List<String> li = new ArrayList<>();
        li.add(rs.getString(1));
        li.add(rs.getString(2));
        li.add(rs.getString(3));
        li.add(rs.getString(4));
        li.add(String.valueOf(rs.getInt(5)));
        li.add(rs.getString(6));
        li.add(rs.getString(7));
        li.add(rs.getString(8));
        list.add(li);
      }
      return list;

    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
  }
}
