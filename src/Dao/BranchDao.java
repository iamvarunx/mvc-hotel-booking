package Dao;

import Model.Branch;
import Util.*;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BranchDao {
    public static void createNewBranch(List<Branch> branch) {

        dbCon db = new dbCon();
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            PreparedStatement branch_insert1 = conn
                    .prepareStatement(
                            "Insert into branch_details(Hotel_address,Hotel_city,Hotel_contact) values(?,?,?)");
            branch_insert1.setString(1, branch.get(0).Haddress);
            branch_insert1.setString(2, branch.get(0).Hcity);
            branch_insert1.setString(3, branch.get(0).Hcontact);
            branch_insert1.executeUpdate();

            // to get hotel_id
            ResultSet rs = stmt
                    .executeQuery("SELECT Hotel_id FROM branch_details WHERE Hotel_city='" + branch.get(0).Hcity
                            + "' AND Hotel_address='" + branch.get(0).Haddress + "';");
            rs.next();

            int Hotel_id = rs.getInt(1);

            // number if different rooms
            for (Branch b : branch) {
                if (b.getNo_of_rooms() != 0) {
                    PreparedStatement branch_insert2 = conn
                            .prepareStatement("Insert into hotel_rooms(Room_id,Hotel_id,no_of_rooms) values(?,?,?)");
                    branch_insert2.setInt(1, b.roomID);
                    branch_insert2.setInt(2, Hotel_id);
                    branch_insert2.setInt(3, b.No_of_rooms);
                    branch_insert2.executeUpdate();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_rooms(Branch b) {
        try {
            
            dbCon db = new dbCon();
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            String query_getRooms = "Select no_of_rooms from hotel_rooms where Room_id =" + b.roomID + " AND Hotel_id ="
                    + b.hotelID + ";";
            ResultSet rs = stmt.executeQuery(query_getRooms);
            int rooms = 0;
            if (rs.next()) {
                rooms = rs.getInt(1);
            }
            b.setNo_of_rooms(rooms+(b.Total_rooms));
            String query = "UPDATE hotel_rooms\r\n" + //
                    "SET no_of_rooms = ?\r\n" + //
                    "WHERE Hotel_id =? AND Room_id =?;";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, b.getNo_of_rooms());
            ps.setInt(2, b.hotelID);
            ps.setInt(3, b.roomID);
            ps.executeUpdate();
            System.out.println("UPDATED SUCESS FULLY");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
