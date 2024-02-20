package Views;

import java.util.*;

import Dao.displayDao;
import Model.Branch;
import Model.RoomTypes;
import Util.scannerCon;

public class AdminView {

    public static int adminwelcome() {
        System.out.println();
        Scanner sc = scannerCon.connect();
        System.out.println("__________Welcome Admin!!!__________");
        System.out.println("          1.To add new Branch: ");
        System.out.println("          2.To edit number of rooms: ");
        System.out.println("          3.To Change Price/Advance price of the room: ");
        System.out.println("          4.Display");
        System.out.println("          5.EXIT ");

        System.out.println("Enter Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static List<Branch> addBranch(List<RoomTypes> RoomList) {

        Scanner sc = scannerCon.connect();
        System.out.println("Hotel Address: ");
        String address = sc.nextLine();
        System.out.println("Enter City: ");
        String city = sc.nextLine();
        System.out.println("Enter Contact Number: ");
        String contact_no = sc.nextLine();
        List<Branch> branch = new ArrayList<>();
        for (RoomTypes list : RoomList) {
            System.out.print("How many " + list.type + " rooms are there :");
            int numberOfRooms = sc.nextInt();
            if (numberOfRooms <= 0)
                continue;
            else {
                branch.add(new Branch(address, city, contact_no, numberOfRooms, list.id));
            }
        }
        return branch;
    }

    public static String editRoom_city() {
        Scanner sc = scannerCon.connect();
        System.out.print("Enter hotel city:");
        String city = sc.nextLine();
        return city;
    }

    public static Branch editRoom(List<List<String>> list) {
        Scanner sc = scannerCon.connect();
        System.out.printf(
                "---------------------------------------------------------------------------------------------------------%n");
        System.out.printf("|%-8s|%-8s|%-15s|%-15s|%-15s|%-12s|%-10s|%-10s|%n",
                "Hotel_ID", "Room_ID", "Hotel_city", "Hotel_contact", "Room_type",
                "NO_OF_ROOMS", "no_of_person",
                "pricePerDay");
        System.out.printf(
                "---------------------------------------------------------------------------------------------------------%n");
        for (int i = 0; i < list.size(); i++) {

            System.out.printf("|%-8s|%-8s|%-15s|%-15s|%-15s|%-12s|%-12s|%-11s|%n",
                    list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3), list.get(i).get(4),
                    list.get(i).get(5), list.get(i).get(6), list.get(i).get(7));
        }
        System.out.printf(
                "---------------------------------------------------------------------------------------------------------%n");
        System.out.print("Enter the Hotel ID: ");
        int hotelID = sc.nextInt();
        System.out.print("Enter the Room ID: ");
        int roomID = sc.nextInt();
        System.out.print("Enter the total number of rooms :");
        int totl_rooms = sc.nextInt();
        Branch branch = new Branch(hotelID, roomID, totl_rooms);
        return branch;
    }
}
