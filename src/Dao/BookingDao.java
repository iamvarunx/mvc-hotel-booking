package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;

import Model.Booking;
import Util.dbCon;

public class BookingDao{
    public static  LinkedHashMap<Integer,Integer> getNumberOfBookedRooms(int hID, Booking booking){
  dbCon db = new dbCon();
  
  LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();   // check_in date
  try {
    Connection conn = db.connect();
    String query = "SELECT Room_id, SUM(no_of_rooms) \r\n" + //
            "FROM booking_table \r\n" + //
            "WHERE ? BETWEEN check_in AND check_out \r\n" + //
            "    AND status='active' \r\n" + //
            "    AND Hotel_id=? \r\n" + //
            "GROUP BY Room_id;\r\n" ;
    PreparedStatement ps1 = conn.prepareStatement(query);
    ps1.setString(1, booking.getCheckIn().toString());
    ps1.setInt(2, hID);
    ResultSet rs1 = ps1.executeQuery();

    PreparedStatement ps2 = conn.prepareStatement(query);
    ps2.setString(1, booking.getCheckIn().toString());
    ps2.setInt(2, hID);
    ResultSet rs2 = ps2.executeQuery();

    while (rs1.next()) {
      map.put(rs1.getInt(1),map.getOrDefault(rs1.getInt(1),0)+rs1.getInt(2));
    }
    while (rs2.next()) {
      map.put(rs2.getInt(1),map.getOrDefault(rs2.getInt(1),0)+rs2.getInt(2));
    }

  } catch (Exception e) {
    e.printStackTrace();
    return null;
  }
  return map;
   }
}