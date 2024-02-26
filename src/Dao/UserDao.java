package Dao;

import Model.*;
import Connections.*;
import java.sql.*;

public class UserDao {
    public boolean userExists(User data) {
        dbCon db = new dbCon();
        try {
            Connection conn = db.connect();
            Statement stmt = conn.createStatement();
            ResultSet user_check = stmt.executeQuery("SELECT user_id FROM user_details WHERE email='"
                    + data.getEmail() + "'; ");
            if (user_check.next()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public User login(User data) {
        dbCon db = new dbCon();
        try {
            Connection conn = db.connect();
            PreparedStatement login_input = conn
                    .prepareStatement("Select name,user_id,role from user_details where email= ? AND password= ?;");
            login_input.setString(1, data.getEmail());
            login_input.setString(2, data.getPassword());
            ResultSet rs = login_input.executeQuery();
            if (rs.next()) {
                data.setName(rs.getString(1));
                User.setId(rs.getInt(2));
                data.setRole(rs.getString(3));
            }

        } catch (Exception e) {
            return data;
        }
        return data;
    }

    public boolean createUser(User data) {
        dbCon db = new dbCon();
        try {
            Connection conn = db.connect();
            PreparedStatement user_insert = conn
                    .prepareStatement("Insert into user_details(name,email,password,role,phone_no) values(?,?,?,?,?)");
            user_insert.setString(1, data.getName());
            user_insert.setString(2, data.getEmail());
            user_insert.setString(3, data.getPassword());
            user_insert.setString(4, "user");
            user_insert.setString(5, data.getPhoneNo());
            user_insert.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
