package Controllers;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import Dao.BookingDao;
import Dao.BranchDao;
import Dao.RoomTypesDao;
import Dao.displayDao;
import Model.Booking;
import Model.Branch;
import Model.RoomTypes;
import Model.User;
import Views.DisplayView;
import Views.UserView;

public class userController {
    public static void user(){

        int choice = UserView.userwelcome();
        if(choice==1)
        {
            startBooking();
        }
    }
    public static void startBooking()
    {
        Booking booking= UserView.bookigDetailsView();
       List<List<String>> list = displayDao.display_hotel_ByCity(booking.getCity());
       DisplayView.ViewAllbranch(list);

        int Hotel_id = DisplayView.getInt("Hotel ID");
        LinkedHashMap<Integer,Integer> map= BookingDao.getNumberOfBookedRooms(Hotel_id,booking);
        
        List<Branch> roomdata = BranchDao.gettotalRooms(booking.getCity());
        LinkedHashMap<Integer,Integer> data = new LinkedHashMap<>();

        for(Branch roomData:roomdata)
        {
            if(map.containsKey(roomData.roomID))
            {
                int noOfRoomsBooked = map.get(roomData.roomID);
                data.put(roomData.roomID,roomData.No_of_rooms-noOfRoomsBooked);
            }
            else
            data.put(roomData.roomID,roomData.No_of_rooms);
        }
        List<RoomTypes> roomtype = RoomTypesDao.getRoomTypes();
        DisplayView.roomsAvaialableToBook(roomtype,data);
        int Room_id = DisplayView.getInt("Room ID");
        int pricePerDay = roomtype.get(Room_id-1).pricePerDay;
        int priceAdvanceAmount = roomtype.get(Room_id-1).advanceAmt;
        int ROOMS_AVAILABLE = data.get(Room_id);
        int no_room = 0;
        while (true) {
            no_room = DisplayView.getInt("Number OF Rooms");
            if (no_room > ROOMS_AVAILABLE) {
                System.out.println("Please..!!");
                System.out.println("Enter the number of rooms as of the availablities:");
            } else
                break;
        }

        payment_process(Room_id, no_room, booking.getNoofDays(),pricePerDay,priceAdvanceAmount);
        
    }
    public static void payment_process(int room_id, int no_room, int noOfDays,int perdayprice,int advanceAmount) {
        int total_price = perdayprice * noOfDays;
        System.out.println("-------------------------------------------");
        System.out.println(" PER DAY PRICE                 =     RS." + perdayprice);
        System.out.println(" TOTAL NUMBER OF DAYS STAY     =     " + noOfDays);
        System.out.println("                                  -------------");
        System.out.println(" TOTAL AMOUNT                  =     RS." + total_price);
        System.out.println("                                  -------------");
        System.out.println(" ADVANCE AMOUNT TO BE PAID     =     RS." + advanceAmount);
        System.out.println("-------------------------------------------");

        System.out.println("CHOOSE THE MODE OF PAYMENT ");
        System.out.println("1.UPI");
        System.out.println("2.CREDIT CARD");
        System.out.println("3.DEBIT CARD");
        String mode = "";
        int choice = DisplayView.getInt("your choice");
        if (choice == 1)
            mode = "UPI";
        else if (choice == 2)
            mode = "CREDIT CARD";
        else if (choice == 3)
            mode = "DEBIT CARD";
        int amount = 0;
        while (advanceAmount != amount) {
            amount = DisplayView.getInt("YOUR Advance amount (" + advanceAmount + ")");
            if (advanceAmount != amount) {
                System.out.println("The Entered amount is wrong please..!!");
            }
        }
        System.out.println("Enter Date Of PayMent (yyyy-mm-dd) : ");
        String date = DisplayView.getString("Date Of PayMent (yyyy-mm-dd)");
        // in.insert_payment(getSet.getUserId(), mode, date, amount);
        
    }
}
