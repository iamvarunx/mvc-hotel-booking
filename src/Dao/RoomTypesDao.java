package Dao;
import java.sql.*;
import java.util.*;
import Model.RoomTypes;
import Util.dbCon;

public class RoomTypesDao {
    public static List<RoomTypes> getRoomTypes(){
        List<RoomTypes> list = new ArrayList<>();
         dbCon db = new dbCon();
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select Room_id, Room_type, no_of_person, pricePerDay, advanceAmount from room_types;");

            while(rs.next())
            {
                list.add(new RoomTypes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
            return list;
        }
        catch(Exception e)
        {
            list.clear();
            return list;
        }
    } 
    public static void update_room_price(int room_id, int price)  {

        try {
             dbCon db = new dbCon();
        Connection conn = db.connect();
        String query = "UPDATE room_types SET pricePerDay =? WHERE Room_id=?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, price);
        ps.setInt(2, room_id);
        ps.executeUpdate();
        System.out.println("UPDATED SUCESS FULLY");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update_room_advprice(int room_id, int price) {
        try {
             dbCon db = new dbCon();
        Connection conn = db.connect();
        String query = "UPDATE room_types SET advanceAmount =? WHERE Room_id=?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, price);
        ps.setInt(2, room_id);
        ps.executeUpdate();
        System.out.println("UPDATED SUCESS FULLY");
        } catch (Exception e) {
            e.printStackTrace();

        }
       
    }
}
