package Model;

public class Branch {
    public int hotelID;
    public String Haddress;
    public String Hcity;
    public String Hcontact;
    public int roomID;
    public int No_of_rooms;

    public int Total_rooms; //no_of_rooms + user_update_no_of_rooms
    public Branch(int hotelid,int roomid,int total_rooms)
    {
        hotelID=hotelid;
        roomID=roomid;
        Total_rooms=total_rooms;
    }
    public Branch(String haddress, String hcity, String hcontact, int no_of_rooms,int roomid) {
        Haddress = haddress;
        Hcity = hcity;
        Hcontact = hcontact;
        No_of_rooms = no_of_rooms;
        roomID=roomid;
    }
    public int getHotelID() {
        return hotelID;
    }
    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }
    public String getHaddress() {
        return Haddress;
    }
    public void setHaddress(String haddress) {
        Haddress = haddress;
    }
    public String getHcity() {
        return Hcity;
    }
    public void setHcity(String hcity) {
        Hcity = hcity;
    }
    public String getHcontact() {
        return Hcontact;
    }
    public void setHcontact(String hcontact) {
        Hcontact = hcontact;
    }
    public int getRoomID() {
        return roomID;
    }
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
    public int getNo_of_rooms() {
        return No_of_rooms;
    }
    public void setNo_of_rooms(int no_of_rooms) {
        No_of_rooms = no_of_rooms;
    }

    
}
