package Controllers;

import Model.*;
import java.util.*;
import Connections.scannerCon;
import Dao.*;
import Views.AdminView;
import Views.DisplayView;

public class adminController {
    public static void admin() {
        int choice = AdminView.adminwelcome();
        if (choice == 1) {
            addBranchCon();
        } else if (choice == 2) {
            editNoOfRooms();
        } else if (choice == 3) {
            changePrice();
        } else if (choice == 4) {
            adminDisplayCon();
        } else if (choice == 5) {
            mainController.wel();
        }
    }

    public static void addBranchCon() {
        List<RoomTypes> list = RoomTypesDao.getRoomTypes();
        List<Branch> branch_list = AdminView.addBranch(list);
        BranchDao.createNewBranch(branch_list);

        admin();
    }

    public static void editNoOfRooms() {
        String city = AdminView.editRoom_city();
        displayDao dis = new displayDao();
        List<List<String>> list = dis.display_city_query(city);
        Branch b = AdminView.editRoom(list);

        BranchDao bDao = new BranchDao();
        bDao.update_rooms(b);

        admin();

    }

    public static void changePrice() {

        int choice = AdminView.changepriceView();

        List<RoomTypes> roomsTypeData = RoomTypesDao.getRoomTypes();
        if (choice == 1) {
            int d[] = AdminView.changePriceView1(roomsTypeData);
            RoomTypesDao.update_room_price(d[0], d[1]);
        } else if (choice == 2) {
            int d[] = AdminView.changePriceView1(roomsTypeData);
            RoomTypesDao.update_room_advprice(d[0], d[1]);
        } else {
            System.out.println("Something Went Wrong Try Again");
            admin();
        }
        admin();

    }

    public static void adminDisplayCon() {
        Scanner sc = scannerCon.connect();
        int choice = AdminView.adminDisplayView();
        switch (choice) {
            case 1:
                List<List<String>> list = BranchDao.display_all_branch();
                if (list == null) {
                    System.out.println("Something Went Wrong!!");
                    adminController.admin();
                }
                DisplayView.ViewAllbranch(list);
                break;
            case 2:
                System.out.println("Enter City Name: ");
                String city = sc.nextLine();
                displayDao dis = new displayDao();
                List<List<String>> list2 = dis.display_city_query(city);
                DisplayView.display_tabel_city(list2);
                break;
            case 3:
                System.out.println("Enter the Date to see the Booking details(yyyy-mm-dd): ");
                String date = sc.nextLine();
                List<List<String>> list3 =BookingDao.display_all_bookingDetails(date);
                AdminView.display_bookedDetails(list3);
                break;
            case 4:
            adminController.admin();
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
        adminController.admin();
    }
}
