package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbCon {
  private static final String URL = "jdbc:mysql://localhost:3306/hotel_booking_mvc";
  private static final String USER = "root";
  private static final String PSW = "#Varun@2003&25";
  protected static Connection conn = null;

  public Connection connect() throws SQLException {
    if (conn == null)
      return conn = DriverManager.getConnection(URL, USER, PSW);
    else
      return conn;
  }

}
