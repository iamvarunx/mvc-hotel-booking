package Dao;

import java.sql.*;
import java.util.*;
import Util.*;

public class displayDao {
     public List<List<String>> display_city_query(String city) {
        dbCon db = new dbCon();
        List<List<String>> list = new ArrayList<>();
        try {
              Connection conn = db.connect();
                String query = querys.display_Bycity();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, city);
                ResultSet rs = ps.executeQuery();

                while(rs.next())
                {
                    List<String> l = new ArrayList<>();
                    l.add(String.valueOf(rs.getInt(1)));
                    l.add(String.valueOf(rs.getInt( 2)));
                    l.add(rs.getString(3));
                    l.add(rs.getString(4));
                    l.add(rs.getString(5));
                    l.add(String.valueOf(rs.getInt(6))); 
                    l.add(String.valueOf(rs.getInt(7))); 
                    l.add(String.valueOf(rs.getInt(8)));
                    list.add(l); 
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list;
     }
}
