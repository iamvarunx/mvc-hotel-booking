package Dao;

import java.sql.*;
import java.util.*;
import Connections.*;

public class displayDao {
  public List<List<String>> display_city_query(String city) {
    dbCon db = new dbCon();
    List<List<String>> list = new ArrayList<>();
    try {
      Connection conn = db.connect();
      String query = "SELECT\n" + //
          "    hd.Hotel_id\n," + //
          "rt.Room_id,\n" + //
          "    hd.Hotel_address,\n" + //
          "    hd.Hotel_city,\n" + //
          "    hd.Hotel_contact,\n" + //
          "    rt.Room_type,\n" + //
          "     r.no_of_rooms,\n" + //
          "    rt.no_of_person,\n" + //
          "    rt.pricePerDay\n" + //
          "FROM\n" + //
          "    hotel_rooms r\n" + //
          "LEFT JOIN\n" + //
          "    Branch_details hd ON r.Hotel_id = hd.Hotel_id\n" + //
          "LEFT JOIN\n" + //
          "    Room_types rt ON r.Room_id = rt.Room_id\n" + //
          "WHERE\n" + //
          "\thd.Hotel_city = ?;";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, city);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        List<String> l = new ArrayList<>();
        l.add(String.valueOf(rs.getInt(1)));
        l.add(String.valueOf(rs.getInt(2)));
        l.add(rs.getString(3));
        l.add(rs.getString(4));
        l.add(rs.getString(5));
        l.add(rs.getString(6));
        l.add(String.valueOf(rs.getInt(7)));
        l.add(String.valueOf(rs.getInt(8)));
        l.add(String.valueOf(rs.getInt(9)));
        list.add(l);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public static List<List<String>> display_hotel_ByCity(String city) {
    try {
      dbCon db = new dbCon();
      Connection conn = db.connect();
      List<List<String>> list = new ArrayList<>();
      String query = "SELECT\n" + //
          "    Hotel_id\n," + //
          "    Hotel_address,\n" + //
          "    Hotel_city,\n" + //
          "    Hotel_contact\n" + //
          "FROM Branch_details " + //
          "WHERE\n" + //
          "\tHotel_city = ?;";

      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, city);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        List<String> li = new ArrayList<>();
        li.add(String.valueOf(rs.getInt(1)));
        li.add(rs.getString(2));
        li.add(rs.getString(3));
        li.add(rs.getString(4));
        list.add(li);
      }
      return list;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
