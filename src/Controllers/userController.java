package Controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import Dao.*;
import Model.*;
import Views.*;

public class userController {
    public static void user() {

        int choice = UserView.userwelcome();
        if (choice == 1) {
            startBooking();
        } else if (choice == 2) {
            viewhotelsUserCon();
        } else if (choice == 3) {
            viewBookedDetailsCon();
        } else if (choice == 4) {
            cancelBookingCon();
        } else if (choice == 5) {
            viewAllBookingHistory();
        } else if (choice == 6) {
            mainController.wel();
        }
    }

    public static void startBooking() {
        Booking booking = UserView.bookigDetailsView();
        List<List<String>> list = displayDao.display_hotel_ByCity(booking.getCity());
        DisplayView.ViewAllbranch(list);

        int Hotel_id = DisplayView.getInt("Hotel ID");
        LinkedHashMap<Integer, Integer> map = BookingDao.getNumberOfBookedRooms(Hotel_id, booking);

        List<Branch> roomdata = BranchDao.gettotalRooms(booking.getCity());
        LinkedHashMap<Integer, Integer> data = new LinkedHashMap<>();

        for (Branch roomData : roomdata) {
            if (map.containsKey(roomData.roomID)) {
                int noOfRoomsBooked = map.get(roomData.roomID);
                data.put(roomData.roomID, roomData.No_of_rooms - noOfRoomsBooked);
            } else
                data.put(roomData.roomID, roomData.No_of_rooms);
        }
        List<RoomTypes> roomtype = RoomTypesDao.getRoomTypes();
        DisplayView.roomsAvaialableToBook(roomtype, data);
        int Room_id = DisplayView.getInt("Room ID");
        int pricePerDay = roomtype.get(Room_id - 1).pricePerDay;
        int priceAdvanceAmount = roomtype.get(Room_id - 1).advanceAmt;
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

        payment_process(Room_id, no_room, booking.getNoofDays(), pricePerDay, priceAdvanceAmount);

        BookingDao.insert_booking(Hotel_id, Room_id, no_room, booking.checkIn.toString(),
                booking.checkOut.toString(),
                Payment.getPaymentID());

        user();
    }

    public static void payment_process(int room_id, int no_room, int noOfDays, int perdayprice, int advanceAmount) {
        int total_price = perdayprice * noOfDays;
        UserView.payment_screen(perdayprice, noOfDays, total_price, advanceAmount);

        String mode = UserView.payment_modeScreen();
        int amount = 0;
        while (advanceAmount != amount) {
            amount = DisplayView.getInt("YOUR Advance amount (" + advanceAmount + ")");
            if (advanceAmount != amount) {
                System.out.println("The Entered amount is wrong please..!!");
            }
        }
        String date = DisplayView.getString("Date Of PayMent (yyyy-mm-dd)");

        PaymentDao payment = new PaymentDao();
        payment.insert_payment(User.getId(), mode, date, amount);

    }

    public static void viewhotelsUserCon() {
        List<List<String>> data = BranchDao.display_all_branch();
        DisplayView.ViewAllbranch(data);
    }

    public static void viewBookedDetailsCon() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        List<List<String>> list = BookingDao.bookedDetails(dtf.format(now).toString(), User.getId());
        UserView.viewBookedDetails(list);
        user();
    }

    public static void viewAllBookingHistory() {
        List<List<String>> list = BookingDao.allBookedHistory(User.getId());
        UserView.viewAllPastBookedDetails(list);
        user();
    }

    public static void cancelBookingCon() {
        List<List<String>> list = BookingDao.viewToCanceldata(User.getId());
        int booking_id = UserView.viewToCancel(list);
        if (booking_id != 0) {
            BookingDao.cancelBooking(booking_id);
            System.out.println("Booking AS been canceled Successfully !!!");
        }
        user();
    }
}
