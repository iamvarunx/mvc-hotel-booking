package Views;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import Connections.scannerCon;
import Model.RoomTypes;

public class DisplayView {
        public static void display_tabel_city(List<List<String>> list) {
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------%n");
                System.out.printf("|%-8s|%-8s|%-20s|%-15s|%-15s|%-15s|%-12s|%-10s|%-10s|%n",
                                "Hotel_ID", "Room_ID", "Hotel_address", "Hotel_city", "Hotel_contact", "Room_type",
                                "NO_OF_ROOMS", "no_of_person",
                                "pricePerDay");
                System.out.printf(
                                "-------------------------------------------------------------------------------------------------------------------------------%n");
                for (int i = 0; i < list.size(); i++) {

                        System.out.printf("|%-8s|%-8s|%-20s|%-15s|%-15s|%-15s|%-12s|%-12s|%-11s|%n",
                                        list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3),
                                        list.get(i).get(4),
                                        list.get(i).get(5), list.get(i).get(6), list.get(i).get(7), list.get(i).get(8));
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

        public static int getInt(String s) {
                Scanner sc = scannerCon.connect();
                System.out.print("Enter " + s + ": ");
                int n = sc.nextInt();
                sc.nextLine();
                return n;
        }

        public static String getString(String s) {
                Scanner sc = scannerCon.connect();
                System.out.print("Enter " + s + ": ");
                String a = sc.nextLine();
                return a;
        }

        public static void roomTypeDisplay(List<RoomTypes> roomsTypeData) {
                System.out.printf(
                                "-------------------------------------------------------------------%n");
                System.out.printf("|%-8s|%-25s|%-15s|%-14s|%n",
                                "ID", "ROOM TYPE", "PRICE", "ADVANCE");
                System.out.printf(
                                "-------------------------------------------------------------------%n");
                for (RoomTypes data : roomsTypeData) {
                        System.out.printf("|%-8s|%-25s|%-15s|%-14s|%n",
                                        data.id, data.type, data.pricePerDay, data.advanceAmt);
                }
                System.out.printf(
                                "-------------------------------------------------------------------%n");
        }

        public static void roomsAvaialableToBook(List<RoomTypes> roomsTypeData, LinkedHashMap<Integer, Integer> map) {
                System.out.printf(
                                "---------------------------------------------------------------------------------------%n");
                System.out.printf("|%-8s|%-25s|%-15s|%-14s|%-20s|%n",
                                "ID", "ROOM TYPE", "PRICE", "ADVANCE", "Room Available");
                System.out.printf(
                                "----------------------------------------------------------------------------------------%n");
                for (RoomTypes data : roomsTypeData) {

                        System.out.printf("|%-8s|%-25s|%-15s|%-14s|%-20s|%n",
                                        data.id, data.type, data.pricePerDay, data.advanceAmt, map.get(data.id));
                }
                System.out.printf(
                                "----------------------------------------------------------------------------------------%n");

        }
}
