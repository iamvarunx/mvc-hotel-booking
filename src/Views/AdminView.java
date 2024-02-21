package Views;

import java.util.*;
import Connections.scannerCon;
import Model.Branch;
import Model.RoomTypes;

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

        DisplayView.display_tabel_city(list); /* **** */

        System.out.print("Enter the Hotel ID: ");
        int hotelID = sc.nextInt();
        System.out.print("Enter the Room ID: ");
        int roomID = sc.nextInt();
        System.out.print("Enter the total number of rooms :");
        int totl_rooms = sc.nextInt();
        Branch branch = new Branch(hotelID, roomID, totl_rooms);
        return branch;
    }

    public static int changepriceView() {
        Scanner sc = scannerCon.connect();
        System.out.println("        1.To Change per day price");
        System.out.println("        2.To Change advance price");
        System.out.print("Enter choice: ");
        int chc = sc.nextInt();
        return chc;
    }

    public static int[] changePriceView1(List<RoomTypes> roomsTypeData) {

        DisplayView.roomTypeDisplay(roomsTypeData);
        Scanner sc = scannerCon.connect();
        System.out.println("Enter the ID: ");
        int id = sc.nextInt();
        System.out.print("Enter the price to be changed: ");
        int price = sc.nextInt();
        int[] d = new int[2];
        d[0] = id;
        d[1] = price;
        return d;
    }

    public static int adminDisplayView() {
        System.out.println("What to Display");
        System.out.println("          1.View All Branch Details ");
        System.out.println("          2.View Hotel Details ");
        System.out.println("          3.View All Booking Details");
        System.out.println("          4.Exit  ");
        Scanner sc = scannerCon.connect();
        System.out.print("Enter Your Choice: ");
        int c = sc.nextInt();
        sc.nextLine();
        return c;
    }
}
