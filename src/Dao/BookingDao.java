package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import Connections.dbCon;
import Model.Booking;

public class BookingDao {
  public static LinkedHashMap<Integer, Integer> getNumberOfBookedRooms(int hID, Booking booking) {
    dbCon db = new dbCon();

    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(); // check_in date
    try {
      Connection conn = db.connect();
      String query = "SELECT Room_id, SUM(no_of_rooms) \r\n" + //
          "FROM booking_table \r\n" + //
          "WHERE ? BETWEEN check_in AND check_out \r\n" + //
          "    AND status='active' \r\n" + //
          "    AND Hotel_id=? \r\n" + //
          "GROUP BY Room_id;\r\n";
      PreparedStatement ps1 = conn.prepareStatement(query);
      ps1.setString(1, booking.getCheckIn().toString());
      ps1.setInt(2, hID);
      ResultSet rs1 = ps1.executeQuery();

      PreparedStatement ps2 = conn.prepareStatement(query);
      ps2.setString(1, booking.getCheckOut().toString());
      ps2.setInt(2, hID);
      ResultSet rs2 = ps2.executeQuery();

      while (rs1.next()) {
        map.put(rs1.getInt(1), map.getOrDefault(rs1.getInt(1), 0) + rs1.getInt(2));
      }
      System.out.println(map);
      while (rs2.next()) {
        map.put(rs2.getInt(1), map.getOrDefault(rs2.getInt(1), 0) + rs2.getInt(2));
      }
      System.out.println(map);
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
}
