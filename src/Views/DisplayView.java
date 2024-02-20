package Views;

import java.util.List;

public class DisplayView {
    public static void display_tabel_city(List<List<String>> list)
    {
        System.out.printf(
            "-------------------------------------------------------------------------------------------------------------------------------%n");
    System.out.printf("|%-8s|%-8s|%-20s|%-15s|%-15s|%-15s|%-12s|%-10s|%-10s|%n",
            "Hotel_ID", "Room_ID", "Hotel_address","Hotel_city", "Hotel_contact", "Room_type",
            "NO_OF_ROOMS", "no_of_person",
            "pricePerDay");
    System.out.printf(
            "-------------------------------------------------------------------------------------------------------------------------------%n");
    for (int i = 0; i < list.size(); i++) {

        System.out.printf("|%-8s|%-8s|%-20s|%-15s|%-15s|%-15s|%-12s|%-12s|%-11s|%n",
                list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3), list.get(i).get(4),
                list.get(i).get(5), list.get(i).get(6), list.get(i).get(7),list.get(i).get(8));
    }
    System.out.printf(
            "-------------------------------------------------------------------------------------------------------------------------------%n");
    }
    public static void ViewAllbranch(List<List<String>> list) {

        System.out.printf(
                "-------------------------------------------------------------------%n");
        System.out.printf("|%-8s|%-25s|%-15s|%-14s|%n",
                "Hotel_Id", "Address", "City", "HOTEL_CONTACT");
        
                System.out.printf(
                    "-------------------------------------------------------------------%n");

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("|%-8s|%-25s|%-15s|%-14s|%n",
                    list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3));
        }
        
        System.out.printf(
                "-------------------------------------------------------------------%n");
    }
}
